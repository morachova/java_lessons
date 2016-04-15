package ua.com.morachova.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    initContactCreation();
    fillContactForm(new ContactData("test1", "testing1", "kievcity", "test1.testing1@mail.net"));
    submitContactCreation();
    gotoHomePage();
  }
}

