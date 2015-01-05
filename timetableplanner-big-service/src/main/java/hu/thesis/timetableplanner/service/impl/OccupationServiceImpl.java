package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.LecturerDto;
import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.form.CreateOccupationForm;
import hu.thesis.timetableplanner.model.Lecturer;
import hu.thesis.timetableplanner.model.Occupation;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.repository.LecturerRepository;
import hu.thesis.timetableplanner.repository.OccupationRepository;
import hu.thesis.timetableplanner.service.OccupationService;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService{

    private static final String SORT_BY_DATETIME = "dateTime";

    @Autowired
    private OccupationRepository occupationRepository;

    @Transactional
    @Override
    public OccupationDto findById(long id) {
        Occupation occupation = occupationRepository.findOne(id);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(occupation, OccupationDto.class);
    }

    @Transactional
    @Override
    public OccupationDto findByName(String name) {
        Occupation occupation = occupationRepository.findByName(name);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(occupation, OccupationDto.class);
    }

    @Transactional
    @Override
    public Pagination<OccupationDto> findAllOccupationPageable(int pageNumber) {
        PageRequest page = new PageRequest(pageNumber - 1, Pagination.PAGE_SIZE, Sort.Direction.ASC, SORT_BY_DATETIME);
        Page<Occupation> occupationPage = occupationRepository.findAll(page);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<OccupationDto> occupations = new ArrayList<OccupationDto>();

        for (Occupation occupation : occupationPage.getContent()) {
            occupations.add(mapper.map(occupation, OccupationDto.class));
        }

        return new Pagination<OccupationDto>(occupationPage, occupations);
    }

    @Transactional
    @Override
    public Long createOccupation(CreateOccupationForm form) {
        Occupation newOccupation = new Occupation();
        newOccupation.setName(form.getName());
        newOccupation.setDateTime(form.getDateTime());

        return occupationRepository.save(newOccupation).getId();
    }


}
