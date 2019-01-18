package org.jiage.srpc.server.messagepack;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;
import org.msgpack.type.Value;
import org.msgpack.unpacker.Converter;

import java.util.ArrayList;
import java.util.List;

public class SimpleTest {

    public static void main(String[] args) throws Exception {
        toObj();
    }

    private static void toObj() throws Exception{
        SimpleVO simpleVO = new SimpleVO(33,"test");
        MessagePack msgpack = new MessagePack();
        msgpack.register(SimpleVO.class);
        byte[] raw = msgpack.write(simpleVO);
        SimpleVO res = msgpack.read(raw,SimpleVO.class);
        System.out.println(res.getAge() + " - " + res.getName());
    }

    private static void  toList() throws Exception{
        // Create serialize objects.
        List<String> src = new ArrayList<String>();
        src.add("msgpack");
        src.add("kumofs");
        src.add("viver");
        MessagePack msgpack = new MessagePack();
        // Serialize
        byte[] raw = msgpack.write(src);
        // Deserialize directly using a template
        System.out.println("test 1");
        List<String> dst1 = msgpack.read(raw, Templates.tList(Templates.TString));
        System.out.println(dst1.get(0));
        System.out.println(dst1.get(1));
        System.out.println(dst1.get(2));
        // Or, Deserialze to Value then convert type.
        System.out.println("test 2");
        Value dynamic = msgpack.read(raw);
        List<String> dst2 = new Converter(dynamic)
                .read(Templates.tList(Templates.TString));
        System.out.println(dst2.get(0));
        System.out.println(dst2.get(1));
        System.out.println(dst2.get(2));
        System.out.println("test 3");
        List dst3 = new Converter(msgpack.read(raw)).read(Templates.tList(Templates.TString));
        dst3.stream().forEach(System.out::println);
    }
}
