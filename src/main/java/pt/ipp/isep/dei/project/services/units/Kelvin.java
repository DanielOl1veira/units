package pt.ipp.isep.dei.project.services.units;

public class Kelvin implements TemperatureUnit {


    public double toKelvin(double temperature) {
        return temperature;
    }

    public double toFahrenheit(double temperature) {
        return temperature * 9/5 - 459.67;
    }

    public double toCelsius(double temperature) {
        return temperature -273.15;
    }

}
