package ua.com.morachova.addressbook.tests;


import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("name1", "header1", "footer1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}
