package es.schooleando.retroweather.Presenter;

import android.content.Context;
import android.util.Log;

import es.schooleando.retroweather.Service.WeatherService;
import es.schooleando.retroweather.model.POJOs.Weather;
import es.schooleando.retroweather.model.WeatherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ruben on 23/01/17.
 */

public class WeatherPresenter {

    private final Context context;
    private final WeatherPresenterListener mListener;
    private final WeatherService weatherService;
    private final String ciudad;

    public interface WeatherPresenterListener {
        void weatherReady(WeatherModel weather);
    }

    //añado el campo "ciudad" para hacer varias llamadas y añadir varias ciudades a la lista
    public WeatherPresenter(WeatherPresenterListener listener, Context context, String ciudad) {
        this.mListener = listener;
        this.context = context;
        this.weatherService = new WeatherService();
        this.ciudad = ciudad;
    }

    public void getWeather() {
        // Aquí llamamos al método de countryService, encolamos y implementamos el callback
        // También deberemos llamar a la Activity a traves del listener (WeatherPresenterListerer)

        // TODO: obtener weatherModel a través del weatherService
        //WeatherModel weathermodel = weatherService.getAPI()....

        // Enviar el weatherModel a la Activity
        //this.mListener.weatherReady(weatherModel);

        final WeatherService.WeatherAPI service = weatherService.getAPI();

        Call<WeatherModel> call = service.getWeather(ciudad);
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                WeatherModel weathermodel = response.body();
          //     Log.d("weatherPresenter", response.raw().toString());
          //     List<Weather> weather = response.body().weather;
                if (weathermodel != null) {
                    //si está lleno lo enviamos
                    mListener.weatherReady(weathermodel);
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                try {
                    throw new InterruptedException("No se ha podido comunicar con el servidor");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
