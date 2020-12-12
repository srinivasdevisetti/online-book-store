

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class storeuser
 */
@WebServlet("/storeuser")
public class storeuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public storeuser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String name = request.getParameter("name");
	       long phone = Long.parseLong(request.getParameter("number"));
	       String username = request.getParameter("username");
	       String password = request.getParameter("password");
	       String address = request.getParameter("address");
	       
		try
	    {
			Class.forName("com.mysql.jdbc.Driver");  
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "14597");
	    
	    
	      String query = " insert into users ( `name`, `number`, `username`, `password`,`address`)"
	        + " values (?, ?, ?, ?,?)";

	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setString (1, name);
	      preparedStmt.setLong(2,phone);
	      preparedStmt.setString (3,username );
	      preparedStmt.setString (4,password );

	      preparedStmt.setString (5,address );
	    
	   

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    }
		response.sendRedirect("login.jsp");
		
		
	}

}
