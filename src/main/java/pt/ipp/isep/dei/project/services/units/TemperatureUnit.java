package pt.ipp.isep.dei.project.services.units;

/**
 * Represents all temperature units.
 * Provides methods to transmute between units.
 */

public interface TemperatureUnit {

    /**
     * Method to convert temperature values to kelvin
     * @return temperature in kelvin
     */
    double toKelvin(double temperature);

    /**
     * Method to convert temperature values to fahrenheit
     * @return temperature in fahrenheit
     */
    double toFahrenheit(double temperature);

    /**
     * Method to convert temperature values to celsius
     * @return temperature in Celsius
     */
    double toCelsius(double temperature);
}
