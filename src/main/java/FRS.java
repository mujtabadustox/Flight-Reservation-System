import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;  
import java.util.Date; 
public class FRS {
	
	int count=1;
	int tcount=1;
	
	ExceptionServices HS=new ExceptionServices();

	Account[] AccountObjects = new Account[5000];
	Passenger[] PassengerObjects = new Passenger[5000];
	Flight[] FlightObject=new Flight[15];
	Ticket[] Tickets=new Ticket[500];
	
	boolean CreateAccount(String name,int id,String address,int phoneNo,int bid,int balance) {
		
		boolean found=false;
		
		for (int i=0 ; i<count ; i++) {
			if (AccountObjects[i]!=null) {
				
				if (AccountObjects[i].accountNumber==id ) {
					
					System.out.println("Id is in Use");
					return false;
				}
				}
		}
		
		for (int i=0 ; i<count ; i++) {
			
			if (AccountObjects[i]!=null) {
				
					if (PassengerObjects[i].phoneNo==phoneNo && PassengerObjects[i].name.equals(name)) {
				found=true;
					}
			}
			
		}
		
		if(found==true) {
			System.out.println("Account Already Exists");
		}else {
			
			//System.out.println("Count:"+count);
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");  
		    Date date = new Date();  
		    AccountObjects[count]=new Account(date,id);
			PassengerObjects[count]=new Passenger(name,address,phoneNo,bid,balance);
			
			
	
		
				try
				{
					String filename= "Accounts.txt";
				    FileWriter fw = new FileWriter(filename,true);
				     //the true will append the new data
				    fw.write("Name: " + " " + PassengerObjects[count].name + " " +  "id: "+ " "+AccountObjects[count].accountNumber + " "+ "Adress: "+ " "+ PassengerObjects[count].address + " "+ "Phone: "+ " "+ PassengerObjects[count].phoneNo + " "+ "BankId: "+ " "+ PassengerObjects[count].getId() + " "+ "Acc Balance: "+ " "+ PassengerObjects[count].getBalance()  + " "+ "Date Created:" + AccountObjects[count].dateCreated + "\n");//appends the string to the file
				    fw.close();
				}
				catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
			
	
			
				
				
					count++;
			
			return true;
			
		}
		
		return false;
	}
	
	void display() {
		
		for (int i=0 ;i<count; i++) {
			
			if (AccountObjects[i]!=null) {
				PassengerObjects[i].display();
				AccountObjects[i].DisplayAccountInfo();
				System.out.println("\n");
			}
			
		}
		
	}
	
	void printStatement(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(PassengerObjects[i].name))) {
					System.out.println("Print Statement");
					PassengerObjects[i].display();
					AccountObjects[i].DisplayAccountInfo();
					System.out.println("\n");
				}
			}
			
		}
		
	}
	
	boolean login(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(PassengerObjects[i].name))) {
					return true;
				}
			}
			
		}
		
		
		return false;
	}
	
	boolean deleteUser(int AccNo,String CTName) {
		
		for (int i=0 ;i<count; i++) {
			if (AccountObjects[i]!=null) {
				if (AccountObjects[i].accountNumber==AccNo && (CTName.equals(PassengerObjects[i].name))) {
					AccountObjects[i]=null;
					return true;
				}
			}
			
		}
		
		
		return false;
	}
	
void createNewFlights(String t , String s , String d , int sz ) {
	
	int size=8;
	FlightObject[size]=new Flight(t,s,d,sz);
	
	
	if (FlightObject[size]!=null) {
try
{
	String filename= "Flights.txt";
    FileWriter fw = new FileWriter(filename,true);
     //the true will append the new data
    fw.write("Type: " + " " + FlightObject[size].getFlightType() + " " +  "Source: "+ " "+FlightObject[size].getSource() + " "+ "Destination: "+ " "+ FlightObject[size].getDestination() + " "+ "Capacity: "+ " "+ FlightObject[size].getCapacity() + "\n");//appends the string to the file
    fw.close();
}
catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	}
	
	size++;

	
}
	
void createFlights() {
	
	boolean p=false;
	
	FlightObject[0]=new Flight("economy","islamabad","karachi",50);
	FlightObject[6]=new Flight("business","islamabad","karachi",50);
	FlightObject[7]=new Flight("economy","islamabad","karachi",150);
	FlightObject[1]=new Flight("economy","islamabad","peshawar",50);
	FlightObject[2]=new Flight("economy","islamabad","lahore",50);
	FlightObject[3]=new Flight("economy","islamabad","multan",50);
	FlightObject[4]=new Flight("economy","islamabad","gilgit",50);
	FlightObject[5]=new Flight("economy","islamabad","hyderabad",50);
	

	if (p==false) {
		
		try {
		      File hsObj = new File("Flights.txt");
		      if (hsObj.createNewFile()) {
		        System.out.println("File created: " + hsObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	
for (int i=0 ; i<15 ; i++) {
	
	
	
		
		if (FlightObject[i]!=null) {
	try
	{
		String filename= "Flights.txt";
	    FileWriter fw = new FileWriter(filename,true);
	     //the true will append the new data
	    fw.write("Type: " + " " + FlightObject[i].getFlightType() + " " +  "Source: "+ " "+FlightObject[i].getSource() + " "+ "Destination: "+ " "+ FlightObject[i].getDestination() + " "+ "Capacity: "+ " "+ FlightObject[i].getCapacity() + "\n");//appends the string to the file
	    fw.close();
	}
	catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
		}
}
	
p=true;
	}
	
	
}
	
void availableFlights () {
	
	for (int i=0 ; i<15 ; i++) {
		
		if (FlightObject[i]!=null) {
			FlightObject[i].display();
			System.out.println("\n");
			}
	}
}

public int searchFlights(String type,String source,String destination) {
for (int i=0 ; i<15 ; i++) {
		if (FlightObject[i]!=null) {
				
			if (FlightObject[i].getFlightType().equals(type) && FlightObject[i].getSource().equals(source) && FlightObject[i].getDestination().equals(destination)) {
				return i;
			}
			
			}
	}

return -1;
}


public boolean canTicket(String t , String s ,String d) {
	
	
	int index=searchFlights(t, s, d);
	//System.out.println("INDEX:" +index);

	if (index>=0) {
	return true;
	}
	
return false;

	
}

public boolean createTicket(int Cid, String Cname,int tid, String s, String d,String t, int p ) {
	
	

		int index=searchFlights(t, s, d);

		if (index>=0) {
		Tickets[tcount] = new Ticket(Cid, Cname, tcount, s, d, t, p);
		FlightObject[index].addSeat();
		Tickets[tcount].setSeat(FlightObject[index].getCount());
		
		try {
		      File hsObj = new File("Passengers.txt");
		      if (hsObj.createNewFile()) {
		        System.out.println("File created: " + hsObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		try
		{
			String filename= "Passengers.txt";
		    FileWriter fw = new FileWriter(filename,true);
		     //the true will append the new data
		    fw.write("Person Name: " + Tickets[tcount].getCustomerName() + " " + "Account Id: " + Tickets[tcount].getCustomerId() + " " + "Reference Id: "  + Tickets[tcount].getId() + " " +  "Source: "+ Tickets[tcount].getOrigin() + " " + "Destination: "+  Tickets[tcount].getDestination() + " "+ "Price: "+  Tickets[tcount].getPrice() + " " + "Type: "  + Tickets[tcount].getType() + " " + "Seat No: " + Tickets[tcount].getSeat() + "\n");//appends the string to the file
		    fw.close();
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		
		tcount++;
		return true;
		}
		
	return false;
	



}

public boolean pay(int id,int p) {
	int index=0;
	
	for (int i=0 ; i<count ; i++) {
		if (AccountObjects[i]!=null) {
			
			if (AccountObjects[i].accountNumber==id ) {
				
				index=i;
				
			}
			}
	}
	
	System.out.println("Balance in your Account:"+ PassengerObjects[index].getBalance());
	System.out.println("Ticket Price:"+p);
	
	
	try {
		HS.validateBalance(PassengerObjects[index].getBalance());
		
	}catch(NegativeBalanceException e){
		
		System.out.println("You Wont Be able to Pay(Negative Balance)");
		
	}
	
	if (PassengerObjects[index].getBalance()>=p) {
				System.out.println("You Have Enough Balance");
				int bal=PassengerObjects[index].getBalance()-p;
				PassengerObjects[index].setBalance(bal);
				System.out.println("Remaining Balance"+ PassengerObjects[index].getBalance());
				return true;

			}else {
					System.out.println("You Dont Have Enough Balance");
					return false;
	}
	
}

public boolean printTicket(int id,String name) {
	

	for (int i=0 ; i<tcount ; i++) {
		if (Tickets[i]!=null) {
			
			if (Tickets[i].getCustomerName().equals(name) && Tickets[i].getCustomerId()==id  ) {
				
				Tickets[i].display();
				System.out.println("\n");
				return true;
				
			}
			}
	}
	
	return false;

}

public boolean cancelTicket(int id,String name) {
	
	for (int i=0 ; i<tcount ; i++) {
		if (Tickets[i]!=null) {
			
			if (Tickets[i].getCustomerName().equals(name) && Tickets[i].getCustomerId()==id  ) {
				
				Tickets[i]=null;
				return true;
				
			}
			}
	}
	
	return false;
	
}

public void search(String s,String d) {

		
		for (int i=0 ; i<15 ; i++) {
			if (FlightObject[i]!=null) {
				
				if (FlightObject[i].getSource().equals(s) && FlightObject[i].getDestination().equals(d)) {
					
					FlightObject[i].display();
					System.out.println("\n");
				
					
				}
				}
		}
		
		
	
	
	
}


}
