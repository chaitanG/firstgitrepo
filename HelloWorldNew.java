import com.calypso.tk.bo.PDFGeneration.SysOutEventListener;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.LocalCache;
import com.calypso.tk.util.ConnectionUtil;
import java.util.Vector;

public class HelloWorldNew {

	public static void main(String[] args) throws Exception {

	   

		DSConnection ds = ConnectionUtil.connect( args, "WSSample");
		Vector<String> domainValues = LocalCache.getDomainValues(ds, "camt056CancellationReason");
		for (String value : domainValues) {
			if("CBPR".equals(value)) {
				String comment = LocalCache.getDomainValueComment(ds, "camt056CancellationReason", value);
				System.out.println("COMMENT: " + comment);
			}
			
			
			
		}
        //camt056CancellationReason
		
		String s = "It was the best of times, it was the worst of times,\n"
		         + "it was the age of wisdom, it was the age of foolishness,\n"
		         + "it was the epoch of belief, it was the epoch of incredulity,\n"
		         + "it was the season of Light, it was the season of Darkness,\n"
		         + "it was the spring of hope, it was the winter of despair,\n"
		         + "we had everything before us, we had nothing before us";
		
		System.out.println("S is " + s);
		
		String originalString = "Line 1\r\nLine 2\r\nLine 3\r\nLine 4";

        // Output the original string for clarity
        System.out.println("Original String:");
        System.out.println(originalString);

        String[] lines = originalString.split("\r\n");
        if (lines.length >= 2) {
            // Concatenate the first two lines
            String firsTwoLines = lines[0] + lines[1]  ;
            System.out.println("First Two lines:" + firsTwoLines);
        } else {
            System.out.println("The string does not contain at least two lines.");
        }
        
        // Replace the first occurrence of \n with an empty string
        // This will concatenate the first and second lines
        int firstLineBreakIndex = originalString.indexOf('\n');
        if (firstLineBreakIndex != -1) {
            String modifiedString = originalString.substring(0, firstLineBreakIndex) +
                                    originalString.substring(firstLineBreakIndex + 1);

            // Output the modified string
            System.out.println("\nModified String:");
            System.out.println(modifiedString);
        } else {
            System.out.println("No line break found in the string.");
        }
	}

}
