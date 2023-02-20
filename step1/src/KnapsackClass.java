import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class KnapsackClass {
    // Variables created
    int weight = 0;
    int numObjects = 0;

    int arrayValue[] = null;
    int arrayWeight[] = null;
    
    public void test() throws InterruptedException{

        // Problem introduction
        printMessage("Imagine that you are a thief breaking into a house.");
        printMessage("There are so many valuables to steal, but you're just one person who can only carry so much.");
        printMessage("Each item has a weight and value, and your goal is to maximize the total value of items while remaining within the weight limit of your knapsack.");
    
        // Enter amount of weight you can carry
        printMessage("Enter the total amount of weight you can carry: ");
        weight = captureData();

        // Enter amount of objects you found
        printMessage("Enter the total amount of objects you found: ");
        numObjects = captureData();

        // Enter the array of object; wieght first and value second
        arrayValue = fillArrayValue();
        System.out.println("THE VALUE OF THE OBJECTS ARE: "+Arrays.toString(arrayValue));

        arrayWeight = fillArrayWeight();
        System.out.println("THE WEIGHT OF THE OBJECTS ARE: "+Arrays.toString(arrayWeight));

        // Apply the knaspack algorithm
        printMessage("the max amount of value you will be able to carry is: ");
        System.out.print(knapSack(weight, arrayWeight, arrayValue, numObjects));

    }

    public void printMessage(String message) throws InterruptedException{
        String stringCaps = message.toUpperCase();
        char[] charsCaps = stringCaps.toCharArray();

        System.out.println();
        for(int i = 0; i < charsCaps.length; i++)
        {
            System.out.print(charsCaps[i]);
            TimeUnit.MILLISECONDS.sleep(25);
        }
    }

    public int captureData() throws InterruptedException{
        int data = 0;
        Scanner myInput = new Scanner(System.in);
        do{
            while(!myInput.hasNextInt()){
                printMessage("Please enter a valid number.");
                myInput.next();
            }
            data = myInput.nextInt();
        }while(data <= 0);

        return data;
    }

    public int[] fillArrayValue() throws InterruptedException{
        Scanner s = new Scanner(System.in);
        int myArray[] = new int [numObjects];

        printMessage("Enter the value of the elements one by one: ");
        for(int i=0; i<numObjects; i++) {
            myArray[i] = s.nextInt();
      }
      return(myArray);
    }

    public int[] fillArrayWeight() throws InterruptedException{
        Scanner s = new Scanner(System.in);
        int myArray[] = new int [numObjects];

        printMessage("Enter the weight of the elements one by one: ");
        for(int i=0; i<numObjects; i++) {
            myArray[i] = s.nextInt();
      }
      return(myArray);
    }

    static int max(int a, int b) { return (a > b) ? a : b; }

    static int knapSack(int W, int wt[], int val[], int n)
    {

        if (n == 0 || W == 0)
            return 0;
 
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);
 
        else
            return max(val[n - 1]
                           + knapSack(W - wt[n - 1], wt,
                                      val, n - 1),
                       knapSack(W, wt, val, n - 1));
    }

}
