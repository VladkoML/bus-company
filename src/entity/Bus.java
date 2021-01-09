package entity;

import java.util.Objects;

public class Bus {

    private Long id;
    private String mark;
    private String licencePlate;
    private int seats;

    public Bus(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(id, bus.id) && Objects.equals(mark, bus.mark) && Objects.equals(licencePlate, bus.licencePlate) && Objects.equals(seats, bus.seats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, licencePlate, seats);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", licencePlate='" + licencePlate + '\'' +
                ", seats=" + seats +
                '}';
    }
}
