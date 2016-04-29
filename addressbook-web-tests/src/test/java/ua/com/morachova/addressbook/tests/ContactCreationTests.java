package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  ContactData contact = new ContactData("test1", "testing", "kievcity", null, "name1");

  @Test
  public void testContactCreation() {
    //Check size of Contact elements before creation
    app.getContactHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();

    //Create contact
    app.getContactHelper().createContact(contact);

    //Check size after creation
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    //Find max id from existing
    int max = 0;
    for (ContactData c : after){
      if (c.getId() > max){
        max = c.getId();
      }
    }
    contact.setId(max);

    //check contact after creation
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}

