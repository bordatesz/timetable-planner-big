package hu.thesis.timetableplanner.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Atesz on 2015.03.18..
 */
public class OccupationGroupForm {

    @NotNull
    @Size(min=1,max=256)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
