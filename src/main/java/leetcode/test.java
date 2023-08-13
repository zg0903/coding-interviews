package leetcode;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhuguang
 * @Project_name coding-interviews
 * @Package_name leetcode
 * @date 2022-10-24-22:30
 * @Desc:
 */
public class test {


    private static String SEARCH_INTERFACE_URL = "https:\\\\//suggest.videos.iqiyi.com/?if=mobile&key=";

    private static String generateUrl(String searchParam) throws UnsupportedEncodingException {
        StringBuilder url = new StringBuilder(SEARCH_INTERFACE_URL);
        if (searchParam != null) {
            url = url.append(searchParam);
        }

        String urls = URLEncoder.encode(url.toString(), "UTF-8");
        System.out.println(urls);
        return urls;
    }




    public static void main(String[] args) throws UnsupportedEncodingException {


        String aaa = test.generateUrl("aaa");
        System.out.println(aaa);


    }

//    https://suggest.videos.iqiyi.com/?if=mobile&key=%E5%A5%A5%E7%89%B9%E6%9B%BC
}