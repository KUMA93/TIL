package com.example.Hello.controller;

import com.example.Hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:9090/api/hello
    public String Hello() {
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET) // method 부분 작성 하지 않으면 get / post/ put/ delete 모두 작동
    public String hi(){
        return "hi";
    }


    // http://localhost:9090/api/get/path-variable/{name} "name"부분은 계속 바뀌는 변수

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName, String name){

        System.out.println("PathVariable: "+pathName);
        return "";
    }


    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    // 첫 연산자는 ?로 시작
    // 다음부터 &으로 시작
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    // ?user=steve&email=steve@gmail.com&age=30
    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){

        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }
}
