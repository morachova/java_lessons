package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    //Start page
    app.getContactHelper().gotoHomePage();

    //In case there are no contacts - create one
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("test1", "testing", "kievcity", null, "name1"), true);
    }

    //Check size of contact List
    List<ContactData> before = app.getContactHelper().getContactList();

    //Modification of selected contact
    app.getContactHelper().selectContactToEdit(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "test2", "testing2", null, null, null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();

    //return to HomePage and check size
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    //check contacts after modification
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
