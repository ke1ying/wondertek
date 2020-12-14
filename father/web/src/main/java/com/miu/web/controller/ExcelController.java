package com.miu.web.controller;

import com.miu.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ExcelController {

    @Autowired
    private ExcelService excelService;


    @RequestMapping("/excelLogin")
    public ModelAndView exelD() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("excel");
        return mv;
    }

    @RequestMapping("/uploadFile")
    @ResponseBody
    public boolean uploadFile(@RequestParam(value="file",required = false) MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();

        try {
            a = excelService.batchImport(fileName, file);
        } catch (Exception e) {
            System.out.println("下载失败："+e.getMessage());
            e.printStackTrace();
        }
        return a;
    }
}
