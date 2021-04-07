package pl.stqa.mla.addressbook;

import org.testng.annotations.*;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    gotoHomePage();
    initContactCreation();
    fillContactForm(new ContactData("FirstName_TestData", "MiddleNameTestData", "LastName_TestData", "Nickname_TestData", "Title_TestData", "Company_TestData", "Address_TestData", "TelHome_testData", "TelMobile_testData", "email_testData", "email2_testData", "Homepage_testData"));
    submitContactCreation();
    returnToHomePage();

  }

}
