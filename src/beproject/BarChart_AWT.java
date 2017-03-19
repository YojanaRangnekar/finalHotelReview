/**
 * 
 */

/**
 * @author Admin
 *
 */

package beproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.awt.SystemColor;
import java.util.HashMap;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChart_AWT extends ApplicationFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public BarChart_AWT(String applicationTitle, String chartTitle, String hotel, Map<String, Double> result)
    {
        super(applicationTitle);
        System.out.println("counts**********"+result.get("Good review"));
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                "Hotel",
                "Rating",
                createDataset(hotel, result),
                PlotOrientation.VERTICAL,
                true, true, false);

        Font f = new Font("abc", Font.ITALIC, 30);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        chartPanel.setFont(f);
        
        CategoryPlot cplot = (CategoryPlot)barChart.getPlot();
        cplot.setBackgroundPaint(SystemColor.controlHighlight);//change background color

        BarRenderer r = (BarRenderer)barChart.getCategoryPlot().getRenderer();
        r.setSeriesPaint(0,  new Color(37, 139, 37));//dark green
        r.setSeriesPaint(1, new Color(139,5,5));//dark red
        setContentPane(chartPanel);
    }

    public CategoryDataset createDataset(String hotel, Map<String, Double> result)
    {
          
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  
        for (Map.Entry<String, Double> entry : result.entrySet())
        {
            System.out.println(entry.getKey() + "/" + entry.getValue());
            dataset.addValue(entry.getValue() , entry.getKey(),hotel); 
        }
               
        return dataset; 
    }
    
    public static void main( String[ ] args )
    {
       Map<String, Double> result = new HashMap<String, Double>();
       result.put("Bad", 13d);
       result.put("Good", 10d);
       BarChart_AWT chart = new BarChart_AWT("Hotel Statistics", "Which one is better?","Poptates",result);
       chart.pack( );        
       RefineryUtilities.centerFrameOnScreen( chart );        
       chart.setVisible( true ); 
    }

}
