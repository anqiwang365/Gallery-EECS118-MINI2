package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDao;
import model.Gallery;
import model.Image;

/**
 * Servlet implementation class ViewGServlet
 */
@WebServlet("/ViewGServlet")
public class ViewGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewGServlet() {
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
		String id = request.getParameter("gId");
		//System.out.println(id);
		GalleryDao dao = new GalleryDao();
		List<Image> list = dao.viewGallery(Integer.parseInt(id));
		int amount = dao.totalNumber(Integer.parseInt(id));
		request.setAttribute("list", list);
		request.setAttribute("amount",amount);
		request.setAttribute("gId", id);
		request.getRequestDispatcher("gallery/ViewGallery.jsp").forward(request, response);
	}

}
