//Parada S�nchez Liliana
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Editar Alumno</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Alumno a=AlumnoDAO.getAlumnoById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+a.getId()+"'/></td></tr>");  
        out.print("<tr><td>Numero de control:</td><td><input type='text' name='numero' value='"+a.getNumero()+"'/></td></tr>");  
        out.print("<tr><td>Nombre:</td><td><input type='text' name='nombre' value='"+a.getNombre()+"'/></td></tr>");  
        out.print("<tr><td>Curso:</td><td><input type='text' name='curso' value='"+a.getCurso()+"'/></td></tr>");  
        out.print("<tr><td>Semestre:</td><td>");  
        out.print("<select name='semestre' style='width:150px'>");  
        out.print("<option>9</option>");  
        out.print("<option>10</option>");  
        out.print("<option>11</option>");  
        out.print("<option>12</option>");
        out.print("<option>13</option>");
        out.print("</select>");  
        out.print("</td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Editar y guardar'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
