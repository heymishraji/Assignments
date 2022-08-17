package dbpart2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DBList {

	private DB[] db;
	private String[] invalidrecords;
	public DBList() {
		this.db = new DB[0];
		this.invalidrecords = new String[0];
	}
	public DB[] getDb() {
		return db;
	}
	
	
	public String[] getInvalidrecords() {
		return invalidrecords;
	}
	public void setInvalidrecords(String[] invalidrecords) {
		this.invalidrecords = invalidrecords;
	}
	
	public void addDB(DB obj3)
	{
		db= Arrays.copyOf(db,db.length +1);
		db[db.length-1] = obj3;
	}
	
	public void addInvalidRecord(String addinvalidrecord )
	{
		invalidrecords= Arrays.copyOf(invalidrecords,invalidrecords.length +1);
		invalidrecords[invalidrecords.length-1] = addinvalidrecord;
	}
	
	
	public String readFile(String filename) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
            DataInputStream in = new DataInputStream(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                Scanner sc = new Scanner(str);
                ArrayList<String> arrayList = new ArrayList<String>();
                sc.useDelimiter(",");
                while (sc.hasNext()) {
                    arrayList.add(sc.next());
                    
                }
                switch (arrayList.get(0)) {
                    case "C":
                        CentralizedDB centralizedDB = new CentralizedDB(arrayList.get(1),
                                Double.parseDouble(arrayList.get(2)),
                                Double.parseDouble(arrayList.get(3)), Double.parseDouble(arrayList.get(4)));
                        addDB(centralizedDB);
                       
                        break;

                    case "D":
                        DistributedDB distributedDB = new DistributedDB(arrayList.get(1),
                                Double.parseDouble(arrayList.get(2)), Double.parseDouble(arrayList.get(3)),
                                Integer.parseInt(arrayList.get(4)), Double.parseDouble(arrayList.get(5)));
                        addDB(distributedDB);
                       
                        break;

                    case "H":
                        HomogeneousDB homogenousDb = new HomogeneousDB(arrayList.get(1),
                                Double.parseDouble(arrayList.get(2)), Double.parseDouble(arrayList.get(3)),
                                Integer.parseInt(arrayList.get(4)), Double.parseDouble(arrayList.get(5)));
                        addDB(homogenousDb);
                       
                        break;

                    case "E":
                        HeterogeneousDB heterogenousDB = new HeterogeneousDB(arrayList.get(1),
                                Double.parseDouble(arrayList.get(2)), Double.parseDouble(arrayList.get(3)),
                                Integer.parseInt(arrayList.get(4)), Double.parseDouble(arrayList.get(5)));
                        addDB(heterogenousDB);
                        
                        break;
                    default:
                        System.out.println("");
                }

                sc.close();
            }

            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        return "";
    }

	 public void generateReport() {
	        DB[] db = getDb();
	        for (int i = 0; i < db.length; i++) {
	            System.out.println(db[i].toString());

	        }
	    }

	    public void generateReportByName() {

	        Arrays.sort(getDb());
	        for (int i = 0; i < db.length; i++) {
	            System.out.println(db[i].toString());

	        }

	    }

	    public void generateReportByMonthlyCost() {
	        Arrays.sort(getDb(), new MonthlyCostComparator());
	        for (int i = 0; i < db.length; i++) {
	            System.out.println(db[i].toString());

	        }
	    }

	    public static void main(String[] args) {
	        DBList dbList = new DBList();
	        dbList.readFile("test.txt");

	        System.out.println("---generateReport---\n\n");
	        dbList.generateReport();
	        System.out.println("\n\n---generateReportByName---\n\n");
	        dbList.generateReportByName();
	        System.out.println("\n\n---generateReportByCost---\n\n");
	        dbList.generateReportByMonthlyCost();

	    }
}
