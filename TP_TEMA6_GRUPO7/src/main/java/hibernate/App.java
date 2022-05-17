package hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import dao.ConfigHibernate;
import hibernate.entidad.Autor;
import hibernate.entidad.Genero;
import hibernate.entidad.Libro;
import hibernate.entidad.Nacionalidad;
import java.time.LocalDate;

public class App {
	
    public static void main( String[] args ) {
    	
    	ConfigHibernate cHibernate = new ConfigHibernate();
    	Session session = cHibernate.abrirConexion();

    	session.beginTransaction();
         
    	Autor autorPrueba = new Autor(1, "Victor","Miller", new Nacionalidad(1, "estadounidense"),"victor.miller@jasonvoorhees.com");
    	Set<Genero> setGeneros = new HashSet<Genero>();
         Genero terror = new Genero(1,"Terror");
         setGeneros.add(terror);
         
         Libro libro = new Libro(4432,"Jason Voorhees", LocalDate.of(2001, 12, 15), "Inglés", 350, autorPrueba,"Libro que no te deja dormir", setGeneros);
         
         session.save(libro);

         session.getTransaction().commit();
         cHibernate.cerrarSession();   
         
    }
}


