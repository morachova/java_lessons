package ua.com.morachova.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification(){
    //Start page
    app.getNavigationHelper().gotoGroupPage();

    //In case there are no groups - create one
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("name1", null, null));
    }

    //Check size of group elements in List
    List<GroupData> before = app.getGroupHelper().getGroupList();

    //Modification of selected (last) group
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "name1", "header1", "footer1");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();

    //return to GroupPage and check List size
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    //check groups after modification
    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    /* Lambda sorting Java 8
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    */
  }
}
