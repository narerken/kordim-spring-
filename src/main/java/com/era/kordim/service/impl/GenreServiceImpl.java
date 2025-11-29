package com.era.kordim.service.impl;

import com.era.kordim.dto.GenreDto;
import com.era.kordim.entity.Genre;
import com.era.kordim.mapper.GenreMapper;
import com.era.kordim.repository.GenreRepository;
import com.era.kordim.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAll(){
        return genreMapper.toDtoList(genreRepository.findAll());
    }

    @Override
    public void addGenre(GenreDto genreDto){
        Genre genre = genreMapper.toEntity(genreDto);
        genreRepository.save(genre);
    }

    @Override
    public void updateGenre(Long id, GenreDto genreDto){
        Genre genre = genreRepository.findById(id).orElse(null);
        if(genre == null){
            return;
        }
        genre.setName(genreDto.getNameDto());
        genreRepository.save(genre);
    }

    @Override
    public boolean deleteGenre(Long id){
        if (!genreRepository.existsById(id)){
            return false;
        }
        genreRepository.deleteById(id);
        return true;
    }
}
