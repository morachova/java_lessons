package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;
import ua.com.morachova.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Check size of Group List before creation
    app.goTo().groupPage();
    Groups before = app.group().all();

    //Group creation
    GroupData group = new GroupData().withName("name1");
    app.group().create(group);

    //Check size after creation
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    //Check groups after creation
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }
}
