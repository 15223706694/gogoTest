import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 开放平台SDK调用样例
 * @author zhaowei 2021年9月2日
 */
public class Demo2 {

    public static void main(String[] args) {
        Map<String, Object> jsonParam = null;
        Map<String,Object> res = null;
        //调用样例1 reqestBody方式
        jsonParam = new HashMap<String, Object>();
        jsonParam.put("cid", "11627");
        jsonParam.put("pageIndex",1);
        jsonParam.put("pageSize",20);
//        jsonParam.put("category","");
//        jsonParam.put("card","5102151965******1X");
//        jsonParam.put("type","6");
        res = DemoAccClientUtil.requestForm("/jsk/company/honor/upgrade", jsonParam);
        System.out.println(JSON.toJSONString(res));

//        //调用样例1
//        jsonParam = new HashMap<String, Object>();
//        jsonParam.put("creditCode", "915000002028257485");
//        res = DemoAccClientUtil.request("/jsk/project/bidByCompany", jsonParam,null);
//        System.out.println(res.toString());
//
//        //调用样例1
//        jsonParam = new HashMap<String, Object>();
//        jsonParam.put("companyId", "19338");
//        res = DemoAccClientUtil.requestBody("/company/control/fengXian", jsonParam);
//        System.out.println(res.toString());

        String s = ",江西省住房和城乡建设厅,湖南省建筑市场监管公共服务平台,新疆工程建设云,重庆建设工程信息网";
        String a = s.substring(1);
        System.out.println(a);

    }
}
