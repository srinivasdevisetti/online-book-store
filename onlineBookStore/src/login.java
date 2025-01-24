

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/post")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stubdd
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
	String username=request.getParameter("username");
	String password=request.getParameter("password");
	
	
	try
    {
		Class.forName("com.mysql.jdbc.Driver");  
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "14597");
    
    
      String query = " select * from users ";

      // create the mysql insert preparedstatement
      Statement stmt=conn.createStatement();

      ResultSet rs = stmt.executeQuery(query);
      while(rs.next()){
    	  
    	 if(username.equals( rs.getString(3)) && password.equals( rs.getString(4))) {
    		 String destination = "home.jsp";
    			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
    			request.setAttribute("username", username);
    			requestDispatcher.forward(request, response);
    			response.sendRedirect("home.jsp");
    			break;
    		}
    		/*else {
    			response.sendRedirect("error.html");
    		}*/
    	 
      }
      response.sendRedirect("error.html");
      conn.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
	
	
	
	
	
	}

}
