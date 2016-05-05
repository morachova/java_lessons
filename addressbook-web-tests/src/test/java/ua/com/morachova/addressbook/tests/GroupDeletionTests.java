package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().addNewGroupIfEmpty();
  }

  @Test
  public void testGroupDeletion() {
    //Check size of group elements in List
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;

    //Deletion of selected (last) group
    app.group().delete(index);

    //check size
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    //check groups after deletion
    before.remove(index);
    Assert.assertEquals(before, after);
  }


}
