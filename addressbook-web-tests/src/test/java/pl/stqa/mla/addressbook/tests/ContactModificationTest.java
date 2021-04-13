package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test_firstName_mod", "test_middleName_mod", "test_lastName_mod","test_Nickname_mod", "Title_mod", "Company_mod", "Address_mod", "TelHome_mod", "TelMobile_mod", "email_mod", "email2_mod", "Homepage_mod", null), false);
    app.getContactHelper().submitContactModification();
  }
}
