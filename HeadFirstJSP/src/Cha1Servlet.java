import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * Name: admin
 * Date: 2017/3/29
 * Time: 16:06
 */
public class Cha1Servlet extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        java.util.Date today = new java.util.Date();
        out.println("<html>"+
                "<body>"+
                "<h1 align=center>HF\'s Chapter1 Servlet</h1>"
                +"<br>"+ today +"</body>" + "</html>");
    }
}