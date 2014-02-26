package py.edu.fpune.tfg.turistaapp.model;

import java.util.List;

import com.the9tcat.hadi.annotation.Column;
import com.the9tcat.hadi.annotation.Table;

@Table(name="categoria")
public class Lugar {
	@Column(name="id", primary=true, autoincrement=true)
	private int id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="email")
	private String email;
	@Column(name="telefono")
	private String telefono;
	@Column(name="web")
	private String web;
	@Column(name="direccion")
	private String direccion;
	@Column(name="latitud")
	private double latitud;
	@Column(name="longitud")
	private double longitud;
	
	private Categoria categoria;
	
	@Column(name="recomentacion")
	private int recomendacion;
	
	private List<Recurso> recursos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double logitud) {
		this.longitud = logitud;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getRecomendacion() {
		return recomendacion;
	}
	public void setRecomendacion(int recomendacion) {
		this.recomendacion = recomendacion;
	}
	public List<Recurso> getRecursos() {
		return recursos;
	}
	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}
	
	
	
}
