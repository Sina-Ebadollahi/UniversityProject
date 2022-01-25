import java.util.Arrays;

public class Calculator {
    each[] eachArray;
    String rawMono;
    String[] monoArr;

    /**
     * @param fr text to be injected on each Class
     */
    public void getRegulation(String fr) {
        rawMono = fr;
        fr = fr.replaceAll(" ", "");
        if(fr.charAt(0) != '+' || fr.charAt(0) != '-'){
            fr = "+" + fr;
        }
        fr = fr.replace(String.valueOf('+'), "$+");
        fr = fr.replace(String.valueOf('-'), "$-");
        monoArr = fr.split("\\$");
        for(int i = 0; i < monoArr.length; i++){
            if(eachArray == null){
                eachArray = new each[1];
                each e = new each();
                e.all = monoArr[0];
                eachArray[0] = e;
            }else{
                eachArray = Arrays.copyOf(eachArray, eachArray.length + 1);
                each e = new each();
                e.all = monoArr[i];
                eachArray[eachArray.length - 1] = e;
            }
        }
        for(int i = 0; i < eachArray.length; i++){
            if(i == eachArray.length - 1){
                break;
            }
            eachArray[i] = eachArray[i + 1];

        }
        eachArray = Arrays.copyOf(eachArray, eachArray.length - 1);
        for(int i = 0; i < eachArray.length; i++){
            if(eachArray[i].all != null){
                eachArray[i].checkFunc();
            }
        }

    }
}
