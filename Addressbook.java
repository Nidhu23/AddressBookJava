import java.util.*;
public class Addressbook {
	static HashMap<String,Persondetails> personMap=new HashMap<String,Persondetails>();
	Scanner sc=new Scanner(System.in);
	String firstName;
	String fileName;
	String lastName=" ";
	String street=" ";
	String city=" ";
	String state;
	int zipCode;
	long phoneNum=0;
	int ch=0;
	public void menu() {
		Addressbook address=new Addressbook();
		do {
			System.out.println("WELCOME TO ADDRESS BOOK");
			System.out.println("---------MAIN MENU---------");
			System.out.println("OPTIONS\n1.Add a person\n2.Search\n3.Edit Details\n4.Delete Person\n5.Sort\n6.Print\n7.Save");
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch) {
					case 1:
							do {
								System.out.println("Enter first name");
								firstName=sc.next();
								System.out.println("Enter last name");
								lastName=sc.next();
								System.out.println("Enter street");
								street=sc.next();
								System.out.println("Enter city");
								city=sc.next();
								System.out.println("Enter state");
								state=sc.next();
								System.out.println("Enter zipcode");
								zipCode=sc.nextInt();
								System.out.println("Enter phone number");
								phoneNum=sc.nextLong();
								Persondetails person=new Persondetails(firstName,lastName,street,city,state,zipCode,phoneNum);
								address.add(person.getFirstName(),person);
								System.out.println("Enter 1 to add more people, 0 to stop");
								ch=sc.nextInt();
							}while(ch!=0);break;
					case 2:
							System.out.println("Enter the name of the person to search");
							firstName=sc.next();
							search(firstName); break;
			}
			System.out.println("Enter 0 to quit, 1 to go to main menu");
			ch=sc.nextInt();
		}while(ch!=0);
	}
	public void add(String nameKey,Persondetails P) {
		personMap.put(nameKey, P);
	}
	public void search(String name) {
		Persondetails p=personMap.get(name);
		System.out.println(name+"'s details are:\n"+"Last Name: "+p.getLastName()+"\nAddress: "+p.getStreet()+", "+p.getCity()+","+p.getState()+", "+"\nPhone Num: "+p.getPhoneNum());
	}
}
