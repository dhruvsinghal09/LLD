public enum Category {

    SILVER(100),
    GOLD(120),
    DIAMOND(150);

    private int price;

    Category(int price) {
        this.price = price;
    }
}
