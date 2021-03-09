package org.jiage.srpc.server.array;

import org.junit.Test;

import java.util.Arrays;

class Value{
    public Value(int id) {
        this.id = id;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

public class SortTest {

    @Test
    public void test(){
        Integer[] data = new Integer[]{1,4,3,6,2};
        System.out.println(unique2(data));
        System.out.println(unique(data));
    }

    public static boolean unique(Integer[] data){
        int n = data.length;
        Integer[] temp = Arrays.copyOf(data,n);
        for(int i=0; i<n; i++)
            for(int j=i+1; j<n; j++)
                if(temp[i] == temp[j])
                    return false;
        return true;
    }

    public static boolean unique2(Integer[] data){
        int n = data.length;
        Integer[] temp = Arrays.copyOf(data,n);
        //Arrays.sort(temp, Collections.reverseOrder());
        Arrays.sort(temp);
        for(int i=0; i<n-1; i++)
            if(temp[i] == temp[i+1])
                return false;
        return true;
    }
}
