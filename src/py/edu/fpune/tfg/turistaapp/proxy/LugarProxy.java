package py.edu.fpune.tfg.turistaapp.proxy;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import py.edu.fpune.tfg.turistaapp.model.Lugar;
import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

public class LugarProxy {
	
	final static String URL_HOST = "http://turista.leodufer.cloudbees.net/";
	//final static String URL_HOST ="http://192.168.1.102:8080/turista-app-server/";
	final static String URL_SERVICE=URL_HOST+"service/lugares";
	final static String URL_SERVICE_HOTELES=URL_HOST+"service/lugares/hoteles";
	final static String URL_SERVICE_RESTAURANTES=URL_HOST+"service/lugares/restaurantes";
	
	public List<Lugar> getLugar(Context context){
		try{
		Gson gson = new Gson();
		InputStream source = doGet(new HttpGet(URL_SERVICE));
		Reader reader = new InputStreamReader(source);
		LugaresResult response = gson.fromJson(reader, LugaresResult.class);
			
			//LugaresRepository lr = new LugaresRepository(context);
			//lr.insertarLugares(response.result);
			return response.result;
		}catch(Exception e){
			//LugaresRepository lr = new LugaresRepository(context);
			//return lr.obtenerLugares();
			return new ArrayList<Lugar>();
			
		}
	}
	
	public List<Lugar> getHoteles(){
		try{
		Gson gson = new Gson();
		InputStream source = doGet(new HttpGet(URL_SERVICE_HOTELES));
		Reader reader = new InputStreamReader(source);
		LugaresResult response = gson.fromJson(reader, LugaresResult.class);
	    	return response.result;
		}catch(Exception e){
			return new ArrayList<Lugar>();	
		}
	}
	
	public List<Lugar> getRestaurantes(){
		try{
		Gson gson = new Gson();
		InputStream source = doGet(new HttpGet(URL_SERVICE_RESTAURANTES));
		Reader reader = new InputStreamReader(source);
		LugaresResult response = gson.fromJson(reader, LugaresResult.class); 
			return response.result;
		}catch(Exception e){
			return new ArrayList<Lugar>();	
		}
	}
	
	public static InputStream doGet(HttpGet requestp){
		
		HttpClient httpclient = new DefaultHttpClient();  
        HttpGet request = requestp;  
   
        try {  
            HttpResponse result = httpclient.execute(request);
            final int statusCode = result.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w(URL_SERVICE,"Error " + statusCode + " for URL " + URL_SERVICE);
                return null;
             }
            Log.i(URL_SERVICE, "Conexión establecida");
            HttpEntity getResponseEntity = result.getEntity();
            return getResponseEntity.getContent();
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }
        
        return null;  
		
	}

}
