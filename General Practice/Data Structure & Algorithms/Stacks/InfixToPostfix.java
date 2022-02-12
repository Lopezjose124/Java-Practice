
import java.io.*;
import java.util.*;

public class infixToPost
{   
   // this method determines the precedence of the operators used in this program
    public static int getPrecedence(String value)
    {
        if (value.equals("*") || value.equals("/"))
        {
            return 2;
        } else if (value.equals("+") || value.equals("~"))
        {
            return 1;
        } else
        {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        //Declare variables 
        String inPutFile = "infix.txt";//file name       
        String line;
        int numChars;
        String value;
        int count;
        String outLine = " ";
        boolean topIsGreater;

        //Instantiate a Stack
        Stack<String> stack = new Stack<>();

        //open the input stream
        FileReader fRead = new FileReader(inPutFile);
        BufferedReader bRead = new BufferedReader(fRead); //get data   

        //read in the first line of the file
        line = bRead.readLine();

        //while not yet at the end of the file  
        while (line != null)
        {
            //get length of line
            numChars = line.length();

            //start character count at zero   
            count = 0;

            //top is greater than or equal = true
            topIsGreater = true;

            //extract characters and create stack
            while (count < numChars)
            {
                //get character    
                value = line.substring(count, count + 1);

                //IF character equals Open Parenthesis
                if (value.equals("("))
                {
                    //Push Open Parenthesis on to stack
                    stack.push(value);
                } //ELSE IF character equals + or ~ or * or /
                else if (value.equals("+") || value.equals("~") || value.equals("*") || value.equals("/"))
                {
                    //IF stack is empty
                    if (stack.empty())
                    {
                        //push character on top
                        stack.push(value);

                    }// end if stack is empty  
                    else
                    {
                        //WHILE stack is not empty AND top >= to character AND top is not an (
                        while (!stack.empty() && getPrecedence(stack.peek()) >= getPrecedence(value) && !stack.peek().equals("("))
                        {
                            //Peek at top of stack
                            stack.peek();

                            //IF top >= character
                            if (getPrecedence(stack.peek()) >= getPrecedence(value))
                            {
                                //Top is greater = true;
                                topIsGreater = true;

                            } //END IF 
                            else
                            {
                                //Top is greater = false;  
                                topIsGreater = false;

                            }//end else

                            //IF top is >= to character 
                            if (getPrecedence(stack.peek()) >= getPrecedence(value))
                            {
                                //Concatenate top onto output string
                                outLine += stack.peek();

                                //Pop top
                                stack.pop();

                            } //END IF

                        }//END WHILE not empty and top is greater or equal to character and not equal to (

                        //Push character on stack
                        stack.push(value);

                        //top is greater or equal to character = true
                        topIsGreater = true;

                    }//END else

                }//end else char isn't an ( or operand
                //ELSE IF character equal closed parenthesis
                else if (value.equals(")"))
                {
                    //WHILE stack not empty AND top not equal to open parenthesis
                    while (!stack.empty() && !stack.peek().equals("("))
                    {
                        //peek at top of stack
                        stack.peek();

                        //Concatenate top of stack to output string
                        outLine += stack.peek();

                        //Pop top of stack
                        stack.pop();

                    }//END WHILE

                    //Pop top of stack to get rid of the open parenthesis
                    if (!stack.empty())
                    {
                        stack.pop();
                    }

                }//end else if
                //ELSE
                else
                {
                    //Concatenate character at end of output string
                    outLine += value;

                }

                //Increment counter
                count++;

            }//END WHILE character count is less than length of string

            //WHILE stack is not empty
            while (!stack.empty())
            {
                // Peek at top of stack
                stack.peek();

                //Concatenate top of stack to output string
                outLine += stack.peek();

                //pop value off stack     
                stack.pop();

            }//end while not empty

            //Concatenate the Enter Key to output string
            outLine += "\n";

            //Print output string
            System.out.println(outLine);

            //Initialize output string back to empty string
            outLine = "";

            //get the next line in the current file
            line = bRead.readLine();

        }//end while line !=null 

        //close the input file
        bRead.close();

    }// end main 

}//end class
