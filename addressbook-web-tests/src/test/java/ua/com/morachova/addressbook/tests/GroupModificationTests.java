package ua.com.morachova.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().addNewGroupIfEmpty();
  }

  @Test
  public void testGroupModification(){
    //Check size of group elements in List
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "name1", "header1", "footer1");

    //Modification of selected group
    app.group().modify(index, group);

    //check List size
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    //check groups after modification
    before.remove(index);
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
