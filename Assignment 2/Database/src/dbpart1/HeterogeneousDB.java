package dbpart1;

public class HeterogeneousDB extends DistributedDB {
	
	public static final double CostFactor= 1.3;

	public HeterogeneousDB(String name, double basecost, double storage, int numberOfUser, double costPerUser) {
		super(name, basecost, storage, numberOfUser, costPerUser);
		
	}
	
	public double getCostFactor()
	{
		return CostFactor;
	}
	
	public double monthlyCost()
	{
		return basecost + userCost()*HeterogeneousDB.CostFactor;
	}
	
	public static void main(String[] args) {
        HeterogeneousDB hetrogeneousDb = new HeterogeneousDB("Ankit", 1023, 200, 1300, 400);
        System.out.println(hetrogeneousDb);
}
}
