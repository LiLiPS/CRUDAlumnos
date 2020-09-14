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


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie ck[] = request.getCookies();

		if (ck != null) {
			String name = ck[0].getValue();
			if (!name.equals("") || name != null) {
				request.getRequestDispatcher("link.html").include(request, response);
				out.print("<b>Bienvenido a tu perfil</b>");
				out.print("<br>Bienvenid@, " + name);
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
