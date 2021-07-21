package pl.stqa.mla.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.GroupData;
import pl.stqa.mla.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroups() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withName("test1").withHeader("header 1").withFooter("footer 1")});
    list.add(new Object[] {new GroupData().withName("test2").withHeader("header 2").withFooter("footer 2")});
    list.add(new Object[] {new GroupData().withName("test3").withHeader("header 3").withFooter("footer 3")});
    return list.iterator();
  }

  @Test (dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
//    Loop 'for' changed into dataProvider
//    String[] names = new String[] {"test'1", "test2", "test3"};
//    for (String name : names) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      app.goTo().groupPage();
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
  //    assertThat(after.size(), equalTo(before.size() + 1));
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
//  }

  @Test (enabled = false)
  public void testBadGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("test1'");
    app.group().create(group);
    app.goTo().groupPage();
    assertThat(app.group().count(), equalTo(before.size()));
    Groups after = app.group().all();
//    assertThat(after.size(), equalTo(before.size()));
    assertThat(after, equalTo(before));
  }

}