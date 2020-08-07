package com.miu.web.controller;


import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@Controller
public class GetVersion {

    @Value("${url}")
    private String URL;

    @Value("${versionUrl}")
    private String versionUrl;

    @RequestMapping("/getVersion")
    @ResponseBody
    public String getVersion() throws Exception {
        System.out.println("versionUrl:" + versionUrl);
        return versionUrl;
    /*    String rootPath = System.getProperty("user.dir");
        System.out.println("rootPath:" + rootPath);
        MavenXpp3Reader reader = new MavenXpp3Reader();
        String myPom = rootPath + File.separator + "pom.xml";
        System.out.println("myPom:" + myPom);
        Model model = reader.read(new FileReader(myPom));
        String versionT = model.getVersion();//获取版本号
        System.out.println("version:" + versionT);*/
        //查看jar包里面pom.properties版本号
      /*  String jarPath = GetVersion.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        jarPath = java.net.URLDecoder.decode(jarPath, "UTF-8");
        System.out.println("jarPath:" + jarPath);
        try {
            URL url = new URL("jar:file:" + jarPath + "!/META-INF/maven/com.miu/web/pom.properties");
            System.out.println("url:" + url);
            InputStream inputStream = url.openStream();
            Properties properties = new Properties();
            properties.load(inputStream);
            String version = properties.getProperty("version");
            System.out.println("version:" + version);
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            //开发过程中查看pom.xml版本号
            MavenXpp3Reader reader = new MavenXpp3Reader();
            String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            if (isWindows() && basePath.startsWith("/")) {
                basePath = basePath.substring(1);
            }
            if (basePath.indexOf("/target/") != -1) {
                basePath = basePath.substring(0, basePath.indexOf("/target/"));
            }
            Model model = reader.read(new FileReader(new File(basePath + "\\pom.xml")));
            String version = model.getVersion();
            return version;
        }*/
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

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        for (Object propert : properties.keySet()) {
            System.out.println(propert +"====="+ properties.get(propert));
        }
    }
}



