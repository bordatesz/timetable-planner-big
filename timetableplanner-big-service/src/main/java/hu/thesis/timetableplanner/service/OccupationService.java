package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.form.OccupationForm;
import hu.thesis.timetableplanner.pagination.Pagination;

public interface OccupationService {

    public OccupationDto findById(long id);

    public OccupationDto findByName(String name);

    public Pagination<OccupationDto> findAllOccupationPageable(int pageNumber);

    public Long createOccupation(OccupationForm form);

    public Long createUserOccupation(String actualUserEmail, OccupationForm form);

    public void editOccupation(long id, OccupationForm form);

    public void deleteOccupation(long id);

    public void deleteUserOccupation(String actualUserEmail, long occupationId);
}
