package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {

    @Autowired
    private DriverService service;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void shouldCreateDriver() throws Exception {
        Driver driver = new Driver();
        driver.setName("Himanshu");
        driver.setAge(25);
        driver.setGender(Gender.MALE);
        Driver driverAfter = this.service.create(driver);
        assertEquals(2,driverAfter.getId());
    }

    @Test
    public void shouldFindCityById() throws Exception {
        Driver driver=this.service.findById(1);
        assertEquals("Rakesh",driver.getName());
    }

    @Test
    public void shouldFindCityByName() throws Exception {
        Driver driver=this.service.findByName("Rakesh");
        assertEquals(1,driver.getId());
    }
}