package hibernate.entidad;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	private String descripcion;
	
	
	//Constructores
	public Genero() {
		super();
	}
	
	public Genero(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	
	//Getters y Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	//toString
	@Override
	public String toString() {
		return "Id de género: " + id + ", Descripción: " + descripcion + ".";
	}
	
}
