import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	PrintWriter out = response.getWriter();
    	
    	String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String semester = request.getParameter("semester");
        String department = request.getParameter("department");
        String collegeName = request.getParameter("collegeName");
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
        	//The driver class `com.mysql.cj.jdbc.Driver` is loaded
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
			//creating a connection
	        String url = "jdbc:mysql://localhost:3306/StudentDB";
	        String username = "root";
	        String pass = "Kumar@1234";
	        
	        conn = DriverManager.getConnection(url, username, pass);
            String sql = "INSERT INTO Student (name, email, password, age, gender, semester, department, collegeName) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setInt(4, Integer.parseInt(age));
            stmt.setString(5, gender);
            stmt.setString(6, semester);
            stmt.setString(7, department);
            stmt.setString(8, collegeName);
            int count = stmt.executeUpdate();
            
			if(count > 0) {
				response.setContentType("text/html");
				out.println("<h3 style = 'color:green'> ✅ </h3>");
				
			}else {
				response.setContentType("text/html");
				out.println("<h3 style = 'color:red'> User registration failed due to some error </h3>");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/display.jsp");
			rd.include(request, response);

        } catch(Exception e) {
            e.printStackTrace();
            response.setContentType("text/html");
			out.println("<h3 style = 'color:red'> Exception occured :" + e.getMessage()+ " </h3>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/display.jsp");
			rd.include(request, response);
        } 
        
        finally {
            try {
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
            
    }
}