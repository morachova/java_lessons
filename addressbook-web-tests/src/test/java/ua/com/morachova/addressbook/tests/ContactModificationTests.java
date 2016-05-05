package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().addNewContactIfEmpty();
  }

  @Test
  public void testContactModification() {


    //Check size of contact List
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "test2", "testing2", null, null, null);

    //Modification of selected contact
    app.getContactHelper().modifyContact(before, contact);

    //check size
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
