package dao;

import org.hibernate.Session;

import hibernate.entidad.Genero;

public class DaoGenero {
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	public static void Add(Genero genero) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(genero);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static Genero ReadOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Genero genero = (Genero)session.get(Genero.class,id);
		cHibernate.cerrarSession();
		return genero;
	}
	
	public static void Update(Genero genero) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(genero);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static void Delete(Genero genero) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(genero);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}

}
