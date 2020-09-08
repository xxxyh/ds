package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestUpload {

    public static final String MEDIA_URL = "C:\\Users\\admin\\Desktop\\信鸽随访操作.mp4";

    public static String uploadPermanentMaterial(String accessToken, File file, String type, String title, String introduction) throws IOException {

        String url = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token="
                + accessToken + "&type=" + type;

        String result = null;

        try {
            URL uploadURL = new URL(url);

            HttpURLConnection conn = (HttpURLConnection) uploadURL.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Cache-Control", "no-cache");
            String boundary = "-----------------------------" + System.currentTimeMillis();
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            OutputStream output = conn.getOutputStream();
            output.write(("--" + boundary + "\r\n").getBytes());
            output.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"%s\"\r\n", file.getName()).getBytes());
            output.write("Content-Type: video/mp4 \r\n\r\n".getBytes());

            byte[] data = new byte[1024];
            int len = 0;
            FileInputStream input = new FileInputStream(file);
            while ((len = input.read(data)) > -1) {
                output.write(data, 0, len);
            }

            /*对类型为video的素材进行特殊处理*/
            if ("video".equals(type)) {
                output.write(("--" + boundary + "\r\n").getBytes());
                output.write("Content-Disposition: form-data; name=\"description\";\r\n\r\n".getBytes());
                output.write(String.format("{\"title\":\"%s\", \"introduction\":\"%s\"}", title, introduction).getBytes());
            }

            output.write(("\r\n--" + boundary + "--\r\n\r\n").getBytes());
            output.flush();
            output.close();
            input.close();

            InputStream resp = conn.getInputStream();

            StringBuffer sb = new StringBuffer();

            while ((len = resp.read(data)) > -1)
                sb.append(new String(data, 0, len, "utf-8"));
            resp.close();
            result = sb.toString();
        } catch (IOException e) {
            //....
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        String accessToken = "35_u7_8ucnr_YcKIsEPfbF0rpaeuYlvqIdLGV1y5jNKGlwyn9FTqNhKL8Ka74g3iAInPXTvIdC12L8FUNBhOqn1-v0WIw9PMbX5EY7qR21x9q_e-3lWWi5rPLocvEb7UvbiLEvm38ESErAaR-5IOTReAHAHMK";
        File file = new File(MEDIA_URL);
        String result = uploadPermanentMaterial(accessToken, file, "video", "测试title", "测试introduction");
        System.out.println(result);
    }
}
