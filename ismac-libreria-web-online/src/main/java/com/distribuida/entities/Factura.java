package com.distribuida.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Component
@Entity
@Table(name= "factura")
public class Factura { //siempre la primera en mayuscula
	//@OneToOne
	//@ManyToOne
	//@OneToMany
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="id_factura")
	private int idFactura;
	@Column(name="num_factura")
	private String numFactura;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="total_neto")
	private Double total_neto;
	@Column(name="iva")
	private Double iva;
	@Column(name="total")
	private Double total;
	//private int idCliente;
	//inyeccion de dependencia de cliente a factura
	
	@JoinColumn(name ="id_cliente")
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//persisten y detach viene asocado con una insercion de dats
	private Cliente cliente;																			//refressh marge 
	
	
	
	public Factura() {}
	public Factura(int idFactura, String num_factura, Date fecha, Double total_neto, Double iva, Double total
			) {
		
		this.idFactura = idFactura;
		this.numFactura = num_factura;
		this.fecha = fecha;
		this.total_neto = total_neto;
		this.iva = iva;
		this.total = total;
		//this.idCliente = idcliente;
		
		
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getTotal_neto() {
		return total_neto;
	}

	public void setTotal_neto(Double total_neto) {
		this.total_neto = total_neto;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}


	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Factura [idFactura=" + idFactura + ", numFactura=" + numFactura + ", fecha=" + fecha + ", total_neto="
				+ total_neto + ", iva=" + iva + ", total=" + total + ", cliente=" + cliente + "]";
	}

	
}