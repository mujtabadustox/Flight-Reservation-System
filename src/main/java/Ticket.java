
public class Ticket {
private int CustomerId;		
private String CustomerName;	
private int id;	
private String origin;
private String destination;
private String type;
private int price;
private int seatNo;

Ticket(int Cid, String Cname,int id, String s, String d,String t, int p ){
	this.CustomerId=Cid;
	this.CustomerName=Cname;
	this.id=id;
	this.origin=s;
	this.destination=d;
	this.type=t;
	this.price=p;
}

void display(){
	System.out.println("Customer: " +this.CustomerName);
	System.out.println("Reference:"+this.id);
	System.out.println("Origin:"+this.origin);
	System.out.println("Destination:"+this.destination);
	System.out.println("Seat:"+this.seatNo);
	System.out.println("Type:"+this.type);
	System.out.println("Price:"+this.price);
}

public int getCustomerId() {
	return CustomerId;
}

public void setCustomerId(int customerId) {
	CustomerId = customerId;
}

public String getCustomerName() {
	return CustomerName;
}

public void setCustomerName(String customerName) {
	CustomerName = customerName;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getOrigin() {
	return origin;
}

public void setOrigin(String origin) {
	this.origin = origin;
}

public String getDestination() {
	return destination;
}

public void setDestination(String destination) {
	this.destination = destination;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public void setSeat(int g) {
	this.seatNo=g;
}

public int getSeat() {
	return this.seatNo;
}

}
