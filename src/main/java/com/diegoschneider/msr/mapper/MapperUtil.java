package com.diegoschneider.msr.mapper;

import com.google.gson.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperUtil {

    private static ModelMapper modelMapper;

    public MapperUtil(){
        modelMapper = new ModelMapper();
    }

    public static <T,S> T toModel(S source, Class<T> destinationType){
        return modelMapper.map(source, destinationType);
    }

    public static <S, D> List<D> toList(List<S> sourceList, Class<D> destinationType) {
        return modelMapper.map(sourceList, TypeToken.getParameterized(List.class, destinationType).getType());
    }
//    private ClienteDto toModel(Cliente cliente){
//        return modelMapper.map(cliente, ClienteDto.class);
//    }

}
