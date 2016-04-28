package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    //Check size of Contact elements on page before deletion
    app.getContactHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();

    //In case there are no contacts - create one
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test1", null, "kievcity", null, "name1"), true);
    }

    //Modification of selected contact
    app.getContactHelper().selectContactToEdit();
    app.getContactHelper().fillContactForm(new ContactData("test1", "testing1", "kievcity", "test1.testing1@mail.net", null), false);
    app.getContactHelper().submitContactModification();

    ////return to HomePage and check size
    app.getContactHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
