package py.edu.fpune.tfg.turistaapp.model;

import com.the9tcat.hadi.annotation.Column;
import com.the9tcat.hadi.annotation.Table;

@Table(name="categoria")
public class Categoria {
	@Column(name="id", primary=true, autoincrement=true)
	private int id;
	
	@Column(name="descripcion")
	private String descripcion;
	
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
