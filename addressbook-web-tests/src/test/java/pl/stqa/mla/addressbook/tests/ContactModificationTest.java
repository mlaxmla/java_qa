package pl.stqa.mla.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {
    app.gotoHomePage();
    if (app.contact().list().size() == 0) {
      app.goTo().groupPage();
      if (! app.group().isThereAGroup()) {
        app.group().create(new GroupData().withName("test1"));
      }
      app.gotoHomePage();
      app.contact().create(new ContactData().withFirstName_td("FirstName_TestData_2modify").withLastName_td("LastName_TestData"), true);
              // , "MiddleNameTestData", "LastName_TestData", "Nickname_TestData", "Title_TestData", "Company_TestData", "Address_TestData", "TelHome_testData", "TelMobile_testData", "email_testData", "email2_testData", "Homepage_testData", "test1"), true);
    }
    List<ContactData> before = app.contact().list();
    app.contact().modify(before.size() -1);
    ContactData contact = new ContactData().withId(before.get(before.size() -1).getId()).withFirstName_td("FirstName_TestData_mod").withLastName_td("test_lastName_mod");
            // , "test_middleName_mod", "test_lastName_mod","test_Nickname_mod", "Title_mod", "Company_mod", "Address_mod", "TelHome_mod", "TelMobile_mod", "email_mod", "email2_mod", "Homepage_mod", "test1");
    app.contact().fillForm(contact, false);
    app.contact().submitModification();
    app.gotoHomePage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
//    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    Assert.assertEquals(before, after);
  }

}
