import java.util.Scanner;
public class Contact {
	Scanner scan = new Scanner(System.in);
	public String Name, PhoneNumber, Email;
	
	void CreateContact() {
		System.out.print("�̸�: ");
		String temp1 = scan.nextLine();
		System.out.print("��ȭ��ȣ: ");
		String temp2 = scan.nextLine();
		System.out.print("�̸���: ");
		String temp3 = scan.nextLine();
		
		Contact c = new Contact(temp1,temp2,temp3);
		
	}
	
	void View() {
		
	}
	 
	public Contact(String Name, String PhoneNumber, String Email) {
		this.Name = Name; this.PhoneNumber = PhoneNumber;
		this.Email = Email;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
