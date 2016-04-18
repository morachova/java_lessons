package ua.com.morachova.addressbook.tests;

import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.initContactCreation();
    app.fillContactForm(new ContactData("test1", "testing1", "kievcity", "test1.testing1@mail.net"));
    app.submitContactCreation();
    app.gotoHomePage();
  }
}

