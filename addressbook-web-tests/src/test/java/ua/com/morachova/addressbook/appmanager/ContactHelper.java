package ua.com.morachova.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.com.morachova.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactToEdit(int index) {
    wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
  }

  public void submitContactModification() {
    click(By.cssSelector("input[value=Update]:nth-child(1)"));
  }

  public void gotoHomePage() {
    if (isElementPresent(By.id("maintable"))){
      return;
    }
    click(By.linkText("home"));
  }

  public void deleteSelectedContact() {
    click(By.cssSelector("input[value=Delete]"));
  }

  public void selectContactToDelete(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void approveContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact, boolean creation){
    initContactCreation();
    fillContactForm(contact, creation);
    submitContactCreation();
    gotoHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.cssSelector("#maintable tr:nth-child(2) input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String firstName = element.findElement(By.cssSelector("[name=entry] td:nth-child(3)")).getText();
      String id = element.findElement(By.className("center")).getAttribute("value");
      ContactData contact = new ContactData(id, firstName, null, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}

//[name=entry] td:nth-child(2)