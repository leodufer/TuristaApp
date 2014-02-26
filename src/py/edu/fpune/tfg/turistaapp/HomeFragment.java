package py.edu.fpune.tfg.turistaapp;

import java.util.ArrayList;
import java.util.List;

import py.edu.fpune.tfg.turistaapp.adapter.LugaresAdapter;
import py.edu.fpune.tfg.turistaapp.model.Lugar;
import py.edu.fpune.tfg.turistaapp.proxy.LugarProxy;
import py.edu.fpune.tfg.turistaapp.proxy.Util;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
	
	ListView listView;
	List<Lugar> lugares = new ArrayList<Lugar>();
	LugaresAdapter adapter;
	public ProgressBar progressBar;
	public ImageView img_network_error;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);		
		listView = (ListView) rootView.findViewById(R.id.list_home);       
        progressBar = (ProgressBar)  rootView.findViewById(R.id.progressBarHome);
        progressBar.setVisibility(ProgressBar.INVISIBLE);
        
        img_network_error = (ImageView) rootView.findViewById(R.id.image_network_error);
        img_network_error.setVisibility(ImageView.INVISIBLE);
        
		if(Util.networkAvailable(rootView.getContext())){
	    	 new LugaresAsyncTask().execute();
	     }else{
	    	 img_network_error.setVisibility(ImageView.VISIBLE);
	    	 Toast t = Toast.makeText(rootView.getContext(), "No se dispone de una conexion de red", Toast.LENGTH_LONG);
	    	 t.show();
	     }
        
        
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> a, View view, int position,
					long id) {
				Lugar l = (Lugar) listView.getItemAtPosition(position);
				
				Fragment detalleFragment = new DetalleFragment();
				
				Bundle parametro = new Bundle();
				parametro.putInt("id", l.getId());
				parametro.putString("nombre", l.getNombre());
				parametro.putString("detalle", l.getDescripcion());
				parametro.putString("direccion", l.getDireccion());
				parametro.putDouble("latitud", l.getLatitud());
				parametro.putDouble("longitud", l.getLongitud());
				parametro.putInt("categoria", l.getCategoria().getId());
				parametro.putString("telefono", l.getTelefono());
				parametro.putString("email", l.getEmail());
				parametro.putString("web", l.getWeb());
				detalleFragment.setArguments(parametro);
				
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.frame_container, detalleFragment)
						.addToBackStack(null)
						.commit();
			}
		});
        
		return rootView;
    }
	public class LugaresAsyncTask extends AsyncTask<Void, Integer, Void>{
		int progress;
		@Override
		protected void onPreExecute() {
			progress = 0;
			progressBar.setVisibility(ProgressBar.VISIBLE);
		}
		
		@Override
		protected Void doInBackground(Void... params) {
			while(progress < 100){
				progress++;
				publishProgress(progress);
				SystemClock.sleep(1);
			}
			
			LugarProxy lp = new LugarProxy();
			
			lugares = lp.getLugar(getActivity().getApplicationContext());
				
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			if(lugares.size()<1){
				img_network_error.setVisibility(ImageView.VISIBLE);
				Toast.makeText(getActivity(), "No se pudo conectar con el servidor", Toast.LENGTH_SHORT).show();;
			}else{
				img_network_error.setVisibility(ImageView.GONE);
			}
			adapter = new LugaresAdapter(getActivity(), lugares);
			listView.setAdapter(adapter);
			progressBar.setVisibility(ProgressBar.GONE);
		}
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			progressBar.setProgress(values[0]);
		}
	}
}
