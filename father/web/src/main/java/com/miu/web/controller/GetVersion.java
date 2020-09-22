package com.miu.web.controller;
import com.miu.service.MongoService;
import com.miu.web.meiju.GradeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetVersion {

    @Value("${versionUrl}")
    private String versionUrl;

    @Autowired
    private MongoService mongoService;

    @RequestMapping("/getVersion")
    @ResponseBody
    public String getVersion() throws Exception {
        System.out.println("versionUrl:" + versionUrl);
        return versionUrl;
    }

    /**
     * 是否是windows系统
     *
     * @return
     */
    private static boolean isWindows() {
        String osName = System.getProperty("os.name");
        if (osName != null && osName.toLowerCase().indexOf("win") >= 0) {
            return true;
        }
        return false;
    }

    @RequestMapping("/testOne")
    @ResponseBody
    public void test() throws InterruptedException {
        System.out.println("测试");
//        mongoService.insert();
//        mongoService.findAll();
//        System.out.println(GradeEnum.HIGH.getSchool());
        //new TestSchedule().test();
    }
}



