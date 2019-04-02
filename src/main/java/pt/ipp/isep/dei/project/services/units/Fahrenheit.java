package pt.ipp.isep.dei.project.services.units;

public class Fahrenheit implements TemperatureUnit {


    public double toKelvin(double temperature) {
        return (temperature + 459.67) * 5 / 9;
    }

    public double toFahrenheit(double temperature) {
        return temperature;
    }

    public double toCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    public Unit convertToApplicationDefault(Unit u) {
        return null;
    }

    public Unit convertToDisplayDefault(Unit u) {
        return null;
    }
}
