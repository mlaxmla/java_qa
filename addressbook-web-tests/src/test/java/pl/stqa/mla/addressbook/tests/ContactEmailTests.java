package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {

  @Test
  public void testContactAddress() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAddress_td(), equalTo(contactInfoFromEditForm.getAddress_td()));
  }

}
