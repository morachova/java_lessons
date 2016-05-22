package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().addNewGroupIfEmpty();
  }

  @Test
  public void testGroupDeletion() {
    //Check size of group elements in List
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();

    //Deletion of selected (last) group
    app.group().delete(deletedGroup);

    //check size
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    //check groups after deletion
    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }


}
