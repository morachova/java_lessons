package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;
import ua.com.morachova.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    app.contact().addNewContactIfEmpty();
  }

  @Test
  public void testContactDeletion(){
    //Check size of contact List
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();

    //Delete
    app.contact().delete(deletedContact);

    //Check list after
    Assert.assertEquals(app.contact().count(), before.size() - 1);
    Contacts after = app.contact().all();

    //check contacts after deletion
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
