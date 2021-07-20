package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTests extends TestBase {

  @Test (enabled = true)
  public void testContactEmails() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }


  @Test (enabled = true)
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


  @Test (enabled = true)
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


  @Test (enabled = true)
  public void testContactDetails() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    ContactData contactDetailsInfoForm = app.contact().infoFromDetails(contact);

    assertThat(mergeDetails(contactInfoFromEditForm), equalTo(cleaned(contactDetailsInfoForm.getDetailText())));
  }

  private String mergeNamesAndSurname(ContactData contact) {
    return Arrays.asList((contact.getFirstName_td() + " " + contact.getMiddleName_td() + " " + contact.getLastName_td())
            .trim())
            .stream().filter((n) -> !n.equals(""))
            .collect(Collectors.joining("\n"));
  }

  private String mergeDetails(ContactData contact) {
    return Arrays.asList(mergeNamesAndSurname(contact),
            contact.getNickName_td(),
            contact.getTitle_td(),
            contact.getCompany_td(),
            contact.getAddress_td(),
            mergePhones(contact), mergeEmails(contact),
            contact.getHomePage_td())
            .stream().filter((d) -> !d.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("[A-Z]: ", "")
            .replaceAll("\n\n", "\n")
            .replaceAll("\n\nMember of: [A-Z,a-z]* *[0-9]*","")
            .replaceAll("Homepage:\n","")
            .replaceAll("[-()]", "")
            ;
  }

}
