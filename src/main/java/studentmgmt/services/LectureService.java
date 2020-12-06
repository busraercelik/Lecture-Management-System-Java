package studentmgmt.services;

import java.util.List;

public interface LectureService {
    List<String> getAllTeacherNames();
    List<String> getAllTopicsLongerThanDuration(int lectureDuration);
}
