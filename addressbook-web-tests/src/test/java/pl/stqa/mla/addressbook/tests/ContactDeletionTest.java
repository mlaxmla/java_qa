package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

  @Test
  public void testContactDeletion() {
    app.gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContacts();
  }
}
