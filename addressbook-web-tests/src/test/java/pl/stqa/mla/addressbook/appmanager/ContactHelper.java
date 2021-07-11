package pl.stqa.mla.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.mla.addressbook.model.ContactData;
import pl.stqa.mla.addressbook.appmanager.ApplicationManager;
import pl.stqa.mla.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  // a change of the helper constructor to accept a link to the manager (instead of a link to a browser driver)
  ApplicationManager manager;

  public ContactHelper(ApplicationManager manager) {
    super(manager.wd);
    this.manager = manager;
  }

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

  public void modify(ContactData contact) {
    editContactById(contact.getId());
//    wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
//    click(By.cssSelector("img[alt='Edit']"));
    fillForm(contact, false);
    submitModification();
    gotoHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContacts();
    gotoHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    gotoHomePage();
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void editContactById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact, boolean creation) {
    initContactCreation();
    fillForm(contact, creation); // true
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

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows_table = wd.findElements(By.xpath("//*[@id='maintable']//tr[@name='entry']")); //    id("maintable"));
    int rows_count = rows_table.size();
    for (int row = 0; row < rows_count; row++) {
      List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
      String lastname = Columns_row.get(1).getText();
      String firstname = Columns_row.get(2).getText();
      String[] phones = Columns_row.get(5).getText().split("\n");
      String allPhones = Columns_row.get(5).getText();
      String[] emails = Columns_row.get(4).getText().split("\n");
      String allEmails = Columns_row.get(4).getText();
      int id = Integer.parseInt(Columns_row.get(0).findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withFirstName_td(firstname).withLastName_td(lastname)
              .withAllPhones(allPhones).withAllEmails(allEmails));
//              .withTelHome_td(phones[0]).withTelMobile_td(phones[1]).withTelWork_td(phones[2]));
      // , null, lastname, null, null, null, null, null, null, null, null, null, null);
    }
    return contacts;
  }

  public void gotoHomePage() {
    wd.get("http://localhost:8080/addressbook/");
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");

    wd.navigate().back();
    return new ContactData()
            .withId(contact.getId()).withFirstName_td(firstname).withLastName_td(lastname)
            .withTelHome_td(home).withTelMobile_td(mobile).withTelWork_td(work)
            .withEmail_td(email).withEmail2_td(email2).withEmail3_td(email3);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

//    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
//    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
//    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }
}