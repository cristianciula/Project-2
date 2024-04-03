package tests;

import constants.AccountDashboardConst;
import constants.LoginConst;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.URL;

import static org.testng.Assert.*;

public class LogInTests extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        super.beforeTest();
        driver.get(URL.LOGIN_PAGE);
    }

    //____________________POSITIVE TESTS____________________//

    @Test (description = "Tests that a user entering valid credentials can login", priority = 1)
    public void validEmailAndPasswordLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.enterEmail(validUser.getEmail());
        logInPage.enterPassword(validUser.getPassword());
        logInPage.clickLoginButton();

        assertEquals(AccountDashboardConst.HELLO_USERNAME_MESSAGE, accountDashboardPage.getUserGreetingPlaceholder());

        header.logoutUser();
    }

    //____________________NEGATIVE TESTS____________________//

    @Test (description = "Tests that a user leaving the Email field empty cannot login.", priority = 2)
    public void emptyEmailLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.enterPassword(validUser.getPassword());
        logInPage.clickLoginButton();

        assertEquals(logInPage.getEmailEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR);
        assertEquals(logInPage.getCurrentUrl(), URL.LOGIN_PAGE);
        assertTrue(logInPage.loginButtonIsDisplayed());
    }

    @Test (description = "Tests that a user leaving the Password field empty cannot login.", priority = 3)
    public void emptyPasswordLogin() {
        driver.get(URL.LOGIN_PAGE);

        logInPage.clearCredentialsInputFields();
        logInPage.enterEmail(validUser.getEmail());
        logInPage.clearPasswordInputField();
        logInPage.clickLoginButton();

        assertTrue(logInPage.passwordEmptyErrorIsDisplayed(), "Password input error message is not displayed.");
        assertEquals(logInPage.getPasswordEmptyErrorMessage(), LoginConst.REQUIRED_FIELD_ERROR);
    }

    @Test (description = "Tests that a user leaving the Email and Password fields empty cannot login", priority = 4)
    public void emptyEmailAndPasswordLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.clickLoginButton();

        assertTrue(logInPage.emailEmptyErrorMessageIsDisplayed(), "Email required error message is not displayed.");
        assertTrue(logInPage.passwordEmptyErrorIsDisplayed(), "Password required error message is not displayed.");
        assertTrue(logInPage.loginButtonIsDisplayed(), "Login button is not displayed.");
    }

    @Test (description = "Tests that a user entering an invalid Email and a valid Password cannot login.", priority = 5)
    public void invalidEmailLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.enterEmail("nonRegisteredEmail@example.com");
        logInPage.enterPassword(validUser.getPassword());
        logInPage.clickLoginButton();

        assertTrue(logInPage.credentialsInvalidErrorMessageIsDisplayed());
        assertEquals(logInPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR);
    }

    @Test (description = "Tests that a user entering a valid Email and an invalid Password cannot login.", priority = 6)
    public void invalidPasswordLogin() {
        logInPage.clearCredentialsInputFields();
        logInPage.enterEmail(validUser.getEmail());
        logInPage.enterPassword(invalidUser.getPassword());
        logInPage.clickLoginButton();

        assertTrue(logInPage.credentialsInvalidErrorMessageIsDisplayed());
        assertEquals(logInPage.getCredentialsInvalidErrorMessage(), LoginConst.INVALID_CREDENTIALS_ERROR);
    }
}
