package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.OccupationGroupDto;
import hu.thesis.timetableplanner.model.OccupationGroup;
import hu.thesis.timetableplanner.pagination.Pagination;
import hu.thesis.timetableplanner.repository.OccupationGroupRepository;
import hu.thesis.timetableplanner.service.OccupationGroupService;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Atesz on 2015.02.28..
 */

@Service
public class OccupationGroupServiceImpl implements OccupationGroupService {

    private static final String SORT_BY_NAME = "name";

    @Autowired
    private OccupationGroupRepository occupationGroupRepository;

    @Transactional
    @Override
    public OccupationGroupDto findByName(String name) {
        OccupationGroup occupationGroup = occupationGroupRepository.findByName(name);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(occupationGroup, OccupationGroupDto.class);
    }

    @Transactional
    @Override
    public Pagination<OccupationGroupDto> findAllOccupationGroupPageable(int pageNumber) {
        PageRequest page = new PageRequest(pageNumber - 1, Pagination.PAGE_SIZE, Sort.Direction.ASC, SORT_BY_NAME);
        Page<OccupationGroup> occupationGroupPage = occupationGroupRepository.findAll(page);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<OccupationGroupDto> occupationGroups = occupationGroupPage.getContent().stream()
                .map((occupationGroup) -> mapper.map(occupationGroup, OccupationGroupDto.class))
                .collect(Collectors.toList());
        return new Pagination<OccupationGroupDto>(occupationGroupPage, occupationGroups);
    }

    @Override
    public void deleteOccupationGroup(long id) {
        OccupationGroup occupationGroup = occupationGroupRepository.findOne(id);
        occupationGroupRepository.delete(occupationGroup);
    }

}
