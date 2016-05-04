package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Check size of Group List before creation
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();

    //Group creation
    GroupData group = new GroupData("name1", null, null);
    app.getGroupHelper().createGroup(group);

    //Check size after creation
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    //Find max id from existing Java 7
    int max = 0;
    for (GroupData g : after){
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    group.setId(max);

    //Check groups after creation
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    /*Java 8 compare lambda method
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
     */

    /* Lambda sorting Java 8
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    */
  }
}
