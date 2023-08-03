package studentenrollment.familyinfo.service;

import studentenrollment.familyinfo.model.Parents;

public interface ParentsService {
    Parents storeParentDetails(int studentId, String fatherName, String motherName, Long contactNumber);
}
