
package beproject;

import java.io.IOException;
import java.util.ArrayList;
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
            
            //To identify the comment category.
            ne.setInputFile("resources/sentiwordcategory.xls");
            List<String> costdata = ne.read(0);
            List<String> fooddata = ne.read(1);
            List<String> servicedata = ne.read(2);
            List<String> ambiencedata = ne.read(3);
                        
            List<String> costList = new ArrayList<String>();
            Double costTotal = 0d;
            List<String> foodList = new ArrayList<String>();
            Double foodTotal = 0d;
            List<String> serviceList = new ArrayList<String>();
            Double serviceTotal = 0d;
            List<String> ambienceList = new ArrayList<String>();
            Double ambienceTotal = 0d;
            //To get the array of category from the list of comments in the Lammetized workbook.
            
            for(String d:data)
            {
                costTotal = getFeatureCount(costdata, costList, costTotal, d);
                
                foodTotal = getFeatureCount(fooddata, foodList, foodTotal, d);
                
                serviceTotal = getFeatureCount(servicedata, serviceList, serviceTotal, d);
                
                ambienceTotal = getFeatureCount(ambiencedata, ambienceList, ambienceTotal, d);
            }
            
         
            ne.setInputFile("resources/sentiwordnew.xls");
            List<String> costWords = ne.read(0);
            List<String> foodWords = ne.read(1);
            List<String> serviceWords = ne.read(2);
            List<String> ambienceWords = ne.read(3);
            
            HashMap<String, Double> result = new HashMap<String, Double>();
            Double costCount=0d, foodCount = 0d, serviceCount = 0d, ambienceCount = 0d;
            
            //iterate through cost array and then if positive review found increment the count by 1 and remove that string from cost array
            
            costCount = getDataList(costList, costWords, null, costCount);
            
            foodCount = getDataList(foodList, foodWords, null, foodCount);
            
            serviceCount = getDataList(serviceList, serviceWords, null, serviceCount);
            
            ambienceCount = getDataList(ambienceList, ambienceWords, null, ambienceCount);
            
          //  Double foodPercent = (foodTotal/foodCount)*100;
            Double count = foodTotal+ambienceTotal+serviceTotal+costTotal;
            result.put("Food review", (foodCount));
            result.put("Service review", (serviceCount));
            result.put("Cost review", (costCount));
            result.put("Ambience review", (ambienceCount));
            
            BarChart_AWT chart = new BarChart_AWT("Hotel Statistics", "Below is the count of Good Reviews", hotel,result);
            chart.pack( );        
            RefineryUtilities.centerFrameOnScreen( chart );        
            chart.setVisible( true );

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void setupcompare(String feature) {

        try {
            
            NewExcel ne = new NewExcel();
            ne.setInputFile("resources/final_Poptates-1.xls");            
            List<String> poptatesdata = ne.read(1);
            
            //ne = new NewExcel();
            ne.setInputFile("resources/final_BlueFrog-1.xls");            
            List<String> blueFrogdata = ne.read(1);
            
            ne.setInputFile("resources/final_Candies.xls");            
            List<String> candiesdata = ne.read(1);
            
            ne.setInputFile("resources/final_WildDining-2.xls");            
            List<String> wildDiningdata = ne.read(1);
            
            //To identify the comment category.
          //  ne.setInputFile("resources/sentiwordcategory.xls");
            
            NewExcel ne1 = new NewExcel();
            ne1.setInputFile("resources/sentiwordnew.xls");
            List<String> costWords = ne1.read(0);
            List<String> foodWords = ne1.read(1);
            List<String> serviceWords = ne1.read(2);
            List<String> ambienceWords = ne1.read(3);
            
            List<String> pcostdata = new ArrayList<String>();
            
            List<String> pcostList = new ArrayList<String>();
            List<String> wcostList = new ArrayList<String>();
            List<String> bcostList = new ArrayList<String>();
            List<String> ccostList = new ArrayList<String>();
            Double pcostTotal = 0d, wcostTotal = 0d, bcostTotal = 0d, ccostTotal = 0d;
            
            List<String> pfooddata = new ArrayList<String>();          
            
            List<String> pfoodList = new ArrayList<String>();
            List<String> wfoodList = new ArrayList<String>();
            List<String> bfoodList = new ArrayList<String>();
            List<String> cfoodList = new ArrayList<String>();
            Double pfoodTotal = 0d, cfoodTotal = 0d, bfoodTotal = 0d, wfoodTotal = 0d;
            
            List<String> pservicedata = new ArrayList<String>();
            
            List<String> pserviceList = new ArrayList<String>();
            List<String> wserviceList = new ArrayList<String>();
            List<String> bserviceList = new ArrayList<String>();
            List<String> cserviceList = new ArrayList<String>();            
            Double pserviceTotal = 0d, wserviceTotal = 0d, bserviceTotal = 0d, cserviceTotal = 0d;
            
            List<String> pambiencedata = new ArrayList<String>();
            
            List<String> pambienceList = new ArrayList<String>();
            List<String> wambienceList = new ArrayList<String>();
            List<String> bambienceList = new ArrayList<String>();
            List<String> cambienceList = new ArrayList<String>();            
            Double pambienceTotal = 0d, wambienceTotal = 0d, bambienceTotal = 0d, cambienceTotal = 0d;
            
            HashMap<String, Double> result = new HashMap<String, Double>();
            Double pcostCount=0d, pfoodCount = 0d, pserviceCount = 0d, pambienceCount = 0d;
            Double wcostCount=0d, wfoodCount = 0d, wserviceCount = 0d, wambienceCount = 0d;
            Double bcostCount=0d, bfoodCount = 0d, bserviceCount = 0d, bambienceCount = 0d;
            Double ccostCount=0d, cfoodCount = 0d, cserviceCount = 0d, cambienceCount = 0d;
            
            ne.setInputFile("resources/sentiwordcategory.xls");
            
            if(feature.contains("cost"))
            {
                pcostdata = ne.read(0);
                //costList = new ArrayList<String>();
                pcostTotal = getDataList(poptatesdata, pcostdata, pcostList, pcostTotal);
                wcostTotal = getDataList(wildDiningdata, pcostdata, wcostList, wcostTotal);
                bcostTotal = getDataList(blueFrogdata, pcostdata, bcostList, bcostTotal);
                ccostTotal = getDataList(candiesdata, pcostdata, ccostList, ccostTotal);
//                Double costTotal = 0d;
                pcostCount = getDataList(pcostList, costWords, null, pcostCount);
                wcostCount = getDataList(wcostList, costWords, null, wcostCount);
                bcostCount = getDataList(bcostList, costWords, null, bcostCount);
                ccostCount = getDataList(ccostList, costWords, null, ccostCount);
                
                result.put("Poptates", (pcostTotal));
                result.put("Wild Dining", (wcostTotal));
                result.put("Blue Frog", (bcostTotal));
                result.put("Candies", (ccostTotal));
            }
            else if(feature.contains("food"))
            {
                pfooddata = ne.read(1);
                //foodList = new ArrayList<String>();
                pfoodTotal = getDataList(poptatesdata, pfooddata, pfoodList, pfoodTotal);
                wfoodTotal = getDataList(wildDiningdata, pfooddata, wfoodList, wfoodTotal);
                bfoodTotal = getDataList(blueFrogdata, pfooddata, bfoodList, bfoodTotal);
                cfoodTotal = getDataList(candiesdata, pfooddata, cfoodList, cfoodTotal);
//                Double foodTotal = 0d;
                pfoodCount = getDataList(pfoodList, foodWords, null, pfoodCount);
                wfoodCount = getDataList(wfoodList, foodWords, null, wfoodCount);
                bfoodCount = getDataList(bfoodList, foodWords, null, bfoodCount);
                cfoodCount = getDataList(cfoodList, foodWords, null, cfoodCount);
                
                result.put("Poptates", (pfoodTotal));
                result.put("Wild Dining", (wfoodTotal));
                result.put("Blue Frog", (bfoodTotal));
                result.put("Candies", (cfoodTotal));
            }
            else if(feature.contains("service"))
            {
                pservicedata = ne.read(2);
                //serviceList = new ArrayList<String>();
                pserviceTotal = getDataList(poptatesdata, pservicedata, pserviceList, pserviceTotal);
                wserviceTotal = getDataList(wildDiningdata, pservicedata, wserviceList, wserviceTotal);
                bserviceTotal = getDataList(blueFrogdata, pservicedata, bserviceList, bserviceTotal);
                cserviceTotal = getDataList(candiesdata, pservicedata, cserviceList, cserviceTotal);
                //                Double serviceTotal = 0d;
                pserviceCount = getDataList(pserviceList, serviceWords, null, pserviceCount);
                wserviceCount = getDataList(wserviceList, serviceWords, null, wserviceCount);
                bserviceCount = getDataList(bserviceList, serviceWords, null, bserviceCount);
                cserviceCount = getDataList(cserviceList, serviceWords, null, cserviceCount);
                
                result.put("Poptates", (pserviceTotal));
                result.put("Wild Dining", (wserviceTotal));
                result.put("Blue Frog", (bserviceTotal));
                result.put("Candies", (cserviceTotal));
            }
            else
            {
                pambiencedata = ne.read(3);
                //ambienceList = new ArrayList<String>();
                pambienceTotal = getDataList(poptatesdata, pambiencedata, pambienceList, pambienceTotal);
                wambienceTotal = getDataList(wildDiningdata, pambiencedata, wambienceList, wambienceTotal);
                bambienceTotal = getDataList(blueFrogdata, pambiencedata, bambienceList, bambienceTotal);
                cambienceTotal = getDataList(candiesdata, pambiencedata, cambienceList, cserviceTotal);
                //                Double ambienceTotal = 0d;
                pambienceCount = getDataList(pambienceList, ambienceWords, null, pambienceCount);
                wambienceCount = getDataList(wambienceList, ambienceWords, null, wambienceCount);
                bambienceCount = getDataList(bambienceList, ambienceWords, null, bambienceCount);
                cambienceCount = getDataList(cambienceList, ambienceWords, null, cambienceCount);
                
                result.put("Poptates", (pambienceTotal));
                result.put("Wild Dining", (wambienceTotal));
                result.put("Blue Frog", (bambienceTotal));
                result.put("Candies", (cambienceTotal));
            }
                                   
//            foodCount = getDataList(foodList, foodWords, null, foodCount);
            
//            serviceCount = getDataList(serviceList, serviceWords, null, serviceCount);
            
//            ambienceCount = getDataList(ambienceList, ambienceWords, null, ambienceCount);
            
          //  Double foodPercent = (foodTotal/foodCount)*100;
            //Double count = foodTotal+ambienceTotal+serviceTotal+costTotal;
//            result.put("Food review", (foodCount));
//            result.put("Service review", (serviceCount));
//            result.put("Cost review", (costCount));
//            result.put("Ambience review", (ambienceCount));            
            BarChart_AWT chart = new BarChart_AWT("Feature based Hotel Statistics", "Below is the count of Good Reviews", feature,result);
            chart.pack( );        
            RefineryUtilities.centerFrameOnScreen( chart );        
            chart.setVisible( true );
            

        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param costdata
     * @param costList
     * @param costTotal
     * @param d
     * @return
     */
    private Double getFeatureCount(List<String> costdata, List<String> costList, Double costTotal, String d) {
        for(Iterator iterator = costdata.iterator(); iterator.hasNext();)
        {
            String value = (String) iterator.next();
            if(value!=null && d.contains(value))
            {
                costTotal++;
                if(costList!=null)
                costList.add(d);
            }                                       
        }
        return costTotal;
    }

    //pcostTotal = getDataList(poptatesdata, pcostdata, pcostList, pcostTotal);
    private Double getDataList(List<String> data, List<String> listValidData, List<String> dataList, Double dataTotal) {
        for (String cost : listValidData) {
            for (Iterator iterator = data.iterator(); iterator.hasNext();) {
                String value = (String) iterator.next();
                if (value != null && value.contains(cost)){
                    dataTotal++;
                    if(dataList!=null)
                        dataList.add(value);
                    else {
                        iterator.remove();
                    }
                }
            }
        }
        return dataTotal;
    }

}
