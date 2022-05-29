package hibernate;

import dao.DaoLibro;

public class AppHQL {

	public static void main(String[] args) {
		/*1) Mostrar todos los libros ordenados según ISBN de mayor a menor.
		Los campos que se deben mostrar son todos los pertenecientes a la clase Libro*/
		DaoLibro.ReadClassOrderAscByISBN();
		
	}

}
