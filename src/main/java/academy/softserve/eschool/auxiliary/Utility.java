package academy.softserve.eschool.auxiliary;

import academy.softserve.eschool.dto.AddedUsersDTO;
import academy.softserve.eschool.dto.StudentDTO;
import academy.softserve.eschool.dto.TeacherDTO;
import academy.softserve.eschool.model.Clazz;
import academy.softserve.eschool.model.Student;
import academy.softserve.eschool.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The utility class created to transform the DTO to model, and vice versa.
 */
public class Utility {

    /**
     * Transform {@link Student} to {@link StudentDTO}.
     * @param student object with data for transformation.
     * @return {@link StudentDTO} created from student.
     */
    public static StudentDTO transform(Student student){
        Clazz clazz = student.getClasses().stream().filter(Clazz::isActive).findFirst().orElseGet(Clazz::new);
        return StudentDTO.builder().firstname(student.getFirstName())
                .lastname(student.getLastName())
                .patronymic(student.getPatronymic())
                .login(student.getLogin())
                .dateOfBirth(student.getDateOfBirth())
                .classe(clazz.getName())
                .classId(clazz.getId())
                .email(student.getEmail())
                .avatar(student.getAvatar())
                .phone(student.getPhone()).build();
    }

    /**
     * Transform {@link User} to {@link TeacherDTO}.
     * @param teacher object with data for transformation.
     * @return {@link StudentDTO} created from teacher.
     */
    public static TeacherDTO transform(User teacher){
        return TeacherDTO.builder().firstname(teacher.getFirstName())
                .lastname(teacher.getLastName())
                .patronymic(teacher.getPatronymic())
                .login(teacher.getLogin())
                .email(teacher.getEmail())
                .phone(teacher.getPhone())
                .dateOfBirth(teacher.getDateOfBirth())
                .avatar(teacher.getAvatar())
                .build();
    }

    /**
     * Transform {@link User} to {@link TeacherDTO}.
     * @param users object with data for transformation.
     * @return list of {@link AddedUsersDTO} created from users.
     */
    public static List<AddedUsersDTO> transform(List<User> users){
        return users.stream().map(i-> AddedUsersDTO.builder()
                .firstname(i.getFirstName())
                .lastname(i.getLastName())
                .patronymic(i.getPatronymic())
                .login(i.getLogin())
                .password(i.getPassword())
                .role(i.getRole())
                .build()).collect(Collectors.toCollection(ArrayList::new));
    }
}
