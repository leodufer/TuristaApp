package py.edu.fpune.tfg.turistaapp.proxy;

import java.util.List;

import py.edu.fpune.tfg.turistaapp.model.Lugar;

import com.google.gson.annotations.SerializedName;

public class LugaresResult {

	@SerializedName("lugar")
	List<Lugar> result;
}
