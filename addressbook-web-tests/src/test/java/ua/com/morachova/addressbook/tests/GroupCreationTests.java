package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Check size of Group List before creation
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();

    //Group creation
    GroupData group = new GroupData().withName("name1");
    app.group().create(group);

    //Check size after creation
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    //Check groups after creation
    before.add(group);
    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
