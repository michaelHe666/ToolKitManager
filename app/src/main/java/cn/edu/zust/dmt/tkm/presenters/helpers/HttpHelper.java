package cn.edu.zust.dmt.tkm.presenters.helpers;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.presenters.tools
 * @description $
 * @time 1/2/2020 21:05
 * copyright(c) all rights reserved by MR.M
 **/
public class HttpHelper {

    private static final String BASE_URL = "http://192.168.0.103:3030";

    public static final String REGISTER_PATH = "/account/create";
    public static final String LOGIN_PATH = "/account/login";

    /**
     * @description forbidden create by new
     */
    private HttpHelper() {
    }

    /**
     * @return null for error or string for normal
     */
    public static String postReturnString(String path, String content) {
        HttpURLConnection mHttpURLConnection = initializeHttpConnection(BASE_URL + path);

        if (mHttpURLConnection != null) {
            try {
                mHttpURLConnection.setRequestMethod("POST");
                mHttpURLConnection.setUseCaches(false);

                mHttpURLConnection.connect();

                DataOutputStream printWriter = new DataOutputStream(mHttpURLConnection.getOutputStream());
                printWriter.write(content.getBytes());
                printWriter.flush();
                printWriter.close();

                int respondCode = mHttpURLConnection.getResponseCode();
                Log.d("respondCode", "respondCode=" + respondCode);

                if (mHttpURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = mHttpURLConnection.getInputStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

                    int readCursor = 0;

                    byte[] buffer = new byte[1024];

                    while ((readCursor = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, readCursor);
                    }

                    inputStream.close();
                    outputStream.close();

                    String message = new String(outputStream.toByteArray());
                    Log.d("Respond", message);

                    mHttpURLConnection.disconnect();

                    Log.d("postSuccess", message);
                    return message;
                }

                mHttpURLConnection.disconnect();

                Log.e("PostFail", "fail to post to URL");
                return "PostFail";
            } catch (Exception e) {
                Log.e("HttpHelper", "ERROR:initializeHttpConnection:" + e.toString());
                return null;
            }
        }
        return null;
    }

    /**
     * @param mUrl target network
     * @return null for error or HttpURLConnection for normal
     */
    private static HttpURLConnection initializeHttpConnection(String mUrl) {
        try {
            URL mURL = new URL(mUrl);
            HttpURLConnection mHttpURLConnection = (HttpURLConnection) mURL.openConnection();

            //http connection settings
            mHttpURLConnection.setConnectTimeout(5000);
            mHttpURLConnection.setReadTimeout(5000);
            mHttpURLConnection.setDoInput(true);
            mHttpURLConnection.setDoOutput(true);
            mHttpURLConnection.setInstanceFollowRedirects(true);
            mHttpURLConnection.setRequestProperty("Content-Type", "application/json");

            return mHttpURLConnection;
        } catch (Exception e) {
            Log.e("HttpHelper", "ERROR:initializeHttpConnection:" + e.toString());
            return null;
        }
    }
}