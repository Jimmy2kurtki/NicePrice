package com.lessons.niceprice;

import java.util.ArrayList;

public class SortArray {
    private final ArrayList<String> stringsForLv;
    private final ArrayList<Double> doublesForLv;

    public SortArray(ArrayList<String> stringsForLv, ArrayList<Double> doublesForLv){
        this.stringsForLv = stringsForLv;
        this.doublesForLv = doublesForLv;
    }

    public ArrayList<String> sort(){
        int n = stringsForLv.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (doublesForLv.get(j) > doublesForLv.get(j+1)) {

                    double temp = doublesForLv.get(j);
                    doublesForLv.set(j, doublesForLv.get(j+1));
                    doublesForLv.set(j+1, temp);

                    String string = stringsForLv.get(j);
                    stringsForLv.set(j,stringsForLv.get(j+1));
                    stringsForLv.set(j+1,string);
                }
            }
        }
        return stringsForLv;
    }
}
