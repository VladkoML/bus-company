package entity;


import java.sql.Date;
import java.util.Objects;

public class Driver {

    private Long id;
    private String fullName;
    private Date birthday;

    public Driver(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(id, driver.id) && Objects.equals(fullName, driver.fullName) && Objects.equals(birthday, driver.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, birthday);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
