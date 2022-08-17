package dbpart1;

public class CentralizedDB extends DB{
	private double license;
	
	public CentralizedDB(String name, double basecost, double storage, double license) {
		super(name, basecost, storage);
		this.license = license;
	}
	
	public double getLicense() {
		return license;
	}
	public void setLicense(double license) {
		this.license = license;
	}
	
	public double monthlyCost()
	{
		return this.basecost + this.license;
	}

	@Override
	public String toString() {
		return "Datbase one (class CentralizedDB) Monthly Cost: $" +monthlyCost() + "\n" 
				+ "Storage : "
				+ storage + " TB \n" + 
				"Base Cost: $" + basecost 
				+ "\n" + "License: $" + license;
	}
	
	public static void main(String[] args) {
        CentralizedDB centralizedDB = new CentralizedDB("Ankit", 1000, 500, 1400);
        System.out.println(centralizedDB);
    }
	
	
	
	

	
	
}
