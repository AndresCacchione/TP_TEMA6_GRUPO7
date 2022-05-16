package hibernate.entidad;

import javax.persistence.Id;

public class Genero {
	@Id
	int id;
	String descripcion;
	
	public Genero() {
	
	}

	public Genero(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

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
	

}
