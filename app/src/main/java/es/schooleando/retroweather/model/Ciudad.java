package es.schooleando.retroweather.model;


    //Me creo otro modelo más simple, solo lo que voy a mostrar
public class Ciudad  {

    String nombre;
    double temp;
    double presion;
    int humedad;
    String descripcion;

    public Ciudad(String nombre, double temp, double presion, int humedad, String descripcion) {
        this.nombre = nombre;
        this.temp = temp;
        this.presion = presion;
        this.humedad = humedad;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTemp() {
        return temp;
    }

    public double getPresion() {
        return presion;
    }

    public int getHumedad() {
        return humedad;
    }

    public String getDescripcion() {
        return descripcion;
    }


}
