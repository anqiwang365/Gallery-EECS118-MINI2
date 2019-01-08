package servlet;

import java.io.IOException;
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
 * Servlet implementation class UpdateAServlet
 */
@WebServlet("/UpdateAServlet")
public class UpdateAServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("aId");
		String iId = request.getParameter("iId");
		if(id != null && !id.equals(" ")) {
			
			int aId = Integer.valueOf(id);
			ArtistDao dao = new ArtistDao();
			Artist a = dao.selectAById(aId);
			//System.out.println(g.getgDes());
			request.setAttribute("artist", a);
			request.setAttribute("iId", iId);
			
		}
		request.getRequestDispatcher("gallery/UpdateArtist.jsp?iId="+iId).forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String aId = request.getParameter("aId");
		String iId = request.getParameter("iId");
		
		
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		String country = request.getParameter("country");
		String description = request.getParameter("description");
		
		Artist a = new Artist();
		a.setaId(Integer.parseInt(aId));
		a.setBirth(Integer.parseInt(year));
		a.setCountry(country);
		a.setName(name);
		a.setaDes(description);
		
		ArtistDao dao = new ArtistDao();
		dao.updateArtist(a);
		request.getRequestDispatcher("ShowAServlet?iId="+iId).forward(request, response);
	}

}
