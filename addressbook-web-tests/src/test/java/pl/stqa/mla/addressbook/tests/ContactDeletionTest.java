package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.model.Contacts;
import pl.stqa.mla.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.gotoHomePage();
    if (app.contact().list().size() == 0) {
      app.goTo().groupPage();
      if (! app.group().isThereAGroup()) {
        app.group().create(new GroupData().withName("test1"));
      }
      app.gotoHomePage();
      app.contact().create(new ContactData().withFirstName_td("FirstName_TestData_2delete").withLastName_td("LastName_TestData").withGroup("test1"), true);
              // "MiddleNameTestData", "LastName_TestData", "Nickname_TestData", "Title_TestData", "Company_TestData", "Address_TestData", "TelHome_testData", "TelMobile_testData", "email_testData", "email2_testData", "Homepage_testData", "test1"), true);
    }
  }

  @Test
  public void testContactDeletion() {
    app.gotoHomePage();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size() - 1);
//    before.remove(deletedContact);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
