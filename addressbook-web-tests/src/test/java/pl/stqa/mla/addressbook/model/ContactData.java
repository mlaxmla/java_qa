package pl.stqa.mla.addressbook.model;

import java.io.File;
import java.util.Objects;
import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("contact")
public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  @Expose
  private String firstName_td;
  @Expose
  private String middleName_td;
  @Expose
  private String lastName_td;
  @Expose
  private String nickName_td;
  @Expose
  private String title_td;
  @Expose
  private String company_td;
  @Expose
  private String address_td;
  @Expose
  private String telHome_td;
  @Expose
  private String telMobile_td;
  private String telWork_td;
  @Expose
  private String email_td;
  @Expose
  private String email2_td;
  private String email3_td;
  @Expose
  private String homePage_td;
  private String detailText;
  @Expose
  private String group;
  private String allEmails;
  private String allPhones;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  //  public ContactData(int id, String firstName_td, String middleName_td, String lastName_td, String nickName_td, String title_td, String company_td, String address_td, String telHome_td, String telMobile_td, String email_td, String email2_td, String homePage_td, String group) {
//    this.id = id;
//    this.firstName_td = firstName_td;
//    this.middleName_td = middleName_td;
//    this.lastName_td = lastName_td;
//    this.nickName_td = nickName_td;
//    this.title_td = title_td;
//    this.company_td = company_td;
//    this.address_td = address_td;
//    this.telHome_td = telHome_td;
//    this.telMobile_td = telMobile_td;
//    this.email_td = email_td;
//    this.email2_td = email2_td;
//    this.homePage_td = homePage_td;
//    this.group = group;
//  }
//
//  public ContactData(String firstName_td, String middleName_td, String lastName_td, String nickName_td, String title_td, String company_td, String address_td, String telHome_td, String telMobile_td, String email_td, String email2_td, String homePage_td, String group) {
//    this.id = Integer.MAX_VALUE;
//    this.firstName_td = firstName_td;
//    this.middleName_td = middleName_td;
//    this.lastName_td = lastName_td;
//    this.nickName_td = nickName_td;
//    this.title_td = title_td;
//    this.company_td = company_td;
//    this.address_td = address_td;
//    this.telHome_td = telHome_td;
//    this.telMobile_td = telMobile_td;
//    this.email_td = email_td;
//    this.email2_td = email2_td;
//    this.homePage_td = homePage_td;
//    this.group = group;
//  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName_td(String firstName_td) {
    this.firstName_td = firstName_td;
    return this;
  }

  public ContactData withMiddleName_td(String middleName_td) {
    this.middleName_td = middleName_td;
    return this;
  }

  public ContactData withLastName_td(String lastName_td) {
    this.lastName_td = lastName_td;
    return this;
  }

  public ContactData withNickName_td(String nickName_td) {
    this.nickName_td = nickName_td;
    return this;
  }

  public ContactData withTitle_td(String title_td) {
    this.title_td = title_td;
    return this;
  }

  public ContactData withCompany_td(String company_td) {
    this.company_td = company_td;
    return this;
  }

  public ContactData withAddress_td(String address_td) {
    this.address_td = address_td;
    return this;
  }

  public ContactData withTelHome_td(String telHome_td) {
    this.telHome_td = telHome_td;
    return this;
  }

  public ContactData withTelMobile_td(String telMobile_td) {
    this.telMobile_td = telMobile_td;
    return this;
  }

  public ContactData withTelWork_td(String telWork_td) {
    this.telWork_td = telWork_td;
    return this;
  }

  public ContactData withEmail_td(String email_td) {
    this.email_td = email_td;
    return this;
  }

  public ContactData withEmail2_td(String email2_td) {
    this.email2_td = email2_td;
    return this;
  }

  public ContactData withEmail3_td(String email3_td) {
    this.email3_td = email3_td;
    return this;
  }

  public ContactData withHomePage_td(String homePage_td) {
    this.homePage_td = homePage_td;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getFirstName_td() {
    return firstName_td;
  }

  public String getMiddleName_td() {
    return middleName_td;
  }

  public String getLastName_td() {
    return lastName_td;
  }

  public String getNickName_td() {
    return nickName_td;
  }

  public String getTitle_td() {
    return title_td;
  }

  public String getCompany_td() {
    return company_td;
  }

  public String getAddress_td() {
    return address_td;
  }

  public String getTelHome_td() {
    return telHome_td;
  }

  public String getTelMobile_td() {
    return telMobile_td;
  }

  public String getTelWork_td() {
    return telWork_td;
  }

  public String getEmail_td() {
    return email_td;
  }

  public String getEmail2_td() {
    return email2_td;
  }

  public String getEmail3_td() {
    return email3_td;
  }

  public String getHomePage_td() {
    return homePage_td;
  }

  public String getGroup() {
    return group;
  }

  public String getDetailText() {
    return detailText;
  }

  public ContactData withDetailText(String detailText) {
    this.detailText = detailText;
    return  this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName_td='" + firstName_td + '\'' +
            ", lastName_td='" + lastName_td + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(firstName_td, that.firstName_td) && Objects.equals(lastName_td, that.lastName_td);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName_td, lastName_td);
  }
}
