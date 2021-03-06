package pl.stqa.mla.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.stqa.mla.addressbook.model.GroupData;
import pl.stqa.mla.addressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroupsFromXml() throws IOException {
    //    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) { // csv
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
//      String[] split = line.split(";");
//      list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
        xml += line;
        line = reader.readLine();
      }
      XStream xstream = new XStream();
      xstream.processAnnotations(GroupData.class);
      List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
      //    return list.iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validGroupsFromJson() throws IOException {
    //    List<Object[]> list = new ArrayList<Object[]>();
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); // idiom List<GroupData>.class
      return groups.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test (dataProvider = "validGroupsFromJson")
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