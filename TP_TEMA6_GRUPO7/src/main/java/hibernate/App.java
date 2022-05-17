package hibernate;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import dao.ConfigHibernate;
import dao.DaoLibro;
import hibernate.entidad.Autor;
import hibernate.entidad.Genero;
import hibernate.entidad.Libro;
import hibernate.entidad.Nacionalidad;


public class App {
	
	public static void main( String[] args ) {
		ConfigHibernate cHibernate = new ConfigHibernate();
		Session session = cHibernate.abrirConexion();
		session.beginTransaction();
    	Nacionalidad nacionalidad = new Nacionalidad(1, "estadounidense");
    	session.save(nacionalidad);
        session.getTransaction().commit();
        cHibernate.cerrarSession();
        
        cHibernate = new ConfigHibernate();
        Session session2 = cHibernate.abrirConexion();
    	session2.beginTransaction();
    	Autor autorPrueba = new Autor(1, "Victor","Miller", nacionalidad,"victor.miller@jasonvoorhees.com");
    	session2.save(autorPrueba);
    	session2.getTransaction().commit();
        cHibernate.cerrarSession();
    	
        cHibernate = new ConfigHibernate();
        Session session3 = cHibernate.abrirConexion();
    	session3.beginTransaction();
    	Set<Genero> setGeneros = new HashSet<Genero>();
        Genero terror = new Genero(1,"Terror");
        session3.save(terror);
        session3.getTransaction().commit();
        cHibernate.cerrarSession();
        
        cHibernate = new ConfigHibernate();
        Session session4 = cHibernate.abrirConexion();
    	session4.beginTransaction();
        setGeneros.add(terror);
        
        Libro libro = new Libro(4432,"Jason Voorhees", new Date(2001, 12, 15), "Inglés", 350, autorPrueba,"Libro que no te deja dormir", setGeneros);
        DaoLibro.Add(libro);
    }
}


