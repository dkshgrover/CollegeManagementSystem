package servelets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnection.ConnectionProvider;

@WebServlet("/PR_updateservlet")
public class PR_updateservlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String roll=request.getParameter("roll");
		String status=request.getParameter("status");
		try {
			Connection con = ConnectionProvider.provideConnection();
			String qry = "update fees_info set annual_fee='"+status+"' where uname='"+roll+"'";
			Statement st = con.createStatement();
			int count = st.executeUpdate(qry);
			if (count == 1) {
				response.sendRedirect("PR_successful.jsp");
			} else {
				request.setAttribute("ERRM", "Something Wrong Happened**");
				request.getRequestDispatcher("PR_updateDetailsANNUAL.jsp").forward(request, response);
			}

		} catch (Exception e) {

		}
	}

}
