package py.edu.fpune.tfg.turistaapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
	ListView listView;
	String[] monthsArray = { "JAN", "FEB", "MAR", "APR", "MAY", "JUNE", "JULY",
			 "AUG", "SEPT", "OCT", "NOV", "DEC" };
	ArrayAdapter arrayAdapter;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		View rootView = inflater.inflate(R.layout.fragment_home, container, false);
		listView = (ListView) rootView.findViewById(R.id.list_home);
		arrayAdapter = new ArrayAdapter(rootView.getContext(), android.R.layout.simple_list_item_1, monthsArray);
        listView.setAdapter(arrayAdapter);
		return rootView;
    }
}
