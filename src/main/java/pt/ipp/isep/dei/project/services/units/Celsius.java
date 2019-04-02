package pt.ipp.isep.dei.project.services.units;

public class Celsius implements TemperatureUnit {

    public double toDefault(String defaultUnit, double valueToConvert){
        if (defaultUnit.equals("Celsius")){
            return this.toCelsius(valueToConvert);
        }
        else if (defaultUnit.equals("Fahrenheit")){
            return this.toFahrenheit(valueToConvert);
        }
        return this.toKelvin(valueToConvert);
    }

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
