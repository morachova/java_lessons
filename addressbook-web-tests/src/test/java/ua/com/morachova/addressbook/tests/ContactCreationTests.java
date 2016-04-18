package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test1", "testing1", "kievcity", "test1.testing1@mail.net"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}

