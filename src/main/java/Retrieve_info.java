import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RetrieveInformation")
public class Retrieve_info extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/StudentDB";
            String username = "root";
            String password = "Kumar@1234";
            conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM Student WHERE email = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            rs = stmt.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("ses_name", rs.getString("name"));
                session.setAttribute("ses_email", rs.getString("email"));
                session.setAttribute("ses_age", rs.getString("age"));
                session.setAttribute("ses_gender", rs.getString("gender"));
                session.setAttribute("ses_semester", rs.getString("semester"));
                session.setAttribute("ses_department", rs.getString("department"));
                session.setAttribute("ses_collegeName", rs.getString("collegeName"));
 
            } else {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.println("<h3 style='color:red;'>No student found with the provided email address.</h3>");
                
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/retrieveDisplay.jsp");
            dispatcher.include(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<h3 style='color:red;'>An error occurred: " + e.getMessage() + "</h3>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/retrieveDisplay.jsp");
            dispatcher.include(request, response);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
