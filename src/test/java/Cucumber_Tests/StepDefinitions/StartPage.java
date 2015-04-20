package Cucumber_Tests.StepDefinitions;

import Cucumber_Tests.PageInstance;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by bondar on 4/20/2015.
 */
public class StartPage extends PageInstance{
    @Given("^I am om mail.ru start page$")
    public void I_am_om_mail_ru_start_page(){
        startPage.open();
    }

    @When("^I login to mail using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void I_login_to_mail_using_and(String login, String password){
        emailPage = startPage.loginToMail(login, password);
        initialMailCount = emailPage.getCurrentUnreadCount();
    }
}
