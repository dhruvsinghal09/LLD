import java.util.List;

public class Theatre {

    private int theatreId;
    private String threatreName;
    private List<Show> shows;
    private String city;
    private String address;

    public Theatre(int theatreId, String threatreName, List<Show> shows, String city, String address) {
        this.theatreId = theatreId;
        this.threatreName = threatreName;
        this.shows = shows;
        this.city = city;
        this.address = address;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public String getThreatreName() {
        return threatreName;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public void addShows(Show show){
        this.shows.add(show);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
