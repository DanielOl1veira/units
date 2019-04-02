package pt.ipp.isep.dei.project.services.units;

import java.io.IOException;

/**
 * Represents all temperature units.
 * Provides methods to transmute between units.
 */

interface RainfallUnit extends Unit {

    double toDefault(double valueToConvert) throws IOException;


    //" 1 Litro por metro quadrado = milimetros"

}
