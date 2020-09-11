//Parada Sánchez Liliana
import java.io.IOException;
import java.io.PrintWriter;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
			out.print("<p>Guardado exitosamente!</p>");
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			out.println("Lo sentimos! Ocurrió un error");
		}

		out.close();
	}

}
