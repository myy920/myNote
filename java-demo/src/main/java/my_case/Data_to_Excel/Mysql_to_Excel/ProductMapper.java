package my_case.Data_to_Excel.Mysql_to_Excel;

import java.util.List;

public interface ProductMapper {

    int insertSome(List<Product> list);

    List<Product> selectAll();
}
