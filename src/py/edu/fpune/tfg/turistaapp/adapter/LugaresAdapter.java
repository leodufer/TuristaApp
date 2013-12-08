package py.edu.fpune.tfg.turistaapp.adapter;

import java.util.ArrayList;

import py.edu.fpune.tfg.turistaapp.R;
import py.edu.fpune.tfg.turistaapp.model.Lugar;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LugaresAdapter extends BaseAdapter{
	protected Activity activity;
    protected ArrayList<Lugar> items;
    
    
    public LugaresAdapter(Activity activity, ArrayList<Lugar> items){
    	this.activity=activity;
    	this.items=items;
    }
	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		 return items.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Generamos una convertView por motivos de eficiencia
        View v = convertView;
 
        //Asociamos el layout de la lista que hemos creado
        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_list, null);
        }
        
     // Creamos un objeto Lugar
        Lugar l = items.get(position);
        //Rellenamos la fotografía TODO
        ImageView foto = (ImageView) v.findViewById(R.id.image_detalle);
        
        //Rellenamos el nombre
        TextView nombre = (TextView) v.findViewById(R.id.text_nombre_detalle);
        nombre.setText(l.getNombre());
        //Rellenamos el cargo
        TextView direccion = (TextView) v.findViewById(R.id.text_direccion_detalle);
        direccion.setText(l.getDireccion());
        
        
     // Retornamos la vista
        return v;
	}

}
