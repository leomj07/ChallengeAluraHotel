package modelo;

import java.util.Date;

public class Reserva {
	
	private Integer id;
	private String fecha_entrada;
	private String fecha_salida;
	private Integer valor;
	private String forma_pago;
	

	public Reserva() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Reserva(Date fecha_entrada, Date fecha_salida, String valor, Object forma_pago) {
		this.fecha_entrada = String.valueOf(fecha_entrada);
		this.fecha_salida = String.valueOf(fecha_salida);
		this.valor = Integer.valueOf(valor);
		this.forma_pago = String.valueOf(forma_pago);
		
	}

	public Reserva(String id, String fecha_entrada, String fecha_salida, String valor, String forma_pago) {
		this.id = Integer.valueOf(id);
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.valor = Integer.valueOf(valor);
		this.forma_pago = forma_pago;
	}

	public String getFecha_entrada() {
		return fecha_entrada;
	}


	public void setFecha_entrada(String fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}


	public String getFecha_salida() {
		return fecha_salida;
	}


	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}


	public Integer getValor() {
		return valor;
	}


	public void setValor(Integer valor) {
		this.valor = valor;
	}


	public String getForma_pago() {
		return forma_pago;
	}


	public void setForma_pago(String forma_pago) {
		forma_pago = forma_pago;
	}

	
}
