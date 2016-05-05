package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().addNewGroupIfEmpty();
  }

  @Test
  public void testGroupDeletion() {

    //Check size of group elements in List
    List<GroupData> before = app.getGroupHelper().getGroupList();

    //Deletion of selected (last) group
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();

    //return to GroupPage and check size
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() - 1);

    //check groups after deletion
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
