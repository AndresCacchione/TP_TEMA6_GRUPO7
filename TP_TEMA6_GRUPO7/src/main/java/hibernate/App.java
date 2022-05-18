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
    	Nacionalidad nacionalidad = new Nacionalidad(1, "estadounidense");
    	DaoNacionalidad.Add(nacionalidad);
        
    	Autor autorPrueba = new Autor(1, "Victor","Miller", nacionalidad,"victor.miller@jasonvoorhees.com");
    	DaoAutor.Add(autorPrueba );
    	
    	Set<Genero> setGeneros = new HashSet<Genero>();
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

        setGeneros.add(terror);
        setGeneros.add(cienciaFiccion);
        setGeneros.add(comedia);
        setGeneros.add(drama);
        setGeneros.add(teatro);
        
        Libro libro = new Libro(4432,"Jason Voorhees", new Date(2001, 12, 15), "Inglés", 350, autorPrueba,"Libro que no te deja dormir", setGeneros);
        DaoLibro.Add(libro);
        
        Biblioteca b1= new Biblioteca(libro, new Date(2022,05,18),1);
        DaoBiblioteca.Add(b1);
        
        Biblioteca b2= DaoBiblioteca.ReadOne(1);
        System.out.println("-----BIBLIOTECA-----");
        System.out.println("Titulo: "+b2.getLibro().getTitulo());
        System.out.println("Autor: "+b2.getLibro().getAutor().getNombre()+ " "+b2.getLibro().getAutor().getApellido());
        System.out.println("Fecha de Alta: "+b2.getFechaAlta());
        if(b2.getEstado()==1) {
        	System.out.println("Estado: En biblioteca");
        }
        else if(b2.getEstado()==2) {
        	System.out.println("Estado: Prestado");
        }
        else {
        	System.out.println("Estado: Sin definir");
        }
    }
}


