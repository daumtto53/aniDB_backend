package com.aniDB.aniDB_backend.controller;

import com.aniDB.aniDB_backend.dto.entity.member.BasicRegisterMemberDTO;
import com.aniDB.aniDB_backend.service.LoginRegisterService;
import jdk.jshell.Snippet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/")
@Log4j2
public class LoginRegisterController {

    private final LoginRegisterService loginRegisterService;

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody BasicRegisterMemberDTO memberDTO
            ) {
        log.info(memberDTO);
        loginRegisterService.register(memberDTO);
        return ResponseEntity.status(HttpStatus.valueOf(201)).body("ok");
    }


}
