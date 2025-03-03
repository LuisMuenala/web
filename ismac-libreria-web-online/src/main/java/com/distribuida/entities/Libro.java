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
@Table(name= "libro")
public class Libro {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="id_libro")
	private int idLibro;
	@Column(name="titulo")
	private String titulo;
	@Column(name="editorial")
	private String editorial;
	@Column(name="num_paginas")
	private int paginas;
	@Column(name="edicion")
	private String edition;
	@Column(name="idioma")
	private String idioma;
	@Column(name="fecha_publicacion")
	private Date FechaPublicacion;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="tipo_pasta")
	private String TipoPasta;
	@Column(name="ISBN")
	private String ISBN;
	@Column(name="num_ejemplares")
	private int numEjemplares;
	@Column(name="portada")
	private String portada;
	@Column(name="presentacion")
	private String presentacion;
	@Column(name="precio")	
	private Double precio;
	
	@JoinColumn(name ="id_categoria")
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//persisten y detach viene asocado con una insercion de dats
	private Categoria categoria;
	
	@JoinColumn(name ="id_autor")
	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//persisten y detach viene asocado con una insercion de dats
	private Autor autor;
	
	public Libro () {}

	public Libro(int idLibro, String titulo, String editorial, int paginas, String edition, String idioma,
			Date fechaPublicacion, String descripcion, String tipoPasta, String ISBN, int numEjemplares, String portada,
			String presentacion, Double precio) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.editorial = editorial;
		this.paginas = paginas;
		this.edition = edition;
		this.idioma = idioma;
		this.FechaPublicacion = fechaPublicacion;
		this.descripcion = descripcion;
		this.TipoPasta = tipoPasta;
		this.ISBN = ISBN;
		this.numEjemplares = numEjemplares;
		this.portada = portada;
		this.presentacion = presentacion;
		this.precio = precio;
		
	}
	
	

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public Date getFechaPublicacion() {
		return FechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoPasta() {
		return TipoPasta;
	}

	public void setTipoPasta(String tipoPasta) {
		TipoPasta = tipoPasta;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getNumEjemplares() {
		return numEjemplares;
	}

	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", editorial=" + editorial + ", paginas=" + paginas
				+ ", edition=" + edition + ", idioma=" + idioma + ", FechaPublicacion=" + FechaPublicacion
				+ ", descripcion=" + descripcion + ", TipoPasta=" + TipoPasta + ", ISBN=" + ISBN + ", numEjemplares="
				+ numEjemplares + ", portada=" + portada + ", presentacion=" + presentacion + ", precio=" + precio
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}
	
	
	
	
}
