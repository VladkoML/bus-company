package entity;

import java.sql.Date;
import java.util.Objects;

public class Route {

    private Long id;
    private String startOfRoute;
    private String endOfRoute;
    private Date departureDate;
    private double price;
    private Long driverID;
    private Long busID;

    public Route(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartOfRoute() {
        return startOfRoute;
    }

    public void setStartOfRoute(String startOfRoute) {
        this.startOfRoute = startOfRoute;
    }

    public String getEndOfRoute() {
        return endOfRoute;
    }

    public void setEndOfRoute(String endOfRoute) {
        this.endOfRoute = endOfRoute;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getDriverID() {
        return driverID;
    }

    public void setDriverID(Long driverID) {
        this.driverID = driverID;
    }

    public Long getBusID() {
        return busID;
    }

    public void setBusID(Long busID) {
        this.busID = busID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Double.compare(route.price, price) == 0 && Objects.equals(id, route.id) && Objects.equals(startOfRoute, route.startOfRoute) && Objects.equals(endOfRoute, route.endOfRoute) && Objects.equals(departureDate, route.departureDate) && Objects.equals(driverID, route.driverID) && Objects.equals(busID, route.busID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startOfRoute, endOfRoute, departureDate, price, driverID, busID);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startOfRoute='" + startOfRoute + '\'' +
                ", endOfRoute='" + endOfRoute + '\'' +
                ", departureDate=" + departureDate +
                ", price=" + price +
                ", driverID=" + driverID +
                ", busID=" + busID +
                '}';
    }
}
