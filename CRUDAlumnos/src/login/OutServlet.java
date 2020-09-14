//Parada Sánchez Liliana
package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OutServlet")
public class OutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();   
        
        Cookie cks[] = request.getCookies();
		if (cks != null) {
			String name = cks[0].getValue();
			if (!name.equals("") || name != null) {
				request.getRequestDispatcher("link.html").include(request, response); 
		        Cookie ck=new Cookie("name","");  
		        ck.setMaxAge(0); 
		        response.addCookie(ck);  
		             
		        out.print("Has cerrado sesión exitosamente!");
			}
		} else {
			out.print("Por favor, primero ingresa a tu cuenta!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
