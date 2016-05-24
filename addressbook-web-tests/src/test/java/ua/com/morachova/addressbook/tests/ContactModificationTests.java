package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;
import ua.com.morachova.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    app.contact().addNewContactIfEmpty();
  }

  @Test
  public void testContactModification() {
    //Check size of contact List
    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("test123").withLastname("testing269");

    //Modification of selected contact
    app.contact().modify(contact);

    //check size
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    //check contacts after modification
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }
}
