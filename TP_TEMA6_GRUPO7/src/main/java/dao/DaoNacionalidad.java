package dao;

import org.hibernate.Session;
import hibernate.entidad.Nacionalidad;

public class DaoNacionalidad {
	
	private static ConfigHibernate cHibernate;
	private static Session session;
	
	public static void Add(Nacionalidad nacionalidad) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();	
		session.beginTransaction();		
		session.save(nacionalidad);		
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static Nacionalidad ReadOne(int id) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		Nacionalidad nacionalidad = (Nacionalidad)session.get(Nacionalidad.class,id);
		cHibernate.cerrarSession();
		return nacionalidad;		
			
	}
	
	public static void Update(Nacionalidad nacionalidad) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.update(nacionalidad);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	
	public static void Delete(Nacionalidad nacionalidad) {
		cHibernate = new ConfigHibernate();
		session = cHibernate.abrirConexion();
		session.beginTransaction();
		session.delete(nacionalidad);
		session.getTransaction().commit();
		cHibernate.cerrarSession();
	}
	

}
