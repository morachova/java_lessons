package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion(){
    app.getContactHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test1", null, "kievcity", null, "name1"), true);
    }
    app.getContactHelper().selectContactToDelete();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().approveContactDeletion();
  }
}
