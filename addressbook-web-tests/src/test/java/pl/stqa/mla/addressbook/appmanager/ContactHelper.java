package pl.stqa.mla.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.mla.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void submitModification() {
    click(By.name("update"));
  }

  public void fillForm(ContactData contactData, boolean creation) {
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

  public void modify(int index) {
    wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
//    click(By.cssSelector("img[alt='Edit']"));
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContacts();
    returnToHomePage(); //    app.gotoHomePage();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
//    click(By.name("selected[]"));
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillForm(contact, true);
    submitContactCreation();
    returnToHomePage();
  }

  public void returnToHomePage() {
    wd.findElement(By.linkText("home page")).click();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows_table = wd.findElements(By.xpath("//*[@id='maintable']//tr[@name='entry']")); //    id("maintable"));
    int rows_count = rows_table.size();
    for (int row = 0; row < rows_count; row++) {
      List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
      String lastname = Columns_row.get(1).getText();
      String firstname = Columns_row.get(2).getText();
      int id = Integer.parseInt(Columns_row.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName_td(firstname).withLastName_td(lastname));
      // , null, lastname, null, null, null, null, null, null, null, null, null, null);
    }
    return contacts;
  }

  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows_table = wd.findElements(By.xpath("//*[@id='maintable']//tr[@name='entry']")); //    id("maintable"));
    int rows_count = rows_table.size();
    for (int row = 0; row < rows_count; row++) {
      List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
      String lastname = Columns_row.get(1).getText();
      String firstname = Columns_row.get(2).getText();
      int id = Integer.parseInt(Columns_row.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName_td(firstname).withLastName_td(lastname));
      // , null, lastname, null, null, null, null, null, null, null, null, null, null);
    }
    return contacts;
  }
}