package hibernate.entidad;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Libro {
	
	@Id
	int isbn;
	
	String titulo;
	Date fecha_lanazamiento;
	String idioma;
	int cant_paginas;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_autor")
	Autor autor;
	
	String descripcion;
	
	@OneToMany(cascade = {CascadeType.ALL})
	@JoinColumn(name="id_genero")
	ArrayList<Genero> generos; 
	
	public Libro() {
		
	}

	public Libro(int isbn, String titulo, Date fecha_lanazamiento, String idioma, int cant_paginas,
			hibernate.entidad.Autor autor, String descripcion, ArrayList<hibernate.entidad.Genero> generos) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.fecha_lanazamiento = fecha_lanazamiento;
		this.idioma = idioma;
		this.cant_paginas = cant_paginas;
		this.autor = autor;
		this.descripcion = descripcion;
		this.generos = generos;
	}


	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha_lanazamiento() {
		return fecha_lanazamiento;
	}

	public void setFecha_lanazamiento(Date fecha_lanazamiento) {
		this.fecha_lanazamiento = fecha_lanazamiento;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getCant_paginas() {
		return cant_paginas;
	}

	public void setCant_paginas(int cant_paginas) {
		this.cant_paginas = cant_paginas;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(ArrayList<Genero> generos) {
		this.generos = generos;
	}
	

}
