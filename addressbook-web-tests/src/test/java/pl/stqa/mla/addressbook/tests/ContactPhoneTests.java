package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.gotoHomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getTelHome_td(), equalTo(cleaned(contactInfoFromEditForm.getTelHome_td())));
    assertThat(contact.getTelMobile_td(), equalTo(cleaned(contactInfoFromEditForm.getTelMobile_td())));
    assertThat(contact.getTelWork_td(), equalTo(cleaned(contactInfoFromEditForm.getTelWork_td())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
