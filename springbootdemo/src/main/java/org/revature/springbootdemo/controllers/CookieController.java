package org.revature.springbootdemo.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Optional;

@RestController
public class CookieController {

    @GetMapping("/getCookie")
    public ResponseEntity<String> createCookie(@RequestParam String name, @RequestParam String value){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(800);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Set-Cookie", cookie.getName() + "=" + cookie.getValue() + " MaxAge = " + cookie.getMaxAge());
        return new ResponseEntity<>("Cookie set", headers, HttpStatus.OK);
    }

    @GetMapping("/readCookie")
    public ResponseEntity<String> readCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            Optional<Cookie> c = Arrays.stream(cookies).filter(cookie -> "revature".equals(cookie.getName())).findFirst();

            if(c.isPresent()){
                return new ResponseEntity<>("Cookie Value: " + c.get().getValue(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Cookie not found", HttpStatus.BAD_REQUEST);

    }
}
