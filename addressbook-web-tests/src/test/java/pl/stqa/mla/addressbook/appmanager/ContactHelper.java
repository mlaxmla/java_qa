package pl.stqa.mla.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.mla.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void initContactModification() {
    click(By.cssSelector("img[alt='Edit']"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

}