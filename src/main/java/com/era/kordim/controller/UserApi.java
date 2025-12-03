package com.era.kordim.controller;

import com.era.kordim.entity.User;
import com.era.kordim.service.CountryService;
import com.era.kordim.service.GenreService;
import com.era.kordim.service.MovieService;
import com.era.kordim.service.impl.MyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserApi {
    private MyService myService;
    private MovieService movieService;
    private CountryService countryService;
    private GenreService genreService;




    @GetMapping
    public String get123(){
        return "Success";
    }

    @PostMapping("/registr")
    public void registr(@RequestBody User model){
        myService.registr(model);
    }

    @GetMapping("/movie")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/country")
    @PreAuthorize("hasAnyAuthority('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<?> getAllCountries(){
        return new ResponseEntity<>(countryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/genre")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAllGenres(){
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }
}
