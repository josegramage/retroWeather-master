package es.schooleando.retroweather;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import es.schooleando.retroweather.Presenter.WeatherPresenter;
import es.schooleando.retroweather.model.Ciudad;
import es.schooleando.retroweather.model.WeatherModel;


public class MainActivity extends AppCompatActivity implements WeatherPresenter.WeatherPresenterListener {
    WeatherPresenter weatherPresenter;

    ListView lista;
    Context context;
    Button update;
    ArrayList<String> list;
    ArrayAdapter adaptador;
    ArrayList ciudades = new ArrayList<Ciudad>();
    //Creo una lista con las ciudades que apareceran
    String[] values = new String[] { "Mislata","Valencia","Madrid","Bilbao","Ceuta","Alicante","Ibiza","Tarragona","Castellon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weatherPresenter = new WeatherPresenter(this, this, values[0]);

        lista = (ListView) findViewById(R.id.lista);
        update = (Button) findViewById(R.id.btn_update);

        //Se hacen las llamadas con un for
        list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
            weatherPresenter = new WeatherPresenter(MainActivity.this, context, values[i]+",es");
            weatherPresenter.getWeather();
        }
    }

    public void update (View v){
        //borro la lista y la vuelvo a crear para actualizarla
        adaptador.clear();

        list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
            weatherPresenter = new WeatherPresenter(MainActivity.this, context, values[i] + ",es");
            weatherPresenter.getWeather();
        }
    }

    @Override
    public void weatherReady(WeatherModel weather) {
        // aquí obtenemos las actualizaciones gracias a WeatherPresenter y actualizamos el interfaz

        //Se recogen todos los datos y se envian al adaptador
        String nombre =weather.getName();
        double temp = weather.getMain().getTemp();
        double presion =weather.getMain().getPressure();
        String descripcion =weather.getWeather().get(0).description;
        int humedad = weather.getMain().getHumidity();

        ciudades.add(new Ciudad(nombre,temp,presion,humedad,descripcion));

        adaptador = new Adaptador(this, ciudades);
        lista.setAdapter(adaptador);

        // para comprobar los parametros
        //    Log.d("nombre", weather.getName());
        //    Log.d("temp", String.valueOf(weather.getMain().getTemp()));
        //    Log.d("presion", String.valueOf(weather.getMain().getPressure()));
        //    Log.d("descrip", weather.getWeather().get(0).description);

      //  imprime todo el json
      //  Gson gson = new GsonBuilder().setPrettyPrinting().create();
      //  Log.d("main",gson.toJson(weather));
    }


}
