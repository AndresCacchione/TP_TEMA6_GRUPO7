package hibernate.entidad;

public class Nacionalidad {

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
}
