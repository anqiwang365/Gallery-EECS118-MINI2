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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ArtistDao;
import dao.DetailDao;
import dao.ImageDao;
import model.Artist;
import model.Detail;
import model.Image;

/**
 * Servlet implementation class UpdateIServlet
 */
@WebServlet("/UpdateIServlet")
public class UpdateIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final int MaxMemorySize = 1024 * 1024 * 4;
	final int MaxRequestSize = 1024 * 1024 * 60;
	String gId;
	String iId;
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
    public UpdateIServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iId = request.getParameter("iId");
		String gId = request.getParameter("gId");
		
		if(iId != null && !iId.equals(" ")) {
					
					int id = Integer.valueOf(iId);
					ImageDao dao = new ImageDao();
					DetailDao dao1 = new DetailDao();
					Image image = dao.selectById(id);
					Detail detail = dao1.selectById(id);
					
					System.out.println(detail.getType()+"detialceshi-test");
					System.out.println(detail.getLocation()+"ppppceshi-test");
					System.out.println(detail.getDes()+"des");
					request.setAttribute("image", image);
					request.setAttribute("detail", detail);
					request.setAttribute("gId", gId);
					request.setAttribute("iId",iId);
				}
		request.getRequestDispatcher("gallery/UpdateImage.jsp?iId="+iId).forward(request, response);;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				String oldlink = request.getParameter("oldlink");
System.out.println("old"+oldlink);
				//deal with oldlink to get file name
				String temp[] = oldlink.split("/");
				String tempName = temp[3];
				
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
							
							
							//upload new image
							fName = new File(item.getName()).getName();
							String uploadPath = path + fName;
							File storeFile = new File(uploadPath);
							relativePath = request.getContextPath()+"/image/" + fName;
							System.out.println("relativePath"+relativePath);
							
							//get old path 
							System.out.println(tempName);
							String oldUploadLink = request.getSession().getServletContext().getRealPath("/image/")+tempName;
						   if(fName.equals("")) {
							   link = oldlink;
							   System.out.println("link"+link);
						   }else {
							 //delete old image upload new image
								File oldFile = new File(oldUploadLink);
								oldFile.delete();
								item.write(storeFile);
								link = relativePath;
						   }
							
						   
						   
							
						} else{
							String name = item.getFieldName();
							if("gId".equals(name)){
								 gId = item.getString();
							}else if("iId".equals(name)){
								iId = item.getString();
							}
							 else if("title".equals(name)){
								  title = item.getString();
							} else if("aId".equals(name)){
								 aId = item.getString();
								
							} else if("year".equals(name)) {
								 year = item.getString();
								
							} else if("itype".equals(name)) {
								
								 type = item.getString();
								 
							} else if("width".equals(name)) {
								width = item.getString();
								
							} else if ("height".equals(name)) {
								height = item.getString();
								
							} else if("location".equals(name)) {
								 location = item.getString();
								
							} else if("des".equals(name)) {
								 des = item.getString();
							}
						}

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		
		
		
		
		
		
		
		
		
		
		
		
//		String gId = request.getParameter("gId");
//		String iId = request.getParameter("iId");
//		String title = request.getParameter("title");
//		String aId = request.getParameter("aId");
//		String year = request.getParameter("year");
//		String type = request.getParameter("type");
//		String width = request.getParameter("width");
//		String height = request.getParameter("height");
//		String location = request.getParameter("location");
//		String des = request.getParameter("des");
		
		
		
		
		Detail detail = new Detail();
		detail.setiId(Integer.parseInt(iId));
		detail.setType(type);
		detail.setDes(des);
		detail.setWidth(Integer.parseInt(width));
		detail.setHeight(Integer.parseInt(height));
		detail.setLocation(location);
		detail.setYear(Integer.parseInt(year));
		DetailDao dao = new DetailDao();
		dao.updateDetail(detail);
		
		Image image = new Image();
		image.setTitle(title);
		image.setaId(Integer.parseInt(aId));
		image.setiId(Integer.parseInt(iId));
		image.setLink(link);
		
		
		ImageDao dao1 = new ImageDao();
		dao1.updateImage(image);
		
		request.getRequestDispatcher("ViewGServlet?gId="+gId).forward(request, response);
	}

}
