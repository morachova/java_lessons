package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    //Check size of Group elements before deletion
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();

    //In case there are no groups - create one
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("name1", null, null));
    }

    //Deletion of selected group
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();

    //return to GroupPage and check size
    app.getNavigationHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before - 1);
  }
}
