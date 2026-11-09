package MovieBookingSystem;

public class Seat {

    private int seatId;
    private Category category;

    public Seat(int seatId, Category category) {
        this.seatId = seatId;
        this.category = category;
    }

    public int getSeatId() {
        return seatId;
    }

    public Category getCategory() {
        return category;
    }
}