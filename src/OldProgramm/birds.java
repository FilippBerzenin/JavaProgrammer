package finalWorks;

import java.util.Arrays;

public class birds {

	static int ARRAY_VERTIKAL = 10;
	static final int ARRAY_HORIZONTAL = 6;
	static String[][] birdsArray = new String[ARRAY_VERTIKAL][ARRAY_HORIZONTAL];

	static int lENGTH_SELL = 15;
	static String[][] arraySellRegister = new String[ARRAY_VERTIKAL][lENGTH_SELL];

	static int LENGTH_BAY = 15;
	static String[][] arrayBayRegister = new String[ARRAY_VERTIKAL][LENGTH_BAY];

	final static String INDEX = "¹";
	final static String TYPE = "Type birds: ";
	final static String ON_STOCK = "On stock: ";
	final static String BAY = "Bay (in stock): ";
	final static String SELL = "Sell (out stock): ";
	final static String PRICE = "Price, $ ";
	
	final static int INDEX_COLUMN = 0;
	final static int TYPE_COLUMN = 1;
	final static int ON_STOCK_COLUMN = 2;
	final static int BAY_COLUMN = 3;
	final static int SELL_COLUMN = 4;
	final static int PRICE_COLUMN = 5;
	
	
	

	public static void main(String[] args) {
		start();
		changeStock();
		printArray(birdsArray);
		statistic();
	}
	
	static void start () {
		errorbirdsArray();
		birdsArrayFill();
		ArrayTypeAndPrice(birdsAndPrice);
		newTypeBirdsAndPrice();
	}
	
	static void statistic () {
		 statisticsForAll();
		 statisticTotalBirds();
		 statisticLessThenTRee();
		 cashFlowForAll();
		 averagePrice();
		 averageCheck();
		 cashFlowForPercent();
		 statisticTotalBirdsFoPercent();
		 
	}
	
	static String[][] birdsAndPrice = new String[][] {
		{ "Eagle", "15" },
		{ "Duck", "5" },
		{ "Fenix", "100" },
		};
	
	static void newTypeBirdsAndPrice () {
		newBirds("Chiken", 3);
		newBirds("Pheasant", 20);
	}
	
	static void changeStock() {
		ArraySellBayFill();
		enterBay("Duck", 10);
		enterSell("Duck", 5);
		enterBay("Duck", 5);
		enterBay("Duck", 5);
		enterSell("Duck", 5);
		enterBay("Eagle", 15);
		enterSell("Eagle", 4);
		enterBay("Fenix", 10);
		enterSell("Fenix", 5);
		enterBay("Chiken", 10);
		enterBay("Pheasant", 10);
	}
		
	static void ArrayTypeAndPrice(String[][] array) {
		errorAdditionArrayStart(array);
		int index = findNull(birdsArray);
		for (int i = index, k = 0; k < array.length; i++, k++) {
			String[] a = array[k];
			errorMinusValue(a[1]);
			birdsArray[i][TYPE_COLUMN] = a[0];
			birdsArray[i][PRICE_COLUMN] = a[1];
			birdsArray[i][ON_STOCK_COLUMN] = "0";
			birdsArray[i][BAY_COLUMN] = "0";
			birdsArray[i][SELL_COLUMN] = "0";
			birdsArrayIndex(i);
		}
		errorAdditionArray(array);
	}
	
	static void errorMinusValue(String value) {
			int a = new Integer(value);
			if (a<=0) {
				System.out.println("Error of value parameter - "+value);
				System.exit(0);
			}
		}
	
	
	static void errorAdditionArrayStart(String[][] array) {
		int sum = 0;
		for (int i = 0; i < birdsArray.length; i++) {
			if (birdsArray[i][TYPE_COLUMN] == null)
				sum += 1;
		}
		if (sum < array.length) {
			System.out.println("Error of langth main array. Please, change parameter ARRAY_VERTIKAL.");
			System.exit(0);
		}
	}

	static void newBirds(String type, int price) {
		String[][] newBirds = new String[][] { { type, Integer.toString(price) } };
		errorAdditionArrayStart(newBirds);
		errorMinusValue(Integer.toString(price));
		int index = findNull(birdsArray);
		birdsArray[index][TYPE_COLUMN] = type;
		birdsArray[index][PRICE_COLUMN] = Integer.toString(price);
		birdsArray[index][ON_STOCK_COLUMN] = "0";
		birdsArray[index][BAY_COLUMN] = "0";
		birdsArray[index][SELL_COLUMN] = "0";
		birdsArrayIndex(index);
		errorAdditionArray(newBirds);
	}
		
	static void ArraySellBayFill() {
		for (int i = 0, k = 1; k < lastPosition(birdsArray); i++, k++) {
			arraySellRegister[i][0]=birdsArray[k][TYPE_COLUMN];
			arrayBayRegister[i][0]=birdsArray[k][TYPE_COLUMN];
		}
	}
	
	static int findNull(String[][] array) {
		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i][TYPE_COLUMN] == null) {
				j = i;
				break;
			}
		}
		return j;
	}

	static int findNullHorizont(String type, String[][] array) {
		int vertikal = findTypeBirds(type) - 1;
		int j = 0;
		for (int k = 0; k < array[vertikal].length; k++) {
			if (array[vertikal][k] == null) {
				j = k;
				break;
			}
		}
		return j;
	}

	static int findTypeBirds(String type) {
		int indexType = 0;
		if (errorType(type) == true) {
			for (int i = 1; i < birdsArray.length; i++) {
				if (birdsArray[i][TYPE_COLUMN].equals(type)) {
					indexType = i;
					break;
				}
			}
		} else {
			System.out.println(type+" -" + " Error of type bird");
			System.exit(0);
		}
		return indexType;
	}
	
	static void enterBay(String type, int bay) {
		int index = findTypeBirds(type);
		int k = findNullHorizont(type, arrayBayRegister);
		errorHorizont(type, arrayBayRegister);
		String value = Integer.toString(bay);
		errorMinusValue(value);
		arrayBayRegister[index - 1][k] = value;
		recalculation(index);
	}

	static void enterSell(String type, int sell) {
		int index = findTypeBirds(type);
		if (stockFills(index, sell) == true) {
			int k = findNullHorizont(type, arraySellRegister);
			String value = Integer.toString(sell);
			errorMinusValue(value);
			arraySellRegister[index - 1][k] = value;
			recalculation(index);
		}
	}
	
	static void errorHorizont(String type, String[][] array) {
		int index = findTypeBirds(type);
		int sum=0;
		for (int i = 1; i<array[index].length; i++) {
			if (array[index][i]==null) {
				sum +=1;
			}
		}
		if (sum == 0) {
			System.out.println("Error of lenght array, Please, change parameter lenght array");
		}
		
		if (sum > 0 && sum < 4) {
			System.out.println("Attention! Array has only " + (sum)	+
					" free line. Please, change parameter lenght array");
		}
		
	}

	static void recalculation(int k) {
		String type = birdsArray[k][1];
		int b = new Integer(bayAll(k, type));
		int c = new Integer(sellAll(k, type));
		birdsArray[k][BAY_COLUMN] = Integer.toString(b);	
		birdsArray[k][SELL_COLUMN] = Integer.toString(c);
		birdsArray[k][ON_STOCK_COLUMN] = Integer.toString(b - c);
	}

	static int sellAll(int index, String type) {
		index -= 1;
		int j = findNullHorizont(type, arraySellRegister) - 1;
		int sum = 0;
		for (int i = 1; i <= j; i++) {
			sum += new Integer(arraySellRegister[index][i]);
		}
		return sum;
	}
	
	static int bayAll(int index, String type) {
		index -= 1;
		int j = findNullHorizont(type, arrayBayRegister) - 1;
		int sum = 0;
		for (int i = 1; i <= j; i++) {
			sum += new Integer(arrayBayRegister[index][i]);
		}
		return sum;
	}

	static boolean stockFills(int k, int sell) {
		String type  = findTypeNumberBirds(k);
		int a = new Integer(birdsArray[k][ON_STOCK_COLUMN]);
		int rezalt = (a - sell);
		if (rezalt <= 3 && rezalt >= 0) {
			System.out.println("Boss! We have only " + rezalt + " " + type+"s! "+"We mast quickly bay more "+type+"s!");
		}
		if (rezalt >= 0) {
			return true;

		} else {
			System.out.println("Boss! We dont have enough" + " " + birdsArray[k][1] + "s.");
			System.out.println("Boss! We can sell only " + a + " " + birdsArray[k][1] + "s.");
			System.exit(0);
			return false;
		}

	}
	
	static String findTypeNumberBirds(int k) {
		String index  = null;
		for (int i = 1;i<birdsArray.length; i++) {
			if (i == k) {
				index = birdsArray[i][TYPE_COLUMN];
				break;
				}
		}
		return index;
	}

	static boolean errorType(String type) {
		for (int i = 1; i < birdsArray.length - 1; i++) {
			if (type.equalsIgnoreCase(birdsArray[i][TYPE_COLUMN])) {
				return true;
			}
		}
		return false;
	}

	static void errorAdditionArray(String[][] newBirds) {
		int sum = 0;
		for (int i = 0; i < birdsArray.length; i++) {
			if (birdsArray[i][TYPE_COLUMN] == null)
				sum += 1;
		}
		if (sum == newBirds.length || sum <= 3) {
			System.out.println("Attention! Array has only " + (sum)	+
					" free line. Please, change parameter ARRAY_VERTIKAL.");
		}
	}

	static void printArray(String[][] birdsArray) {
		System.out.print("\n");
		System.out.println("Main report of "+"\"Birds shop\"");
		String border = "-----------------------------------------------------------------------------------------"
				+ "-------";
		System.out.println(border);
		for (int k = 0; k < birdsArray[0].length; k++) {
			System.out.print(birdsArray[0][k] + "\t");
		}
		System.out.print("\n");
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			System.out.printf("%-8s", birdsArray[i][INDEX_COLUMN]);
			System.out.printf("%-17s", birdsArray[i][TYPE_COLUMN]);
			System.out.printf("%-16s", birdsArray[i][ON_STOCK_COLUMN]);
			System.out.printf("%-24s", birdsArray[i][BAY_COLUMN]);
			System.out.printf("%-24s", birdsArray[i][SELL_COLUMN]);
			System.out.printf("%s%n", birdsArray[i][PRICE_COLUMN]);
		}
		System.out.println(border);
		System.out.println("Notes:");
		for (int i = 1; i<lastPosition(birdsArray); i++) {
		stockFills(i, 0);
		
		}
	}
	
	static int lastPosition(String[][] array) {
		int index = findNull(array);
		if (index == 0 || index == -1) {
			index = array.length;
			return index;
		} else {
			return index;
		}
	}

	static void birdsArrayFill() {
		birdsArray[0][INDEX_COLUMN] = INDEX;
		birdsArray[0][TYPE_COLUMN] = TYPE;
		birdsArray[0][ON_STOCK_COLUMN] = ON_STOCK;
		birdsArray[0][BAY_COLUMN] = BAY;
		birdsArray[0][SELL_COLUMN] = SELL;
		birdsArray[0][PRICE_COLUMN] = PRICE;
	}

	static void birdsArrayIndex(int i) {
		birdsArray[i][INDEX_COLUMN] = Integer.toString(i);
	}

	static void errorbirdsArray() {
		if (birdsArray == null || birdsArray.length < ARRAY_VERTIKAL) {
			System.out.println("Error data");
			System.exit(0);
		}
	}
	
	static int rounding(double x) {
		int roundingAfterPoint = 2;
		String k = null;
		String xSt = Double.toString(x);
		for (int i = xSt.length() - 1; i > 1 + roundingAfterPoint; i--) {
			k = xSt.substring(i);
			int v = new Integer(k);
			if (v >= 5) {
				double r = 1;
				r = r / Math.pow(10, i - 2);
				x += r;
			}
			xSt = Double.toString(x);
			xSt = xSt.substring(0, i);
			x = new Double(xSt);

		}
		int rezult=(int)(x*100);
		return rezult;
	}
	
	static void statisticTotalBirdsFoPercent() {
		System.out.println("\n" + "Statistic of total birds on stock, on percent");
		int sum = 0;
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			sum+=new Integer(birdsArray[i][ON_STOCK_COLUMN]);
		}
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			double rezult = new Double(birdsArray[i][ON_STOCK_COLUMN])/new Double(sum);
			System.out.println(birdsArray[i][TYPE_COLUMN] + "s" + " we have now: " + "\t" + rounding(rezult)+"%");
		}
		System.out.println("------------------------------");
		System.out.println("Total, items " + sum+"      "+rounding(new Double(sum)/new Double(sum))+"%");
	}
	
	static void cashFlowForPercent() {
		System.out.println("\n" + "CashFlow on percent");
		int sum = 0;
		for (int k = 1; k < lastPosition(birdsArray); k++) {
			sum += new Integer(birdsArray[k][SELL_COLUMN]) * new Integer(birdsArray[k][PRICE_COLUMN]);
		}
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			int rezult =  new Integer(birdsArray[i][SELL_COLUMN]) * new Integer(birdsArray[i][PRICE_COLUMN]);
			double x = new Double(rezult)/new Double(sum);
			System.out.println(birdsArray[i][TYPE_COLUMN] + "s" + " total sales: " + "\t" +rounding(x)+"%");
		}
		System.out.println("------------------------------");
		System.out.println("Total, $" + sum+" "+rounding(new Double(sum)/new Double(sum))+"%");
	}

	static void averageCheck() {
		System.out.print("\n" + "Average check for one sell: $");
		int sum = 0;
		int total = 0;
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			sum += new Integer(birdsArray[i][SELL_COLUMN]) * new Integer(birdsArray[i][PRICE_COLUMN]);
			total += new Integer(birdsArray[i][SELL_COLUMN]);
		}
		if (total<=0) {
			System.out.println("Error of value sells birds");
		}
		else {
			System.out.println(sum / total);
		}
	}

	static void cashFlowForAll() {
		System.out.println("\n" + "CashFlow for all");
		int sum = 0;
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			System.out.printf(birdsArray[i][TYPE_COLUMN] + "s" + " total sales: " + "\t" + "+$"
					+ (new Integer(birdsArray[i][SELL_COLUMN]) * new Integer(birdsArray[i][PRICE_COLUMN])) + "\n");
			sum += new Integer(birdsArray[i][SELL_COLUMN]) * new Integer(birdsArray[i][PRICE_COLUMN]);
		}
		System.out.println("------------------------------");
		System.out.println("Total, $" + sum);
	}

	static void statisticsForAll() {
		System.out.println("\n" + "Statictic fo all sell birds");
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			System.out.printf(birdsArray[i][TYPE_COLUMN] + "s" + " total sales, items: " + "\t" + birdsArray[i][SELL_COLUMN] + "\n");
		}
	}

	static void statisticTotalBirds() {
		System.out.println("\n" + "Statistic of total birds on stock");
		int sum = 0;
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			sum+=new Integer(birdsArray[i][ON_STOCK_COLUMN]);
		}
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			System.out.printf(birdsArray[i][TYPE_COLUMN] + "s" + " we have now: " + "\t" + birdsArray[i][2] + "\n");
		}
		System.out.println("------------------------------");
		System.out.println("Total, items " + sum);

	}

	static void statisticLessThenTRee() {
		System.out.println("\n" + "Statistic of problem with birds on stock");
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			int k = new Integer(birdsArray[i][ON_STOCK_COLUMN]);
			if (k <= 3) {
				System.out.printf(birdsArray[i][TYPE_COLUMN] + "s" + " less then tree: " + "\t" + birdsArray[i][ON_STOCK_COLUMN] + "\n");
			}
		}
	}
	
	static void averagePrice() {
		System.out.print("\n" + "Average price for all birds: $");
		int sum = 0;
		int index = lastPosition(birdsArray) - 1;
		for (int i = 1; i < lastPosition(birdsArray); i++) {
			sum += new Integer(birdsArray[i][PRICE_COLUMN]);
		}
		System.out.println(sum / index);
	}
}
