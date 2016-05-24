package ua.com.morachova.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.GroupData;
import ua.com.morachova.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    app.group().addNewGroupIfEmpty();
  }

  @Test
  public void testGroupModification(){
    //Check size of group elements in List
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("name1").withFooter("footer1").withHeader("header1");

    //Modification of selected group
    app.group().modify(group);

    //check size
    assertEquals(app.group().count(), before.size());
    Groups after = app.group().all();

    //check groups after modification
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
  }




}
