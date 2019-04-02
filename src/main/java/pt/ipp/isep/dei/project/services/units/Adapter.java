package pt.ipp.isep.dei.project.services.units;

import java.io.*;

import static pt.ipp.isep.dei.project.services.units.UnitHelper.defaultSetter;

public class Adapter {

    private String userDefault;

    private void getUserDefault() throws IOException{
        this.userDefault = defaultSetter();
    }

    public double convertToSystemDefault(double valueToConvert, Unit unitToConvert) {
        return UnitHelper.convertToSystemDefault(valueToConvert,unitToConvert);
    }

    public double convertToUserDefault(double valueToConvert, Unit unitToConvert) throws IOException {
        getUserDefault();
        return UnitHelper.convertToSystemDefault(valueToConvert,unitToConvert);
    }

}
