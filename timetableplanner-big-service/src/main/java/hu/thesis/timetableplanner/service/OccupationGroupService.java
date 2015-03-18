package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.OccupationGroupDto;
import hu.thesis.timetableplanner.form.OccupationGroupForm;
import hu.thesis.timetableplanner.pagination.Pagination;

/**
 * Created by Atesz on 2015.02.28..
 */
public interface OccupationGroupService {

    public OccupationGroupDto findByName(String name);

    /**
     * Returns all the created user having author authority
     * in a page.
     * @param pageNumber
     * @return @{link Pagination<UserDto>}
     */

    public Pagination<OccupationGroupDto> findAllOccupationGroupPageable(int pageNumber);

    public Long createOccupationGroup(OccupationGroupForm form);

    public void deleteOccupationGroup(long id);
}
