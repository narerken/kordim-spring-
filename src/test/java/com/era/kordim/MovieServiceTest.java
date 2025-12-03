package com.era.kordim;

import com.era.kordim.dto.MovieDto;
import com.era.kordim.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Test
    void getAllTest(){
        List<MovieDto> movies = movieService.getAll();
        Assertions.assertNotNull(movies);
        Assertions.assertFalse(movies.isEmpty());

        for(MovieDto movie : movies){
            Assertions.assertNotNull(movie);
            Assertions.assertNotNull(movie.getTitleDto());
            Assertions.assertNotNull(movie.getYearDto());
            Assertions.assertNotNull(movie.getCountryDto());
        }
    }

    @Test
    void getByIdTest(){
        List<MovieDto> movies = movieService.getAll();
        Random random = new Random();
        Long id = movies.get(random.nextInt(movies.size())).getId();

        MovieDto movie = movieService.getById(id);
        Assertions.assertNotNull(movie);
    }

    @Test
    void addMovieTest() {
        MovieDto movieDto = new MovieDto();
        movieDto.setTitleDto("Test Movie");
        movieDto.setYearDto(2025);

        MovieDto created = movieService.addMovie(movieDto);
        Assertions.assertNotNull(created);
        Assertions.assertNotNull(created.getId());
        Assertions.assertEquals("Test Movie", created.getTitleDto());
        Assertions.assertEquals(2025, created.getYearDto());

        MovieDto fetched = movieService.getById(created.getId());
        Assertions.assertNotNull(fetched);
        Assertions.assertEquals(created.getId(), fetched.getId());
    }

    @Test
    void updateMovieTest() {
        List<MovieDto> movies = movieService.getAll();
        Random random = new Random();
        Long id = movies.get(random.nextInt(movies.size())).getId();

        MovieDto updateDto = new MovieDto();
        updateDto.setId(id);
        updateDto.setTitleDto("Updated Movie");
        updateDto.setYearDto(2030);

        MovieDto updated = movieService.updateMovie(id, updateDto);
        Assertions.assertNotNull(updated);
        Assertions.assertEquals("Updated Movie", updated.getTitleDto());
        Assertions.assertEquals(2030, updated.getYearDto());
    }

    @Test
    void deleteMovieTest(){
        List<MovieDto> movies = movieService.getAll();
        Random random = new Random();
        Long id = movies.get(random.nextInt(movies.size())).getId();

        Assertions.assertNotNull(movieService.deleteMovie(id));
        Assertions.assertNull(movieService.getById(id));
    }
}
