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
    app.getContactHelper().addNewContactIfEmpty();

    //Check size of contact List
    List<ContactData> before = app.getContactHelper().getContactList();

    //Modification of selected contact
    app.getContactHelper().selectContactToEdit(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "test2", "testing2", null, null, null);
    app.getContactHelper().fillModificationContactForm(contact);
    app.getContactHelper().submitContactModification();

    //return to HomePage and check size
    app.getContactHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    //check contacts after modification
    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    /* Lambda sorting Java 8
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    */
  }
}
