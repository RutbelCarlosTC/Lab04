package laboratorio4;
import java.util.Date;
public class Paquete {

	private int identificador;
	private Date fechaRecepcion,fechaEntrega;
	private double peso,costo;
	private String direccion;
	private Persona remitente;
	
	public Paquete(int id,Date fechaRecepcion,double peso,String direccion,double costo,Persona remitente) {
		this.identificador=id;
		this.fechaRecepcion = fechaRecepcion;
		this.peso = peso;
		this.direccion = direccion;
		this.costo = costo;	
		this.remitente = remitente;	
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public void setIndentificador(int identificador) {
		this.identificador = identificador;
	}
	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}
	public int getIdentificador() {
		return this.identificador;
	}
	public double getPeso() {
		return this.peso;
	}
	public double getCosto() {
		return this.costo;
	}
	public Persona getRemitente() {
		return this.remitente;
	}
	public Date getFechaRecepcion() {
		return this.fechaRecepcion;
	}
	
	
}
