package py.edu.fpune.tfg.turistaapp;



import py.edu.fpune.tfg.turistaapp.model.Lugar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetalleFragment extends Fragment {
	
	private LatLng mapLatLng = new LatLng(-25.5167, -54.6167);
	private GoogleMap map;
	private LinearLayout layout;
	
	private TextView text_nombre;
	private TextView text_detalle;
	private TextView text_direccion;
	
	public DetalleFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_detalle, container, false);
         
        layout = (LinearLayout) rootView.findViewById(R.id.layout_detalle);    
        layout.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				on_touch_detalle();
				return false;
			}
		});
        
        Lugar l = new Lugar();
        l.setId(getArguments().getInt("id"));
        l.setNombre(getArguments().getString("nombre"));
        l.setDetalle(getArguments().getString("detalle"));
        l.setDireccion(getArguments().getString("direccion"));
        l.setLatitud(getArguments().getDouble("latitud"));
        l.setLongitud(getArguments().getDouble("longitud"));
        mapLatLng = new LatLng(l.getLatitud(), l.getLongitud());
        
        map = ((MapFragment)getFragmentManager().findFragmentById(R.id.maps_fragment)).getMap();
        Marker amksc = map.addMarker(new MarkerOptions().position(mapLatLng).title(l.getNombre()));       
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLatLng, 14));
        
        
        
        
        
        text_nombre= (TextView) rootView.findViewById(R.id.text_nombre);
        text_nombre.setText(l.getNombre());
        
        text_detalle= (TextView) rootView.findViewById(R.id.text_detalle);
        text_detalle.setText(l.getDetalle());
        
        text_direccion= (TextView) rootView.findViewById(R.id.text_direccion);
        text_direccion.setText(l.getDireccion());
         
        return rootView;
    }
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		MapFragment f = (MapFragment) getFragmentManager().findFragmentById(R.id.maps_fragment);
	    if (f != null){ 
	        getFragmentManager().beginTransaction().remove(f).commit();
	    }
	}
	
	private void on_touch_detalle(){
		Toast.makeText(getActivity(), "Touch Detalle", Toast.LENGTH_SHORT).show();
	}
}

