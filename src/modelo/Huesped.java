package modelo;

import java.sql.Date;
import java.sql.SQLData;

public class Huesped {
	
	private Integer id;
	private String nombre;
	private String apellidos;
	private String fecha_nacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer idReserva;

	public Huesped() {
			
	}

	public Huesped(String nombre, String apellidos, Date fecha_nacimiento, Object nacionalidad, String telefono, String idReserva) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = String.valueOf(fecha_nacimiento);
		this.nacionalidad = (String) nacionalidad;
		this.telefono =telefono;
		this.idReserva = Integer.valueOf(idReserva);
		
	}

	public Huesped(String id, String nombre, String apellidos, String fecha_nacimiento, String nacionalidad, String telefono,
			String idReserva) {
		this.id = Integer.valueOf(id);
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = Integer.valueOf(idReserva); 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = String.valueOf(fecha_nacimiento);
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	
	

}
