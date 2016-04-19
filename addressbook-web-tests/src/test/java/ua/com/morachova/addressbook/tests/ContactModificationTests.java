package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().fillContactForm(new ContactData("test1", "testing1", "kievcity", "test1.testing1@mail.net"));
    app.getContactHelper().submitContactModification();
  }
}
