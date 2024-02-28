package com.example.demo;

import org.testng.annotations.DataProvider;

public class DataProvider {

    @DataProvider(name ="categories")
    public static Object[][] getCategoryData() {
        return new Object[][] {
                {"bmw"},
                {"honda"},
                {"audi"},
                {"benz"},
                {"Home loan"},
                {"education loan"},
                {"school fee"},
                {"hostel fee"}
        };
    }
    @DataProvider(name = "editUserData")
    public static Object[][] getEditUserData() {
        return new Object[][] {
                {"pass1 ", " ", "pass2"},
                {"pass1", "pass2", " "},
                {" ", "pass2", "pass2"},
                {"pass1", "pass2", "pass3"},
                {"pass1", "pass2", "pass2"}
        };
    }

    @DataProvider(name = "newUserData")
    public static Object[][] getnewUserData() {
        return new Object[][] {
                {"Vova", "pass1", "pass1"},
                {"Petro", "1234", "1234"},
                {"Alex", "1234", "abcd"}
        };
    }
}
