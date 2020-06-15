import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
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
				case 1: do {
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
				case 2: System.out.println("Enter the name of the person to search");
					firstName=sc.next();
					search(firstName); break;
				case 3: System.out.println("Enter first name of the person");
					firstName=sc.next();
					edit(firstName);
					break;
				case 4: System.out.println("Enter first name of the person to be deleted");
					firstName=sc.next();
					del(firstName); break;
				case 5: sort();
					break;
				case 6: print();
					break;
				case 7: System.out.println("Enter File Name");
					fileName=sc.next();
					save(fileName);
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
		System.out.println(name+"'s details are:\n"+"Last Name: "+p.getLastName()+"\nAddress: "+p.getStreet()+", "+p.getCity()+", "+p.getState()+", "+p.getZipCode()+"\nPhone Num: "+p.getPhoneNum());
	}
	public void edit(String name) {
		System.out.println("OPTIONS\n1.Edit last name\n2.Edit street\n3.Edit city\n4.Edit state\n5.Edit Zip code\n6.Edit phone number");
		do {
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			Persondetails p=personMap.get(name);
			switch(ch) {
				case 1: System.out.println("Enter new last name");
					String newName=sc.next();
					p.setLastName(newName);
					break;
				case 2: System.out.println("Enter new street name");
					String newStreet=sc.next();
					p.setStreet(newStreet);
					break;
				case 3: System.out.println("Enter new city name");
					String newCity=sc.next();
					p.setCity(newCity);
					break;
				case 4: System.out.println("Enter new state name");
					String newState=sc.next();
					p.setState(newState);
					break;
				case 5: System.out.println("Enter new zip code");
					int newZip=sc.nextInt();
					p.setZipCode(newZip);
					break;
				case 6: System.out.println("Enter new phone number");
					long newPhone=sc.nextLong();
					p.setPhoneNum(newPhone);
					break;
			}
			System.out.println("Enter 1 to continue editing,0 to quit");
			ch=sc.nextInt();
		}while(ch!=0);
		search(name);
	}

	public void del(String name) {
		personMap.remove(name);
		System.out.println(name+"'s details has been deleted from adrress book");
	}
	public void print() {
		for(Map.Entry<String, Persondetails> entry:personMap.entrySet()){
	        	String key=entry.getKey();
			Persondetails p=entry.getValue();
	        	System.out.println(key+"'s Details:");
	        	System.out.println("\nLast Name: "+p.getLastName()+"\nAddress: "+p.getStreet()+","+p.getCity()+","+p.getState()+","+p.getZipCode()+"\nPhone Num: "+p.getPhoneNum()+"\n");
	        	System.out.println("------------------------------------------------------------------");
	    }
	}
	public void sort() {
		System.out.println("\nSORT OPTIONS\n1.By zip code\n2.by last name");
		ch=sc.nextInt();
		ArrayList<Integer> zip=new ArrayList<Integer>();
		ArrayList<String> name=new ArrayList<String>();
		switch(ch) {
			case 1:	for(Map.Entry<String, Persondetails> entry:personMap.entrySet()){
					Persondetails p=entry.getValue();
					zip.add(p.getZipCode());
				}
				Collections.sort(zip);
				System.out.println("The sorted zip codes are:"+zip);
				break;
			case 2: for(Map.Entry<String, Persondetails> entry:personMap.entrySet()){
					Persondetails p=entry.getValue();
					name.add(p.getLastName());
				}
				Collections.sort(name);
				System.out.println("The sorted last names are:"+name);
				break;
			}
		}
	public void save(String fileName) {
		System.out.println("Save As:\n1.txt file\n2.pdf file\n3.doc file");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		try{
			switch(ch) {
				case 1: FileWriter myWriter = new FileWriter(fileName+".txt");
					for(Map.Entry<String, Persondetails> entry:personMap.entrySet()){
						String key=entry.getKey();
						Persondetails p=entry.getValue();
						myWriter.write("\nFull Name: "+key+" "+p.getLastName()+"\nAddress: "+p.getStreet()+" "+p.getCity()+" "+p.getState()+" "+p.getZipCode()+"\n Ph: "+p.getPhoneNum()+"\n");
						myWriter.write("-------------------------------------------------------------------------------");
					}
					myWriter.close();
					System.out.println("Succesfully saved details to "+fileName+".txt");
					break;
				case 2: Document  doc = new Document();
			  		PdfWriter.getInstance(doc, new FileOutputStream(fileName+".pdf"));
			  		doc.open();
			  		for(Map.Entry<String, Persondetails> entry:personMap.entrySet()){
						String key=entry.getKey();
						Persondetails p=entry.getValue();
						doc.add(new Paragraph("\nFull Name: "+key+" "+p.getLastName()+"\nAddress: "+p.getStreet()+" "+p.getCity()+" "+p.getState()+" "+p.getZipCode()+"\n Ph: "+p.getPhoneNum()+"\n-------------------------------------------------------------------------------\n"));
					}
			  		doc.newPage();
			  		doc.close();
					System.out.println("Succesfully saved details to "+fileName+".pdf");
			  		break;
				case 3: myWriter = new FileWriter(fileName+".doc");
					for(Map.Entry<String, Persondetails> entry:personMap.entrySet()){
						String key=entry.getKey();
						Persondetails p=entry.getValue();
						myWriter.write("\nFull Name: "+key+" "+p.getLastName()+"\nAddress: "+p.getStreet()+" "+p.getCity()+" "+p.getState()+" "+p.getZipCode()+"\n Ph: "+p.getPhoneNum()+"\n");
						myWriter.write("-------------------------------------------------------------------------------");

					}
					myWriter.close();
					System.out.println("Succesfully saved details to "+fileName+".doc");
				}
			}
		catch (IOException e) {
				e.printStackTrace();
		}
		catch (DocumentException e) {
				e.printStackTrace();
		}

	}
}
