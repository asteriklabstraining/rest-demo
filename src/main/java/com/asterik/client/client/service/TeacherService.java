package com.asterik.client.client.service;

import com.asterik.client.client.dto.TeacherResponseDTO;

public interface TeacherService {
    TeacherResponseDTO findTeacherFromServer();

    void postTeacherToServer();
}
