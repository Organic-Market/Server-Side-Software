package com.organicmarket.market.converter;

import com.organicmarket.market.dto.LoginResponseDTO;
import com.organicmarket.market.entities.Agricultor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AgricultorConverter {
    private final ModelMapper modelMapper;

    public AgricultorConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LoginResponseDTO convertEntityToDto(Agricultor agricultor) {
        return modelMapper.map(agricultor, LoginResponseDTO.class);
    }
}
