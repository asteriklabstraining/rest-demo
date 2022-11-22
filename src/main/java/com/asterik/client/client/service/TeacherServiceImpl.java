package com.asterik.client.client.service;

import com.asterik.client.client.dto.TeacherRequestDTO;
import com.asterik.client.client.dto.TeacherResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TeacherServiceImpl implements TeacherService{
   @Autowired
   private RestTemplate restTemplate;
    @Override
    public TeacherResponseDTO findTeacherFromServer() {
        String url = "http://localhost:8080/teachers/1";

        // ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        TeacherResponseDTO response = restTemplate.getForObject(url, TeacherResponseDTO.class);
        return response;
    }

    @Override
    public void postTeacherToServer() {
        String url = "http://localhost:8080/createteacher";
        TeacherRequestDTO teacherRequestDTO = new TeacherRequestDTO();
        teacherRequestDTO.setFirstName("Hari");
        teacherRequestDTO.setLastName("Smith");
        teacherRequestDTO.setPhoneNum("123456");
        teacherRequestDTO.setSocialSecurity("1245656");

        String response = restTemplate.postForObject(url, teacherRequestDTO, String.class);
        System.out.println(response);
    }
}
