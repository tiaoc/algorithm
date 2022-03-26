package com.toOffer02;

import java.util.ArrayList;

public class code62 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int index=0;
        while(list.size()!=1){
            index+=m-1;
            index=index%list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
