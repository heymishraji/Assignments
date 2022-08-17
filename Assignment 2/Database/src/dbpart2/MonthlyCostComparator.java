package dbpart2;

public class MonthlyCostComparator implements Comparable<DB> {
	public int compare(DB db1, DB db2)
	{
		return (int) (db1.basecost- db2.basecost);
	}

	@Override
	public int compareTo(DB o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
