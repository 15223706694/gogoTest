
import java.util.Map;

import com.dsk.acc.openapi.api.AccClient;
import com.dsk.acc.openapi.client.Config;
import com.dsk.acc.openapi.client.util.CommonUtils;

//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import lombok.extern.slf4j.Slf4j;

/**
 * 开放平台SDK请求工具样例
 * @author zhaowei 2021年9月2日
 */
//@Slf4j
//@Component
public class DemoAccClientUtil {
    //Spring项目可通过@Component setAccessKeyId方法注入
    private static String accessKeyId = "5yrUTFO7DwD7jglCAZDUbJeANLM4zcn8";
    //Spring项目可通过@Component setAccessSecret方法注入
    private static String accessSecret = "KCwg3fMOPNfIa620GpEOzwtkJCLYh9Rv";

        //红杉资本
//    private static String accessKeyId = "6WNllLNroBdfnr67o213wOJ1mJt5TVO3";
//    //Spring项目可通过@Component setAccessSecret方法注入
//    private static String accessSecret = "QeulJwlGnGZ3qpiGCMWf9f5IdCCi430T";

//    //薯片
//    private static String accessKeyId = "3388c41af769489beadc1254040f8197";
//    //Spring项目可通过@Component setAccessSecret方法注入
//    private static String accessSecret = "dpzkrtnc0ngNNzkLUKrZUXxKyLJ5piJ3";

    //测试
//    private static String accessKeyId = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
//    //Spring项目可通过@Component setAccessSecret方法注入
//    private static String accessSecret = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    /**
     * <b>application/json请求</b>
     * @param path 请求路径
     * @param bodyMap 参数体
     * @return
     */
    public static Map<String,Object> requestBody(String path, Map<String, Object> bodyMap){
        return request(path, bodyMap, "json");
    }

    /**
     * <b>application/x-www-form-urlencoded请求</b>
     * @param path 请求路径
     * @param bodyMap 参数体
     * @return
     */
    public static Map<String,Object> requestForm(String path, Map<String, Object> bodyMap){
        return request(path, bodyMap, "form");
    }

    /**
     * <b>开放平台统一请求</b>
     * @param path 请求路径
     * @param bodyMap 参数体
     * @param reqBodyType 请求格式
     * @return
     */
    public static Map<String,Object> request(String path, Map<String, Object> bodyMap, String reqBodyType){
        try {
            //47.104.238.59 线上地址
            AccClient.init(new Config(accessKeyId, accessSecret).setEndpoint("47.104.238.59:8766").setProtocol("HTTP"));

            //测试中台
//            AccClient.init(new Config(accessKeyId, accessSecret).setEndpoint("120.27.13.145:8766").setProtocol("HTTP"));

            //沙盒
//            AccClient.init(new Config(accessKeyId, accessSecret).setEndpoint("sandbox.openapi.jiansheku.com"));
            Map<String, ?> res = AccClient.request(reqBodyType, path, bodyMap);
            if(!res.containsKey("headers") || !res.containsKey("body")) {
                throw new RuntimeException(String.format("请求无返回:path=%s",path));
            }
            Object resBody = res.get("body");
            if(resBody == null) {
                return null;
            }
            return CommonUtils.assertAsMap(resBody);
        } catch (Exception e) {
            throw new RuntimeException(String.format("请求异常:path=%s,err=%s",path,e.getMessage()));
        }
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }
    //	@Value("${dsk-acc.open.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        DemoAccClientUtil.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }
    //	@Value("${dsk-acc.open.accessSecret}")
    public void setAccessSecret(String accessSecret) {
        DemoAccClientUtil.accessSecret = accessSecret;
    }

}