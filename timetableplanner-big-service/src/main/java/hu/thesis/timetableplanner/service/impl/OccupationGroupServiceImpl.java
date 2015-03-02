package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.OccupationGroupDto;
import hu.thesis.timetableplanner.model.OccupationGroup;
import hu.thesis.timetableplanner.repository.OccupationGroupRepository;
import hu.thesis.timetableplanner.service.OccupationGroupService;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Atesz on 2015.02.28..
 */

@Service
public class OccupationGroupServiceImpl implements OccupationGroupService {

    @Autowired
    private OccupationGroupRepository occupationGroupRepository;

    @Transactional
    @Override
    public OccupationGroupDto findByName(String name) {
        OccupationGroup occupationGroup = occupationGroupRepository.findByName(name);
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        return mapper.map(occupationGroup, OccupationGroupDto.class);
    }

}
