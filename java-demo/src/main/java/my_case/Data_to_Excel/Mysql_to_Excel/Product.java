package my_case.Data_to_Excel.Mysql_to_Excel;

public class Product {

    private Integer id;
    private String name;
    private Double price;
    private Integer total;

    public Product() {
    }

    public Product(Integer id, String name, Double price, Integer total) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getTotal() {
        return total;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
