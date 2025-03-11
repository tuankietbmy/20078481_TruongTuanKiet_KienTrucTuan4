package bai2;
import java.util.ArrayList;
import java.util.List;

// Component Interface (Sản phẩm và Bàn đều kế thừa)
interface Component {
    double getPrice();
}

// Leaf Class (Sản phẩm đơn lẻ)
class Product implements Component {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

// Composite Class (Bàn, chứa nhiều sản phẩm)
class Table implements Component {
    private List<Component> items = new ArrayList<>();

    public void add(Component item) {
        items.add(item);
    }

    public void remove(Component item) {
        items.remove(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (Component item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

// Composite Class (Quán cà phê, chứa nhiều bàn)
class Cafe {
    private List<Table> tables = new ArrayList<>();

    public void addTable(Table table) {
        tables.add(table);
    }

    public void removeTable(Table table) {
        tables.remove(table);
    }

    public double getTotalRevenue() {
        double total = 0;
        for (Table table : tables) {
            total += table.getPrice();
        }
        return total;
    }
}

// Main Class
public class Bai2 {
    public static void main(String[] args) {
        // Tạo sản phẩm
        Product coffee = new Product("Cà phê", 25000);
        Product tea = new Product("Trà sữa", 30000);
        Product water = new Product("Nước suối", 10000);

        // Tạo bàn và thêm sản phẩm
        Table table1 = new Table();
        table1.add(coffee);
        table1.add(tea);

        Table table2 = new Table();
        table2.add(water);
        table2.add(coffee);
        table2.add(tea);

        // Tạo quán cà phê
        Cafe cafe = new Cafe();
        cafe.addTable(table1);
        cafe.addTable(table2);

        // Hiển thị doanh thu
        System.out.println("Tổng doanh thu của quán cà phê: " + cafe.getTotalRevenue() + " VND");
    }
}
