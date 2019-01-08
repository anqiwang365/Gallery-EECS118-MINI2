package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImageDao;
import model.Image;

/**
 * Servlet implementation class SearhIByYear
 */
@WebServlet("/SearchIByYear")
public class SearchIByYear extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIByYear() {
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
		String year1 = request.getParameter("year1");
		String year2 = request.getParameter("year2");
		ImageDao dao = new ImageDao();
		List<Image> list = new ArrayList<Image>();
		//System.out.println("jjj");
		list = dao.findByYearRange(year1, year2);
		//System.out.println(list.size());
		request.setAttribute("ilist", list);
		request.getRequestDispatcher("gallery/SearchImage.jsp").forward(request, response);
	}

}
