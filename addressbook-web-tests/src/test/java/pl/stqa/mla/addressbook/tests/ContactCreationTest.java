package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() {
    app.gotoHomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withFirstName_td("FirstName_TestData999").withMiddleName_td("MiddleNameTestData").withLastName_td("LastName_TestData").withNickName_td("Nickname_TestData").withTitle_td("Title_TestData").withCompany_td("Company_TestData").withAddress_td("Address_TestData").withTelHome_td("TelHome_testData").withTelMobile_td("TelMobile_testData").withEmail_td("email_testData").withEmail2_td("email2_testData").withHomePage_td("Homepage_testData").withGroup("test1");
    app.contact().create(contact, true);
    app.gotoHomePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() + 1));

//    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//    before.add(contact);
//    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
//    assertEquals(before, after);

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}