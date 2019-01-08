package servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ArtistDao;
import dao.DetailDao;
import dao.ImageDao;
import model.Artist;
import model.Detail;
import model.Image;

/**
 * Servlet implementation class AddIServlet
 */
@WebServlet("/AddIServlet")
public class AddIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final int MaxMemorySize = 1024 * 1024 * 4;
	final int MaxRequestSize = 1024 * 1024 * 60;
	String gId;
	String title;
	String link;
	String aId ;
	String year;
	String type;
	String width;
	String height;
	String location;
	String des;
	String fName;
	String relativePath;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//upload image
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//set factory constriants
		factory.setSizeThreshold(MaxMemorySize);

		//configure a repository
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.conext.tempdir");
		factory.setRepository(repository);

		//create a new file 
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setSizeMax(MaxRequestSize);

		
		//upload path
		String path = request.getSession().getServletContext().getRealPath("/image/");

		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		
		try {
			//parse request
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> Fiter = items.iterator();
			while (Fiter.hasNext()) {
				FileItem item = Fiter.next();
				if (!item.isFormField()) {
					long filesize = item.getSize();
					if(filesize==0){
						request.setAttribute("uploadError", "choose an upload file ");
					}
					fName = new File(item.getName()).getName();
					String uploadPath = path + fName;
					File storeFile = new File(uploadPath);
					relativePath = request.getContextPath()+"/image/" + fName;
					item.write(storeFile);
				} else{
					String name = item.getFieldName();
					if("gId".equals(name)){
						 gId = item.getString();
					}
					 else if("title".equals(name)){
						  title = item.getString();
						
					} else if("link".equals(name)){
						 link = relativePath;
						
					} else if("aId".equals(name)){
						 aId = item.getString();
						
					} else if("year".equals(name)) {
						 year = item.getString();
						
					} else if("type".equals(name)) {
						
						 type = item.getString();
					} else if("width".equals(name)) {
						width = item.getString();
						
					} else if ("height".equals(name)) {
						height = item.getString();
						
					} else if("location".equals(name)) {
						 location = item.getString();
						
					} else if("description".equals(name)) {
						 des = item.getString();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
//		String gId = request.getParameter("gId");
//		String title = request.getParameter("title");
//		String link = request.getParameter("link");
//		String aId = request.getParameter("aId");
//		String year = request.getParameter("year");
//		String type = request.getParameter("type");
//		String width = request.getParameter("width");
//		String height = request.getParameter("height");
//		String location = request.getParameter("location");
//		String des = request.getParameter("description");
		
		
		
		Image i = new Image();
		Detail d = new Detail();
		i.setgId(Integer.parseInt(gId));
		i.setTitle(title);
		i.setLink(relativePath);
		i.setaId(Integer.parseInt(aId));
		d.setDes(des);
		d.setYear(Integer.parseInt(year));
		d.setType(type);
		d.setWidth(Integer.parseInt(width));
		d.setHeight(Integer.parseInt(height));
		d.setLocation(location);
		ImageDao iDao = new ImageDao();
		DetailDao dDao = new DetailDao();
		int image_Id = iDao.addImage(i);
		//System.out.println("newimageid"+image_Id);
		d.setiId(image_Id);
		int detail_Id = dDao.addDetail(d);
		iDao.updateImageDid(image_Id, detail_Id);
		request.getRequestDispatcher("ViewGServlet?gId="+gId).forward(request, response);  
	}

}
