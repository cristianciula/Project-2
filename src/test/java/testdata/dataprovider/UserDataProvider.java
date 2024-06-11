package testdata.dataprovider;

import lombok.Data;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class UserDataProvider {

    /* ---------- EMAIL ADDRESS DATA ---------- */

    @DataProvider (name = "validEmailAddress")
    public Object[][] validEmail() {
        return new Object[][] {
                {"testuser@example.com"}
        };
    }

    @DataProvider (name = "wrongEmail")
    public Object[][] wrongEmail() {
        return new Object[][] {
                // Duplicate email
                {"testuser@example.com"},
                // Unregistered email
                {"unknown@example.com"}
        };
    }

    @DataProvider (name = "invalidEmailSyntax")
    public Object[][] invalidEmailSyntax() {
        return new Object[][]{
                {""},
                {" "},
                {" @example.com"},
                {"user@example. com"},
                {"user @example.com"},
                {"user@ example.com"},
                {"user@example .com"},
                {"@example.com"},
                {"userexample.com"},
                {"user@.com"},
                {"user@examplecom"},
                {"user@example."},
                {"user@example.c"}
        };
    }

    /* ---------- EMAIL ADDRESS DATA ---------- */

    @DataProvider (name = "validPassword")
    public Object[][] validPassword() {
        return new Object[][] {
                {"Parola100!"}
        };
    }

    @DataProvider (name = "wrongPassword")
    public Object[][] wrongPassword() {
        return new Object[][] {
                {"Parola000!"}
        };
    }

    @DataProvider (name = "invalidPassword")
    public Object[][] invalidPasswordSyntax() {
        return new Object[][] {
                {""},
                {" "},
                {"P"},
                {"123"},
                {"P123"},
                {"ParolaParola"},
                {"ParolaParola100"},
                {"ParolaParola!"},
                {"1234567890"},
                {"1234567890!"}
        };
    }

    /* ---------- COMBINED EMAIL & PASSWORD DATA PROVIDERS ---------- */

    @DataProvider (name = "validEmailAndValidPassword")
    public Object[][] validEmailAndValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "validEmailAndWrongPassword")
    public Object[][] validEmailAndWrongPassword() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = wrongPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "validEmailAndInvalidPasswordSyntax")
    public Object[][] validEmailAndInvalidPasswordSyntax() {

        //Prerequisites
        Object[][] dataProvider1 = validEmail();
        Object[][] dataProvider2 = invalidPasswordSyntax();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidEmailAndWrongPassword")

    @DataProvider
    public Object[][] invalidEmailAndValidPassword() {

        //Prerequisites
        Object[][] dataProvider1 = invalidEmailSyntax();
        Object[][] dataProvider2 = validPassword();
        List<Object[]> combinedDataProviders = new ArrayList<>();

        //Combine the data
        for (Object[] dataProvider1Obj : dataProvider1) {
            for (Object[] dataProvider2Obj : dataProvider2) {
                Object[] combinedItem = new Object[dataProvider1Obj.length + dataProvider2Obj.length];
                System.arraycopy(dataProvider1Obj, 0, combinedItem, 0, dataProvider1Obj.length);
                System.arraycopy(dataProvider2Obj, 0, combinedItem, dataProvider1Obj.length, dataProvider2Obj.length);
                combinedDataProviders.add(combinedItem);
            }
        }
        return combinedDataProviders.toArray(new Object[combinedDataProviders.size()][]);
    }

    @DataProvider (name = "invalidLoginCredentials")
    public static Object[][] invalidLoginCredentials() {
        return new Object[][] {

//                //Valid Email & Invalid Password
//                {"testuser@example.com", "P"},
//                {"testuser@example.com", "Parola999!!!"},
//
//                //Valid Email & Empty Password
//                {"testuser@example.com", ""},
//                {"testuser@example.com", " "},
//
//                //Empty Email & Valid Password
//                {"", "Parola100!"},
//                {" ", "Parola100!"},
//
//                //Empty Email & Empty Password
//                {"", ""},
//                {"", " "},
//                {" ", ""},
//                {" ", " "}
        };
    }
}