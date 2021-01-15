package com.lyao.net;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * @author lyao
 * @date 2019/12/30 16:55
 * @description
 */
public class HttpTest {

    public static void main(String[] args) throws Exception{
        URL url = null;
        HttpURLConnection urlConn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        String sLine = null;
        StringBuilder sbBuf = new StringBuilder();
        try
        {
            url = new URL("http://192.168.1.168:8082/openetc/busiportal/etccardcancelapply");
            urlConn = (HttpURLConnection)url.openConnection();
            urlConn.setRequestMethod("POST");
            urlConn.setConnectTimeout(30000);
            urlConn.setReadTimeout(30000);
            urlConn.setDoInput(true);
            urlConn.setDoOutput(true);
            urlConn.setUseCaches(false);
            urlConn.setRequestProperty("Content-Type", "application/text;charset=UTF-8");
            out = new PrintWriter(new OutputStreamWriter(urlConn.getOutputStream(), "UTF-8"));
            out.println("openid=f809017b7e836d1a&business=value1&signdata=value2");
            out.flush();
            out.close();
            in = new BufferedReader(new InputStreamReader(urlConn.getInputStream(), "UTF-8"));
            while ((sLine = in.readLine()) != null)
            {
                sbBuf.append(sLine).append("\n");
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally
        {
            if (out != null)
            {
                out.close();
                out = null;
            }

            if (in != null)
            {
                in.close();
                in = null;
            }

            if (urlConn != null)
            {
                urlConn.disconnect();
                urlConn = null;
            }
        }
        System.out.println((sbBuf == null) ? "0" : sbBuf.toString());
    }

}
