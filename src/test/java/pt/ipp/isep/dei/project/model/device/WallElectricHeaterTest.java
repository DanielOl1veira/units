package pt.ipp.isep.dei.project.model.device;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import pt.ipp.isep.dei.project.model.device.devicespecs.WallElectricHeaterSpec;
import pt.ipp.isep.dei.project.model.device.log.Log;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Lamp Device tests class.
 */

class WallElectricHeaterTest {
    // Common testing artifacts in this class

    private WallElectricHeater validHeater;

    @BeforeEach
    void arrangeArtifacts() {
        validHeater = new WallElectricHeater(new WallElectricHeaterSpec());
    }

    @Test
    void seeSettersAndGetters(){
        // Arrange

        validHeater.setName("NewHeater");
        validHeater.setNominalPower(35);

        // Act

        String actualResult1 = validHeater.getName();
        double actualResult2 = validHeater.getNominalPower();

        // Assert

        assertEquals("NewHeater", actualResult1);
        assertEquals(35,actualResult2);
    }

    @Test
    void seeBuildString(){
        // Arrange

        validHeater.setName("NewHeater");
        validHeater.setNominalPower(35);
        String expectedResult = "The device Name is NewHeater, and its nominal power is 35.0 kW.\n";

        // Act

        String actualResult = validHeater.buildString();

        // Assert

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void seeIfGetDeviceTypeWorks() {
        // Act

        String result = validHeater.getType();

        //Act

        assertEquals("WallElectricHeater", result);
    }

    @Test
    void seeIfDeviceIsActiveBothConditions(){
        // Act

        boolean actualResult1 = validHeater.isActive();
        boolean actualResult2 = validHeater.deactivate();
        validHeater.deactivate();
        boolean actualResult3 = validHeater.deactivate();
        boolean actualResult4 = validHeater.isActive();

        // Assert

        assertTrue(actualResult1);
        assertTrue(actualResult2);
        assertFalse(actualResult3);
        assertFalse(actualResult4);
    }

    @Test
    void seeEmptyLogList(){
        // Act

        boolean actualResult = validHeater.isLogListEmpty();

        // Assert

        assertTrue(actualResult);
    }

    @Test
    void seeIfAllMethodsThrowException() {
        // Act


        Throwable exception1 = assertThrows(UnsupportedOperationException.class,
                validHeater::getLogList);
        Throwable exception2 = assertThrows(UnsupportedOperationException.class,
                () -> validHeater.addLog(new Log(10, new GregorianCalendar().getTime(), new GregorianCalendar().getTime())));
        Throwable exception3 = assertThrows(UnsupportedOperationException.class,
                () -> validHeater.countLogsInInterval(new GregorianCalendar().getTime(), new GregorianCalendar().getTime()));
        Throwable exception4 = assertThrows(UnsupportedOperationException.class,
                () -> validHeater.getLogsInInterval(new GregorianCalendar().getTime(), new GregorianCalendar().getTime()));
        Throwable exception5 = assertThrows(UnsupportedOperationException.class,
                () -> validHeater.getConsumptionInInterval(new GregorianCalendar().getTime(), new GregorianCalendar().getTime()));
        Throwable exception6 = assertThrows(UnsupportedOperationException.class,
                () -> validHeater.getEnergyConsumption(20));


        // Assert

        Assert.assertEquals("At the moment, this operation is not supported.", exception1.getMessage());
        Assert.assertEquals("At the moment, this operation is not supported.", exception2.getMessage());
        Assert.assertEquals("At the moment, this operation is not supported.", exception3.getMessage());
        Assert.assertEquals("At the moment, this operation is not supported.", exception4.getMessage());
        Assert.assertEquals("At the moment, this operation is not supported.", exception5.getMessage());
        Assert.assertEquals("At the moment, this operation is not supported.", exception6.getMessage());
    }

    @Test
    void seeAttributeMethods() {
        // Arrange

        Object expectedResult1 = 0;
        List<String> expectedResult2 = new ArrayList<>();


        // Act

        Object actualResult1 = validHeater.getAttributeValue("Nonexistent");
        List<String> actualResult2 = validHeater.getAttributeNames();
        Object actualResult3 = validHeater.getAttributeUnit("Nonexistent");
        boolean actualResult4 = validHeater.setAttributeValue("Nonexistent", 20D);

        // Assert

        Assert.assertEquals(expectedResult1, actualResult1);
        Assert.assertEquals(expectedResult2, actualResult2);
        Assert.assertEquals(false, actualResult3);
        Assert.assertFalse(actualResult4);
    }

    @Test
    void seeIfEqualsWorks() {

        WallElectricHeater wEH = new WallElectricHeater(new WallElectricHeaterSpec());
        WallElectricHeater wEH2 = new WallElectricHeater(new WallElectricHeaterSpec());

        wEH.setName("WallElectricHeater1");
        wEH2.setName("WallElectricHeater2");

        boolean actualResult1 = validHeater.equals(wEH);
        boolean actualResult2 = validHeater.equals(wEH2);
        boolean actualResult3 = validHeater.equals(20D); // Necessary for Sonarqube testing
        boolean actualResult4 = validHeater.equals(validHeater); // Necessary for Sonarqube testing
        boolean actualResult5 = validHeater.equals(null); // Necessary for Sonarqube testing

        assertFalse(actualResult1);
        assertFalse(actualResult2);
        assertFalse(actualResult3);
        assertTrue(actualResult4);
        assertFalse(actualResult5);
    }

    @Test
    void hashCodeDummyTest() {
        // Arrange

        int expectedResult = 1;

        // Act

        int actualResult = validHeater.hashCode();

        // Assert

        assertEquals(expectedResult, actualResult);
    }
}
