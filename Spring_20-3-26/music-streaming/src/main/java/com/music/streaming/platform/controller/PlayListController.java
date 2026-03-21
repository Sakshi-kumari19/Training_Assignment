package com.music.streaming.platform.controller;

import com.music.streaming.platform.dto.PlayListRequest;
import com.music.streaming.platform.model.PlayList;
import com.music.streaming.platform.service.PlayListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music/platform/v1/playlists")
public class PlayListController {
    private final PlayListService ps;

    public PlayListController(PlayListService ps) {
        this.ps = ps;
    }

    @PostMapping
    public ResponseEntity<PlayList> createNewPlaylist(@RequestBody PlayListRequest pl){
        return ResponseEntity.ok(ps.createPlayList(pl));
    }

    @GetMapping("/{artistId}")
    public ResponseEntity<PlayList> getById(@PathVariable("artistId") Long id){

        return ResponseEntity.ok(ps.getPlayListById(id));
    }

    @DeleteMapping("/{artistId}")
    public ResponseEntity<PlayList> deleteById(@PathVariable("artistId") Long id){

        ps.deletePlayList(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
