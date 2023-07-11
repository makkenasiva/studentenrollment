package studentenrollment.SearchApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.Academicinfo.model.AcademicInfo;
import studentenrollment.Academicinfo.repository.AcademicInfoRepository;
import studentenrollment.InstitutionAPI.Institution;
import studentenrollment.InstitutionAPI.InstitutionRepository;
import studentenrollment.SearchApi.Repository.StudentSearchRepository;
import studentenrollment.SearchApi.pojo.SearchEntity;
import studentenrollment.StudentinfoApi.Model.StudentModel;
import studentenrollment.StudentinfoApi.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class StudentSearchService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private StudentSearchRepository studentSearchRepository;

    public List<SearchEntity> searchStudents(String input) {
        // Trim the input
        String trimmedInput = input.trim();

        // Search by student ID
        if (isNumeric(trimmedInput)) {
            int studentId = Integer.parseInt(trimmedInput);
            Optional<StudentModel> studentOptional = studentRepository.findById(studentId);

            if (studentOptional.isPresent()) {
                StudentModel student = studentOptional.get();
                List<StudentModel> studentList = new ArrayList<>();
                studentList.add(student);
                return createSearchEntityList(studentList);
            }
        }

        // Search by username
        List<StudentModel> studentsByUsername = studentSearchRepository.findByUsernameContainingIgnoreCase(trimmedInput);
        if (!studentsByUsername.isEmpty()) {
            return createSearchEntityList(studentsByUsername);
        }

        // Search by full name
        List<StudentModel> students = studentSearchRepository.findByFirst_nameContainingIgnoreCaseOrLastNameContainingIgnoreCase(trimmedInput);
        if (students.isEmpty()) {
            students = studentSearchRepository.findByFullNameContainingIgnoreCase(trimmedInput);
        }

        if (!students.isEmpty()) {
            return createSearchEntityList(students);
        } else {
            return Collections.singletonList(new SearchEntity("No student found", "", 0, "", ""));
        }
    }

    private List<SearchEntity> createSearchEntityList(List<StudentModel> students) {
        List<SearchEntity> searchEntities = new ArrayList<>();

        for (StudentModel student : students) {
            Long institutionId = Long.valueOf(student.getInstitutionId());
            Optional<Institution> institutionOptional = institutionRepository.findById(institutionId);

            if (institutionOptional.isPresent()) {
                Institution institution = institutionOptional.get();
                String entryLevel = getEntryLevelForStudent(student.getId());
                SearchEntity searchEntity = new SearchEntity(
                        getFullName(student),
                        student.getUsername(),
                        student.getId(),
                        institution.getName(),
                        entryLevel
                );

                searchEntities.add(searchEntity);
            }
        }

        return searchEntities;
    }

    private String getFullName(StudentModel student) {
        StringBuilder fullNameBuilder = new StringBuilder();
        if (student.getFirst_name() != null) {
            fullNameBuilder.append(student.getFirst_name());
        }
        if (student.getMiddle_name() != null && !student.getMiddle_name().isEmpty()) {
            fullNameBuilder.append(" ").append(student.getMiddle_name());
        }
        if (student.getLastName() != null) {
            fullNameBuilder.append(" ").append(student.getLastName());
        }
        return fullNameBuilder.toString();
    }

    @Autowired
    private AcademicInfoRepository academicInfoRepository;

    private String getEntryLevelForStudent(int studentId) {
        Optional<AcademicInfo> academicInfoOptional = academicInfoRepository.findById(studentId);
        if (academicInfoOptional.isPresent()) {
            AcademicInfo academicInfo = academicInfoOptional.get();
            return academicInfo.getEntryLevel();
        }
        return ""; // Return an appropriate value if no entry level is found
    }





    private boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
}
