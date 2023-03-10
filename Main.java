import java.util.Scanner; // Import scanner function
public class Main {

  public static char menu (Scanner inputScanner) {

    // Declare Variables

    char userInput;

    // Display Menu

    System.out.println("Calculator Menu");
    System.out.println(""); // Create Extra Line
    System.out.println("Get 3 (N)umbers.");
    System.out.println("(A)dd the numbers.");
    System.out.println("(S)ubtract the numbers.");
    System.out.println("(M)ultiply the numbers.");
    System.out.println("(D)ivide the numbers.");
    System.out.println("A(V)erage the numbers.");
    System.out.println("Determine the (L)argest number.");
    System.out.println("Determine the small(E)st number.");
    System.out.println("Determine the s(I)gn of each number.");
    System.out.println("E(X)it.");
    System.out.println(""); // Create Extra Line

    // Get User Input

    userInput = inputScanner.next().charAt(0);

    // Return Char
    return userInput;

  }
  
  public static boolean menuProcess (char menuAnswer, Scanner userInput, double[] calculatorArray, boolean arrayAllocation, String[] signOfArray){
    // Declare Variables

    // Call Other Methods

    if (menuAnswer == 'N' || menuAnswer == 'n') { // Calls Method to Allocate Array and returns boolean
      arrayAllocation = arrayInput(userInput, calculatorArray);
      return arrayAllocation;
    }

    if (menuAnswer == 'X' || menuAnswer == 'x') { // Prints Good-Bye Message
      System.out.println("Thank you for using Team 5's calculator! Good-bye!"); 
      return false;
    }

    if (arrayAllocation) { // Checks if Array is Allocated


      if (menuAnswer == 'A' || menuAnswer == 'a') { // Calls Sum Method
        double sumOfArray = sum(calculatorArray);
        sumProof(calculatorArray, sumOfArray);
      }

      else if (menuAnswer == 'S' || menuAnswer == 's') { // Calls Difference Method
        double differenceOfArray = difference(calculatorArray);
        differenceProof(calculatorArray, differenceOfArray);
        
      }

      else if (menuAnswer == 'M' || menuAnswer == 'm') { // Calls Product Method
        double productOfArray = product(calculatorArray);
        productProof(calculatorArray, productOfArray);
      }

      else if (menuAnswer == 'D' || menuAnswer == 'd') { // Calls Division Method

        boolean checkResult = zeroCheck(calculatorArray);
        if (checkResult) {
          double quotientOfArray = division(calculatorArray);
          divisionProof(calculatorArray, quotientOfArray);
        }
        else {
          System.out.println("Error: Cannot divide by zero!");
        }
      }

      else if (menuAnswer == 'V' || menuAnswer == 'v') { // Calls Average Method
        double averageOfArray = average(calculatorArray);
        averageProof(calculatorArray, averageOfArray);
      }

      else if (menuAnswer == 'L' || menuAnswer == 'l') { // Calls Largest Number Method
        double largestNumberOfArray = largestNumber(calculatorArray);
        printLargestNumber(largestNumberOfArray);
      }

      else if (menuAnswer == 'E' || menuAnswer == 'e') { // Calls Smallest Number Method
        double smallestNumberOfArray = smallestNumber(calculatorArray);
        printSmallestNumber(smallestNumberOfArray);
      }

      else if (menuAnswer == 'I' || menuAnswer == 'i') { // Calls Sign Method
        sign(signOfArray, calculatorArray);
        signProof(signOfArray);
      }

      else { // Error Message if No Possible if user inputs incorrect letter
        System.out.println("Error: Invalid choice!\n");
      }
  }
    else if (!arrayAllocation) {
      System.out.println("Error: Please select option N from the menu first!\n");
      return false;
    }
    return arrayAllocation;

  }
  
  public static boolean arrayInput (Scanner userInput, double[] calculatorArray) {
    // Declare Variables
  
    // Get User Input
    System.out.println("Enter 3 numbers seperated with spaces: ");

    for (int i = 0; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      calculatorArray[i] = userInput.nextDouble();
    }
    System.out.println(""); // Create New Line
    // Assign Numbers to Array
    return true;

  }

  public static double sum (double[] calculatorArray){
    // Declare Variables
    double sumOfArray = calculatorArray[0];
    // Get Sum of Array
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      sumOfArray += calculatorArray[i];
    }

    // Return Sum
    return sumOfArray;
  }

  public static double difference (double[] calculatorArray){
    // Declare Variables
    double differenceOfArray = calculatorArray[0];
    // Get Difference of Array
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      differenceOfArray = differenceOfArray - calculatorArray[i];
    }

    // Return Difference
    return differenceOfArray;

  }

  public static double product (double[] calculatorArray) {
    // Declare Variables
    double productOfArray = calculatorArray[0];
    // Get Product of Array
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      productOfArray *= calculatorArray[i];
    }

    // Return Product
    return productOfArray;
  }

  public static boolean zeroCheck (double[] calculatorArray) {
    // Declare Variables
    boolean checkResult = true;

    // Check if Array Numbers are Zero
    for (int i = 0; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      if (calculatorArray[i] <= 0.001) {
        checkResult = false;
      }
    }

    // Return Boolean
    return checkResult;
  }

  public static double division (double[] calculatorArray){
    // Declare Variables
    double quotientOfArray = calculatorArray[0];

    // Get Quotient (Get Quotient from 1st and 2nd Number, Then the quotient of 1st and 2nd to 3rd, and etc)
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      quotientOfArray = (quotientOfArray / calculatorArray[i]);
    }
    // Return Quotient
    return quotientOfArray;
  }

  public static double average (double[] calculatorArray) {
    // Declare Variables
    double averageOfArray;

    // Get Average 
    double sumOfArray = sum(calculatorArray);
    averageOfArray = (sumOfArray / calculatorArray.length);

    // Return Average
    return averageOfArray;
  }

  public static double largestNumber (double[] calculatorArray) {
    // Declare Variables
    double maxValue = calculatorArray[0];

    // Get Largest Number
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      if (calculatorArray[i] > maxValue) {
        maxValue = calculatorArray[i];
      }
    }

    // Return Largest Number
    return maxValue;
  }

  public static double smallestNumber (double[] calculatorArray){
    // Declare Variables
    double minValue = calculatorArray[0];

    // Get Smallest Number
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      if (calculatorArray[i] < minValue) {
        minValue = calculatorArray[i];
      }
    }

    // Return Smallest Number
    return minValue;
  }

  public static void sign (String[] signOfArray, double[] calculatorArray){
    // Declare Variables

    // Assign each element in signOfArray according to the sign of calculatorArray
    for (int i = 0; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      if (calculatorArray[i] <= 0.001 && calculatorArray[i] >= -0.001) {
        signOfArray[i] = "zero";
      }
      else if (calculatorArray[i] < 0) {
        signOfArray[i] = "negative";
      }
      else if (calculatorArray[i] > 0) {
        signOfArray[i] = "positive";
      }
    }

  }

  public static void sumProof (double[] calculatorArray, double sumOfArray){
    // Print Proof for Sum Method
    System.out.print("Answer: ");
    System.out.print(calculatorArray[0]);
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      System.out.print(" + " + calculatorArray[i]);
    }
    System.out.println(" = " + sumOfArray +"\n");
  }

  public static void productProof (double[] calculatorArray, double productOfArray) {
    // Print Proof for Product Method
    System.out.print("Answer: " + calculatorArray[0]);
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      System.out.print(" * " + calculatorArray[i]);
    }
    System.out.println(" = " + productOfArray + "\n");
  }

  public static void divisionProof (double[] calculatorArray, double quotientOfArray){
    // Print Proof for Division Method
    System.out.print("Answer: " + calculatorArray[0]);
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      System.out.print(" / " + calculatorArray[i]);
    }
    System.out.println(" = " + quotientOfArray + "\n");

  }

  public static void averageProof (double[] calculatorArray, double averageOfArray) {
    // Print Proof for Average Method
    System.out.print("Answer: (");
    System.out.print(calculatorArray[0]);
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      System.out.print(" + " + calculatorArray[i]);
    }
    System.out.println(") / " + calculatorArray.length + " = " + averageOfArray + "\n");
  }

  public static void differenceProof (double[] calculatorArray, double differenceOfArray) {
    //Print Proof for Difference Method
    System.out.print("Answer: " );
    for (int i = 1; (Math.abs(i - calculatorArray.length)) >= 0.001; ++i) {
      System.out.print("(" + calculatorArray[0] + " - " + calculatorArray[i] + ") ");
    }
    System.out.println("= " + differenceOfArray + "\n");
  }

  public static void printLargestNumber (double largestNumberOfArray) {
    // Print largestNumber
    System.out.println("The largest number is " + largestNumberOfArray + ".\n");
  }

  public static void printSmallestNumber (double smallestNumberOfArray) {
    // Print smallestNumber
    System.out.println("The smallest number is " + smallestNumberOfArray + ".\n");
  }

  public static void signProof (String[] signOfArray) {
    // Print sign of each number in array
    for (int i = 0; (Math.abs(i - signOfArray.length)) >= 0.001; ++i) {
      System.out.println("The number in position " + (i + 1) + " is " + signOfArray[i] + ".");
    }
  }

  
  public static void main (String [] args) {

  // Declare variables
  final int NUMBERS_IN_ARRAY = 3; // Amount of Numbers that can be entered in an Array
  Scanner inputScanner = new Scanner(System.in); // Declares Scanner
  char menuAnswer; // Stores Answer From Menu Method
  double[] calculatorArray = new double[NUMBERS_IN_ARRAY]; // Stores Numbers in Array from arrayInput Method
  String[] signOfArray = new String[NUMBERS_IN_ARRAY]; // Stores Strings in Array from sign Method
  boolean arrayAllocation = false; // Sets arrayAllocation to false until numbers have been allocated in array



  
  do {
    
    // Call Menu
    menuAnswer = menu(inputScanner);
    // Process Menu Answer
    arrayAllocation = menuProcess(menuAnswer, inputScanner, calculatorArray, arrayAllocation, signOfArray);

  } while (menuAnswer != 'X' && menuAnswer != 'x');

  // ARRAY TEST - WORKING
  // SUM TEST - WORKING
  // DIFFERENCE TEST - WORKING (FIX: DIFFERENCE PROOF REPEATS THE FIRST VALUE OF THE ARRAY TWICE. CHANGE IT SO DURING THE SECOND LOOP IT SHOWS THE DIFFERENCE BEING SUBTRACTED)
  // PRODUCT TEST - WORKING
  // DIVISION TEST - WORKING
  // LARGEST NUMBER TEST - WORKING
  // SMALLEST NUMBER TEST - WORKING
  // EXIT TEST - WORKING
  // ERROR MESSAGE (INVALID CHOICE) - WORKING
  // ERROR MESSAGE (PRESS N FIRST) - WORKING
    
  }
}

