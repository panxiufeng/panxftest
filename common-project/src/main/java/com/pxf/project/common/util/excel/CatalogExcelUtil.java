
package com.pxf.project.common.util.excel;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Comment;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @author panxiufeng
 * @version Id: CatalogExcelUtil.java, v 0.1 2018/11/20 18:15 panxiufeng Exp $$
 */
public class CatalogExcelUtil {

    /**
     * 创建Workbook
     *
     * @param in
     * @return
     * @throws Exception
     */
    public static Workbook createWorkBook(InputStream in) throws Exception {
        try {
            return new HSSFWorkbook(in);
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * 获取单单元格字符串值
     *
     * @param cell
     * @return
     */
    public static String getCellStringValue(Cell cell) {
        if (cell == null) {
            return "";
        }

        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
        RichTextString str = cell.getRichStringCellValue();
        return str.getString();
    }

    /**
     * 初始化Excel单元格, 设置单元格值和样式
     *
     * @param cell
     * @param style
     * @param value
     */
    public static void initCell(Cell cell, CellStyle style, String value) {
        cell.setCellStyle(style);
        cell.setCellValue(value);
    }

    /**
     * 初始化Excel单元格, 设置单元格值、样式和备注
     *
     * @param cell
     * @param style
     * @param value
     * @param comment
     */
    public static void initCell(Cell cell, CellStyle style, String value, Comment comment) {
        cell.setCellStyle(style);
        cell.setCellValue(value);
        cell.setCellComment(comment);
    }

    /**
     * 获取Excel单元格备注
     *
     * @param drawing
     * @param anchor
     * @param content
     * @return
     */
    public static Comment getCellComment(Drawing drawing, HSSFClientAnchor anchor, String content) {
        Comment comment = drawing.createCellComment(anchor);
        comment.setString(new HSSFRichTextString(content));
        return comment;
    }

    /**
     * 获取Excel标题单元格样式
     *
     * @param wb
     * @return
     */
    public static CellStyle getHeadStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中

        Font font = wb.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); // 粗体
        font.setFontHeightInPoints((short) 12);//设置字体大小
        style.setFont(font);
        style.setLocked(true);
        return style;
    }

    /**
     * 获取Excel数据单元格样式
     *
     * @param wb
     * @return
     */
    public static CellStyle getBodyStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setWrapText(true);//设置自动换行
        return style;
    }

    /**
     * 获取Excel错误单元格样式
     *
     * @param wb
     * @return
     */
    public static CellStyle getErrorStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();

        Font font = wb.createFont();
        font.setColor(HSSFColor.RED.index);

        style.setFont(font);
        return style;
    }

    /**
     * @param wb HSSFWorkbook对象
     * @param realSheet 需要操作的sheet对象
     * @param datas 下拉的列表数据
     * @param startRow 开始行
     * @param endRow 结束行
     * @param startCol 开始列
     * @param endCol 结束列
     * @param hiddenSheetName 隐藏的sheet名
     * @param hiddenSheetIndex 隐藏的sheet索引
     * @return
     * @throws Exception
     */
    public static HSSFWorkbook dropDownList2003(Workbook wb, Sheet realSheet, List<String> datas, int startRow, int endRow,
                                                int startCol, int endCol, String hiddenSheetName, int hiddenSheetIndex)
            throws Exception {

        HSSFWorkbook workbook = (HSSFWorkbook) wb;
        // 创建一个数据源sheet
        HSSFSheet hidden = workbook.createSheet(hiddenSheetName);
        // 数据源sheet页不显示
//        workbook.setSheetHidden(hiddenSheetIndex, true);
        workbook.setSheetHidden(hiddenSheetIndex, false);
        // 将下拉列表的数据放在数据源sheet上
        HSSFRow row = null;
        HSSFCell cell = null;
        for (int i = 0, length = datas.size(); i < length; i++) {
            row = hidden.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(datas.get(i));
        }

        // A1 到 Adatas.length 表示第一列的第一行到datas.length行，需要与前一步生成的隐藏的数据源sheet数据位置对应
        //namedCell.setRefersToFormula(hiddenSheetName + "!$A$1:$A" + datas.length);
        // 指定下拉数据时，给定目标数据范围 hiddenSheetName!$A$1:$A5   隐藏sheet的A1到A5格的数据
        DVConstraint constraint = DVConstraint.createFormulaListConstraint(hiddenSheetName + "!$A$1:$A" + datas.size());
        CellRangeAddressList addressList = null;
        HSSFDataValidation validation = null;
        row = null;
        cell = null;
        // 单元格样式
        CellStyle style = workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);//设置自动换行
        // 循环指定单元格下拉数据
        for (int i = startRow; i <= endRow; i++) {
            row = (HSSFRow) realSheet.createRow(i);
            cell = row.createCell(startCol);
            cell.setCellStyle(style);
            addressList = new CellRangeAddressList(i, i, startCol, endCol);
            validation = new HSSFDataValidation(addressList, constraint);
            realSheet.addValidationData(validation);
        }
        return workbook;
    }



    /**
     * 测试EXCEL
     */
    /*
    @RequestMapping("/testExcel")
    public void testExcel(HttpServletResponse response, HttpSession session ) throws Exception {
        OutputStream os = null;
        // 声明一个工作薄
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("管理台用户导入模板");
        try {
            String fileName = "consoleuser_template.xls";
            response.setContentType("application/x-msdownload;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
            os = response.getOutputStream();

            // 第一行
            Row row = sheet.createRow(0);
            CellStyle style = CatalogExcelUtil.getHeadStyle(wb);
            row.setHeight((short)300);
            CatalogExcelUtil.initCell(row.createCell(0), style, "用户姓名");
            CatalogExcelUtil.initCell(row.createCell(1), style, "手机号");
            CatalogExcelUtil.initCell(row.createCell(2), style, "部门名称");
            CatalogExcelUtil.initCell(row.createCell(3), style, "登录账号");
            CatalogExcelUtil.initCell(row.createCell(4), style, "角色ID");
            //  设置宽度
            for(int i=0;i<5;i++){
                sheet.setColumnWidth(i,  (int)((30 + 0.72) * 256)); // 在EXCEL文档中实际列宽为30
            }
            // 设置部门
            ServiceResult<OrganNode> result = menuService.queryOrganTree(EnumRootId.MANAGE_ORGAN_ROOT_ID);
            List<String> orgInfoList = new ArrayList<String>();
            if(result.isSuccess()){
                List<OrganNode> listData = result.getListData();
                if(!CollectionUtils.isEmpty(listData)){
                    for(OrganNode node : listData){
                        orgInfoList.add(node.getOrganName()+" <"+node.getOrganId()+">");
                    }
                }
            }
            // 第3列的第1行到第150行单元格部门下拉 ，可替换为从数据库的部门表数据，
            // hidden_depart 为隐藏的sheet的别名，1为这个sheet的索引 ，考虑到有多个列绑定下拉列表
            wb = CatalogExcelUtil.dropDownList2003(wb, sheet, orgInfoList, 1, 150, 2, 2, "hidden_depart", 1);
            wb.write(os);
            os.flush();
        }finally{
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (wb != null) {
                try {
                    wb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

}