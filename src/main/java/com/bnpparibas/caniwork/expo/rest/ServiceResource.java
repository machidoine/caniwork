package com.bnpparibas.caniwork.expo.rest;

import com.bnpparibas.caniwork.application.service.AddAllServiceCommand;
import com.bnpparibas.caniwork.application.service.FindAllServiceCommand;
import com.bnpparibas.caniwork.application.service.GetServiceCommand;
import com.bnpparibas.caniwork.expo.dto.ServiceDTO;
import com.bnpparibas.caniwork.expo.mapper.DTOMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/service/")
public class ServiceResource {

    private final DTOMapper mapper;
    private final GetServiceCommand getServiceCommand;
    private final FindAllServiceCommand findAllServiceCommand;
    private final AddAllServiceCommand addAllServiceCommand;

    public ServiceResource(DTOMapper mapper, GetServiceCommand getServiceCommand, FindAllServiceCommand findAllServiceCommand, AddAllServiceCommand addAllServiceCommand) {
        this.mapper = mapper;
        this.getServiceCommand = getServiceCommand;
        this.findAllServiceCommand = findAllServiceCommand;
        this.addAllServiceCommand = addAllServiceCommand;
    }

    @GetMapping("{id}")
    public ServiceDTO getService(@PathVariable int id) {
        return mapper.toDTO(getServiceCommand.process(id));
    }

    @GetMapping
    public List<ServiceDTO> findAllServices() {
        return findAllServiceCommand.process().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/")
    public List<ServiceDTO> addAllService(List<ServiceDTO> services) {
        return addAllServiceCommand.process(services.stream()
                .map(mapper::toService)
                .collect(Collectors.toList())
                ).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
