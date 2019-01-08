 package servlet;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.JsonArray;

import dao.GalleryDao;
import model.Gallery;
import net.sf.json.JSONArray;

/**
 * Servlet implementation class ShowG
 */
@WebServlet("/ShowGServlet")
public class ShowGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGServlet() {
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
		// TODO Auto-generated method stub
		
		GalleryDao dao = new GalleryDao();
		List<Gallery> list = dao.getAllGallery();
		
		//List<String> links = new ArrayList<String>();
		for(int i=0;i<list.size();i++) {
			//System.out.println(i);
			int gId = list.get(i).getgId();
			//System.out.println("gid--"+gId);
			ArrayList<String> links = (ArrayList<String>) dao.getFirstImg(gId);
			//System.out.println(links.size());
			if(links.size()!=0) {
				list.get(i).setImgLink(links.get(0));
			} else {
				list.get(i).setImgLink("/EECS118-MINIP2/image/0.jpg");
			}
			
		}
		
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("gallery/gallery.jsp").forward(request, response);
		
	}

}
