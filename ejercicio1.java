package laboratorio4;
//laboratorio4 
//AUTOR: Rutbel Carlos Ttito Campos
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class ejercicio1 {
	static Paquete[]paquete =new Paquete[20];
	static Persona[]cliente =new Persona[10];
	static int i=-1;
	static int j=-1;
	static Scanner sc = new Scanner (System.in);
	static SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) throws ParseException {
		
		int resp,desicion;
		System.out.println("MENU\n"+"1.Realizar el registro de personas\n"
		                           +"2.Realizar el registro de paquetes\n"
		                           +"3.Registar cuando el paquete ha sido entregado\n"
		                           +"4.Mostrar paquetes de peso mayor a al ingresado\n"
		                           +"5.Mostrar paquetes con un costo igual al ingresado\n"
		                           +"6.Mostrar paquetes pendientes de ser enviados\n"
		                           +"7.Mostrar los datos de la persona al proporcionar un paquete\n"
		                           +"8.Mostrar los datos de los paquetes al ingresar el dni de la persona\n");
		int quedan=10, num, queda=20, cant;;
		do {
			System.out.print("Ingrese una opción: ");
			resp=sc.nextInt();
			
			switch (resp) {
			case 1:
				System.out.print("Número de personas a registrar (máximo "+quedan+"): ");
				num=sc.nextInt();
				quedan -= num;
				for(int a=1;a<=num;a++) {
					i++;
					System.out.println(">>>>>Cliente"+a);
					registrarPersona(i);
				}
				System.out.println();
				break;
			case 2:
				
				System.out.print("Número de paquetes a registrar (máximo "+queda+"): ");
				cant=sc.nextInt();
				queda -= cant;
				for(int a=1;a<=cant;a++) {
					j++;
					System.out.println(">>>>>Paquete"+a+"   ---ID asignado: "+(j+1));
					registrarPaquete(j);
				}
				System.out.println();
				break;
			case 3:
				int id;
				String fechaE;
				Date fechaEntrega;
				System.out.print("Ingrese el identificador del paquete: ");
				id=sc.nextInt();
				System.out.print("Ingrese la fecha de entrega (dd/MM/yyyy): ");
				fechaE=sc.next();
				fechaEntrega=sdf.parse(fechaE);
				registrarFechaDeEntrega(id,fechaEntrega);
				break;
			case 4:
				System.out.print("ingrese cantidad en KG a comparar: ");
				double kg=sc.nextDouble();
				kgMayores(kg);
				break;
			case 5:
				System.out.print("ingrese costo a comparar: ");
				double costo=sc.nextDouble();
				costosIguales(costo);
				break;
			case 6:
				paquetesPendientes();
				break;
			case 7:
				System.out.print("ingrese el identificador del paquete: ");
				int iden=sc.nextInt();
				mostrarDatosPersona(iden);
				break;
			case 8:
				System.out.print("ingrese el DNI del cliente: ");
				int dnii=sc.nextInt();
				mostrarDatosPaquete(dnii);
			}
			System.out.print("Desea continuar? <1>Si <2>No: ");
			desicion=sc.nextInt();
			
		}while(desicion==1 );
			
	}
	
	public static void registrarPersona(int n) {
		String nombre;
		int dni,celular;
		System.out.print("ingrese nombre: ");
		nombre = sc.next();
		System.out.print("ingrese DNI: ");
		dni = sc.nextInt();
		System.out.print("ingrese celular: ");
		celular = sc.nextInt();
		cliente[n]=new Persona(nombre,dni,celular);
	}
	public static void registrarPaquete(int n) {
		int dni;
		Date fechaRecepcion=new Date();
		double peso,costo;
		String direccion;
		
		if(i>=0) {
			System.out.print("ingrese DNI del remitente: ");
			dni = sc.nextInt();
			Persona p=encontrarPersona(dni);
			if(p!=null) {
				
				System.out.print("ingrese peso en Kg: ");
				peso = sc.nextDouble();
				System.out.print("ingrese costo: ");
				costo = sc.nextDouble();
				System.out.print("ingrese direccion: ");
				direccion = sc.next();
				paquete[n]=new Paquete(n+1,fechaRecepcion,peso,direccion,costo,p);
			}
			else
				System.out.println("La persona no existe en el grupo de clientes,"
						           + " intente registralarla en la opcion 1 del MENU");
		}
		else
			System.out.println("el registro de clientes está vacio");	
	}
	public static Persona encontrarPersona(int dni) {
		Persona clientX = null;
		for(int it=0;it<=i;it++) {
			if(cliente[it].getdni() == dni){
				clientX = cliente[it];
			}
		}
		return  clientX;
	}
	public static void registrarFechaDeEntrega(int id,Date fecha) {
		Paquete pq=encontrarPaquete(id);
		if(pq!= null) {
			pq.setFechaEntrega(fecha);
		}
		else
			System.out.println("paquete no encontrado");
			
	}
	public static Paquete encontrarPaquete(int id) {
		Paquete paqueteX = null;
		for(int i=0;i<=j;i++) {
			if(paquete[i].getIdentificador() == id){
				paqueteX = paquete[i];
			}
		}
		return  paqueteX;
	}
	public static void kgMayores(double kg) {
		for(int i=0;i<=j;i++) {
			if(paquete[i].getPeso()>kg)
				System.out.println("Paquete "+paquete[i].getIdentificador());
		}
	}
	public static void costosIguales(double costo) {
		for(int i=0;i<=j;i++) {
			if(paquete[i].getCosto() == costo)
				System.out.println("Paquete "+paquete[i].getIdentificador());
		}
	}
	public static void paquetesPendientes() {
		for(int i=0;i<=j;i++) {
			if(paquete[i].getFechaEntrega() == null)
				System.out.println("Paquete "+paquete[i].getIdentificador());
		}
	}
	public static void mostrarDatosPersona(int id) {
		Paquete pq = encontrarPaquete(id);
		Persona p= pq.getRemitente();
		if(pq!= null) {
			System.out.println("nombre: "+p.getNombre());
			System.out.println("DNI: "+p.getdni());
			System.out.println("celular: "+p.getcelular());
		}
		else 
			System.out.println("No existe el paquete indicado");
	}
	public static void mostrarDatosPaquete(int dni) {
		Persona p=encontrarPersona(dni);
		if(p!= null) {
			for(int i=0;i<=j;i++) {
				if(paquete[i].getRemitente().getdni()== dni) {
					printDatos(paquete[i]);
				}
			}
		}
		else 
			System.out.println("la persona no se encuentra en la lista de clientes");
		
	}
	public static void printDatos(Paquete x) {
		
		String fRecepcion;
		String fEntrega="pendiente";
		fRecepcion=sdf.format(x.getFechaRecepcion());
		if(x.getFechaEntrega()!=null)
			fEntrega=sdf.format(x.getFechaEntrega());
		
		System.out.println("-----Paquete "+x.getIdentificador());
		System.out.println("Identificador: "+x.getIdentificador());
		System.out.println("fecha de Recepcion: "+fRecepcion);
		System.out.println("fecha de Entrega: "+fEntrega);
		System.out.println("peso: "+x.getPeso());
		System.out.println("costo: "+x.getCosto());
		System.out.println("remitente: "+x.getRemitente().getNombre());
	}
	
}