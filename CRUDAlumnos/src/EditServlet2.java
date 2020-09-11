//Parada Sánchez Liliana
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditServlet2
 */
@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet2() {
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
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String numero=request.getParameter("numero");  
        String nombre=request.getParameter("nombre");  
        String curso=request.getParameter("curso");  
        String semestre=request.getParameter("semestre");  
          
        Alumno a=new Alumno();  
        a.setId(id);  
        a.setNumero(numero);  
        a.setNombre(nombre);  
        a.setCurso(curso);  
        a.setSemestre(Integer.parseInt(semestre));  
          
        int status=AlumnoDAO.update(a);  
        if(status>0){  
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Lo sentimos! Ocurrió un error");  
        }  
          
        out.close();
	}

}
