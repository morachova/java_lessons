package ua.com.morachova.addressbook.tests;

import ua.com.morachova.addressbook.model.Contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    //Check size of Contact elements before creation
    app.goTo().homePage();
    Contacts before = app.contact().all();

    //Create contact
    ContactData contact = new ContactData()
            .withFirstname("test1").withLastname("testing")
            .withAddress("kievcity").withGroup("name1").withEmail(null);
    app.contact().createContact(contact);

    //Check size
    Assert.assertEquals(app.contact().count(), before.size() + 1);
    Contacts after = app.contact().all();

    //check contact after creation
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}

