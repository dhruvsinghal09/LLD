package MovieBookingSystem;

import java.time.LocalDateTime;

public class ShowSeat {

    private Show show;
    private Seat seat;
    private SeatStatus status;
    private String lockedBy;
    private LocalDateTime expiry;

    public ShowSeat(Show show, Seat seat, SeatStatus status) {
        this.show = show;
        this.seat = seat;
        this.status = status;
    }

    public Show getShow() {
        return show;
    }

    public Seat getSeat() {
        return seat;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public void setLockedBy(String lockedBy) {
        this.lockedBy = lockedBy;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }
}

//entities completed