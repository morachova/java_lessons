package ua.com.morachova.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    //Check size of Contact elements before creation
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();

    //Create contact
    ContactData contact = new ContactData()
            .withFirstname("test1").withLastname("testing")
            .withAddress("kievcity").withGroup("name1").withEmail(null);
    app.contact().createContact(contact);

    //Check size after creation
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    //Find max id from existing
    int max = 0;
    for (ContactData c : after){
      if (c.getId() > max){
        max = c.getId();
      }
    }
    //set max id
    contact.withId(max);

    //check contact after creation
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    /*Java 8 compare lambda method
    contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    */

    /* Lambda sorting Java 8
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    */
  }
}

