package hu.thesis.timetableplanner.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateOccupationForm {

    @NotNull
    @Size(min=1,max=128)
    private String name;

    private String dateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
