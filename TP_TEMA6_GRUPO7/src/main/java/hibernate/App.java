package hibernate;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import dao.ConfigHibernate;
import dao.DaoBiblioteca;
import dao.DaoGenero;
import dao.DaoAutor;
import dao.DaoLibro;
import dao.DaoNacionalidad;
import hibernate.entidad.Autor;
import hibernate.entidad.Biblioteca;
import hibernate.entidad.Genero;
import hibernate.entidad.Libro;
import hibernate.entidad.Nacionalidad;


public class App {
	
	public static void main( String[] args ) {
    	Nacionalidad nacionalidad1 = new Nacionalidad(1, "estadounidense");
    	Nacionalidad nacionalidad2 = new Nacionalidad(2, "argentina");
    	Nacionalidad nacionalidad3 = new Nacionalidad(3, "argentina");
    	Nacionalidad nacionalidad4 = new Nacionalidad(4, "japones");
    	Nacionalidad nacionalidad5 = new Nacionalidad(5, "ruso");
    	DaoNacionalidad.Add(nacionalidad1);
    	DaoNacionalidad.Add(nacionalidad2);
    	DaoNacionalidad.Add(nacionalidad3);
    	DaoNacionalidad.Add(nacionalidad4);
    	DaoNacionalidad.Add(nacionalidad5);
        
    	Autor autorPrueba1 = new Autor(1, "Victor","Miller", nacionalidad1,"victor.miller@jasonvoorhees.com");
    	Autor autorPrueba2 = new Autor(2, "Juan","Perez", nacionalidad2,"juanp@gmail.com");
    	Autor autorPrueba3 = new Autor(3, "Arnold","Schwarz", nacionalidad3,"arnoldS@gmail.com");
    	Autor autorPrueba4 = new Autor(4, "Tanaka","Akira", nacionalidad4,"akiraT@hotmail.com");
    	Autor autorPrueba5 = new Autor(5, "mihail","tchaikovsky", nacionalidad5,"mihailT@outlook.com");
    	DaoAutor.Add(autorPrueba1 );
    	DaoAutor.Add(autorPrueba2 );
    	DaoAutor.Add(autorPrueba3 );
    	DaoAutor.Add(autorPrueba4 );
    	DaoAutor.Add(autorPrueba5 );
    	
    	Set<Genero> setGeneros1 = new HashSet<Genero>();
    	Set<Genero> setGeneros2 = new HashSet<Genero>();
    	Set<Genero> setGeneros3 = new HashSet<Genero>();
        Genero terror = new Genero(1,"Terror");
        DaoGenero.Add(terror);
        Genero cienciaFiccion = new Genero(2,"Ciencia Ficción");
        DaoGenero.Add(cienciaFiccion);
        Genero comedia = new Genero(3,"Comedia");
        DaoGenero.Add(comedia);
        Genero drama = new Genero(4,"Drama");
        DaoGenero.Add(drama);
        Genero teatro = new Genero(5,"Teatro");
        DaoGenero.Add(teatro);

        setGeneros1.add(terror);
        setGeneros1.add(cienciaFiccion);
        setGeneros2.add(comedia);
        setGeneros2.add(drama);
        setGeneros3.add(teatro);
        setGeneros3.add(terror);
        
        Libro libro1 = new Libro(4432,"Jason Voorhees", new Date(2001,12,20), "Inglés", 350, autorPrueba1,"Libro que no te deja dormir", setGeneros1);
        Libro libro2 = new Libro(4433,"Harry Potter", new Date(1999,10,15), "Español", 350, autorPrueba2,"Libro sobre magos", setGeneros1);
        Libro libro3 = new Libro(4434,"Lords Of the Ring", new Date(1910,9,30), "Japones", 1350, autorPrueba3,"Libro de aventuras", setGeneros2);
        Libro libro4 = new Libro(4435,"Jurassic Park", new Date(1989,8,12), "Italiano", 300, autorPrueba4,"Libro que de dinosaurios", setGeneros3);
        Libro libro5 = new Libro(4436,"Silence of the lambs", new Date(1980,1,25), "Frances", 250, autorPrueba5,"Libro de misterio", setGeneros2);
        Libro libro6 = new Libro(4437,"Dracula", new Date(1870,8,20), "Ingles", 400, autorPrueba1,"Libro de vampiros", setGeneros1);
        
        
        
        DaoLibro.Add(libro1);
        DaoLibro.Add(libro2);
        DaoLibro.Add(libro3);
        DaoLibro.Add(libro4);
        DaoLibro.Add(libro5);
        DaoLibro.Add(libro6);
        
        Biblioteca b1= new Biblioteca(libro1, new Date(2022,04,18),1);
        Biblioteca b2= new Biblioteca(libro2, new Date(2022,04,19),1);
        Biblioteca b3= new Biblioteca(libro3, new Date(2022,04,28),2);
        Biblioteca b4= new Biblioteca(libro4, new Date(2022,05,1),2);
        Biblioteca b5= new Biblioteca(libro5, new Date(2022,05,8),1);
        DaoBiblioteca.Add(b1);
        DaoBiblioteca.Add(b2);
        DaoBiblioteca.Add(b3);
        DaoBiblioteca.Add(b4);
        DaoBiblioteca.Add(b5);
        
        Biblioteca b6= DaoBiblioteca.ReadOne(1);
        System.out.println("-----ABML-----");
        System.out.println("-----READ-ONE-----");
        System.out.println("-----BIBLIOTECA-----");
        System.out.println("Titulo: "+b6.getLibro().getTitulo());
        System.out.println("Autor: "+b6.getLibro().getAutor().getNombre()+ " "+b6.getLibro().getAutor().getApellido());
        System.out.println("Fecha de Alta: "+b6.getFechaAlta());
        if(b6.getEstado()==1) {
        	System.out.println("Estado: En biblioteca");
        }
        else if(b6.getEstado()==2) {
        	System.out.println("Estado: Prestado");
        }
        else {
        	System.out.println("Estado: Sin definir");
        }
        
        b6.setEstado(2);
        b6.setFechaAlta(new Date(2022,05,18));
        b6.setLibro(libro6);
        DaoBiblioteca.Update(b6);
        
        
        System.out.println("-----BIBLIOTECA-----");
        System.out.println("--------UPDATE------");
        System.out.println("Titulo: "+b6.getLibro().getTitulo());
        System.out.println("Autor: "+b6.getLibro().getAutor().getNombre()+ " "+b6.getLibro().getAutor().getApellido());
        System.out.println("Fecha de Alta: "+b6.getFechaAlta());
        if(b6.getEstado()==1) {
        	System.out.println("Estado: En biblioteca");
        }
        else if(b6.getEstado()==2) {
        	System.out.println("Estado: Prestado");
        }
        else {
        	System.out.println("Estado: Sin definir");
        }
        
        DaoBiblioteca.Delete(b6);
        
        System.out.println("-----BIBLIOTECA-----");
        System.out.println("--------DELETE------");
        System.out.println("SE ELIMINO EL LIBRO DE LA BIBLIOTECA EN LA BASE DE DATOS");
        System.out.println("---------------------");
    }
}


