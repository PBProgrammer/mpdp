package com.mpdp.mpdp.controller;

import com.mpdp.mpdp.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = {"*"})
public class RestController {




    @GetMapping(path = {"/8B0AF486D660DD72259E978345B14ADD/pw/{password}"})
    public ResponseEntity<Boolean> checkPassword(@PathVariable("password") String password) {
        if(password.equals(Constants.pw)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
