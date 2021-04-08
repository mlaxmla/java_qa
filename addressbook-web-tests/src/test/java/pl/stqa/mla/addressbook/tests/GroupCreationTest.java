package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("group_name_test1", "group_header_test2", "group_footer_test3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}