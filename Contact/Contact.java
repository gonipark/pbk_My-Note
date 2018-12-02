import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class Contact {
	static Scanner scan = new Scanner(System.in);
	public String Name, PhoneNumber, Email;
		static HashMap<String,Contact> ContactMap = new HashMap<String,Contact>();
	
	static void createContact() {
		System.out.print("�̸�: ");
		String temp1 = scan.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String temp2 = scan.nextLine();
		System.out.print("�̸���: ");
		String temp3 = scan.nextLine();
		
		Contact c = new Contact(temp1,temp2,temp3);
		ContactMap.put(temp1,c);
	}
	static void saveContact() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Contact.txt"));
		oos.writeObject(ContactMap);
		System.out.println("Contact.txt �� ����Ǿ����ϴ�.");
		oos.close();
	}
	static void openContactFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Contact.txt"));
			ContactMap = (HashMap<String,Contact>)ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException fnf){
			System.out.println("������ ã�� ���Ͽ����ϴ�.");
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
	static void viewContact() {
		if(ContactMap.isEmpty()) {
			System.out.println("����� ����ó�� �����ϴ�.");
		}
		Set<String> keys = ContactMap.keySet();
		Iterator<String> it = keys.iterator();
		while(it.hasNext()) {
			String name = it.next();
			Contact details = ContactMap.get(name);
			System.out.println(details);
		}
	}
	 
	public Contact(String Name, String PhoneNumber, String Email) {
		this.Name = Name; this.PhoneNumber = PhoneNumber;
		this.Email = Email;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
