package org.jiage.srpc.server.file;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteFileTest {

    /* */

    private String PATH = "/Users/liujiage/Desktop/users.txt";
    private Gson GSON = new Gson();
    @Test
    public void write() throws Exception{
        Path path = Paths.get(PATH);
        //get users from database
        List<ExportUser> list = getData();
        //export all of users
        try (BufferedWriter writer = Files.newBufferedWriter(path))
        {
            list.stream().filter(v->v!=null && v.getDeveloper_id()!=null).forEach(o->{
                try {
                    writer.write(GSON.toJson(o, ExportUser.class)+"\n");
                }catch(Exception e){
                    System.out.println("error user id "+o.getDeveloper_id());
                }
            });

        }
    }


    @Test
    public void export(){
        ExportUser exportUser = new ExportUser(123,
                System.currentTimeMillis(),"1","SA");
        String s = GSON.toJson(exportUser,ExportUser.class);
    }

    //get test data
    public static List<ExportUser> getData(){
        List<ExportUser> list = new ArrayList<ExportUser>();
        for(int i=0; i<10; i++){
            list.add(new ExportUser(123,
                    System.currentTimeMillis(),String.valueOf(i),"SA"));
        }
        return list;
    }


}
