package pt.ipp.isep.dei.project.model.device;

import pt.ipp.isep.dei.project.model.Metered;
import pt.ipp.isep.dei.project.model.device.devicespecs.FreezerSpec;
import pt.ipp.isep.dei.project.model.device.log.Log;
import pt.ipp.isep.dei.project.model.device.log.LogList;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Freezer implements Device, Metered {

    private String nameFreezer;
    private double nominalPowerFreezer;
    private FreezerSpec freezerSpecs;
    private boolean active;
    private LogList logList;
    private double annualConsumption;


    public Freezer(FreezerSpec freezerSpec) {
        this.freezerSpecs = freezerSpec;
        this.active = true;
        logList = new LogList();
    }

    public void setName(String name) {
        this.nameFreezer = name;
    }

    public String getName() {
        return this.nameFreezer;
    }

    public String getType() {
        return "Freezer";
    }

    public void setNominalPower(double nominalPower) {
        this.nominalPowerFreezer = nominalPower;
    }

    public double getNominalPower() {
        return this.nominalPowerFreezer;
    }

    public void setAnnualConsumption(double annualConsumption) {
        this.annualConsumption = annualConsumption;
    }

    public double getAnnualConsumption() {
        return this.annualConsumption;
    }

    public boolean isActive() {
        return this.active;
    }

    public boolean deactivate() {
        if (isActive()) {
            this.active = false;
            return true;
        } else {
            return false;
        }
    }


    public String buildString() {
        String result;
        result = "The device Name is " + this.nameFreezer + ", and its NominalPower is " + this.nominalPowerFreezer + " kW.\n";
        return result;
    }

    /**
     * This method returns the Device LogList.
     *
     * @return Device LogList.
     */
    public LogList getLogList() {
        return logList;
    }

    /**
     * Method checks if device LogList is empty
     *
     * @return true if LogList is empty, false otherwise
     */
    public boolean isLogListEmpty() {
        return this.logList.isEmpty();
    }

    /**
     * This method adds a Log to the device LogList, if the Log isn't already in the LogList.
     *
     * @param log - Parameter which will be used to addWithoutPersisting to the Device LogList.
     * @return true if log was added
     */
    public boolean addLog(Log log) {
        if (this.active) {
            return this.logList.addLog(log);
        } else {
            return false;
        }
    }

    /**
     * Method determines the amount of data logs that fall within a given time interval.
     *
     * @param initialTime is the start time of the interval.
     * @param finalTime   is the end time of the interval.
     * @return is the number of valid data logs in the given interval.
     */
    public int countLogsInInterval(Date initialTime, Date finalTime) {
        return logList.countLogsInInterval(initialTime, finalTime);
    }

    public LogList getLogsInInterval(Date startDate, Date endDate) {
        return logList.getLogsInInterval(startDate, endDate);
    }

    /**
     * This method checks the Logs registered in a periods which are totally contained in the defined interval.
     *
     * @param initialTime - Beginning of the interval
     * @param finalTime   - Ending of the interval
     * @return total consumption within the defined interval
     */
    public double getConsumptionInInterval(Date initialTime, Date finalTime) {
        return logList.getConsumptionWithinGivenInterval(initialTime, finalTime);
    }

    /**
     * Energy consumption (daily) = annual energy consumption / 365 (kWh)
     *
     * @param time the desired time
     * @return the energy consumed in the given time
     */
    public double getEnergyConsumption(float time) {
        return nominalPowerFreezer * time;
    }

    public double getDailyEnergyConsumption() {
        return this.annualConsumption / 365;
    }


    // WRAPPER METHODS TO DEVICE SPECS
    public List<String> getAttributeNames() {
        return freezerSpecs.getAttributeNames();
    }

    public Object getAttributeValue(String attributeName) {
        return freezerSpecs.getAttributeValue(attributeName);
    }

    public boolean setAttributeValue(String attributeName, Object attributeValue) {
        return freezerSpecs.setAttributeValue(attributeName, attributeValue);
    }

    public Object getAttributeUnit(String attributeName) {
        return freezerSpecs.getAttributeUnit(attributeName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Device device = (Device) o;
        return Objects.equals(nameFreezer, device.getName());
    }

    @Override
    public int hashCode() {
        return 1;
    }

}