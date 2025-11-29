package com.era.kordim.controller;


import com.era.kordim.dto.GenreDto;
import com.era.kordim.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCountry(@RequestBody GenreDto genreDto){
        genreService.addGenre(genreDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable("id") Long id, @RequestBody GenreDto genreDto){
        genreService.updateGenre(id, genreDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable("id") Long id){
        if(genreService.deleteGenre(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
