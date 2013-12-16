package py.edu.fpune.tfg.turistaapp.adapter;

import java.util.List;

import py.edu.fpune.tfg.turistaapp.R;
import py.edu.fpune.tfg.turistaapp.model.Categoria;
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
    protected List<Lugar> items;
    
    
    public LugaresAdapter(Activity activity, List<Lugar> items){
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
        //Rellenamos la fotografía
        Categoria c = l.getCategoria();
        ImageView foto = (ImageView) v.findViewById(R.id.image_detalle);
        if(c.getId()==1){
        	foto.setImageResource(R.drawable.ic_hotel);
        }
        if(c.getId()==2){
        	foto.setImageResource(R.drawable.ic_restaurant);
        }
        
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
