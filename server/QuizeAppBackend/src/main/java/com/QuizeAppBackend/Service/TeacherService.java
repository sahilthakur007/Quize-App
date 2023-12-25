

package com.QuizeAppBackend.Service;

import java.util.List;

import com.QuizeAppBackend.Payload.QuizeDto;

public interface TeacherService {

      List<QuizeDto> getAllQuizeList(int tid); 
}
