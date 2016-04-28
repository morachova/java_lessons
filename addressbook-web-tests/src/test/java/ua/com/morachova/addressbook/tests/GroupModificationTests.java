package ua.com.morachova.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification(){
    //Check size of Group elements before deletion
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();

    //In case there are no groups - create one
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("name1", null, null));
    }

    //Modification of selected group
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("name1", "header1", "footer1"));
    app.getGroupHelper().submitGroupModification();

    //return to GroupPage and check size
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }
}
