package ua.com.morachova.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().addNewGroupIfEmpty();
  }

  @Test
  public void testGroupModification(){
    //Check size of group elements in List
    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("name1").withFooter("footer1").withHeader("header1");

    //Modification of selected group
    app.group().modify(group);

    //check List size
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size());

    //check groups after modification
    before.remove(modifiedGroup);
    before.add(group);
    Assert.assertEquals(before, after);
  }




}
