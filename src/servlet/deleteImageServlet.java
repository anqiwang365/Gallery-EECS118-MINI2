package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ArtistDao;
import dao.DetailDao;
import dao.ImageDao;
import model.Image;

/**
 * Servlet implementation class deleteImageServlet
 */
@WebServlet("/deleteImageServlet")
public class deleteImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteImageServlet() {
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
			String id = request.getParameter("iId");
			String gId = request.getParameter("gId");
			String dId = request.getParameter("dId");
			if(id != null && !id.equals(" ")) {
				int iId = Integer.valueOf(id);
				ImageDao dao = new ImageDao();
				DetailDao dao1 = new DetailDao();
				dao1.deleteDetail(Integer.valueOf(dId));
				
				
				//delete in file
				Image image = dao.selectById(iId);
				String link = image.getLink();
				System.out.println(link);
				String temp[] = link.split("/");
				String tempName = temp[3];
				String uploadLink = request.getSession().getServletContext().getRealPath("/image/")+tempName;
				File oldFile = new File(uploadLink);
				oldFile.delete();
				dao.deleteImage(iId);
			}
			request.getRequestDispatcher("ViewGServlet?gId="+gId).forward(request, response);
	}

}
