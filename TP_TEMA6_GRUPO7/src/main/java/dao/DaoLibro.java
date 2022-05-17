package dao;

import java.sql.Date;

import org.hibernate.Session;

import hibernate.entidad.Libro;

public class DaoLibro {
	
	public void Add(Libro libro) {
		ConfigHibernate cHibernate = new ConfigHibernate();
		Session session = cHibernate.abrirConexion();
		libro.setFechaLanzamiento(formatDate(libro.getFechaLanzamiento()));		
		session.beginTransaction();		
		session.save(libro);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public Libro ReadOne(int isbn) {
		ConfigHibernate cHibernate = new ConfigHibernate();
		Session session = cHibernate.abrirConexion();
		session.beginTransaction();
		Libro libro = (Libro)session.get(Libro.class,isbn);
		cHibernate.cerrarSession();
		return libro;
	}
	
	public void Update(Libro libro) {
		ConfigHibernate cHibernate = new ConfigHibernate();
		Session session = cHibernate.abrirConexion();
		libro.setFechaLanzamiento(formatDate(libro.getFechaLanzamiento()));
		session.beginTransaction();
		session.update(libro);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public void Delete(Libro libro) {
		ConfigHibernate cHibernate = new ConfigHibernate();
		Session session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(libro);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	protected Date formatDate(Date date) {
		ConfigHibernate cHibernate = new ConfigHibernate();
		Session session = cHibernate.abrirConexion();
		date.setMonth(date.getMonth()-1);
		date.setYear(date.getYear()-1900);
		return date;
	}
}
