package utils;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateAdapter extends XmlAdapter<String, LocalDate> {
    private DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public String marshal(LocalDate date) {
        return date.format(customFormat);
    }

    @Override
    public LocalDate unmarshal(String dateTime) {
        return LocalDate.parse(dateTime, customFormat);
    }
}
