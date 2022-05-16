package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	
    public static void main( String[] args ) {
    	 SessionFactory sessionFactory;
         
         Configuration configuration = new Configuration();
         configuration.configure();
         
         ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
         sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
         Session session = sessionFactory.openSession();
         
         session.beginTransaction();
         
         session.close();
         
         sessionFactory.close();
    }
}
