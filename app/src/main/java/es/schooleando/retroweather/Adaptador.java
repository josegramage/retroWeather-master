package es.schooleando.retroweather;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import es.schooleando.retroweather.model.Ciudad;

/**
 * Created by joso on 07/02/2017.
 */



//Creo un adaptador para imprimir la lista de ciudades

public class Adaptador extends ArrayAdapter<Ciudad> {

    AppCompatActivity context;
    ArrayList<Ciudad> lista;

    public Adaptador(AppCompatActivity context, ArrayList<Ciudad> listaAtributos) {
        super(context, R.layout.elemento_lista, listaAtributos);
        this.context = context;
        lista = listaAtributos;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View view = inflater.inflate(R.layout.elemento_lista, null);

        //Obteniendo instancias de los elementos
        TextView nombre = (TextView)view.findViewById(R.id.nombre);
        TextView temp = (TextView)view.findViewById(R.id.txt_temp);
        TextView presion = (TextView)view.findViewById(R.id.txt_presion);
        TextView humedad = (TextView)view.findViewById(R.id.txt_humedad);
        TextView descripcion = (TextView)view.findViewById(R.id.txt_descripcion);

        Ciudad ciudad = (Ciudad) getItem(position);

        //Los campos que se veran en la lista
        nombre.setText(ciudad.getNombre());
        temp.setText(Double.toString(ciudad.getTemp()));
        presion.setText(Double.toString(ciudad.getPresion()));
        humedad.setText(Integer.toString(ciudad.getHumedad()));
        descripcion.setText(ciudad.getDescripcion());

        return view;

    }
}
