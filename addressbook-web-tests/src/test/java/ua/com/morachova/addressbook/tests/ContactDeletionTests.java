package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    app.contact().addNewContactIfEmpty();
  }

  @Test
  public void testContactDeletion(){
    //Check size of contact List
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();

    //Delete
    app.contact().delete(deletedContact);

    //Check list after
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    //check contacts after deletion
    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }
}
