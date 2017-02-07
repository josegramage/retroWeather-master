package es.schooleando.retroweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import es.schooleando.retroweather.model.POJOs.Clouds;
import es.schooleando.retroweather.model.POJOs.Coord;
import es.schooleando.retroweather.model.POJOs.Main;
import es.schooleando.retroweather.model.POJOs.Sys;
import es.schooleando.retroweather.model.POJOs.Weather;
import es.schooleando.retroweather.model.POJOs.Wind;

/**
 * Created by ruben on 23/01/17.
 */

public class WeatherModel {

        // Rellenar con los POJOs
        @SerializedName("coord")
        @Expose
        public Coord coord;
        @SerializedName("weather")
        @Expose
        public List<Weather> weather = null;
        @SerializedName("base")
        @Expose
        public String base;
        @SerializedName("main")
        @Expose
        public Main main;
        @SerializedName("visibility")
        @Expose
        public Integer visibility;
        @SerializedName("wind")
        @Expose
        public Wind wind;
        @SerializedName("clouds")
        @Expose
        public Clouds clouds;
        @SerializedName("dt")
        @Expose
        public Integer dt;
        @SerializedName("sys")
        @Expose
        public Sys sys;
        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("cod")
        @Expose
        public Integer cod;

        public String getName() {
            return name;
       }

        public Main getMain() {
                return main;
        }

    public List<Weather> getWeather() {
        return weather;
    }
}
