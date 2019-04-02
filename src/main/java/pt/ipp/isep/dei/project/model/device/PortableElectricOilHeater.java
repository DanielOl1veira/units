package pt.ipp.isep.dei.project.model.device;

import pt.ipp.isep.dei.project.model.Metered;
import pt.ipp.isep.dei.project.model.device.devicespecs.PortableElectricOilHeaterSpec;
import pt.ipp.isep.dei.project.model.device.log.Log;
import pt.ipp.isep.dei.project.model.device.log.LogList;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PortableElectricOilHeater implements Device, Metered {
    private String notSupported = "At the moment, this operation is not supported.";

    private String name;
    private double nominalPower;
    private PortableElectricOilHeaterSpec deviceSpecs;
    private boolean active;

    public PortableElectricOilHeater(PortableElectricOilHeaterSpec portableElectricOilHeaterSpec) {
        this.deviceSpecs = portableElectricOilHeaterSpec;
        this.active = true;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
    return "PortableElectricOilHeater";
    }

    public void setNominalPower(double nominalPower) {
        this.nominalPower = nominalPower;
    }

    public double getNominalPower() {
        return this.nominalPower;
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
        return "The device Name is " + this.name + ", and its nominal power is " + this.nominalPower + " kW.\n";
    }

    /**
     * This method returns the Device LogList.
     *
     * @return Device LogList.
     */
    public LogList getLogList() {
        throw new UnsupportedOperationException(notSupported);
    }

    /**
     * Method checks if device LogList is empty
     *
     * @return true if LogList is empty, false otherwise
     */
    public boolean isLogListEmpty() {
        return true;
    }

    /**
     * This method adds a Log to the device LogList, if the Log isn't already in the LogList.
     *
     * @param log - Parameter which will be used to addWithoutPersisting to the Device LogList.
     * @return true if log was added
     */
    public boolean addLog(Log log) {
        throw new UnsupportedOperationException(notSupported);
    }

    /**
     * Method determines the amount of data logs that fall within a given time interval.
     *
     * @param initialTime is the start time of the interval.
     * @param finalTime   is the end time of the interval.
     * @return is the number of valid data logs in the given interval.
     */
    public int countLogsInInterval(Date initialTime, Date finalTime) {
        throw new UnsupportedOperationException(notSupported);
    }

    public LogList getLogsInInterval(Date startDate, Date endDate) {
        throw new UnsupportedOperationException(notSupported);
    }

    /**
     * This method checks the Logs registered in a periods which are totally contained in the defined interval.
     *
     * @param initialTime - Beginning of the interval
     * @param finalTime   - Ending of the interval
     * @return total consumption within the defined interval
     */
    public double getConsumptionInInterval(Date initialTime, Date finalTime) {
        throw new UnsupportedOperationException(notSupported);
    }

    /**
     * Energy consumption = Nominal power * time (Wh)
     *
     * @param time the desired time
     * @return the energy consumed in the given time
     */
    public double getEnergyConsumption(float time) {
        throw new UnsupportedOperationException(notSupported);
    }


    // WRAPPER METHODS TO DEVICE SPECS
    public List<String> getAttributeNames() {
        return deviceSpecs.getAttributeNames();
    }

    public Object getAttributeValue(String attributeName) {
        return deviceSpecs.getAttributeValue(attributeName);
    }

    public boolean setAttributeValue(String attributeName, Object attributeValue) {
        return deviceSpecs.setAttributeValue(attributeName, attributeValue);
    }

    public Object getAttributeUnit(String attributeName) {
        return deviceSpecs.getAttributeUnit(attributeName);
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
        return Objects.equals(name, device.getName());
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
