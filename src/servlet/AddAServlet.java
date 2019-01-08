package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDao;
import model.Artist;

/**
 * Servlet implementation class AddAServlet
 */
@WebServlet("/AddAServlet")
public class AddAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAServlet() {
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
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String country = request.getParameter("country");
		String des = request.getParameter("description");
		Artist a = new Artist();
		a.setName(name);
		a.setBirth(Integer.parseInt(year));
		a.setCountry(country);
		a.setaDes(des);
		ArtistDao dao = new ArtistDao();
		dao.addArtist(a);
		request.getRequestDispatcher("ShowGServlet").forward(request, response);                                                                  
	}

}
