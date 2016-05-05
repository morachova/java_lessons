package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().addNewContactIfEmpty();
  }

  @Test
  public void testContactDeletion(){
    //Check size of contact List
    List<ContactData> before = app.getContactHelper().getContactList();

    //Deletion of selected contact
    app.getContactHelper().selectContactToDelete(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().approveContactDeletion();

    //return to HomePage and check size
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    //check contacts after deletion
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }
}
