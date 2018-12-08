import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class Appointment {
	static Scanner scan = new Scanner(System.in);
	
	public int Date;
	public String Persons, Location;
	
	static ArrayList<Appointment> AppointmentMap = new ArrayList<Appointment>();
	
	static void createAppointment(int Date, String Persons, String Location) {
		System.out.print("��ӳ�¥: ");
		int date = scan.nextLine();
		System.out.print("������ ���: ");
		String persons = scan.nextLine();
		System.out.print("������: ");
		String location = scan.nextLine();
		
		Appointment appointmentTemp = new Appointment(date,persons,location);
		AppointmentMap.add(appointmentTemp);
	}
	
	static void saveAppointment() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Appointment.txt"));
		oos.writeObject(AppointmentMap);
		System.out.println("Appointment.txt �� ����Ǿ����ϴ�.");
		oos.close();
	}
	
	static void openContactFile() throws ClassNotFoundException {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Appointment.txt"));
			AppointmentMap = (HashMap<Integer,Appointment>)ois.readObject();
			ois.close();
		}
		catch(FileNotFoundException fnf){
			System.out.println("������ ã�� ���Ͽ����ϴ�.");
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	static void viewAppointment() {
		if(AppointmentMap.isEmpty()) {
			System.out.println("����� ����� �����ϴ�.");
			return;
		}
		else {
			for(int index = 0; index < AppointmentMap.size();index++) {
				int number = index + 1;
				System.out.println(number+". ��ӳ�¥ : "+AppointmentMap.get(index).Date+"\n");
			}
		}
	}
	
	static void printViewAppointmentDetails() {
		System.out.println("��ӳ�¥ : "+AppointmentMap.get(index).Date+"\t������ ��� : "+AppointmentMap.get(index).Persons+"\t������ : "+AppointmentMap.get(index).Location+"\n");
	}
	
	static void viewAppointmentDetails(int Number) {
		if(AppointmentMap.isEmpty()) {
			System.out.println("����� ����� �����ϴ�.");
		}
		else {
			int index = Number - 1;
			printViewAppointmentDetails();
		}
	}
		
	static void deleteAppointment(int number) {
		if (number <= AppointmentMap.size()) {
			int index = number-1;
			AppointmentMap.remove(index);
		}
		else {
			System.out.println("����� �׸��� �����ϴ�.");
			return;
		}
	}
	static void updateAppointment(int number) {								//index�� number�� �ٲ�
		index = number-1;
		
		if (index <= ContactMap.size()) {									//��ȣ ����
			String tempDate = AppointmentMap.get(index).Date;
			String tempPersons = AppointmentMap.get(index).Persons;
			String tempLocation = AppointmentMap.get(index).Location;
			
			//System.out.print("������ �ʿ����� ���� �׸��� ��ĭ���� �μ���.");
			
			System.out.print("��ӳ�¥: ");
			String updateDate = scan.nextLine();							//temp1 -> updateDate�� ����
			System.out.print("������ ���: ");
			String updatePersons = scan.nextLine();							//����
			System.out.print("������: ");
			String updateLocation = scan.nextLine();						//����
			
			if (!temp1.equals("")) {tempDate = updateDate;}
			if(!temp2.equals("")) {tempPersons = updatePersons;}
			if(!temp3.equals("")) {tempLocation = updateLocation;}
			
			AppointmentMap.remove(index);
			Appointment.createAppointment(tempDate, tempPersons, tempLocation);
		}
		else {
			System.out.println("����� �׸��� �����ϴ�.");
		}
	}
	
	static void clearAppointmentMap() {
		AppointmentMap.clear();
	}
	
	public Appointment(int Date, String Persons, String Location) {
		this.Date = Date; this.Persons = Persons; this.Location = Location;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
