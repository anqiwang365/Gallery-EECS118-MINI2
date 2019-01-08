package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDao;
import model.Gallery;

/**
 * Servlet implementation class UpdateG
 */
@WebServlet("/UpdateGServlet")
public class UpdateGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGServlet() {
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("gId");
		//System.out.println(id);
		if(id != null && !id.equals(" ")) {
			
			int gId = Integer.valueOf(id);
			GalleryDao dao = new GalleryDao();
			Gallery g = dao.selectGById(gId);
			//System.out.println(g.getgDes());
			request.setAttribute("gallery", g);
		}
		request.getRequestDispatcher("gallery/UpdateGallery.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String gId = request.getParameter("id");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		Gallery g = new Gallery();
		g.setgId(Integer.parseInt(gId));
		g.setName(name);
		g.setgDes(description);
		
		GalleryDao dao = new GalleryDao();
		dao.updateGallery(g);
		request.getRequestDispatcher("ShowGServlet").forward(request, response);
	}

}
