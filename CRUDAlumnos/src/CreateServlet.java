//Parada Sánchez Liliana
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
        Cookie ck[] = request.getCookies();

		if (ck != null) {
			String name = ck[0].getValue();
			if (!name.equals("") || name != null) {
				request.getRequestDispatcher("link.html").include(request, response);
				out.println("<h1>Agregar nuevo alumno</h1>");  
		        out.print("<form action='SaveServlet' method='post'>");  
		        out.print("<table>");   
		        out.print("<tr><td>Numero de control:</td><td><input type='text' name='numero'/></td></tr>");  
		        out.print("<tr><td>Nombre:</td><td><input type='text' name='nombre'/></td></tr>");  
		        out.print("<tr><td>Curso:</td><td><input type='text' name='curso'/></td></tr>");  
		        out.print("<tr><td>Semestre:</td><td>");  
		        out.print("<select name='semestre' style='width:150px'>");  
		        out.print("<option>9</option>");  
		        out.print("<option>10</option>");  
		        out.print("<option>11</option>");  
		        out.print("<option>12</option>");
		        out.print("<option>13</option>");
		        out.print("</select>");  
		        out.print("</td></tr>");  
		        out.print("<tr><td colspan='2'><input type='submit' value='Guardar alumno'/></td></tr>");  
		        out.print("</table>");  
		        out.print("</form>");
			}
		} else {
			out.print("Por favor, primero ingresa a tu cuenta!");
			request.getRequestDispatcher("login.html").include(request, response);
		}          
        out.close();
	}
}
