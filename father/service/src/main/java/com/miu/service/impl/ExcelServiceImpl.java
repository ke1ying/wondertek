package com.miu.service.impl;

import com.miu.service.ExcelService;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

@Service
public class ExcelServiceImpl implements ExcelService {
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
        int indexID = 341;
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;//创建工作簿
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);//创建表
        if(sheet!=null){
            notNull = true;
        }

        int totalRows=sheet.getLastRowNum();//得到表的最后行数（总行数）
        // System.out.println("rowNum="+totalRows);
//        List<SchoolTask> userList = new ArrayList<SchoolTask>();
        String[] strs = new String[8];
        Row rowtitle=sheet.getRow(0);//得到表下标为0的第一行
        System.out.println(rowtitle.getLastCellNum());//得到表的总列数
//        for(int y=1;y<rowtitle.getLastCellNum();y++) {
//            strs[y-1]=getValue(rowtitle.getCell(y));//把标题放进数组
//        }


        String subjectName=fileName.substring(0,fileName.lastIndexOf("."));
        for (int r = 1; r <= totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            String POSITION = getValue(row.getCell(0));//得到下标为0的第一列的所有值
            String CLICKNAME = getValue(row.getCell(1));//
            String str = "INSERT INTO DATAU_CLICK_POSITION (id,POSITION,CLICKNAME) VALUES('"+indexID+"','"+POSITION+"','"+CLICKNAME+"');";
            System.out.println(str);
            indexID++;
        }


//        for (SchoolTask userResord : userList) {
//            String school = userResord.getSchoolName();
//            String subject = userResord.getSubjectName();
//            schoolTaskDao.deleteBySS(school,subject);
//        }
//        for (SchoolTask userResord : userList) {
//            schoolTaskDao.save(userResord);
//        }
        return notNull;
    }

    private String getValue(Cell cell) {
        String value = "";
        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_NUMERIC: // 数字
                //如果为时间格式的内容
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    value=sdf.format(HSSFDateUtil.getJavaDate(cell.
                            getNumericCellValue())).toString();
                    break;
                } else {
                    value = new DecimalFormat("0").format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING: // 字符串
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_BOOLEAN: // Boolean
                value = cell.getBooleanCellValue() + "";
                break;
            case Cell.CELL_TYPE_FORMULA: // 公式
                value = cell.getCellFormula() + "";
                break;
            case Cell.CELL_TYPE_BLANK: // 空值
                value = "";
                break;
            case Cell.CELL_TYPE_ERROR: // 故障
                value = "非法字符";
                break;
            default:
                value = "未知类型";
                break;
        }



        return value;

    }
}
