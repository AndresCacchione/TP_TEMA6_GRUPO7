package hibernate.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Libro implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int isbn;
	private String titulo;
	private Date fechaLanzamiento;
	private String idioma;
	private int cantidadPaginas;
	private Autor autor;
	private String descripcion;
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(name="generos_x_libro", joinColumns= {@JoinColumn(name="isbn")}, inverseJoinColumns= {@JoinColumn(name="id_genero")})
	private Set<Genero> setGeneros = new HashSet<Genero>();
	

	//Constructores
	public Libro() {
		super();
	}
	
	public Libro(int isbn, String titulo, Date fechaLanzamiento, String idioma, int cantidadPaginas, Autor autor,
			String descripcion, HashSet<Genero> setGeneros) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
		this.idioma = idioma;
		this.cantidadPaginas = cantidadPaginas;
		this.autor = autor;
		this.descripcion = descripcion;
		this.setGeneros = setGeneros;
	}


	//Getters y Setters
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
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getCantidadPaginas() {
		return cantidadPaginas;
	}
	public void setCantidadPaginas(int cantidadPaginas) {
		this.cantidadPaginas = cantidadPaginas;
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
	public Set<Genero> getSetGeneros() {
		return setGeneros;
	}
	public void setSetGeneros(Set<Genero> setGeneros) {
		this.setGeneros = setGeneros;
	}

	//toString
	@Override
	public String toString() {
		return "Isbn: " + isbn + ", titulo: " + titulo + ", fecha de lanzamiento: " + fechaLanzamiento + ", idioma: "
				+ idioma + ", cantidad de páginas: " + cantidadPaginas + ", autor: " + autor + ", descripción: " + descripcion
				+ ", géneros: " + setGeneros.toString() + ".";
	}

}
