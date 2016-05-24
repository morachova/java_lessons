package ua.com.morachova.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
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

    //Check size after creation
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    //check contact after creation
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}

