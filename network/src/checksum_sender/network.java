package checksum_sender;

import java.util.*;

public class network
{
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the string input:");
        String input = scan.next();
        int checksum = generateChecksum(input);
        // Call the method to create the checksum
        System.out.println("The checksum generated is = "
                + Integer.toHexString(checksum));
        System.out.println("carry sum = "
                + Integer.toHexString(checksum+1));
        System.out.println(charAt);
		System.out.println("Checksum(1¡¯s Complement) = "+checksum+1 );
        //input = scan.next();
        System.out.println("Enter the checksum to be sent:");
        //checksum = Integer.parseInt((scan.next()), 16);
        // User inputs data as hexadecimal value but it will be stored as a
        // decimal value unless it is converted into hexadecimal first.
        
       
        scan.close();
    }

    static int generateChecksum(String s)
    {
        String hex_value = new String();
        // 'hex_value' will be used to store various hex values as a string
        int x, i, checksum = 0;
        // 'x' will be used for general purpose storage of integer values
        // 'i' is used for loops
        // 'checksum' will store the final checksum
        for (i = 0; i < s.length() - 4; i = i + 4)
        {
            x = (int) (s.charAt(i));
            hex_value = Integer.toHexString(x);
            x = (int) (s.charAt(i + 1));
            hex_value = hex_value + Integer.toHexString(x);
            x = (int) (s.charAt(i + 2));
            hex_value = hex_value + Integer.toHexString(x);
            x = (int) (s.charAt(i + 3));
            hex_value = hex_value + Integer.toHexString(x);
            // Extract two characters and get their hexadecimal ASCII values
            System.out.println(s.charAt(i) + "" + s.charAt(i + 1) + s.charAt(i + 2) +s.charAt(i + 3) + " : "
                    + hex_value );
            x = Integer.parseInt(hex_value, 16);
            // Convert the hex_value into int and store it
            checksum += x;
            // Add 'x' into 'checksum'
        }
        if (s.length() % 4 == 0)
        {
            // If number of characters is even, then repeat above loop's steps
            // one more time.
            x = (int) (s.charAt(i));
            hex_value = Integer.toHexString(x);
            x = (int) (s.charAt(i + 1));
            hex_value = hex_value + Integer.toHexString(x);
            x = (int) (s.charAt(i+2));
            hex_value = hex_value+ Integer.toHexString(x);
            x = (int) (s.charAt(i + 3));
            hex_value = hex_value + Integer.toHexString(x);
            
            System.out.println(s.charAt(i) + "" + s.charAt(i + 1) + s.charAt(i + 2) +s.charAt(i + 3) + " : "
                    + hex_value);
            x = Integer.parseInt(hex_value, 16);
        }
        else
        {
            // If number of characters is odd, last 2 digits will be 00.
            x = (int) (s.charAt(i));
            hex_value = Integer.toHexString(x)+"000000";
            x = Integer.parseInt(hex_value, 16);
            System.out.println(s.charAt(i) + "000" + " : " + hex_value);
            
        }
        checksum += x;
        // Add the generated value of 'x' from the if-else case into 'checksum'
        hex_value = Integer.toHexString(checksum);
        // Convert into hexadecimal string
        if (hex_value.length() > 9)
        {
            // If a carry is generated, then we wrap the carry
            int carry = Integer.parseInt(("" + hex_value.charAt(0)), 16);
            // Get the value of the carry bit
            hex_value = hex_value.substring(1, 9);
            // Remove it from the string
            checksum = Integer.parseInt(hex_value, 16);
            // Convert it into an int
            checksum += carry;
            // Add it to the checksum
        }
        checksum = generateComplement(checksum);
        // Get the complement
        return checksum;
    }

 

    static int generateComplement(int checksum)
    {
    	int checksum1 = 0;
        // Generates 15's complement of a hexadecimal value
       try {
        checksum = Integer.parseInt("ffffffff", 16) - checksum;
       }catch(NumberFormatException e) {}
        
		return checksum;
        
    }
    
}