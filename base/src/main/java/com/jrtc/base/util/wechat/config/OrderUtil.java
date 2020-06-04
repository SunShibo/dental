package com.jrtc.base.util.wechat.config;

import com.jrtc.base.util.wechat.WXPayUtil;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wang bin
 * @date: Created in 12:03 2019/9/5
 */
public class OrderUtil {

    /**
     * 生成订单号
     * @return
     */
    public static String getNumber(){
        StringBuffer stringBuffer = new StringBuffer();
        Date t = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        stringBuffer.append(df.format(t));
        int ran  = (int)((Math.random()*9+1)*100000);
        stringBuffer.append(String.valueOf(ran));
        return stringBuffer.toString();
    }

    //将InputStream转换为Map
    public static Map<String, String> inStreamToMap(InputStream inStream)  {
        int _buffer_size = 1024;
        Map<String, String> resultMap = new HashMap<String, String>();
        try {
            if (inStream != null) {
                ByteArrayOutputStream outStream = new ByteArrayOutputStream();
                byte[] tempBytes = new byte[_buffer_size];
                int count = -1;
                while ((count = inStream.read(tempBytes, 0, _buffer_size)) != -1) {
                    outStream.write(tempBytes, 0, count);
                }
                tempBytes = null;
                outStream.flush();
                //将流转换成字符串
                String result = new String(outStream.toByteArray(), "UTF-8");
                //将字符串解析成MAP
                resultMap = WXPayUtil.xmlToMap(result);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultMap;
    }

    //转换金额 有 1.00 转为 100分
    public static String totalFee(BigDecimal price) {
        BigDecimal setScale = price.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        System.out.println(setScale);
        String str = setScale.multiply(new BigDecimal("100")).toString();
        BigDecimal b = new BigDecimal(str.substring(0, str.length() - 3));
        return b.toString();
    }
}
