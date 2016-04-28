package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    //Check size of Group elements before creation
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();

    //Group creation
    app.getGroupHelper().createGroup(new GroupData("name1", null, null));

    //Check size after creation
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before + 1);
  }
}
