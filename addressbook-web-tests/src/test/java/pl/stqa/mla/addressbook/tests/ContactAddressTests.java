package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddressTests extends TestBase {

  @Test
  public void testContactEmails() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail_td(), contact.getEmail2_td(), contact.getEmail3_td())
            .stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

}
