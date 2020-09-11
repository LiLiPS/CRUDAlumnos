//Parada Sánchez Liliana
import java.util.*;  
import java.sql.*;  
  
public class AlumnoDAO {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnosweb","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    
    public static int save(Alumno a){  
        int status=0;  
        try{  
            Connection con=AlumnoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into alumnosWeb(numeroControl,nombre,curso,semestre) values (?,?,?,?)");  
            ps.setString(1,a.getNumero());  
            ps.setString(2,a.getNombre());  
            ps.setString(3,a.getCurso());  
            ps.setInt(4,a.getSemestre());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int update(Alumno a){  
        int status=0;  
        try{  
            Connection con=AlumnoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update alumnosWeb set numeroControl=?,nombre=?,curso=?,semestre=? where id=?");  
            ps.setString(1,a.getNumero());  
            ps.setString(2,a.getNombre());  
            ps.setString(3,a.getCurso());  
            ps.setInt(4,a.getSemestre());  
            ps.setInt(5,a.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=AlumnoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from alumnosWeb where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    
    public static Alumno getAlumnoById(int id){  
        Alumno a=new Alumno();  
          
        try{  
            Connection con=AlumnoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from alumnosWeb where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                a.setId(rs.getInt(1));  
                a.setNumero(rs.getString(2));  
                a.setNombre(rs.getString(3));  
                a.setCurso(rs.getString(4));  
                a.setSemestre(rs.getInt(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return a;  
    }  
    
    public static List<Alumno> getTodosAlumnos(){  
        List<Alumno> list=new ArrayList<Alumno>();  
          
        try{  
            Connection con=AlumnoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from alumnosWeb");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Alumno a=new Alumno();  
                a.setId(rs.getInt(1));  
                a.setNumero(rs.getString(2));  
                a.setNombre(rs.getString(3));  
                a.setCurso(rs.getString(4));  
                a.setSemestre(rs.getInt(5));  
                list.add(a);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
    
    public static List<Alumno> getAlumnosbyNumero(String numero){  
        List<Alumno> list=new ArrayList<Alumno>();  
          
        try{  
            Connection con=AlumnoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from alumnosWeb where numeroControl LIKE ?");  
            ps.setString(1,"%" + numero + "%");  
            ResultSet rs=ps.executeQuery(); 
            while(rs.next()){  
                Alumno a=new Alumno();  
                a.setId(rs.getInt(1));  
                a.setNumero(rs.getString(2));  
                a.setNombre(rs.getString(3));  
                a.setCurso(rs.getString(4));  
                a.setSemestre(rs.getInt(5));  
                list.add(a);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }
}