
public class findLargestSmallest 
{
    public static void main(String[] args) 
    {
        int smallestValue = Integer.MAX_VALUE;
        int largestValue = Integer.MIN_VALUE;
        String again = "y";
        int numInput;
        int counter = 0;
        int numSets = 0;
        double averageSmallest;
        double averageLargest;
        int runningTotalSmallest = 0;
        int runningTotalLargest = 0;
        
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a set of 10 numbers: ");
        numSets++;
        
        for(counter = 0; counter < 10; counter++)
        {
            numInput = input.nextInt();

            if (numInput > largestValue)
            {
                largestValue = numInput;
            }
            
            else if (numInput < smallestValue )
            {
               smallestValue = numInput;
            }
        }
    
        System.out.println( "Smallest is " + smallestValue ); 
        System.out.println("Largest is " + largestValue); 
        
        runningTotalSmallest = runningTotalSmallest + smallestValue;
        runningTotalLargest = runningTotalLargest + largestValue;
        
        System.out.println("");

        System.out.println("Would you like to enter another set? (Enter y or n): ");
        again = input.next();
        
        while (again.equalsIgnoreCase("Y"))
        {
            System.out.print("Enter a set of 10 numbers: ");
            numSets++;
        
        for(counter = 0; counter < 10; counter++)
        {
            numInput = input.nextInt();

            if (numInput > largestValue)
            {
                largestValue = numInput;
            }
            
            else if (numInput < smallestValue )
            {
               smallestValue = numInput;
            }
        }
    
        System.out.println( "Smallest is " + smallestValue ); 
        System.out.println("Largest is " + largestValue); 
        
        runningTotalSmallest = runningTotalSmallest + smallestValue;
        runningTotalLargest = runningTotalLargest + largestValue;
        
            
            System.out.println("");

            System.out.println("Would you like to enter another set? (Enter y or n): ");
            again = input.next();                   
        }
        
        System.out.println("");
         
        averageSmallest = (double)(runningTotalSmallest / numSets);
        averageLargest = (double)(runningTotalLargest / numSets);
               
        System.out.println("The average of all the smallest values is " + averageSmallest + ".");
        System.out.println("The average of all the largest values is " + averageLargest + ".");
        
    } //End main 
    
} //End class
