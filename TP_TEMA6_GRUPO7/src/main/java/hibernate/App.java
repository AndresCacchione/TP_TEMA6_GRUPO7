package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import dao.ConfigHibernate;
import hibernate.entidad.Autor;
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
         session.getTransaction().commit();
         cHibernate.cerrarSession();;      
         
    }
}


