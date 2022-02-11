import java.util.Scanner;

public static void main(String[] args) 
    {
        double pounds ;
        double kilograms ;
        
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat(".###");
        
        System.out.print("Enter the number of pounds: ");
        pounds = input.nextDouble();
        
        kilograms = pounds * 0.45359237;
        
        System.out.println(pounds + " lbs in kilograms is " + df.format(kilograms));
        
    }
