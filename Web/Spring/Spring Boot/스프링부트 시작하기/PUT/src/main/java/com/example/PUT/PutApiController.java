package com.example.PUT;

import com.example.PUT.dto.PostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PostRequestDto put(@RequestBody PostRequestDto requestDto, @PathVariable(name = "userId") Long id){
        System.out.println(id);
        return requestDto;
    }

}
