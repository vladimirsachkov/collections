package com.javacode.javaio;

import com.javacode.collections.map.treemap.AverageStudentGrade;
import com.javacode.collections.map.treemap.SubjectGrade;
import com.javacode.collections.map.treemap.TreeMapRunner;

import java.io.*;
import java.util.*;

public class IOMain {

    private static final String FILE_NAME = "GradeBook.txt";
    private static final String BINARY_FILE = "Students.bin";
    private static final String BUFFERED_FILE = "Buffered.bin";

    public static void main(String[] args) throws IOException {
        SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapRunner.createGrades();
        Reader reader = new Reader();
        Writer writer = new Writer();
        writer.writeFile(grades, FILE_NAME);
//        reader.readFile(FILE_NAME);
//        writeWithFormatter();
//        processGrades(grades, writer, BINARY_FILE);
//        outputObjects(reader, BINARY_FILE);
//        System.out.println(System.getProperty("user.dir"));

//        FileUtils utils = new FileUtils();
//        utils.printIOFileDetails("./");
//        utils.printNioFileDetails(FILE_NAME);
//        utils.printNioFileDetails(FILE_NAME);
//        reader.nioReadFileWithBuffer(FILE_NAME);
//        writer.nipWriteWithBuffer(BUFFERED_FILE);
//        reader.nioReadWithStream(FILE_NAME);
//       writer.nioWriteWithStream(BUFFERED_FILE);
        reader.nioReadWithChannel(FILE_NAME);
//        writer.nioWriteWithChannel(BUFFERED_FILE);
    }

    private static void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName) {
        List<Student> students = new ArrayList<>();
        for (AverageStudentGrade gradeKey: grades.keySet()) {
            students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
        }
        writer.writeObject(students, fileName);
    }

    private static void outputObjects(Reader reader, String fileName) {
        List<Student> students = reader.readObject(fileName);
        for (Student student : students) {
            System.out.printf("%s, %.2f %n", student.getName(), student.getAverageGrade());
            System.out.println(student.getGrades());
        }
    }
}
