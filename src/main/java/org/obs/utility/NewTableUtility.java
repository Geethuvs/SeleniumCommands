package org.obs.utility;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewTableUtility {
    public static List<ArrayList<String>> getDynamicTableDetails(List<WebElement> rowElements, List<WebElement> columnElements) {

     int rowSize=rowElements.size();
     int columnSize= 4*rowSize;
        String[] columnList = new String[columnSize / rowSize];
        List<ArrayList<String>> gridData = new ArrayList<ArrayList<String>>();
        int x = 1;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnList.length; j++) {
                columnList[j] = columnElements.get(x).getText();
                x++;
            }
            x=x+2;
            gridData.add(new ArrayList<String>(Arrays.asList(columnList)));
        }
        return gridData;
    }
}
