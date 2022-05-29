package dao;
import java.util.List;

import org.hibernate.Session;

import hibernate.entidad.Autor;
import hibernate.entidad.Libro;
import hibernate.entidad.Nacionalidad;

public class DaoAutor {
	
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	public static void ReadAutorByNacionalidad(String nacionalidad) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		List<Autor> listaAutores = (List<Autor>) session.createQuery("FROM Autor aut where aut.nacionalidad.descripcion = '" + nacionalidad + "'").list();
		
		System.err.println("Autores Argentinos: ");
		for (Autor autor : listaAutores) {
			System.out.println(autor.toString());
		}
		
		cHibernate.cerrarSession();
	}
	
	public static void Add(Autor autor) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(autor);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static Autor ReadOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Autor autor = (Autor)session.get(Autor.class,id);
		cHibernate.cerrarSession();
		return autor;		
			
	}
	
	public static void Update(Autor autor) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(autor);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static void Delete(Autor autor) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(autor);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	

}
