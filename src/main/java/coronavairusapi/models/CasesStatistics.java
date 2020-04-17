package coronavairusapi.models;

import org.apache.tomcat.jni.Local;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CasesStatistics implements Serializable {

    String date;

    Long count;

    public CasesStatistics(LocalDate date, Long count) {

        String newDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.date = newDate;
        this.count = count;

    }

    public String getDate() {

        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
