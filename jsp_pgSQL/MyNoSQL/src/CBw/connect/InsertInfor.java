package CBw.connect;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CBw.connect.connect;

@WebServlet("/insert")
public class InsertInfor extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertInfor() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String coures1 = request.getParameter("course1");
		String course1_score = request.getParameter("course1_score");
		String course2 = request.getParameter("course2");
		String course2_score = request.getParameter("course2_score");
		
		//System.out.println(math+ " hhhhh"+ id);
		
		connect con = new connect();
		try {
			if(con.insertInfo(id, name, coures1, course1_score, course2, course2_score)) {
				request.setAttribute("successMessage", "Congratulations on your successful insertion.");
				request.getRequestDispatcher("success.jsp").forward(request, response);
			}else {
				request.setAttribute("errorMessage", "Your insertion work failed!");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
