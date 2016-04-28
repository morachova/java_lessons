package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion(){
    //Check size of Contact elements on page before deletion
    app.getContactHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();

    //In case there are no contacts - create one
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test1", null, "kievcity", null, "name1"), true);
    }

    //Deletion of selected contact
    app.getContactHelper().selectContactToDelete(before - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().approveContactDeletion();

    //return to HomePage and check size
    app.getContactHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);
  }
}
