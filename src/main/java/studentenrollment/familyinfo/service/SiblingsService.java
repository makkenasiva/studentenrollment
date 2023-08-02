package studentenrollment.familyinfo.service;

import studentenrollment.familyinfo.model.Siblings;


public interface SiblingsService {
    Siblings storeSiblingDetails(int studentId, String firstName, String middleName, String lastName, Long contactNumber);
}

