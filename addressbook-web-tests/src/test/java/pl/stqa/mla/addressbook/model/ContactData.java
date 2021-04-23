package pl.stqa.mla.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String firstName_td;
  private final String middleName_td;
  private final String lastName_td;
  private final String nickName_td;
  private final String title_td;
  private final String company_td;
  private final String address_td;
  private final String telHome_td;
  private final String telMobile_td;
  private final String email_td;
  private final String email2_td;
  private final String homePage_td;
  private String group;

  public ContactData(int id, String firstName_td, String middleName_td, String lastName_td, String nickName_td, String title_td, String company_td, String address_td, String telHome_td, String telMobile_td, String email_td, String email2_td, String homePage_td, String group) {
    this.id = id;
    this.firstName_td = firstName_td;
    this.middleName_td = middleName_td;
    this.lastName_td = lastName_td;
    this.nickName_td = nickName_td;
    this.title_td = title_td;
    this.company_td = company_td;
    this.address_td = address_td;
    this.telHome_td = telHome_td;
    this.telMobile_td = telMobile_td;
    this.email_td = email_td;
    this.email2_td = email2_td;
    this.homePage_td = homePage_td;
    this.group = group;
  }

  public ContactData(String firstName_td, String middleName_td, String lastName_td, String nickName_td, String title_td, String company_td, String address_td, String telHome_td, String telMobile_td, String email_td, String email2_td, String homePage_td, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstName_td = firstName_td;
    this.middleName_td = middleName_td;
    this.lastName_td = lastName_td;
    this.nickName_td = nickName_td;
    this.title_td = title_td;
    this.company_td = company_td;
    this.address_td = address_td;
    this.telHome_td = telHome_td;
    this.telMobile_td = telMobile_td;
    this.email_td = email_td;
    this.email2_td = email2_td;
    this.homePage_td = homePage_td;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getEmail_td() {
    return email_td;
  }

  public String getEmail2_td() {
    return email2_td;
  }

  public String getHomePage_td() {
    return homePage_td;
  }

  public String getGroup() {
    return group;
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
    return Objects.equals(firstName_td, that.firstName_td) && Objects.equals(lastName_td, that.lastName_td);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName_td, lastName_td);
  }

}
