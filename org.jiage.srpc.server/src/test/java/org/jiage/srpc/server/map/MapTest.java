package org.jiage.srpc.server.map;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.WeakHashMap;

public class MapTest {

    int id;
    String name;

    public MapTest(){

    }

    public MapTest(int id,String name){
        this.id = id;
        this.name = name;
    }

    public static void main(String args[]) throws Exception{
        Map map = new Hashtable();
        //map.put(null,"");
        //System.out.println(map);
        Map map2 = new HashMap();
        map2.put("2",null);
        map2.put(null,null);
        map2.get("2");
        System.out.println(map2);
        Map weakHashMap = new WeakHashMap();
        weakHashMap.put("1","test");
        System.out.println("weak map: "+weakHashMap.get("1"));
        MapTest car = new MapTest(22000,"silver");
        WeakReference<MapTest> weakCar = new WeakReference<MapTest>(car);
        System.gc(); //can't immediately action
        System.out.println("after gc weak map: "+weakHashMap.get("1"));
        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();
        System.out.println(heapMemoryUsage.getUsed() /1000);
        for(int i=0; i<10000000; i++){
            System.out.println(heapMemoryUsage.getUsed() /1000);
            map2.put(i,new MapTest(i,"testname"));
        }
    }

    @Test
    public void test2(){

    }
}
