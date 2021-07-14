package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTests extends TestBase {

  @Test
  public void testContactEmails() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  @Test
  public void testContactAddress() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress_td(), equalTo(contactInfoFromEditForm.getAddress_td()));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail_td(), contact.getEmail2_td(), contact.getEmail3_td())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  @Test
  public void testContactPhones() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

//    assertThat(contact.getTelHome_td(), equalTo(cleaned(contactInfoFromEditForm.getTelHome_td())));
//    assertThat(contact.getTelMobile_td(), equalTo(cleaned(contactInfoFromEditForm.getTelMobile_td())));
//    assertThat(contact.getTelWork_td(), equalTo(cleaned(contactInfoFromEditForm.getTelWork_td())));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getTelHome_td(), contact.getTelMobile_td(), contact.getTelWork_td())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
