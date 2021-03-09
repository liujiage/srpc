package org.jiage.srpc.server.jvm;

import com.rits.cloning.Cloner;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//https://zhuanlan.zhihu.com/p/260117694
public class CloneTest {

    @Test
    public void test() throws Exception{
        CloneObj co = new CloneObj();
        CloneObj co2 = (CloneObj)co.clone();
        System.out.println(co == co2);
        System.out.println(co.subObj == co2.subObj);
        Cloner cloner = new Cloner();
        CloneObj co3 = cloner.deepClone(co);
        System.out.println(co.subObj == co3.subObj);
        System.out.println("list "+(co.list == co2.list));
        System.out.println("co.id"+ co.id + " co2.id" + co2.id + " co == co2"+ (co == co2));
        System.out.println("co"+ co + " co2" + co2);
        System.out.println("co.subObj "+ co.subObj + " co2.subObj " + co2.subObj);
        System.out.println("co.id.subObj"+ co.subObj.id + " co2.id.subObj" + co2.subObj.id + " co == co2"+ (co == co2));

    }

    @Test
    public void test2() throws Exception{
        List<CloneObj> list = new ArrayList<>();
        for(int i=0; i<10000; i++){
            list.add(new CloneObj());
        }
        long start = System.currentTimeMillis();
        List<CloneObj> list2 = deepCopy(list);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test3() throws Exception{
        List<CloneObj> list = new ArrayList<>();
        for(int i=0; i<10000; i++){
            list.add(new CloneObj());
        }
        long start = System.currentTimeMillis();
        Cloner cloner = new Cloner();
        List<CloneObj> list2 = cloner.deepClone(list);
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test4() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CloneObj2 cc = new CloneObj2();
        Class ac = cc.getClass();

        System.out.println(ac.getSuperclass());
        for(Method m : ac.getMethods()){
            System.out.println("m: "+m.getName());
        }
        Method m = ac.getMethod("getTest");
        String s = (String)m.invoke(cc);
        System.out.print(s);
    }

    public void test5() {
        Object list = new ArrayList();
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        List<T> dest = (List)in.readObject();
        return dest;
    }
}

class CloneObj implements Cloneable, Serializable{
    String id = new String("1111");
    CloneSubObj subObj = new CloneSubObj();
    List<String> list = new ArrayList<>();
    public Object clone() throws CloneNotSupportedException {
        CloneObj obj = (CloneObj)super.clone();
        //obj.subObj = (CloneSubObj)subObj.clone();
        list = new ArrayList<>(list);
        return obj;
    }
    public Object getTest(){
        return "ok";
    }
}
class CloneObj2 {
    public Object getTest(){
        return "ok";
    }
}
class CloneSubObj implements Cloneable,Serializable {
    String id = new String("222222");
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
