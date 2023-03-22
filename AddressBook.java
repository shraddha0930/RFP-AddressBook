import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    public void getContact() {
        System.out.println("Enter details : ");
        Contact personDetails = getPersonDetails();
        int present = 0;
        for (Contact contact : contacts) {
            if (contact.getFirstName().equals(personDetails.getFirstName())) {
                present = 1;
                System.out.println("Person already exist");
                break;
            }
        }
        if (present == 0) {
            contacts.add(personDetails);
        }
    }

    public Contact getPersonDetails() {
        Contact contact = new Contact();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Name : ");
        contact.setFirstName(input.next());
        System.out.print("Enter Last Name : ");
        contact.setLastName(input.next());
        System.out.print("Enter Address : ");
        contact.setAddress(input.next());
        System.out.print("Enter City : ");
        contact.setCity(input.next());
        System.out.print("Enter State : ");
        contact.setState(input.next());
        System.out.print("Enter Zipcode : ");
        contact.setZipcode(input.nextInt());
        System.out.print("Enter Phone number : ");
        contact.setPhoneNumber(input.nextInt());
        System.out.print("Enter Email ID : ");
        contact.setEmail(input.next());
        return contact;
    }

    public void editPersonDetails() {
        System.out.println("Enter the option to edit");
        String name = input.next();
        for (Contact person : contacts) {
            if (person.getFirstName().equals(name)) {
                System.out.println("Enter the option to edit");
                System.out.println("1.Firstname\t 2.Lastname\t 3.Address\t 4.City\t 5.State\t 6.Zipcode\t 7.Phone number\t 8.Email\t 9.Exit");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Changing First name : ");
                        person.setFirstName(input.next());
                        break;
                    case 2:
                        System.out.println("Changing last name : ");
                        person.setLastName(input.next());
                        break;
                    case 3:
                        System.out.println("Changing address : ");
                        person.setAddress(input.next());
                        break;
                    case 4:
                        System.out.println("Changing city : ");
                        person.setCity(input.next());
                        break;
                    case 5:
                        System.out.println("Changing state : ");
                        person.setState(input.next());
                        break;
                    case 6:
                        System.out.println("Changing zipcode : ");
                        person.setZipcode(input.nextInt());
                        break;
                    case 7:
                        System.out.println("Changing phone number: ");
                        person.setPhoneNumber(input.nextInt());
                        break;
                    case 8:
                        System.out.println("Changing email : ");
                        person.setEmail(input.next());
                        break;
                    case 9:
                        System.out.println("Exiting from edit operation");
                        break;
                }
            }
        }
    }

    public void deleteContact() {
        System.out.println(contacts);
        System.out.println("Enter name to delete : ");
        String name = input.next();
        for (Contact person : contacts) {
            if (person.getFirstName().equals(name)) {
                contacts.remove(person);
            }
        }
    }

    public void searchState() {
        System.out.println("Enter state want to search:");
        String statename = input.nextLine();
        List<Contact> statelist = contacts.stream().filter(p -> p.getState().equalsIgnoreCase(statename)).collect(Collectors.toList());
        System.out.println(statelist);
    }

    public void searchCity() {
        System.out.println("Enter city want to search:");
        String cityname = input.nextLine();
        List<Contact> citylist = contacts.stream().filter(p -> p.getCity().equalsIgnoreCase(cityname)).collect(Collectors.toList());
        System.out.println(citylist);
    }


    @Override
    public String toString() {
        return "AddressBook{" +
                "contacts=" + contacts +
                ", input=" + input +
                '}';
    }

}