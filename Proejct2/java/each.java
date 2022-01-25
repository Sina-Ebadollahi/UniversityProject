/**
 * @author Melika Maleki
 * @author Sina Ebadollahi
 * @version 1.0
 */
public class each {
    public boolean isAbsolute;
    public int power;
    public String all;
    public String numString;
    public int num;
    public String allResult;
    /**
     * converting the all String to smaller components
     */
    public void checkFunc(){
        if(all.charAt(0) == '+'){
            isAbsolute = true;
        }else if(all.charAt(0) == '-'){
            isAbsolute = false;
        }
        if(all.contains("^")){
            power = Integer.parseInt(all.split("\\^")[1]);
        }else{
            power = 0;
        }
        if (all.charAt(0) == '+' && all.length() > 1) {
            numString = all.split("\\+")[1].split("\\^")[0];
        } else if (all.charAt(0) == '-' && all.length() > 1) {
            numString = all.split("-")[1].split("\\^")[0];
        }
        if(numString != null){
            num = Integer.parseInt(numString.split("x")[0]);
        }
        if(!isAbsolute){
            num = -num;
        }
    }

    /**
     * creating the final result after all calculations
     */
    public void finalResult(){
        if(isAbsolute){
            allResult = "+" + num + "x^" + power;
        }
        if(!isAbsolute){
            allResult =   num + "x^" + power;
        }
        if(allResult.charAt(0) != '+' && allResult.charAt(0) != '-'){
            allResult = "+" + allResult;

        }
    }
}
