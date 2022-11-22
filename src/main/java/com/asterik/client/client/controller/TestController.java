package com.asterik.client.client.controller;

import com.asterik.client.client.dto.TeacherResponseDTO;
import com.asterik.client.client.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/test")
    public TeacherResponseDTO getTeachers(){
       return teacherService.findTeacherFromServer();
    }

    @GetMapping("/testpost")
    public boolean testPostTeacher(){
        teacherService.postTeacherToServer();
        return true;
    }


}
