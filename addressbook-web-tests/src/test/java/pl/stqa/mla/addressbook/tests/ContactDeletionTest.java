package pl.stqa.mla.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.model.GroupData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() {
    app.gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.goTo().groupPage();
      if (! app.group().isThereAGroup()) {
        app.group().create(new GroupData().withName("test1"));
      }
      app.gotoHomePage();
      app.getContactHelper().createContact(new ContactData("FirstName_TestData_2delete", "MiddleNameTestData", "LastName_TestData", "Nickname_TestData", "Title_TestData", "Company_TestData", "Address_TestData", "TelHome_testData", "TelMobile_testData", "email_testData", "email2_testData", "Homepage_testData", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContacts();
    app.gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

}
