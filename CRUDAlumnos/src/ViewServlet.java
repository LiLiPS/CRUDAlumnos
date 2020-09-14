//Parada Sánchez Liliana
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String estadoPagina = "nada";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Cookie cks[] = request.getCookies();
		if (cks != null) {
			String name = cks[0].getValue();
			if (!name.equals("") || name != null) {
				request.getRequestDispatcher("link.html").include(request, response);
				out.print("Bienvenido " + name);
				out.println("<br><a href='CreateServlet'>Agregar nuevo alumno</a>");
				out.println("<form action='http://localhost:9090/CRUDAlumnos/ViewServlet' method='GET'> ");
				out.println("<h4>Buscar un alumno</h4>");
				out.println("<input type='text' placeholder='Número de control' name='numeroC'>"
						+ "<input type='submit' name='buscar' value='buscar'>");
				out.println(" <input type='hidden' name='sts' value='buscar'> ");
				out.println("</form>");
				out.println("<h1>Lista de alumnos</h1>");
				String sid = request.getParameter("numeroC");
				String numero = sid;
				List<Alumno> list = new ArrayList<Alumno>();

				try { // Obtener el estado (status-->sts)
					estadoPagina = request.getParameter("sts");
					if (estadoPagina == null) {
						estadoPagina = "nada";
						list = AlumnoDAO.getTodosAlumnos();
					}
					if (estadoPagina.equals("buscar")) {
						if (numero == "")
							list = AlumnoDAO.getTodosAlumnos();
						else
							list = AlumnoDAO.getAlumnosbyNumero(numero);
					}
				} catch (Exception exx) {
					exx.printStackTrace();
				}

				out.print("<table border='1' width='100%'");
				out.print("<tr><th>Id</th><th>Número de control</th><th>Nombre</th><th>Curso</th>"
						+ "<th>Semestre</th><th>Editar</th><th>Borrar</th></tr>");
				if (list.isEmpty()) {
					out.print("<tr><th colspan=7>No se encontraron alumnos</th></tr>");
				} else {
					for (Alumno a : list) {
						out.print("<tr><td>" + a.getId() + "</td><td>" + a.getNumero() + "</td><td>" + a.getNombre()
								+ "</td>" + "<td>" + a.getCurso() + "</td><td>" + a.getSemestre()
								+ "</td><td><a href='EditServlet?id=" + a.getId()
								+ "'>Editar</a></td><td><a href='DeleteServlet?id=" + a.getId()
								+ "'>Borrar</a></td></tr>");
					}
				}
				out.print("</table>");
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
