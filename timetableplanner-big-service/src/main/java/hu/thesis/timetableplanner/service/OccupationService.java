package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.form.CreateOccupationForm;
import hu.thesis.timetableplanner.pagination.Pagination;

public interface OccupationService {

    OccupationDto findById(long id);

    OccupationDto findByName(String name);

    Pagination<OccupationDto> findAllOccupationPageable(int pageNumber);

    Long createOccupation(CreateOccupationForm form);
}
