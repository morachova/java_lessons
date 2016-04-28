package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion(){
    //Start page
    app.getContactHelper().gotoHomePage();

    //In case there are no contacts - create one
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test1", null, "kievcity", null, "name1"), true);
    }

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
  }
}
