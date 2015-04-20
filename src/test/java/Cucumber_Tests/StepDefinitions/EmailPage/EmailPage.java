package Cucumber_Tests.StepDefinitions.EmailPage;

import Cucumber_Tests.PageInstance;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by bondar on 4/20/2015.
 */
public class EmailPage extends PageInstance{
    @When("^I press 'Write letter' button$")
    public void I_press_Write_letter_button(){
        writeLetter = emailPage.writeLetter();
    }

    @When("^I write letter to \"([^\"]*)\" with \"([^\"]*)\" and text \"([^\"]*)\"$")
    public void I_write_letter_to_with_and_text(String login, String subject, String textMessage){
        writeLetter.addReceiver(login + "@mail.ru");
        writeLetter.addSubject(subject);
        writeLetter.addText(textMessage);
    }

    @Then("^I press 'Send letter'$")
    public void I_press_Send_letter(){
        emailPage = writeLetter.sendLetter();
    }

    @Then("^I receive new letter$")
    public void I_receive_new_letter() throws Throwable {
        int updatedMailCount = emailPage.getCurrentUnreadCount();
        Assert.assertTrue("Mail count was not changed. New letter was not received.", updatedMailCount > initialMailCount);
    }
}
