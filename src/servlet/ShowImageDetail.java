package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GalleryDao;
import dao.ImageDao;
import model.Gallery;
import model.Image;

/**
 * Servlet implementation class ShowImageDetail
 */
@WebServlet("/ShowImageDetail")
public class ShowImageDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowImageDetail() {
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
		//System.out.println(id+"id");
		String gId = request.getParameter("gId");
		//System.out.println("gid"+gId);
		ImageDao dao = new ImageDao();
		Image image = dao.getInfo(Integer.parseInt(id));
		//System.out.println(image.getaId()+"iaid");
		request.setAttribute("image", image);
		request.setAttribute("gId",Integer.parseInt(gId));
		request.getRequestDispatcher("gallery/ImageInfo.jsp").forward(request, response);
		
	}

}
