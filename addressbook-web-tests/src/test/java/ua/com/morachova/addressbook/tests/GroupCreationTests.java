package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("name1", "header1", "footer1"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}
