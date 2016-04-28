package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    //Check size of Contact elements before creation
    app.getContactHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();

    //Create contact
    app.getContactHelper().createContact(new ContactData("test1", null, "kievcity", null, "name1"), true);

    //Check size after creation
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}

