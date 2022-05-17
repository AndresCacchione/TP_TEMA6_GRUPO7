package dao;

import java.sql.Date;

import org.hibernate.Session;

import hibernate.entidad.Libro;

public class DaoLibro {
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	public static void Add(Libro libro) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		libro.setFechaLanzamiento(formatDate(libro.getFechaLanzamiento()));		
		session.beginTransaction();		
		session.save(libro);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static Libro ReadOne(int isbn) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Libro libro = (Libro)session.get(Libro.class,isbn);
		cHibernate.cerrarSession();
		return libro;
	}
	
	public static void Update(Libro libro) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		libro.setFechaLanzamiento(formatDate(libro.getFechaLanzamiento()));
		session.beginTransaction();
		session.update(libro);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static void Delete(Libro libro) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(libro);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	protected static Date formatDate(Date date) {
		date.setMonth(date.getMonth()-1);
		date.setYear(date.getYear()-1900);
		return date;
	}
}
