package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    app.contact().addNewContactIfEmpty();
  }

  @Test
  public void testContactDeletion(){
    //Check size of contact List
    List<ContactData> before = app.contact().list();
    int index = before.size() - 1;

    //Delete
    app.contact().delete(index);

    //Check list after
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    //check contacts after deletion
    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
