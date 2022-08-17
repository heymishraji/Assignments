package dbpart1;

public abstract class DB {
protected String name;
protected double basecost;
protected double storage;

protected static int count;

public DB(String name, double basecost, double storage) {
	this.name = name;
	this.basecost = basecost;
	this.storage = storage;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getBasecost() {
	return basecost;
}

public void setBasecost(double basecost) {
	this.basecost = basecost;
}

public double getStorage() {
	return storage;
}

public void setStorage(double storage) {
	this.storage = storage;
}

public static int getCount() {
	return count;
}

public static void setCount(int count) {
	DB.count = count;
}
public static void resetCount() {
	count=0;
}

@Override
public String toString() {
	return "DB [name=" + name + ", basecost=" + basecost + ", storage=" + storage + "]";
}






}
