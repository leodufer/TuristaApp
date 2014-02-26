package py.edu.fpune.tfg.turistaapp.repository;

import java.util.List;

import py.edu.fpune.tfg.turistaapp.model.Lugar;
import android.content.Context;

import com.the9tcat.hadi.DefaultDAO;

public class LugaresRepository {
	private DefaultDAO dao;
	
	public LugaresRepository(Context context){
		dao = new DefaultDAO(context);
	}
	
	public void insertLugar(Lugar lugar) {
		  long id = dao.insert(lugar);
	}
	public void insertarLugares(List<Lugar> lugares){
		for(Lugar l:lugares){
			dao.insert(l);
		}
	}
	public List<Lugar> obtenerLugares(){
		return (List<Lugar>) dao.select(Lugar.class, false, null, null, null, null, null, null);
	}
	
	public Lugar obtener(int id){
		return (Lugar)dao.select(Lugar.class, false, " fatherId = ? ", new String[] { String.valueOf(id) }, null, null, null, null);
	}

}
