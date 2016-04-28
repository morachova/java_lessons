package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    //Check size of Contact elements before creation
    app.getContactHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();

    //Create contact
    app.getContactHelper().createContact(new ContactData("test1", null, "kievcity", null, "name1"), true);

    //return to HomePage and check size
    app.getContactHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}

