

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
 * Servlet implementation class buy
 */
@WebServlet("/buy")
public class buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public buy() {
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
		String name=request.getParameter("username");

		try
	    {
			Class.forName("com.mysql.jdbc.Driver");  
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "14597");
	    
	    
	      String query = "INSERT INTO `book_store`.`orders` (`book_id`, `username`) VALUES (?, ?)";


	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      
	      preparedStmt.setInt(1,id);
	      preparedStmt.setString(2,name);
	   

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    } 
		try
	    {
			Class.forName("com.mysql.jdbc.Driver");  
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "14597");
	    
	    
	      String query = "UPDATE `book_store`.`books` SET `stock` = stock - 1 WHERE (`id` = ?)";



	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      
	      preparedStmt.setInt(1,id);
	    
	   

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    } 
		try
	    {
			Class.forName("com.mysql.jdbc.Driver");  
	      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_store", "root", "14597");
	    
	    
	      String query = "delete from cart\r\n"
	      		+ "where book_id=? and username=?";



	      // create the mysql insert preparedstatement
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      
	      preparedStmt.setInt(1,id);
	      preparedStmt.setString(2, name);
	   

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception!");
	      System.err.println(e.getMessage());
	    } 
		 String destination = "os.jsp";
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
			request.setAttribute("username", name);
			requestDispatcher.forward(request, response);
		

	}

}
