
package beproject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jfree.ui.RefineryUtilities;

public class Hypernyms {

    public void setup(String hotel, String lem) {

        try {
            NewExcel ne = new NewExcel();
            ne.setInputFile(lem);
            
            List<String> data = ne.read(1);

            /*String[] positiveWords = { "good", "nice", "worth", "not bad" };
            String[] negativeWords = { "not good", "bad", "boring", "cold", "not nice", "less" };
*/
            ne.setInputFile("resources/sentiword.xls");
            List<String> positiveWords = ne.read(0);
            List<String> negativeWords = ne.read(1);
            
            HashMap<String, Double> result = new HashMap<String, Double>();
            Double negativeCount=0d, positiveCount = 0d;
            
            //iterate through negative array and then if negative review found increment bad count by 1 and remove that string from main array;
            for (String negative : negativeWords) {
                for (Iterator iterator = data.iterator(); iterator.hasNext();) {
                    String value = (String) iterator.next();
                    if (value != null && value.contains(negative)){
                       negativeCount++;
                       iterator.remove();
                    }
                }
            }

            for (String positive : positiveWords) {
                for (Iterator iterator = data.iterator(); iterator.hasNext();) {
                    String value = (String) iterator.next();
                    if (value != null && value.contains(positive)){
                       positiveCount++;
                       iterator.remove();
                    }
                }
            }
            
            result.put("Good review", positiveCount);
            result.put("Bad review", negativeCount);
            
            BarChart_AWT chart = new BarChart_AWT("Hotel Statistics", "Now you know!!!",hotel,result);
            chart.pack( );        
            RefineryUtilities.centerFrameOnScreen( chart );        
            chart.setVisible( true );
            

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
