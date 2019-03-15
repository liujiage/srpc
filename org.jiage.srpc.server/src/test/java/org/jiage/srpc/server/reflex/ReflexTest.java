package org.jiage.srpc.server.reflex;

import org.jiage.srpc.api.message.vo.ProtocolVO;
import org.jiage.srpc.api.message.vo.RequestVO;
import org.jiage.srpc.api.message.vo.ResponseVO;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Ignore
public class ReflexTest {

    @Test
    public void reflexObjTest() throws Exception{
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData("test");
        System.out.println(ReflexTest.getClassValue(responseVO));
        System.out.println(ReflexTest.getClassValue(new ProtocolVO()));
        System.out.println(ReflexTest.getClassValue(new RequestVO("test")));
    }

    public static String getClassValue(Object target){
        final String methodName = "getData";
        if(target == null) return null;
        try {
            Method m = target.getClass().getMethod(methodName);
            Object o = m.invoke(target);
            if(o instanceof String){
                return (String)o;
            }
        }catch(NoSuchMethodException m){
            return null;
        }catch(Exception e) {
            return null;
        }
        return null;
    }

}
