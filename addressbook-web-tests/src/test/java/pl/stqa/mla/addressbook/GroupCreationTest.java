package pl.stqa.mla.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("group_name_test1", "group_header_test2", "group_footer_test3"));
    submitGroupCreation();
    returnToGroupPage();
  }

}