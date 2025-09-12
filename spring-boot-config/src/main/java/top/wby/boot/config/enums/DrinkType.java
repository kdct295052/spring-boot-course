package top.wby.boot.config.enums;

/**
 * @author YUU
 */

public enum DrinkType {
    COFFEE("咖啡",9.9),
    TEA("奶茶",6.6),
    JUICE("果汁",18.8);

   public  final String type;
   public  final double price;

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    DrinkType(String type, double price) {
        this.type = type;
        this.price = price;
    }
}
