package pt.ipp.isep.dei.project.services.units;

public class UnitHelper {

    public static double toDefault(String defaultUnit, double valueToConvert){
        if (defaultUnit.equals("Celsius")){
            return this.toCelsius(valueToConvert);
        }
        else if (defaultUnit.equals("Fahrenheit")){
            return this.toFahrenheit(valueToConvert);
        }
        return this.toKelvin(valueToConvert);
    }
}
