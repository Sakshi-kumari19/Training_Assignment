package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.ArtistRequest;
import com.music.streaming.platform.model.Artist;
import com.music.streaming.platform.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music/platform/v1/artists")
public class ArtistController {

    private final ArtistService as;

    public ArtistController(ArtistService as) {
        this.as = as;
    }

    @PostMapping
    public ResponseEntity<Artist> createNewArtist(ArtistRequest a){

        return ResponseEntity.ok(as.createArtist(a));
    }
    @GetMapping
    public ResponseEntity<List<Artist>> getAllArtists(){

        return ResponseEntity.ok(as.getAllArtists());
    }

    @GetMapping("/{artistId}")
    public ResponseEntity<Artist> getById(@PathVariable("artistId") Long id){
        return ResponseEntity.ok(as.getArtistById(id));
    }

    @PutMapping("/{artistId}")
    public ResponseEntity<Artist> updateById(@PathVariable("artistId") Long id, @RequestBody ArtistRequest a){
        return ResponseEntity.ok(as.updateArtist(id,a));
    }

    @DeleteMapping("{artistId}")
    public ResponseEntity<Artist> deleteById(@PathVariable("artistId") Long id){

        as.deleteArtist(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
