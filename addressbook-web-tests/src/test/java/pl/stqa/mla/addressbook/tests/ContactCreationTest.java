package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactData().withFirstName_td("FirstName_td1").withMiddleName_td("MiddleName_td1").withLastName_td("LastName_td1").withGroup("new_group")});
    list.add(new Object[] {new ContactData().withFirstName_td("FirstName_td2").withMiddleName_td("MiddleName_td2").withLastName_td("LastName_td2").withGroup("new_group")});
    return list.iterator();
  }

  @Test (dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.gotoHomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/photo.png");
//    ContactData contact = new ContactData()
//            .withFirstName_td("FirstName_TestData999").withMiddleName_td("MiddleNameTestData").withLastName_td("LastName_TestData").withNickName_td("Nickname_TestData").withTitle_td("Title_TestData").withCompany_td("Company_TestData").withAddress_td("Address_TestData").withTelHome_td("TelHome_testData").withTelMobile_td("TelMobile_testData").withEmail_td("email_testData").withEmail2_td("email2_testData").withEmail3_td("email3_testData").withHomePage_td("Homepage_testData")
//            .withPhoto(photo).withGroup("test1");
    app.contact().create(contact, true); // true
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

  @Test  (enabled = false)
  public void testCurrentDir() {
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/photo.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
    System.out.println(photo.isDirectory());
  }


}