package py.edu.fpune.tfg.turistaapp;

import py.edu.fpune.tfg.turistaapp.model.Lugar;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
	private ImageButton imgButtonCall;
	private ImageButton imgButtonEmail;
	private ImageButton imgButtonWeb;
	private Button buttonTrace;
	private Button buttonShare;
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
        
        imgButtonCall = (ImageButton) rootView.findViewById(R.id.imageButtonCall);
        imgButtonCall.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				 String posted_by = l.getTelefono();

				 String uri = "tel:" + posted_by.trim() ;
				 Intent intent = new Intent(Intent.ACTION_DIAL);
				 intent.setData(Uri.parse(uri));
				 startActivity(intent);
				
			}
		});
        
        imgButtonEmail = (ImageButton) rootView.findViewById(R.id.imageButtonEmail);
        imgButtonEmail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent email = new Intent(Intent.ACTION_SEND);
				email.putExtra(Intent.EXTRA_EMAIL, new String[]{l.getEmail()});		  
				email.putExtra(Intent.EXTRA_SUBJECT, "Consulta via TuristaApp");
				//email.putExtra(Intent.EXTRA_TEXT, "");
				email.setType("message/rfc822");
				startActivity(Intent.createChooser(email, "Choose an Email client :"));
			}
		});
        
        imgButtonWeb = (ImageButton) rootView.findViewById(R.id.imageButtonWeb);
        imgButtonWeb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
						Intent intent;
						String uri = l.getWeb();
						if(uri.length()>0){
						if(!uri.substring(0, 7).equals("http://")){
							uri = "http://"+uri;
							intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
						}else{
							intent = new Intent(Intent.ACTION_VIEW, Uri.parse(l.getWeb()));
						}
							startActivity(intent);
						}else{
							Toast.makeText(getActivity().getApplicationContext(), "Direccion no disponible",Toast.LENGTH_SHORT ).show();;
						}
						
			}
		});
        
        buttonTrace = (Button) rootView.findViewById(R.id.button_como);
        buttonTrace.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_VIEW, 
					    Uri.parse("http://maps.google.com/maps?f=d&daddr="+l.getLatitud()+","+l.getLongitud()));
					intent.setComponent(new ComponentName("com.google.android.apps.maps", 
					    "com.google.android.maps.MapsActivity"));
					startActivity(intent);
				
			}
		});
        
        buttonShare = (Button) rootView.findViewById(R.id.button_share);
        buttonShare.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent sharingIntent = new Intent(Intent.ACTION_SEND);
			    sharingIntent.setType("text/plain");
			    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT,l.getNombre()+" "+l.getDescripcion()+" "+l.getLatitud()+","+l.getLongitud()+" via #turistaApp");
			    startActivity(Intent.createChooser(sharingIntent, "Share using"));
			}
		});
        return rootView;
    }
}
