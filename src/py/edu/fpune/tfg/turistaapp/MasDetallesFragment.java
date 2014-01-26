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

public class MasDetallesFragment extends Fragment {
	
	public MasDetallesFragment(){}
	private Lugar l = new Lugar();
	private TextView nombre;
	private TextView direccion;
	private TextView descripcion;
	private TextView telefono;
	private TextView email;
	private TextView web;
	private LinearLayout layoutTelefono;
	private LinearLayout layoutEmail;
	private LinearLayout layoutWeb;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_mas, container, false);
         
        
        l.setId(getArguments().getInt("id"));
        l.setNombre(getArguments().getString("nombre"));
        l.setDescripcion(getArguments().getString("detalle"));
        l.setDireccion(getArguments().getString("direccion"));
        l.setLatitud(getArguments().getDouble("latitud"));
        l.setLongitud(getArguments().getDouble("longitud"));
        l.setTelefono(getArguments().getString("telefono"));
        l.setEmail(getArguments().getString("email"));
        l.setWeb(getArguments().getString("web"));
        //int c = getArguments().getInt("categoria");
        
        nombre = (TextView) rootView.findViewById(R.id.text_nombre_detalle);
        nombre.setText(l.getNombre());
        direccion = (TextView) rootView.findViewById(R.id.text_direccion_detalle);
        direccion.setText(l.getDireccion());
        descripcion = (TextView) rootView.findViewById(R.id.text_descripcion_detalle);
        descripcion.setText(l.getDescripcion());
        telefono = (TextView) rootView.findViewById(R.id.text_telefono_detalle);
        telefono.setText(l.getTelefono());
        email = (TextView) rootView.findViewById(R.id.text_email_detalle);
        email.setText(l.getEmail());
        web = (TextView) rootView.findViewById(R.id.text_web_detalle);
        web.setText(l.getWeb());
        
        layoutTelefono = (LinearLayout) rootView.findViewById(R.id.layout_telefono);
        layoutTelefono.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				Toast.makeText(getActivity(), "Llamar", Toast.LENGTH_LONG).show();
				return false;
			}
		});
        
        layoutEmail = (LinearLayout) rootView.findViewById(R.id.layout_email);
        layoutEmail.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				Toast.makeText(getActivity(), "Email", Toast.LENGTH_LONG).show();
				return false;
			}
		});
        
        layoutWeb = (LinearLayout) rootView.findViewById(R.id.layout_web);
        layoutWeb.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				Toast.makeText(getActivity(), "Web", Toast.LENGTH_LONG).show();
				return false;
			}
		});
        return rootView;
    }
}
