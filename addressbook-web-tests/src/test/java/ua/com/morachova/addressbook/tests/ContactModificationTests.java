package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getContactHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test1", null, "kievcity", null, "name1"), true);
    }
    app.getContactHelper().selectContactToEdit();
    app.getContactHelper().fillContactForm(new ContactData("test1", "testing1", "kievcity", "test1.testing1@mail.net", null), false);
    app.getContactHelper().submitContactModification();
  }
}
