package com.era.kordim.controller;

import com.era.kordim.dto.MovieDto;
import com.era.kordim.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id ){
        return new ResponseEntity<>(movieService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.addMovie(movieDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") Long id, @RequestBody MovieDto movieDto){
        return new ResponseEntity<>(movieService.updateMovie(id, movieDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id ){
        if(movieService.deleteMovie(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
