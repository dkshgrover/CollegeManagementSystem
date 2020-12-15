package servelets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DBConnection.ConnectionProvider;

import java.sql.*;

@WebServlet("/Main_editMainData")
public class Main_editMainData extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Connection con = ConnectionProvider.provideConnection();
			String qry = "select * from main_data";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qry);
			rs.next();
			int a = rs.getInt(1);
			a++;
			String query = "update main_data set no_of_students=" + a;
			int c = st.executeUpdate(query);
		} catch (Exception e) {

		}
		RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
		rd.forward(request, response);
	}

}
