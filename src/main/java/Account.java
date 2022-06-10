 
import java.util.Date;
//import java.util.*;
public class Account {
		Date dateCreated;
		int accountNumber;
		
	
		Account(Date dateC , int aN){
			this.dateCreated=dateC;
			this.accountNumber=aN;

		}

		void DisplayAccountInfo(){
			System.out.println("Your Account's Creation Date:" + this.dateCreated);
			System.out.println("Your Account's Id:" + this.accountNumber);
		}

	
}
