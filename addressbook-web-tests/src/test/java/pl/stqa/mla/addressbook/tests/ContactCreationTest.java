package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.*;
import pl.stqa.mla.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.gotoHomePage();
    app.initContactCreation();
    app.fillContactForm(new ContactData("FirstName_TestData", "MiddleNameTestData", "LastName_TestData", "Nickname_TestData", "Title_TestData", "Company_TestData", "Address_TestData", "TelHome_testData", "TelMobile_testData", "email_testData", "email2_testData", "Homepage_testData"));
    app.submitContactCreation();
    app.returnToHomePage();

  }

}