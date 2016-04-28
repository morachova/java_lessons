package ua.com.morachova.addressbook.model;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String email;

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            '}';
  }

  private String group;

  public ContactData(String firstname, String lastname, String address, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return firstname != null ? firstname.equals(that.firstname) : that.firstname == null;

  }

  @Override
  public int hashCode() {
    return firstname != null ? firstname.hashCode() : 0;
  }
}

