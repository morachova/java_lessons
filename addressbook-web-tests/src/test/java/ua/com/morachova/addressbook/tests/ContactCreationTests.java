package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    //Check size of Contact elements before creation
    app.goTo().homePage();
    Set<ContactData> before = app.contact().all();

    //Create contact
    ContactData contact = new ContactData()
            .withFirstname("test1").withLastname("testing")
            .withAddress("kievcity").withGroup("name1").withEmail(null);
    app.contact().createContact(contact);

    //Check size after creation
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    //check contact after creation
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }
}

