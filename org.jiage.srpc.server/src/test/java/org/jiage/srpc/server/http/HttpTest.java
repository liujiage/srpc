package org.jiage.srpc.server.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;


public class HttpTest {
    //https://square.github.io/okhttp/
    private static OkHttpClient client = new OkHttpClient();
    private static String url = "https://appleid.apple.com/auth/keys";

    @Test
    public void getTest() throws Exception {
        System.out.println(get(url));
    }

    public static String  get(String url) throws Exception{
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
