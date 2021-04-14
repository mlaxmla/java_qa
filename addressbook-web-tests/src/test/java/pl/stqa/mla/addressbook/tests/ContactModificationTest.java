package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.model.GroupData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoGroupPage();
      if (! app.getGroupHelper().isThereAGroup()) {
        app.getGroupHelper().createGroup(new GroupData("test1", null, null));
      }
      app.gotoHomePage();
      app.getContactHelper().createContact(new ContactData("FirstName_TestData_2modify", "MiddleNameTestData", "LastName_TestData", "Nickname_TestData", "Title_TestData", "Company_TestData", "Address_TestData", "TelHome_testData", "TelMobile_testData", "email_testData", "email2_testData", "Homepage_testData", "test1"), true);
    }
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test_firstName_mod", "test_middleName_mod", "test_lastName_mod","test_Nickname_mod", "Title_mod", "Company_mod", "Address_mod", "TelHome_mod", "TelMobile_mod", "email_mod", "email2_mod", "Homepage_mod", "test1"), false);
    app.getContactHelper().submitContactModification();
  }

}
