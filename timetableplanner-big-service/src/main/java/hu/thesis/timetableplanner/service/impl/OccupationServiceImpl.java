package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.OccupationDto;
import hu.thesis.timetableplanner.form.OccupationForm;
import hu.thesis.timetableplanner.model.Occupation;
import hu.thesis.timetableplanner.model.User;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.repository.OccupationRepository;
import hu.thesis.timetableplanner.repository.UserRepository;
import hu.thesis.timetableplanner.service.OccupationService;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService{

    private static final String SORT_BY_DATETIME = "dateTime";

    @Autowired
    private OccupationRepository occupationRepository;

    @Autowired
    private UserRepository userRepository;

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
    public Long createOccupation(OccupationForm form) {
        Occupation newOccupation = new Occupation();
        newOccupation.setName(form.getName());
        newOccupation.setDateTime(form.getDateTime());

        return occupationRepository.save(newOccupation).getId();
    }

    @Transactional
    @Override
    public Long createUserOccupation(String actualUserEmail, OccupationForm form) {
        Occupation newOccupation = new Occupation();
        newOccupation.setName(form.getName());
        newOccupation.setDateTime(form.getDateTime());
        User currentUser = userRepository.findByEmailAdress(actualUserEmail);
        currentUser.getOccupations().add(newOccupation);

        return occupationRepository.save(newOccupation).getId();
    }

    @Transactional
    @Override
    public void editOccupation(long id, OccupationForm form) {
        Occupation occupation = occupationRepository.findOne(id);
        occupation.setName(form.getName());
        occupation.setDateTime(form.getDateTime());
        occupationRepository.save(occupation);
    }

    @Transactional
    @Override
    public void deleteOccupation(long id) {
        Occupation occupation = occupationRepository.findOne(id);
        //occupation.getUsers().clear();
        //occupationRepository.save(occupation);
        occupationRepository.delete(occupation);
    }

    @Transactional
    @Override
    public void deleteUserOccupation(String actualUserEmail, long occupationId) {
        User user = userRepository.findByEmailAdress(actualUserEmail);
        List<Occupation> occupations = user.getOccupations();
        for (Iterator<Occupation> iterator = occupations.iterator(); iterator.hasNext();) {
            Occupation occupation = iterator.next();
            if (occupation.getId() == occupationId) {
                iterator.remove();
            }
        }
        user.setOccupations(occupations);
        userRepository.save(user);
    }


}
