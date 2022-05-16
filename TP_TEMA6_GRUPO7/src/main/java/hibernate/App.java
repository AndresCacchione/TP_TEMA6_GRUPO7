package hibernate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.ConfigHibernate;
import hibernate.entidad.Autor;
import hibernate.entidad.Genero;
import hibernate.entidad.Libro;
import hibernate.entidad.Nacionalidad;

public class App {
	
    public static void main( String[] args ) {
    	
    	ConfigHibernate cHibernate =new ConfigHibernate();
    	Session session =cHibernate.abrirConexion();

    	session.beginTransaction();
         
         Nacionalidad nacionalidad =new Nacionalidad(1,"Argentina");
         session.save(nacionalidad);
         
         Autor autor=new Autor();
         autor.setId(1);
         autor.setNombre("juan");
         autor.setNacionalidad(nacionalidad);
         session.save(autor);
         
         Genero genero= new Genero(1,"Misterio");   
         Genero genero2= new Genero(1,"Accion");  
          ArrayList<Genero> generos=new ArrayList<Genero>();
           generos.add(genero);
           generos.add(genero2);
           session.save(generos);
           
         Date fecha = new Date(0);
         Libro libro =new Libro(123,"Asesinato en el orient express",fecha,"ingles",200,autor,"muy bueno",generos);
         
         session.save(libro);
         
         session.getTransaction().commit();
         cHibernate.cerrarSession();;    
         

         
    }
}


