/**
 * 
 */

/**
 * @author Mjolnir
 *
 */
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main extends Contact {
	public Main(String Name, String PhoneNumber, String Email) {
		super(Name, PhoneNumber, Email);
		// TODO Auto-generated constructor stub
	}
	public static String mainMenu() {
		return "1. Contact 2. TodoList 3. Appointment 4. Quit ";
	}
	public static String subMenu() {
		return "1. Create 2. View 3. Save \t 0. Go to Main";
	}
	public static String ViewSubMenu() {
		return "1. Update 2. Delete 0. Go Back";
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Scanner scan = new Scanner(System.in);
		//Contact �ؽ��� �̸��� HashMap<String, Contact> ContactMap
		//HashMap<String,TodoList> TodoListMap = new HashMap<String,TodoList>();
		//HashMap<String,Appointment> AppointmentMap = new HashMap<String,Appointment>();
		
		while(true) {
			System.out.println(mainMenu());
			String MainMenu;
			MainMenu = scan.nextLine();
			if (MainMenu.equals("1")) {
				try {
					Contact.openContactFile();
					System.out.println("����ó�� �ҷ��Խ��ϴ�.");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				while(true) {
					System.out.println(subMenu());
					String SubMenu;
					SubMenu = scan.nextLine();
					if(SubMenu.equals("1")) {
						System.out.print("�̸�: ");
						String Name = scan.nextLine();
						System.out.print("��ȭ��ȣ: ");
						String PhoneNumber = scan.nextLine();
						System.out.print("�̸���: ");
						String Email = scan.nextLine();
						Contact.createContact(Name, PhoneNumber, Email);
						System.out.println("����Ǿ����ϴ�.\n");
						continue;
					}
					if(SubMenu.equals("2")) {
						System.out.println("========");
						Contact.viewContact();
						System.out.println("========");
						
						System.out.println(ViewSubMenu());
						String ViewSubMenu;
						ViewSubMenu = scan.nextLine();
						if (ViewSubMenu.equals("1")) {
							System.out.println("�����Ͻ� �̸��� �ۼ����ּ���.");
							String key = scan.nextLine();
							Contact.updateContact(key);
						}
						if (ViewSubMenu.equals("2")) {
							String key = scan.nextLine();
							Contact.deleteContact(key);
							System.out.println("�����Ǿ����ϴ�.");
						}
						
						
					}
					if(SubMenu.equals("3")) {
						try {
							Contact.saveContact();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					else {break;}
					
				}
				
			}
			if (MainMenu.equals("2")) {
				
			}
			if (MainMenu.equals("3")) {
				
			}
			else	{
				System.out.println("�����Ͻðڽ��ϱ�?");
				break;
			}
		}scan.close();
		
		
	}
}