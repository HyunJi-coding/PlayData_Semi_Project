package com.example.project.controller.api;

import com.example.project.dto.request.feed.RequestContentDTO;
import com.example.project.dto.response.feed.ContentDTO;
import com.example.project.dto.response.user.UserDTO;
import com.example.project.service.BoardService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class BoardApiController {

    private final BoardService service;

    @GetMapping("/feed")
    public List<ContentDTO> requestContent(@ModelAttribute RequestContentDTO dto, HttpSession res) {
        UserDTO session = (UserDTO)res.getAttribute("user");
        if (session != null){
            dto.setUser_seq(session.getUser_seq());
        }
        log.info(dto.toString());
        return service.getContentList(dto);
    }
}
