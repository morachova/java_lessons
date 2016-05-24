package ua.com.morachova.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;
import ua.com.morachova.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().addNewGroupIfEmpty();
  }

  @Test
  public void testGroupDeletion() {
    //Check size of group elements in List
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();

    //Deletion of selected (last) group
    app.group().delete(deletedGroup);

    //check size
    assertEquals(app.group().count(), before.size() - 1);
    Groups after = app.group().all();

    //check groups after deletion
    assertThat(after, equalTo(before.without(deletedGroup)));
  }
}
