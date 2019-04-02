package pt.ipp.isep.dei.project.services.units;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static pt.ipp.isep.dei.project.services.units.UnitHelper.toDefaultUnit;

public class Celsius implements TemperatureUnit {

    public double toDefault(double valueToConvert) throws IOException {
        String defaultUnit;
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream("resources/units.properties")){
            prop.load(input);
            defaultUnit = prop.getProperty("defaultDisplayTemperatureUnit");
        } catch (IOException ioe) {
            throw new IOException("ERROR: Unable to process configuration file.");
        }
        return toDefaultUnit(defaultUnit, valueToConvert, this);
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

    public String buildString() {
        return "Celsius";
    }

}
