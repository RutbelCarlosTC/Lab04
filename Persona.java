package laboratorio4;

public class Persona {
	private String nombre;
	private int dni;
	private int celular;
	
	public Persona(String nombre,int dni,int celular) {
		setNombre(nombre);
		setDni(dni);
		setCelular(celular);
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setDni(int dni) {
		this.dni=dni;
	}
	public void setCelular(int celular) {
		this.celular=celular;
	}
	public String getNombre() {
		return this.nombre;
	}
	public int getdni() {
		return this.dni;
	}
	public int getcelular() {
		return this.celular;
	}
	

}
