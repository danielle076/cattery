package nl.danielle.cattery.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressTest {
    private Address address;

    @BeforeEach
    void setUp() {
        this.address = new Address("Boxtelplein", "89", "1324XG", "Almere");
    }

    @Test
    void testGetId() {
        assertNotNull(this.address.getId());
    }

    @Test
    void testGetStreetname() {
        String expectedStreetName = "Boxtelplein";
        String actualStreetName = this.address.getStreetName();
        assertEquals(expectedStreetName, actualStreetName);
    }

    @Test
    void testGetHouseNumber() {
        String expectedHouseNumber = "89";
        String actualHouseNumber = this.address.getHouseNumber();
        assertEquals(expectedHouseNumber, actualHouseNumber);
    }

    @Test
    void testGetPostalCode() {
        String expectedPostalCode = "1324XG";
        String actualPostalCode = this.address.getPostalCode();
        assertEquals(expectedPostalCode, actualPostalCode);
    }

    @Test
    void testGetHomeTown() {
        String expectedCity = "Almere";
        String actualCity = this.address.getHomeTown();
        assertEquals(expectedCity, actualCity);
    }

    @Test
    void testSetStreetName() {
        String expectedStreetName = "Wisselhof";
        this.address.setStreetName("Wisselhof");
        String actualStreetName = this.address.getStreetName();
        assertEquals(expectedStreetName, actualStreetName);
    }

    @Test
    void testSetHouseNumber() {
        String expectedHouseNumber = "35";
        this.address.setHouseNumber("35");
        String actualHouseNumber = this.address.getHouseNumber();
        assertEquals(expectedHouseNumber, actualHouseNumber);
    }

    @Test
    void testSetPostalCode() {
        String expectedPostalCode = "5809BZ";
        this.address.setPostalCode("5809BZ");
        String actualPostalCode = this.address.getPostalCode();
        assertEquals(expectedPostalCode, actualPostalCode);
    }

    @Test
    void testSetHomeTown() {
        String expectedCity = "Leunen";
        this.address.setHomeTown("Leunen");
        String actualCity = this.address.getHomeTown();
        assertEquals(expectedCity, actualCity);
    }
}
