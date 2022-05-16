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
    
    protected Session abrirConexion() {
        session = sessionFactory.openSession();
        return session;
    }
    
    protected void cerrarSession() {
        session.close();
        cerrarSessionFactory();
    }
    
    protected void cerrarSessionFactory() {
        sessionFactory.close();
    }
}