import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Map.Entry;

import com.tresbu.demo.core.DemoLogger;
import com.tresbu.demo.core.Utils;

public class Test {

	
	/*static int maxSubArraySum(int a[])
    {
        int size = a.length;
        ArrayList<Integer> b = new ArrayList<Integer>();
        
        int max_so_far = 0, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            
            if (max_ending_here < 0){
                max_ending_here = 0;
            	b.clear();
            }
            if (max_so_far < max_ending_here){
            
            	max_so_far = max_ending_here;
            }
        }
        System.out.println(b);
        return max_so_far;
    }
	*/
	
	public static void main(String[] args) throws IOException {
		
	        /*int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	        
	        System.out.println("Maximum contiguous sum is " +
	                                       maxSubArraySum(a));*/
	    
		System.out.println(System.getenv("APPIUM_HOME")+"/node.exe");
		Scanner scanner = new Scanner(Runtime.getRuntime().exec("dir").getInputStream()).useDelimiter("\\A");
		System.out.println(scanner.next());
	    
	}
	
	

}
