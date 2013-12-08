package py.edu.fpune.tfg.turistaapp;

import java.util.ArrayList;

import py.edu.fpune.tfg.turistaapp.adapter.LugaresAdapter;
import py.edu.fpune.tfg.turistaapp.model.Lugar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
	ListView listView;
	String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY",
			 "AUG", "SEPT", "OCT", "NOV", "DEC" };
	ArrayAdapter<String> arrayAdapter;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		
		ArrayList<Lugar> lugares = new ArrayList<Lugar>();
		Lugar l = new Lugar();
		l.setNombre("Nombre de Lugar 1");
		l.setDetalle("Detalle del Lugar 1 Mas texto para mas detalle");
		l.setDireccion("Direccion del Lugar 1, casi algo");
		l.setLatitud(-25.5167);
		l.setLongitud(-54.6167);
		lugares.add(l);
		
		Lugar l2 = new Lugar();
		l2.setNombre("Nombre de Lugar 2");
		l2.setDetalle("Detalle del Lugar 2 Mas texto para mas detalle");
		l2.setDireccion("Direccion del Lugar 2, casi algo");
		l2.setLatitud(-25.5167);
		l2.setLongitud(-54.6167);
		lugares.add(l2);
		

		Lugar l3 = new Lugar();
		l3.setNombre("Nombre de Lugar 3");
		l3.setDetalle("Detalle del Lugar 3 Mas texto para mas detalle");
		l3.setDireccion("Direccion del Lugar 3, casi algo");
		l2.setLatitud(-25.5167);
		l2.setLongitud(-54.6167);
		lugares.add(l3);
		
		listView = (ListView) rootView.findViewById(R.id.list_home);
		LugaresAdapter adapter = new LugaresAdapter(getActivity(), lugares);
		//arrayAdapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, monthsArray);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View view, int position,
					long id) {
				Lugar l = (Lugar) listView.getItemAtPosition(position);
				
				Fragment detalleFragment = new DetalleFragment();
				
				Bundle parametro = new Bundle();
				parametro.putInt("id", l.getId());
				parametro.putString("nombre", l.getNombre());
				parametro.putString("detalle", l.getDetalle());
				parametro.putString("direccion", l.getDireccion());
				parametro.putDouble("latitud", l.getLatitud());
				parametro.putDouble("longitud", l.getLongitud());
				
				detalleFragment.setArguments(parametro);
				
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.frame_container, detalleFragment)
						//.addToBackStack(null)
						.commit();
			}
		});
        
		return rootView;
    }
}
