package hu.thesis.timetableplanner.service;

import hu.thesis.timetableplanner.dto.LecturerDto;
import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.pagination.Pagination;

public interface LecturerService {

    LecturerDto findById(long id);

    LecturerDto findByEmailAdress(String email);

    boolean checkLecturer(String email);

    Pagination<LecturerDto> findAllLecturerPageable(int pageNumber);

}
