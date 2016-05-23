package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    app.contact().addNewContactIfEmpty();
  }

  @Test
  public void testContactModification() {
    //Check size of contact List
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test123").withLastname("testing269");

    //Modification of selected contact
    app.contact().modify(contact);

    //check size
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    //check contacts after modification
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}
