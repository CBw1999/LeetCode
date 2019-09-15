package CBw.connect;

import java.io.IOException;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CBw.connect.connect;

/**
 * Servlet implementation class getStuScore
 */
@WebServlet("/Query")
public class QueryInfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryInfor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuId = request.getParameter("Id");
		connect model = new connect();
		Map map = null;
		try {
			if((map=model.getStuScore(stuId)) != null) {
				request.setAttribute("scoreMap", map);
				request.setAttribute("Id", stuId);
				request.getRequestDispatcher("query_result.jsp").forward(request, response);
			}else {
				request.setAttribute("errorMessage", "Sorry, can't find the data.");
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
