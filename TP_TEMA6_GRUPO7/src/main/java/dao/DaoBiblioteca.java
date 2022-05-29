package dao;

import java.sql.Date;

import org.hibernate.Session;

import hibernate.entidad.Biblioteca;

public class DaoBiblioteca {
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	public static void Add(Biblioteca b) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();	
		b.setFechaAlta(formatDate(b.getFechaAlta()));
		session.save(b);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static Biblioteca ReadOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Biblioteca b = (Biblioteca)session.get(Biblioteca.class,id);
		cHibernate.cerrarSession();
		return b;
	}
	
	public static void Update(Biblioteca b) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		b.setFechaAlta(formatDate(b.getFechaAlta()));
		session.update(b);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static void Delete(Biblioteca b) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(b);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	protected static Date formatDate(Date date) {
		date.setMonth(date.getMonth()-1);
		date.setYear(date.getYear()-1900);
		return date;
	}
}
