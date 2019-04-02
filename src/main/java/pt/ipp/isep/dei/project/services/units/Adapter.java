package pt.ipp.isep.dei.project.services.units;

public class Adapter {

    private String userDefault;
    private String applicationDefault;

    public String getApplicationDefault(){
        this.applicationDefault = properties.getApplicationDefault();
        return this.applicationDefault;
    }

    public String getUserDefault(){
        this.userDefault = properties.getUserDefault();
        return this.userDefault;
    }

    public double convertToSystemDefault(double valueToConvert, Unit unitToConvert){
        getApplicationDefault();
        try {
            TemperatureUnit specificUnit = (TemperatureUnit) unitToConvert;
            return specificUnit.toDefault(applicationDefault, valueToConvert);
        }
        catch (ClassCastException ok){
            ok.printStackTrace();
        }
        try {
            RainfallUnit specificUnit = (RainfallUnit) unitToConvert;
            return specificUnit.toDefault(applicationDefault, valueToConvert);
        }
        catch (ClassCastException ok){
            ok.printStackTrace();
        }
        return valueToConvert;
    }

    public double convertToDisplayDefault(double valueToConvert, Unit unitToConvert){
        getUserDefault();
        try {
            TemperatureUnit specificUnit = (TemperatureUnit) unitToConvert;
            return specificUnit.toDefault(userDefault, valueToConvert);
        }
        catch (ClassCastException ok){
            ok.printStackTrace();
        }
        try {
            RainfallUnit specificUnit = (RainfallUnit) unitToConvert;
            return specificUnit.toDefault(userDefault, valueToConvert);
        }
        catch (ClassCastException ok){
            ok.printStackTrace();
        }
        return valueToConvert;
    }


}
