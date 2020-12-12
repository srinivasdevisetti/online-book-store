

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String username=request.getParameter("username");
		
		try
	    {
			Class.forName("com.mysql.jdbc.Driver");  
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "14597");
	    
	    
	      String query = "insert into cart(book_id,username)\r\n"
	      		+ "value(?,?)";


	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      
	      preparedStmt.setInt(1,id);
	      preparedStmt.setString(2,username);
	      

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    } 
		 String destination = "home.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
			request.setAttribute("username", username);
			requestDispatcher.forward(request, response);
			response.sendRedirect("home.jsp");
		response.sendRedirect("home.jsp");
	}

}
