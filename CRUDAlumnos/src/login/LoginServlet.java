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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
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
	    
	    request.getRequestDispatcher("link.html").include(request, response);
	          
	    String n=request.getParameter("name");  
	    String p=request.getParameter("password");  
	          
	    if(LoginDAO.validate(n, p)){  
	        request.getRequestDispatcher("ViewServlet").forward(request,response);  
	        
	        Cookie ck=new Cookie("name",n);  
            response.addCookie(ck);
	    }  
	    else{  
	        out.print("Lo sentimos, error de usuario o contraseña!");  
	        request.getRequestDispatcher("login.html").include(request,response);  
	    }  
	          
	    out.close();  
	}

}
