import Entities.Comparators.Users.UsersComparatorFullName;
import Entities.Comparators.Users.UsersComparatorUuid;
import Entities.Student.Student;
import Entities.Student.StudentsGroup;
import Entities.Student.StudentsGroupController;
import Entities.Student.StudentsGroupService;
import Entities.Teacher.Teacher;
import Entities.Teacher.TeachersGroup;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        seminar4HomeWork();
    }

    private static void seminar4HomeWork() {
        TeachersGroup teachersGroup = new TeachersGroup();
        teachersGroup.add(new Teacher("Алла", "Орлова", 10));
        teachersGroup.add(new Teacher("Ольга", "Волкова", 4));
        teachersGroup.add(new Teacher("Ирина", "Петрова", 20));
        teachersGroup.add(new Teacher("Евгения", "Онегина", 2));

        List<Teacher> teacherList = teachersGroup.sorted(new UsersComparatorFullName<>());

        int count = 0;
        for (Teacher teacher :
                teacherList) {
            System.out.printf("%d) %s\n", ++count, teacher);
        }
    }

    private static StudentsGroup BLOCK_3_1_TESTS(boolean consoleOut) {
        Student student0 = new Student("Вероника", "Тарасова");
        Student student1 = new Student("Анастасия", "Афанасьева");
        Student student2 = new Student("Мирослава", "Тарасова");
        Student student3 = new Student("Мария", "Комарова");
        Student student4 = new Student("Сергей", "Федоров");
        Student student5 = new Student("Маргарита", "Безрукова");
        Student student6 = new Student("Ксения", "Бочарова");
        Student student7 = new Student("Амира", "Смирнова");
        Student student8 = new Student("Тимур", "Стариков");
        Student student9 = new Student("Анастасия", "Кожевникова");

        if (consoleOut) {
            System.out.println("Экземпляры Student:");
            System.out.printf(
                    "1) %s\n2) %s\n3) %s\n4) %s\n5) %s\n6) %s\n7) %s\n8) %s\n9) %s\n10) %s\n\n",
                    student0,
                    student1,
                    student2,
                    student3,
                    student4,
                    student5,
                    student6,
                    student7,
                    student8,
                    student9
            );
        }

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student4);
        students.add(student3);
        students.add(student0);
        students.add(student2);

        StudentsGroup studentsGroup = new StudentsGroup(students);
        if (consoleOut) {
            System.out.println("Экземпляр StudentsGroup:");
            System.out.printf("%s\n\n", studentsGroup);
        }

        studentsGroup.add(student6);
        studentsGroup.add(student5);
        if (consoleOut) {
            System.out.println("Экземпляр StudentsGroup после addToGroup(Student student):");
            System.out.printf("%s\n\n", studentsGroup);
        }

        List<Student> studentsList = new ArrayList<>() {{
            add(student7);
            add(student8);
            add(student9);
        }};
        studentsGroup.add(studentsList);
        if (consoleOut) {
            System.out.println("Экземпляр StudentsGroup после addToGroup(Student student):");
            System.out.printf("%s\n\n", studentsGroup);
        }

        return studentsGroup;
    }

    private static ServiceAndController BLOCK_3_2_TESTS(StudentsGroup group, boolean consoleOut) {

        if (consoleOut) {
            printStudentsGroup(group);
        }

        StudentsGroupService groupService = new StudentsGroupService(group);
        groupService.deleteByFullName("Вероника", "Тарасова");
        if (consoleOut) {
            printStudentsGroup(group);
        }

        StudentsGroupController controller = new StudentsGroupController(groupService);
        controller.delete("Анастасия", "Кожевникова");
        if (consoleOut) {
            printStudentsGroup(group);
        }

        return new ServiceAndController(groupService, controller);
    }

    private record ServiceAndController(StudentsGroupService service, StudentsGroupController controller) {

    }

    private static void printStudentsGroup(StudentsGroup group) {
        int counter = 0;
        for (Student student :
                group) {
            System.out.printf("%d) %s\n", ++counter, student);
        }
        System.out.println();
    }

    private static void BLOCK_3_4_TESTS(ServiceAndController ServiceAndController, boolean consoleOut) {
        StudentsGroupService service = ServiceAndController.service();
        StudentsGroupController controller = ServiceAndController.controller();

        controller.sort(new UsersComparatorFullName());

        if (consoleOut) {
            printStudentsGroup(service.getGroup());
        }

        controller.sort(new UsersComparatorUuid());

        if (consoleOut) {
            printStudentsGroup(service.getGroup());
        }
    }
}