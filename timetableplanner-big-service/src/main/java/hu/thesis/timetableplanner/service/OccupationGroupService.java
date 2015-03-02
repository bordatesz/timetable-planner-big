package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.OccupationGroupDto;

/**
 * Created by Atesz on 2015.02.28..
 */
public interface OccupationGroupService {

    public OccupationGroupDto findByName(String name);
}
