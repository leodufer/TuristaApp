package py.edu.fpune.tfg.turistaapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class HotelesFragment extends Fragment {
	
	private Button btn;
	
	public HotelesFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_hoteles, container, false);
        btn = (Button) rootView.findViewById(R.id.button1);
        
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Fragment detalleFragment = new DetalleFragment();
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.frame_container, detalleFragment)
						.addToBackStack(null)
						.commit();
				
			}
		});
        return rootView;
    }
}
