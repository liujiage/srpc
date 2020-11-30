package org.jiage.srpc.server.list;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Ignore
public class ListObjectTest {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Test
    public void setValueTest(){
        ListObjectTest o = new ListObjectTest();
        o.setValue("value");
        resetValue(new ArrayList<>(Arrays.asList(o)));
        System.out.println(o.getValue());
    }

    public static void resetValue(List<ListObjectTest> list){
        list.stream().forEach(o->{
            o.setValue("reset value");
        });
    }
}
