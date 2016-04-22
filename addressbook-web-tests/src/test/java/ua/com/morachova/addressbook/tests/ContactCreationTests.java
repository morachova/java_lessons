package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().fillContactForm(new ContactData("test1", null, "kievcity", null));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();
  }
}

