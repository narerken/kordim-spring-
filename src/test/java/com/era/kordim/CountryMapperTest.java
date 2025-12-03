package com.era.kordim;

import com.era.kordim.dto.CountryDto;
import com.era.kordim.entity.Country;
import com.era.kordim.mapper.CountryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class CountryMapperTest {
    @Autowired
    private CountryMapper countryMapper;

    @Test
    void toDtoTest(){
        Country country = new Country(1L, "USA");
        CountryDto dto = countryMapper.toDto(country);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(dto.getId(), country.getId());
        Assertions.assertEquals(dto.getNameDto(), country.getName());
    }

    @Test
    void toEntityTest(){
        CountryDto countryDto = new CountryDto(2L, "KAZ");
        Country entity = countryMapper.toEntity(countryDto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(entity.getId(), countryDto.getId());
        Assertions.assertEquals(entity.getName(), countryDto.getNameDto());
    }


    @Test
    void toDtoListTest(){
        Country c1 = new Country(1L, "USA");
        Country c2 = new Country(2L, "KAZ");
        List<CountryDto> list = countryMapper.toDtoList(Arrays.asList(c1, c2));

        Assertions.assertNotNull(list);
        Assertions.assertEquals("USA", list.get(0).getNameDto());
        Assertions.assertEquals("KAZ", list.get(1).getNameDto());
    }
}
