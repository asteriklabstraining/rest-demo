package com.asterik.client.client;

import com.asterik.client.client.dto.TeacherResponseDTO;
import com.asterik.client.client.service.TeacherService;
import com.asterik.client.client.service.TeacherServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.*;

public class TeacherServiceTest {
    @Mock
    private RestTemplate mockRestTemplate;

    @InjectMocks
    private TeacherService teacherService = new TeacherServiceImpl();

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getGetTeacher(){
        TeacherResponseDTO mockTeacherResponseDTO = new TeacherResponseDTO();
        mockTeacherResponseDTO.setFirstName("ram");
        mockTeacherResponseDTO.setLastName("thapa");

        Mockito.when(mockRestTemplate.getForObject(anyString(), eq(TeacherResponseDTO.class))).thenReturn(mockTeacherResponseDTO);

        TeacherResponseDTO responseDTO = teacherService.findTeacherFromServer();
        Assertions.assertNotNull(responseDTO);
        Assertions.assertEquals("ram", responseDTO.getFirstName());
    }
}

