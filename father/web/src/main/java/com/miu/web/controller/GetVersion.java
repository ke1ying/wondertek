package com.miu.web.controller;



import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Controller
public class GetVersion {

    @Value("${version}")
    private String version;

    @RequestMapping("/getVersion")
    @ResponseBody
    public void getVersion() throws Exception {
        String rootPath = System.getProperty("user.dir");
        MavenXpp3Reader reader = new MavenXpp3Reader();
        String myPom = rootPath + File.separator + "pom.xml";
        Model model = reader.read(new FileReader(myPom));
        String versionT = model.getVersion();//获取版本号
        System.out.println("version:"+versionT);

        System.out.println(version);
    }

}
