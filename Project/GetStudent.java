import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Melika Maleki
 * @author Sina Ebadollahi
 * @version 1.0
 * */
public class GetStudent {
    static Scanner textScanner = new Scanner(System.in);
    static Student[] studentArray;
    static String inputFileName;
    public static void main(String[] args) throws IOException {
        while(true){
            System.out.print("Please Enter '.txt' File Name : ");
            inputFileName = textScanner.nextLine();
            if(inputFileName.endsWith(".txt")){
                break;
            }
        }
        readFromFile(inputFileName);
        userSelect: while(true){
            System.out.println("1:Add new student\n2:Edit student\n3:Delete student\n4:Sort students\n5:Show List\n6:Save to file\n7:Exit");
            System.out.print("Enter Your Choice : ");
            int userChoice = textScanner.nextInt();
            switch(userChoice){
                case 1:
                    // Add new student in terminal
                    Student tempSt = addNewStudentToList();
                    studentArray = updateStudentArray(studentArray, tempSt);
                    break;
                case 2:
                    // Edit Student Data
                    System.out.print("Enter Student Code to Edit Information Or Enter 0 to exit to main menu : ");
                    long studentCode = textScanner.nextLong();
                    if(studentCode == 0){
                        break;
                    }else{
                        editStudentInfo(studentCode);
                    }
                    break;
                case 3:
                    // Delete Student
                    System.out.println("Enter Your data to delete.");
                    System.out.println("1.Delete by Student Code\n2.Delete by Student Name\n3.Exit to main menu");
                    int userChoiceInDelete = textScanner.nextInt();
                    switch (userChoiceInDelete){
                        case 1:
                            System.out.print("Enter Student Code to Delete : ");
                            textScanner.nextLine();
                            deleteStudentFromArray(Long.parseLong(textScanner.nextLine()));
                            break;
                        case 2:
                            System.out.print("Enter Student Name to Delete : ");
                            textScanner.nextLine();
                            deleteStudentFromArray(textScanner.nextLine());
                        case 3:
                            break;
                    }
                    break;
                case 4:
                    // Sort Menu
                    System.out.println("1.Sort by Student Code ASC\n2.Sort by Student Code DESC\n3.Sort By Name ASC\n4.Sort By Name DESC" +
                            "\n5.Sort By Student Field ASC\n6.Sort By Student Field DESC\n7.Sort By Total Grade ASC\n8.Sort By Total Grade DESC\n9.Exit to main menu");
                    int sortChoice = textScanner.nextInt();
                    switch(sortChoice){
                        case 1:
                            sortStudentByCode(true);
                            break;
                        case 2:
                            sortStudentByCode(false);
                            break;
                        case 3:
                            sortStudentByNameASC();
                            break;
                        case 4:
                            sortStudentByNameDESC();
                        case 5:
                            sortStudentByField(true);
                        case 6:
                            sortStudentByField(false);
                        case 7:
                            sortStudentByTotalGrade(true);
                        case 8:
                            sortStudentByTotalGrade(false);
                        default:
                            break;
                    }
                    break;
                case 5:
                    // Show list of Students
                    showStudentList();
                    break;
                case 6:
                    // Save Students Data to a File
                    saveStudentDataToFile();
                    break;
                case 7:
                    break userSelect;
            }
        }

    } // main
    static void showStudentList(){
        if(studentArray != null){
            for (int i = 0; i < studentArray.length; i++) {
                System.out.println(studentArray[i].studentData());
            }
        }
    } // show students list in terminal
    static void readFromFile(String fileName) throws FileNotFoundException {
        File inpFile = new File(fileName);
        System.out.println(inpFile.getPath());
        if(inpFile.exists()){
            Scanner fileReader = new Scanner(inpFile);
            while(fileReader.hasNext()){
                String[] a = fileReader.nextLine().split(",");
                Student st = new Student();
                st.stCode = Long.parseLong(a[0]);
                st.stName = a[1];
                st.stField = a[2];
                st.totalGrade = Double.parseDouble(a[3]);
                studentArray = updateStudentArray(studentArray, st);
            }
            fileReader.close();
        }
    } // read from file

    static Student[] updateStudentArray(Student[] studentArray, Student st){
        if(studentArray == null){
            studentArray = new Student[1];
        }else{
            studentArray = Arrays.copyOf(studentArray, studentArray.length + 1);
        }
        studentArray[studentArray.length - 1] = st;
        return studentArray;
    } // student array actions
    static void sortStudentByNameASC(){
        if(studentArray != null){
            for(int i = 0; i < studentArray.length; i++){
                for (int j = i + 1; j < studentArray.length; j++) {
                    if(studentArray[i].stName.compareToIgnoreCase(studentArray[j].stName) > 0){
                        Student temporary = studentArray[i];
                        studentArray[i] = studentArray[j];
                        studentArray[j] = temporary;
                    }
                }
            }
        }
        showStudentList();
    } // sort by ASC
    static void sortStudentByNameDESC(){
        if(studentArray != null){
            for(int i = 0; i < studentArray.length; i++){
                for (int j = i + 1; j < studentArray.length; j++) {
                    if(studentArray[i].stName.compareToIgnoreCase(studentArray[j].stName) < 0){
                        Student temporary = studentArray[i];
                        studentArray[i] = studentArray[j];
                        studentArray[j] = temporary;
                    }
                }
            }
        }
        showStudentList();
    } // sort by DESC
    static void sortStudentByCode(boolean ascOrDesc){
        if(ascOrDesc){
            if(studentArray != null){
                for (int i = 0; i < studentArray.length; i++) {
                    for (int j = 0; j < studentArray.length; j++){
                        if(studentArray[i].stCode > studentArray[j].stCode){
                            Student temp = studentArray[i];
                            studentArray[i] = studentArray[j];
                            studentArray[j] = temp;
                        }
                    }
                }
            }
        }
        if(!ascOrDesc){
            if(studentArray != null){
                for (int i = 0; i < studentArray.length; i++) {
                    for (int j = 0; j < studentArray.length; j++){
                        if(studentArray[i].stCode < studentArray[j].stCode){
                            Student temp = studentArray[i];
                            studentArray[i] = studentArray[j];
                            studentArray[j] = temp;
                        }
                    }
                }
            }
        }
        showStudentList();
    }// sort student by student name
    static void sortStudentByField(boolean ascOrDesc){
        if(ascOrDesc){
            if(studentArray != null){
                for(int i = 0; i < studentArray.length; i++){
                    for (int j = i + 1; j < studentArray.length; j++) {
                        if(studentArray[i].stField.compareToIgnoreCase(studentArray[j].stField) > 0){
                            Student temporary = studentArray[i];
                            studentArray[i] = studentArray[j];
                            studentArray[j] = temporary;
                        }
                    }
                }
            }
        }
        if(!ascOrDesc){
            if(studentArray != null){
                for(int i = 0; i < studentArray.length; i++){
                    for (int j = i + 1; j < studentArray.length; j++) {
                        if(studentArray[i].stField.compareToIgnoreCase(studentArray[j].stField) < 0){
                            Student temporary = studentArray[i];
                            studentArray[i] = studentArray[j];
                            studentArray[j] = temporary;
                        }
                    }
                }
            }
        }
        showStudentList();
    }// sort student by field
    static void sortStudentByTotalGrade(boolean ascOrDesc){
        if(ascOrDesc){
            if(studentArray != null){
                for(int i = 0; i < studentArray.length; i++){
                    for (int j = i + 1; j < studentArray.length; j++) {
                        if(studentArray[i].totalGrade > studentArray[j].totalGrade){
                            Student temporary = studentArray[i];
                            studentArray[i] = studentArray[j];
                            studentArray[j] = temporary;
                        }
                    }
                }
            }
        }
        if(!ascOrDesc){
            if(studentArray != null){
                for(int i = 0; i < studentArray.length; i++){
                    for (int j = i + 1; j < studentArray.length; j++) {
                        if(studentArray[i].totalGrade < studentArray[j].totalGrade){
                            Student temporary = studentArray[i];
                            studentArray[i] = studentArray[j];
                            studentArray[j] = temporary;
                        }
                    }
                }
            }
        }
        showStudentList();
    }// sort student by total grade
    static Student addNewStudentToList(){
        Student newTempStudent = new Student();
        System.out.print("Enter Student Code : ");
        newTempStudent.stCode = textScanner.nextLong();
        textScanner.nextLine();
        System.out.print("Enter Student Name : ");
        newTempStudent.stName = textScanner.nextLine();
        System.out.print("Enter Student study Field : ");
        newTempStudent.stField = textScanner.nextLine();
        System.out.print("Enter Student TotalGrade : ");
        newTempStudent.totalGrade = textScanner.nextDouble();
        return newTempStudent;
    } // add new student from terminal
    static void saveStudentDataToFile() throws IOException {
        textScanner.nextLine();
        System.out.print("Enter a Name For File : ");
        String saveFileName = textScanner.nextLine();
        textScanner.nextLine();
        File saveFile = new File(saveFileName);
        FileWriter fileWriter = new FileWriter(saveFile, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
                for(int i = 0; i < studentArray.length; i++){
                    bWriter.write(studentArray[i].studentData());
                    bWriter.newLine();
                }
        bWriter.close();
        fileWriter.close();

    } // save to file
    static void deleteStudentFromArray(long studentCode){
        int flag = 0;

            for(int i = 0; i < studentArray.length; i++){
                if(studentArray[i].stCode == studentCode){
                    flag = 1;
                    if(!(i == studentArray.length - 1)) {
                        for (int j = i; j < studentArray.length; j++) {
                            studentArray[j] = studentArray[j + 1];
                        }
                    }else{
                        studentArray[i] = null;
                    }
                }
            }
        if(flag == 1){
            studentArray = Arrays.copyOf(studentArray, studentArray.length - 1);
            System.out.println("Student Successfully Deleted!");
        }

    } // delete student (long param)
    static void deleteStudentFromArray(String studentName){
        int flag = 0;
        for (int i = 0; i < studentArray.length; i++) {
            if(studentArray[i].stName.contains(studentName) || studentArray[i].stName.equals(studentName) || studentArray[i].stName.split(" ")[0].equals(studentName) || studentArray[i].stName.split(" ")[1].equals(studentName)){
                flag = 1;
                if(!(i == studentArray.length - 1)) {
                    for (int j = i; j < studentArray.length; j++) {
                        if(j == 0){
                            studentArray[j] = studentArray[j + 1];
                        }else if(j == (studentArray.length - 1)){
                            continue;
                        }else{
                            studentArray[j] = studentArray[j + 1];
                        }
                        studentArray[j] = studentArray[j];
                    }
                }else{
                    studentArray[i] = null;
                }
            }
        }
        if(flag == 1){
            studentArray = Arrays.copyOf(studentArray, studentArray.length - 1);
            System.out.println("Student Successfully Deleted!");
        }
    }
    static void editStudentInfo(long stCode){
        int flag = 0;
        for(int i = 0; i < studentArray.length; i++){
            if(studentArray[i].stCode == stCode){
                flag = 1;
                editLoop: while(true){
                    System.out.print("Student Code Were Found!\n1.Edit Name\n2.Edit Field\n3.Edit Total Grade\n4.Exit to main menu\nEnter a number to continue : ");
                    int editInfoChoice = textScanner.nextInt();
                    switch (editInfoChoice){
                        case 1:
                            System.out.print("Enter New Name : ");
                            textScanner.nextLine();
                            studentArray[i].stName = textScanner.nextLine();
                            break;
                        case 2:
                            System.out.print("Enter New Field : ");
                            textScanner.nextLine();
                            studentArray[i].stField = textScanner.nextLine();
                            break;
                        case 3:
                            System.out.print("Enter New Total Grade : ");
                            studentArray[i].totalGrade = textScanner.nextDouble();
                            break;
                        case 4:
                            break editLoop;
                    }
                }
            }
        }
        if(flag == 0){
            System.out.println("404 Student Code Not Found!");
        }
    } // edit student
}
