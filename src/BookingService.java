import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
public class BookingService {

    //reserverSeat() - reserve -> checkout
    //payment() -> payment karega
    //BookingConfirmation(payment,booking) -> payment status -> book ticket 1000 -> 1-1-1-1-1-11
    //a1,b1,c1 -> multiple reentrants locks

    Map<Integer, ReentrantLock> lockManager = new HashMap<>();

    public Booking reserveSeat(Show show, List<ShowSeat> reserveSeats, String userId){

        List<ShowSeat> seats = reserveSeats.stream()
                .sorted(Comparator.comparing(s->s.getSeat().getSeatId()))
                .toList();
        List<ReentrantLock> locks = new ArrayList<>();
        try{
            for(ShowSeat seat:seats){
                ReentrantLock lock = lockManager.computeIfAbsent(seat.getSeat().getSeatId(),r->new ReentrantLock());
                if(!lock.tryLock()){
                    throw new RuntimeException("Seat Already Locked");
                }
                lock.lock();
                locks.add(lock);
            }

            for(ShowSeat seat:seats){
                if(seat.getStatus().equals(SeatStatus.BOOKED)){
                    throw new RuntimeException("Seat Already Booked");
                }
            }

            for(ShowSeat seat:seats){
                seat.setStatus(SeatStatus.LOCKED);
                seat.setLockedBy(userId);
                seat.setExpiry(LocalDateTime.now().plusMinutes(5));
            }

            //Booking booking = new Booking(seats,userId);
            return booking;
            //booking -> show, reservedSeats, bookingid, status(Processing,Cancelled,Completed), userId, expiryTime
        }finally {
            for(ReentrantLock lock:locks){
                lock.unlock();;
            }
        }
    }

    /*public Payment payment(Booking booking){
        //payment done
        //payment update status
        return payment;
    }*/

    //BookingConfirmation(payment,booking)
}