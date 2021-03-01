package my_case.Data_to_Excel.Mysql_to_Excel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Demo {

    /**
     * 从excel表格中读取数据储存到mysql中
     *
     * @throws Exception
     */
    @Test
    public void excelToMysql() throws Exception {

        XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\myy\\Desktop\\java-demo\\src\\main\\java\\my_case\\" +
                "Data_to_Excel\\Mysql_to_Excel\\work1.xlsx");
        XSSFSheet sheet = book.getSheetAt(0);


        int lastRowNum = sheet.getLastRowNum();

        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);

            //差评
            Integer id = (int) row.getCell(0).getNumericCellValue();
            String name = row.getCell(1).getStringCellValue();
            Double price = row.getCell(2).getNumericCellValue();
            Integer total = (int) row.getCell(3).getNumericCellValue();

            list.add(new Product(id, name, price, total));

        }

        //升序
        list.sort((o1, o2) -> o1.getId() > o2.getId() ? 1 : -1);
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getId() == list.get(i + 1).getId()) {
                throw new Exception("表格中商品编号不可重复!");

            }
        }


        //存入数据库
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        mapper.insertSome(list);
        //sqlSession.commit();

        sqlSession.close();
        book.close();

    }

    /**
     * 从Mysql读取数据生成xlsx文件
     */
    @Test
    public void mysqlToExcel() throws IOException {
        //取出
        InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = factory.openSession();
        ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
        List<Product> list = mapper.selectAll();

        if (list.size() > 0) {
            //生成表格
            XSSFWorkbook book = new XSSFWorkbook();
            XSSFSheet sheet = book.createSheet("产品清单");

            XSSFRow headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("商品编号");
            headRow.createCell(1).setCellValue("商品名称");
            headRow.createCell(2).setCellValue("商品价格(单位:元/斤)");
            headRow.createCell(3).setCellValue("商品库存数量(单位:吨)");

            for (int i = 0; i < list.size(); i++) {
                XSSFRow row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(list.get(i).getId());
                row.createCell(1).setCellValue(list.get(i).getName());
                row.createCell(2).setCellValue(list.get(i).getPrice());
                row.createCell(3).setCellValue(list.get(i).getTotal());
            }
            book.write(new FileOutputStream(new File("C:\\Users\\myy\\Desktop\\java-demo\\" +
                    "src\\main\\java\\my_case\\Data_to_Excel\\Mysql_to_Excel\\work2.xlsx")));
            book.close();
        }


    }
}



















