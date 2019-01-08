package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDao;
import dao.GalleryDao; 	
import model.Artist;
import model.Gallery;

/**
 * Servlet implementation class ShowAServlet
 */
@WebServlet("/ShowAServlet")
public class ShowAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAServlet() {
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
		String iId = request.getParameter("iId");
		ArtistDao dao = new ArtistDao();
		Artist a = dao.selectAByImageId(Integer.parseInt(iId));
		request.setAttribute("a", a);
		request.setAttribute("iId", iId);
		request.getRequestDispatcher("gallery/artists.jsp").forward(request, response);
	}

}
