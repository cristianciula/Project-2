package testdata.dataprovider;

import org.testng.annotations.DataProvider;

public class userDataProvider {

    @DataProvider (name = "validLoginCredentials")
    public static Object[][] validLoginCredentials() {
        return new Object[][]{
                {"testuser@example.com", "Parola100!"}
        };
    }

    @DataProvider (name = "validEmailAddress")
    public Object[][] validEmailAddress() {
        return new Object[][] {
                {"testuser@example.com"}
        };
    }

    @DataProvider (name = "validPassword")
    public Object[][] validPassword() {
        return new Object[][] {
                {"Parola100!"}
        };
    }

    @DataProvider (name = "invalidEmailSyntaxes")
    public Object[][] invalidEmailSyntax() {
        return new Object[][]{
                {"@example.com"},
                {"userexample.com"},
                {"user@.com"},
                {"user@examplecom"},
                {"user@example."},
                {"user@example.c"}
        };
    }

    @DataProvider (name = "invalidPassword")
    public Object[][] invalidPasswordSyntax() {
        return new Object[][] {
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

    @DataProvider (name = "invalidLoginCredentials")
    public static Object[][] invalidLoginCredentials() {
        return new Object[][] {

                // Invalid Email syntax & Valid Password
//                {"@example.com", "Parola100!"},
//                {"userexample.com", "Parola100!"},
//                {"user@.com", "Parola100!"},
//                {"user@examplecom", "Parola100!"},
//                {"user@example.", "Parola100!"},
//                {"user@example.c", "Parola100!"},

                //Unregistered Email & Valid Password
                {"notauser@example.com", "Parola100!"},

                {"testuser@example.com", "Parola100!"},

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