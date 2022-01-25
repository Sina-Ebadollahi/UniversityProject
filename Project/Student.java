/**
 * Student Information Class
 * @author Melika Maleki
 * @author Sina Ebadollahi
 */
public class Student {
    public long stCode;
    public String stName;
    public String stField;
    public double totalGrade;
    public String studentData(){
        return stCode + "," + stName + "," + stField + "," + totalGrade;
    }
}
