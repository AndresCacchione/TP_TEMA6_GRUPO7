package dao;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
 
public class ConfigHibernate {
    
    private SessionFactory sessionFactory;
    private Session session;
    
    public ConfigHibernate() {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceregistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceregistry);
    }
    
    public Session abrirConexion() {
        session = sessionFactory.openSession();
        return session;
    }
    
    public void cerrarSession() {
        session.close();
        cerrarSessionFactory();
    }
    
    public void cerrarSessionFactory() {
        sessionFactory.close();
    }
}