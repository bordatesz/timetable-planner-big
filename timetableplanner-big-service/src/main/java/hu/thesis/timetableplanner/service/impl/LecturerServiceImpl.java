package hu.thesis.timetableplanner.service.impl;


import java.util.ArrayList;
import java.util.List;
import hu.thesis.timetableplanner.dto.LecturerDto;
import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.model.Authority;
import hu.thesis.timetableplanner.model.Lecturer;
import hu.thesis.timetableplanner.model.Occupation;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.repository.AuthorityRepository;
import hu.thesis.timetableplanner.repository.LecturerRepository;
import hu.thesis.timetableplanner.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;

@Service
public class LecturerServiceImpl implements LecturerService{

    private static final String SORT_BY_NAME = "name";

    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Transactional
    @Override
    public LecturerDto findByEmailAdress(String email) {
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        Lecturer lecturer = lecturerRepository.findByEmail(email);
        return mapper.map(lecturer, LecturerDto.class);
    }

    @Transactional
    @Override
    public boolean checkLecturer(String email) {
        Lecturer lecturer = lecturerRepository.findByEmail(email);
        if(lecturer == null){
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public Pagination<LecturerDto> findAllLecturerPageable(int pageNumber) {
        PageRequest page = new PageRequest(pageNumber - 1, Pagination.PAGE_SIZE, Sort.Direction.ASC, SORT_BY_NAME);
        Page<Lecturer> lecturerPage = lecturerRepository.findAll(page);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<LecturerDto> lecturers = new ArrayList<LecturerDto>();

        for (Lecturer lecturer : lecturerPage.getContent()) {
            lecturers.add(mapper.map(lecturer, LecturerDto.class));
        }

        return new Pagination<LecturerDto>(lecturerPage, lecturers);
    }

    @Transactional
    @Override
    public LecturerDto findById(long id) {
        Lecturer lecturer = lecturerRepository.findOne(id);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(lecturer, LecturerDto.class);
    }

}
