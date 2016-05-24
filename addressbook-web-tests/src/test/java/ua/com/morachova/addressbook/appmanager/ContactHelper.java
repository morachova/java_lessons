package ua.com.morachova.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ua.com.morachova.addressbook.model.ContactData;
import ua.com.morachova.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  private void fillBaseContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());
  }

  private void fillCreationContactForm(ContactData contactData) {
    fillBaseContactForm(contactData);
    new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
  }

  public void fillModificationContactForm(ContactData contactData) {
    fillBaseContactForm(contactData);
    Assert.assertFalse(isElementPresent(By.name("new_group")));
  }

  public void createContact(ContactData contact){
    initContactCreation();
    fillCreationContactForm(contact);
    submitContactCreation();
    contactCache = null;
    gotoHomePage();
  }

  public void modify(ContactData contact) {
    selectContactToEditById(contact.getId());
    fillModificationContactForm(contact);
    submitContactModification();
    contactCache = null;
    gotoHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    approveContactDeletion();
    contactCache = null;
    gotoHomePage();
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactToEditById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void approveContactDeletion() {
    wd.switchTo().alert().accept();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.cssSelector("#maintable tr:nth-child(2) input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void addNewContactIfEmpty() {
    if (! isThereAContact()){
      createContact(new ContactData().withFirstname("Newtest1").withLastname("Newtesting").withAddress("Newkievcity").withGroup("name1"));
    }
  }

  private Contacts contactCache = null;

  public Contacts all(){
    if (contactCache != null){
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String lastName = element.findElement(By.cssSelector("[name=entry] td:nth-child(2)")).getText();
      String firstName = element.findElement(By.cssSelector("[name=entry] td:nth-child(3)")).getText();
      int id = Integer.parseInt(element.findElement(By.cssSelector(".center>input")).getAttribute("id"));
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return new Contacts(contactCache);
  }
}
