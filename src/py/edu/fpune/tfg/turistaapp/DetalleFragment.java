package py.edu.fpune.tfg.turistaapp;



import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetalleFragment extends Fragment {
	
	public DetalleFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_detalle, container, false);
         
        return rootView;
    }
	

}

