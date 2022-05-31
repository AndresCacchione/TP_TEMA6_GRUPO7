package hibernate.entidad;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="BIBLIOTECA")
public class Biblioteca implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BIBLIOTECA_ID")
	private int id;
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="LIBRO_ISBN")
	private Libro libro;
	@Column(name="FECHA_ALTA")
	private Date fechaAlta;
	@Column(name="ESTADO")
	private int estado;
	
	public Biblioteca() {}
	
	public Biblioteca(Libro libro, Date fechaAlta, int estado) {
		super();
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}

	public Biblioteca(int id, Libro libro, Date fechaAlta, int estado) {
		super();
		this.id = id;
		this.libro = libro;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
