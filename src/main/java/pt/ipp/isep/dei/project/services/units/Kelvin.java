package pt.ipp.isep.dei.project.services.units;

public class Kelvin implements TemperatureUnit {


    public double toDefault(String defaultUnit, double valueToConvert) {
        if (defaultUnit.equals("Celsius")){
            return this.toCelsius(valueToConvert);
        }
        else if (defaultUnit.equals("Fahrenheit")){
            return this.toFahrenheit(valueToConvert);
        }
        return this.toKelvin(valueToConvert);
    }

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
