package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDao;
import model.Artist;

/**
 * Servlet implementation class SearchAByCountry
 */
@WebServlet("/SearchAByCountry")
public class SearchAByCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchAByCountry() {
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
		String country = request.getParameter("country");
		ArtistDao dao = new ArtistDao();
		List<Artist> list = new ArrayList<Artist>();
		//System.out.println("jjj");
		list = dao.selectByCountry(country);
		//System.out.println(list.size());
		request.setAttribute("list", list);
		request.getRequestDispatcher("gallery/SearchArtist.jsp").forward(request, response);
	}

}
