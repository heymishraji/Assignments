package dbpart1;

public class DistributedDB extends DB {

	protected int NumberOfUser;
	protected double CostPerUser;
	
	public static final double CostFactor = 1.1;
	public DistributedDB(String name, double basecost, double storage, int numberOfUser, double costPerUser) {
		super(name, basecost, storage);
		NumberOfUser = numberOfUser;
		CostPerUser = costPerUser;
	}
	public int getNumberOfUser() {
		return NumberOfUser;
	}
	public void setNumberOfUser(int numberOfUser) {
		NumberOfUser = numberOfUser;
	}
	public double getCostPerUser() {
		return CostPerUser;
	}
	public void setCostPerUser(double costPerUser) {
		CostPerUser = costPerUser;
	}
	public static double getCostfactor() {
		return CostFactor;
	}
	public double userCost() {
		return NumberOfUser*CostPerUser;
	}
	public double monthlyCost() {
		return basecost*userCost()*DistributedDB.CostFactor;
	}
	@Override
	public String toString() {
		return "Database Two (class DistributionDB) Monthly cost: $" + monthlyCost() + "\n"
				+ "Storage: "+ getStorage() + " TB" + "\nBase Cost: $" +getBasecost()+"\n"+
				"Number Of Users: " + NumberOfUser +
				"\n" + "Cost Per User: $" + CostPerUser + "\n" + "User Cost: $" + userCost()+ 
				"\n" + "Cost Factor: " + getCostfactor();
	}
	
	public static void main(String[] args) {
        DistributedDB distributedDB = new DistributedDB("Ankit", 100, 200, 300, 400);
        System.out.println(distributedDB);
    }
}
		