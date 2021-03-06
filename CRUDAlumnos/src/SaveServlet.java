//Parada S�nchez Liliana
import java.io.IOException;
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);
		if (session != null) {
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} else {
			out.print("Por favor, primero ingresa a tu cuenta!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String numero = request.getParameter("numero");
		String nombre = request.getParameter("nombre");
		String curso = request.getParameter("curso");
		String semestre = request.getParameter("semestre");

		Alumno e = new Alumno();
		e.setNumero(numero);
		e.setNombre(nombre);
		e.setCurso(curso);
		e.setSemestre(Integer.parseInt(semestre));

		int status = AlumnoDAO.save(e);
		if (status > 0) {
			request.getRequestDispatcher("link.html").include(request, response);
			out.print("<p>Guardado exitosamente!</p>");
		} else {
			out.println("Lo sentimos! Ocurri� un error");
		}
		out.close();
	}

}
