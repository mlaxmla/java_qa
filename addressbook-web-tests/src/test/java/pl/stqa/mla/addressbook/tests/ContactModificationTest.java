package pl.stqa.mla.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.model.Contacts;
import pl.stqa.mla.addressbook.model.GroupData;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

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
  public void testContactModification() {
    app.gotoHomePage();
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(
            modifiedContact.getId()).withFirstName_td("FirstName_TestData_mod").withLastName_td("test_lastName_mod").withGroup("test1");
    // , "test_middleName_mod", "test_lastName_mod","test_Nickname_mod", "Title_mod", "Company_mod", "Address_mod", "TelHome_mod", "TelMobile_mod", "email_mod", "email2_mod", "Homepage_mod", "test1");
    app.contact().modify(contact);
    Contacts after = app.contact().all();

    assertEquals(after.size(), before.size());
//    before.remove(modifiedContact);
//    before.add(contact);
//    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//    assertEquals(before, after);
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }

}