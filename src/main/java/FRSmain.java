 
import java.util.Scanner; 


public class FRSmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean menu=true;
		int option;
		Scanner S=new Scanner(System.in);
		FRS AMS=new FRS();
		AMS.createFlights();
		ExceptionServices HS=new ExceptionServices();

		while(menu) {
			
			System.out.println("Enter An Option");
			System.out.println("Enter 1 to Create a New Account");
			System.out.println("Enter 2 to Log In into an Existing Account");
			System.out.println("Enter 3 to Delete an Existing Account");
			System.out.println("Enter 4 to Login as Admin");
			System.out.println("Enter 5 to view the Info of all the Existing Accounts(If u dont know Acc Number)");
			System.out.println("Enter 6 to Exit");
			option=S.nextInt(); 
			S.nextLine();
			switch(option) {
			case 1:
				System.out.println("Account Creation");
				
				System.out.println("Enter Your Name");
				String Cname="";
				Cname+=S.nextLine();
				System.out.println("Enter Your Id");
				int id;
				id=Integer.parseInt(S.nextLine());
				
				try {
					HS.validateBalance(id);
					
				}catch(NegativeBalanceException e){
					
					System.out.println("Negative id");
					
				}
				
				
				System.out.println("Enter Your PhoneNo");
				int ph;
				ph=Integer.parseInt(S.nextLine());
				
				try {
					HS.validateBalance(ph);
					
				}catch(NegativeBalanceException e){
					
					System.out.println("Negative Phone Number");
					
				}
				
				System.out.println("Enter Your Address");
				String ad="";
				ad+=S.nextLine();
				System.out.println("Enter Your Bank Account");
				int bid;
				bid=Integer.parseInt(S.nextLine());
				
				try {
					HS.validateBalance(bid);
					
				}catch(NegativeBalanceException e){
					
					System.out.println("Negative Bank Id");
					
				}
				
				System.out.println("Enter Balance");
				int bl;
				bl=Integer.parseInt(S.nextLine());
				
				try {
					HS.validateBalance(bl);
					
				}catch(NegativeBalanceException e){
					
					System.out.println("Balance is in Negative");
					
				}
				
				
			
				
				
				boolean check=AMS.CreateAccount(Cname,id,ad,ph,bid,bl);
				
				if(check==true) {
					System.out.println("Account Created Successfully!");
				}else {
					System.out.println("Account Creation Failed!");
				}
				
				break;
			
			case 2:
				System.out.println("Login Screen");
				System.out.println("Enter Your Account Number");
				int AccNo=Integer.parseInt(S.nextLine());
				
				try {
					HS.validateBalance(AccNo);
					
				}catch(NegativeBalanceException e){
					
					System.out.println("Negative AccNo");
					
				}
				
				System.out.println("Enter Your Name");
				String CustName="";
				CustName+=S.nextLine();
				
				boolean y=AMS.login(AccNo,CustName);
				
				boolean x=y;
				
				if (y==true) {
					System.out.println("You Are Logged In");
					int choice;
						while(x) {
							System.out.println("Welcome! "+CustName);
							System.out.println("Enter An Option");
							System.out.println("Enter 1 to Make Reservation");
							System.out.println("Enter 2 to Cancel Reservation");
							System.out.println("Enter 3 to View Available Flights");
							System.out.println("Enter 4 to Print E-ticket");
							System.out.println("Enter 5 for Account Details");
							System.out.println("Enter 6 to Search for Flights");
							System.out.println("Enter 7 to Log Out");
							choice=S.nextInt(); 
							S.nextLine();
							switch(choice) {
							case 1:
								int price=0;
								int tid=1;
								
								System.out.println("Ticket Reservation");
								System.out.println("Are You Buying Ticket For Yourself (y/n)");
								String ch="";
								String Tname="";
								ch+=S.nextLine();
								
								if(ch.equals("y")) {
									Tname=CustName;
								}else {
								System.out.println("Your Name");
								Tname+=S.nextLine();
								}
								System.out.println("Your Ticket Type(economy/business)");
								String type="";
								type+=S.nextLine();
								
								
								try {
									HS.validateType(type);
									
								}catch(UnknownTypeException e){
									
									System.out.println("Flight Type isn't correct (economy/business)");
									
								}
								
								
								System.out.println("Where Are You From");
								String source="";
								source+=S.nextLine();
								System.out.println("Where Do You Wanna Go");
								String destination="";
								destination+=S.nextLine();
								
								if(type.equals("economy")) {
									price = 25000;
								}else if(type.equals("business")) {
									price = 40000;
								}
								
								
								
							 boolean proceed=AMS.canTicket(type,source,destination);
									 
								
									 if (proceed==true) {
										 System.out.println("Your Reservation has been Made");
										 System.out.println("Please Pay to Confirm");
										 System.out.println("Ticket Price: " +price);
										 System.out.println("Do you wanna Pay [y/n]");
										 
										 
										 String pc="";
										pc+=S.nextLine();
											
											if(pc.equals("y")) {
												boolean sh=AMS.pay(AccNo,price);
												
												if(sh==true) {
												boolean checkout=AMS.createTicket(AccNo, Tname, tid, source, destination,type, price);
												tid++;
												System.out.println("Your booking has been placed");
												System.out.println("Thank You!! for your time");
												}else {
													System.out.println("Your booking has been cancelled!");
													System.out.println("Thank You!! for your time");
											}
									 }else {
											System.out.println("Your booking has been cancelled!");
											System.out.println("Thank You!! for your time");
										}
										 
									 }else {
										 System.out.println("Couldnt process your Request");
										 System.out.println("Try Again");
									 }
									 
									
								
								break;
							case 2:
								System.out.println("Delete Reservation");
								System.out.println("Enter The Name with You Made the Reservation");
								String CuN="";
								CuN+=S.nextLine();
								boolean yy=AMS.cancelTicket(AccNo,CuN);
								
								if(yy==true) {
									
										System.out.println("Dear"+CuN);
										System.out.println("The Booking On Your Name has been cancelled");
									}
									else {
										System.out.println("Dear: "+ CuN);
										System.out.println("There is No Booking Made on Your Name");
									}
								
								
								break;
							case 4:
								System.out.println("E-ticket");
								System.out.println("Enter The Name with You Made the Reservation");
								String CN="";
								CN+=S.nextLine();
								boolean ss=AMS.printTicket(AccNo,CN);
								if(ss==false) {
										System.out.println("Dear: "+ CN);
										System.out.println("There is No Booking Made on Your Name");
								}
								break;
							case 3:
								AMS.availableFlights();
								break;
							case 5:
								AMS.printStatement(AccNo,CustName);
								break;
							case 6:
								System.out.println("Enter Source");
								String s="";
								s+=S.nextLine();
								System.out.println("Enter Destination");
								String d="";
								d+=S.nextLine();
								AMS.search(s,d);
								break;
							case 7:
								x=false;
								System.out.println("Going Back to Menu");
								break;
							}
							
							
						}
				}else {
					System.out.println("Account Doesnt Exist or Incorrect Information");
				}
				
				
				break;
			case 3:
				System.out.println("Deletion Screen");
				System.out.println("Enter Account Number to be Deleted");
				int AccNo1=Integer.parseInt(S.nextLine());
				System.out.println("Enter the User's Name");
				String CustName1="";
				CustName1+=S.nextLine();
				
				boolean z=AMS.deleteUser(AccNo1,CustName1);
				
				if (z==true) {
					System.out.println("Account Deleted Successfully!");
				}else {
					System.out.println("Operation Failed!");
				}
				break;
			case 4:
				System.out.println("Admin Portal");
				System.out.println("Enter Password(1234");
				int pass;
				pass=Integer.parseInt(S.nextLine());
				
				if (pass==1234) {
					System.out.println("Welcome!");
					System.out.println("1.Create Flights");
					int opt;
					opt=S.nextInt(); 
					S.nextLine();
					switch(opt) {
					
					case 1:
						System.out.println("Type(economy/business)");
						String type="";
						type+=S.nextLine();
						System.out.println("Source");
						String source="";
						source+=S.nextLine();
						System.out.println("Destination");
						String destination="";
						destination+=S.nextLine();
						int size;
						size=S.nextInt(); 
						S.nextLine();
						
						AMS.createNewFlights(type, source, destination, size);
						break;
						
					}
					
				}else {
					System.out.println("Incorrect Password");
				}
				
				break;
			case 5:
				AMS.display();
				break;
			case 6:
				System.out.println("Terminated");
				S.close();
				menu=false;
				break;
			default:
				System.out.println("Input Valid Choice");
			}
			
		}
	}

}
