package pt.ipp.isep.dei.project.services.units;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class UnitHelper {

    static double toDefaultUnit(String defaultUnit, double valueToConvert, TemperatureUnit unit) {
        if (defaultUnit.equals("Celsius")) {
            return unit.toCelsius(valueToConvert);
        } else if (defaultUnit.equals("Fahrenheit")) {
            return unit.toFahrenheit(valueToConvert);
        }
        return unit.toKelvin(valueToConvert);
    }

    static String defaultSetter() throws IOException {
        String temperatureDefault;
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("resources/units.properties")){
            prop.load(input);
            temperatureDefault = prop.getProperty("defaultDisplayTemperatureUnit");
        } catch (IOException ioe) {
            throw new IOException("ERROR: Unable to process configuration file.");
        }
        return temperatureDefault;
    }

    static double convertToSystemDefault(double valueToConvert, Unit unitToConvert) throws IOException {
        try {
            TemperatureUnit specificUnit = (TemperatureUnit) unitToConvert;
            return specificUnit.toDefault(valueToConvert);
        }
        catch (ClassCastException ok){
            ok.printStackTrace();
        }
        try {
            RainfallUnit specificUnit = (RainfallUnit) unitToConvert;
         //   return specificUnit.toDefault(givenDefault, valueToConvert);
        }
        catch (ClassCastException ok){
            ok.printStackTrace();
        }
        return valueToConvert;
    }

}
