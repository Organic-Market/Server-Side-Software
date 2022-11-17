package com.organicmarket.market.converter;

import com.organicmarket.market.dto.LoginResponseDTO;
import com.organicmarket.market.entities.Mayorista;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MayoristaConverter {
    private final ModelMapper modelMapper;

    public MayoristaConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public LoginResponseDTO convertEntityToDto(Mayorista mayorista) {
        return modelMapper.map(mayorista, LoginResponseDTO.class);
    }
}
