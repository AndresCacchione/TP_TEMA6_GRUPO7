package hibernate.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nacionalidad {
	
	@Id
	int id;
	String descripcion;
	
	public Nacionalidad() {
	
	}
	
	public Nacionalidad(int id,String des) {
		
		this.id=id;
		this.descripcion=des;
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

	@Override
	public String toString() {
		return "-Nacionalidad: id nacionalidad=" + id + ", nacionalidad=" + descripcion + "- ";
	}
}
