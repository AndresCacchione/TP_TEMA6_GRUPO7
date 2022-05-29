package dao;
import org.hibernate.Session;

import hibernate.entidad.Autor;

public class DaoAutor {
	
	private static ConfigHibernate cHibernate;
	private static Session session;
	
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
