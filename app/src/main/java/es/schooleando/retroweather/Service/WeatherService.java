package es.schooleando.retroweather.Service;


import es.schooleando.retroweather.model.WeatherModel;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ruben on 23/01/17.
 */

public class WeatherService {
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public interface WeatherAPI {

        // TODO: Completar
        @GET("weather?APPID=38ed2d21bfff8785c274573d807d0c9b")
        Call<WeatherModel> getWeather(@Query("q") String ciudad);

    }

    public static WeatherAPI getAPI() {
        // TODO: creamos la instancia del interfaz del API mediante Retrofit
        // Retrofit retrofit ...

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WeatherAPI.class);
    }

}
