package ua.com.morachova.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.com.morachova.addressbook.model.ContactData;

public class ContactHelper extends BaseHelper {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("email"), contactData.getEmail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactToEdit() {
    click(By.xpath("(//img[@alt='Edit'])[1]"));
  }

  public void submitContactModification() {
    click(By.cssSelector("input[value=Update]:nth-child(1)"));
  }

  public void deleteSelectedContact() {
    click(By.cssSelector("input[value=Delete]"));
  }

  public void selectContactToDelete() {
    click(By.cssSelector("#maintable>tbody>tr:nth-child(2)>.center>input"));
  }

  public void approveContactDeletion() {
    wd.switchTo().alert().accept();
  }
}
