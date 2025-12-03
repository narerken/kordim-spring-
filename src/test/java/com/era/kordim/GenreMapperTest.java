package com.era.kordim;

import com.era.kordim.dto.CountryDto;
import com.era.kordim.dto.GenreDto;
import com.era.kordim.entity.Country;
import com.era.kordim.entity.Genre;
import com.era.kordim.mapper.GenreMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class GenreMapperTest {
    @Autowired
    private GenreMapper genreMapper;

    @Test
    void toDtoTest(){
        Genre genre = new Genre(1L, "Action");
        GenreDto dto = genreMapper.toDto(genre);

        Assertions.assertNotNull(dto);
        Assertions.assertEquals(dto.getId(), genre.getId());
        Assertions.assertEquals(dto.getNameDto(), genre.getName());
    }

    @Test
    void toEntityTest(){
        GenreDto genreDto = new GenreDto(2L, "Drama");
        Genre entity = genreMapper.toEntity(genreDto);

        Assertions.assertNotNull(entity);
        Assertions.assertEquals(entity.getId(), genreDto.getId());
        Assertions.assertEquals(entity.getName(), genreDto.getNameDto());
    }

    @Test
    void toDtoListTest(){
        Genre g1 = new Genre(1L, "Comedy");
        Genre g2 = new Genre(2L, "Horror");

        List<GenreDto> list = genreMapper.toDtoList(Arrays.asList(g1, g2));
        Assertions.assertNotNull(list);
        Assertions.assertEquals("Comedy", list.get(0).getNameDto());
        Assertions.assertEquals("Horror", list.get(1).getNameDto());
     }
}
