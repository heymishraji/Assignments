package dbpart2;

public class HomogeneousDB extends DistributedDB {

	public static final double CostFactor= 1.2;
	
	public HomogeneousDB(String name, double basecost, double storage, int numberOfUser, double costPerUser) {
		super(name, basecost, storage, numberOfUser, costPerUser);
		// TODO Auto-generated constructor stub
	}
	
	public double getCostFactor()
	{
		return CostFactor;
	}
	
	public double monthlyCost()
	{
		return basecost + userCost()*HomogeneousDB.CostFactor;
	}
	
	public static void main(String[] args) {
        HomogeneousDB homogenousDb = new HomogeneousDB("Ankit", 1023, 200, 1300, 400);
        System.out.println(homogenousDb);
    }
}
