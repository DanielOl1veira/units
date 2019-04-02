package pt.ipp.isep.dei.project.services.units;

public class Celsius implements TemperatureUnit {


    public double toKelvin(double temperature) {
        return temperature + 273.15;
    }

    public double toFahrenheit(double temperature) {
        return temperature * 9 / 5 + 32;
    }

    public double toCelsius(double temperature) {
        return temperature;
    }

}
