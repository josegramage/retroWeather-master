
package es.schooleando.retroweather.model.POJOs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import es.schooleando.retroweather.model.WeatherModel;

public class Weather {

    public List<Weather> weather;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName("main")
    @Expose
    public String main;
    @SerializedName("description")
    @Expose
    public String description;
    @SerializedName("icon")
    @Expose
    public String icon;

    public String getDescription() {
        return description;
    }

}
