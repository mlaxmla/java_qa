package pl.stqa.mla.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.stqa.mla.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName_td());
    type(By.name("middlename"), contactData.getMiddleName_td());
    type(By.name("lastname"), contactData.getLastName_td());
    type(By.name("nickname"), contactData.getNickName_td());
    type(By.name("title"), contactData.getTitle_td());
    type(By.name("company"), contactData.getCompany_td());
    type(By.name("address"), contactData.getAddress_td());
    type(By.name("home"), contactData.getTelHome_td());
    type(By.name("mobile"), contactData.getTelMobile_td());
    type(By.name("email"), contactData.getEmail_td());
    type(By.name("email2"), contactData.getEmail2_td());
    type(By.name("homepage"), contactData.getHomePage_td());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
}
