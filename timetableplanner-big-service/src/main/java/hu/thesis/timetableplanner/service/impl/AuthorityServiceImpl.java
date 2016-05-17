package hu.thesis.timetableplanner.service.impl;

import hu.thesis.timetableplanner.dto.AuthorityDto;
import hu.thesis.timetableplanner.model.Authority;
import hu.thesis.timetableplanner.repository.AuthorityRepository;
import hu.thesis.timetableplanner.service.AuthorityService;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    @Autowired
    private AuthorityRepository authorityRepository;

    @Transactional
    @Override
    public List<AuthorityDto> findAllAuthority() {

        List<Authority> roleEntites = authorityRepository.findAll();
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        List<AuthorityDto> roles = new ArrayList<>();

        for (Authority roleEntity : roleEntites) {
            roles.add(mapper.map(roleEntity, AuthorityDto.class));
        }

        return roles;
    }
}
