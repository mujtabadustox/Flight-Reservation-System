
public class ExceptionServices {
	
	public void validateType(String type) throws UnknownTypeException {
		if ( !((type.equals("economy")) || (type.equals("Economy")) || (type.equals("business")) || (type.equals("Business"))) ){
			throw new UnknownTypeException("TypeNotDefined");
		}
	}
	
	public void validateBalance(int bal) throws NegativeBalanceException {
		if(bal<0) {
			throw new NegativeBalanceException("NegativeBalance");
		}
	}

}
