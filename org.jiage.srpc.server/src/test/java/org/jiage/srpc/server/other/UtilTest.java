package org.jiage.srpc.server.other;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {



    //get int from one object
    public int getInt(Object obj){
        try {
            return obj == null ? 0 : (Integer) obj;
        }catch(Exception e){
            /*Do noting*/
        }
        return 0;
    }

    public static void main(String args[]){
        List<ValueVO> list = new ArrayList<>();
        list.add(new ValueVO());
        list.add(new ValueVO());
        list.stream().forEach(v->{v.setFlag(true);});
        list.stream().forEach(v->{System.out.print(v.isFlag());});
    }
}

class ValueVO{
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;


}