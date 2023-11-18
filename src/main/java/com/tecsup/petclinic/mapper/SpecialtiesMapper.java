package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.domain.SpecialtiesTO;
import com.tecsup.petclinic.entities.Specialties;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy =  NullValueMappingStrategy.RETURN_DEFAULT)
public interface SpecialtiesMapper {

    SpecialtiesMapper INSTANCE = Mappers.getMapper(SpecialtiesMapper.class);


    List<SpecialtiesTO> toSpecialtiesTOList(List<Specialties> specialtiesList);

    List<Specialties> toSpecialtiesList(List<Specialties> specialtiesTOList);
}