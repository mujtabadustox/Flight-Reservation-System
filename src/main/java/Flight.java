
public class Flight {

	int count=0;
    private String flightType;
    private String source;
    private String destination;
    private int capacity;


    public  Flight(String flightNumber,String s,String d ,int capacity){
        this.flightType = flightNumber;
        this.source=s;
        this.destination=d;
        this.capacity = capacity;
    }

    public boolean checkAvailability(){

        if(count < capacity)
            return true;
        else
            return false;
    }

    public int bookedS() {
    	return (capacity-count);
    }
    
    public void display() {
    	
    	System.out.println("Type: "+this.flightType);
    	System.out.println("Source: "+this.source);
    	System.out.println("Destination: "+this.destination);
    	System.out.println("Capacity: :"+this.capacity);    	
    }
    
    public void addSeat() {
    	count++;
    }
    

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
