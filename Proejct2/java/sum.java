/**
 * @author Melika Maleki
 * @author Sina Ebadollahi
 * @version 1.0
 *
 */

public class sum {
    public String result;
    Calculator calc1 = new Calculator();
    Calculator calc2 = new Calculator();

    /**
     *
     * @param fr1 first input text
     * @param fr2 second input text
     * @param requestID String that identifies (Sum, Sub, Mult, Div)
     * @return returns the calculated String
     */
    public String  mainAction(String fr1, String fr2, String requestID){
        calc1.getRegulation(fr1);
        calc2.getRegulation(fr2);
        switch (requestID){
            case "Sum":
                checkFunc(calc1, calc2, requestID);
                break;
            case "Sub":
                checkFunc(calc1, calc2, requestID);
                break;
            case "Mult":
                checkFunc(calc1, calc2, requestID);
                break;
            case "Div":
                checkFunc(calc1, calc2, requestID);
                break;
            default:
                return null;
        }
        // invoking the finalResult function on each index of Calculation Array
        for(int f = 0; f < calc1.eachArray.length; f++){
            calc1.eachArray[f].finalResult();
        }
        result = finalRegulation(calc1);
        cleanFunction(calc1, calc2);
        return result;
    }

    /**
     *
     * @param calc1 first Calculation Class that contains first text area sentence
     * @param calc2 second Calculation Class that contains second text area sentence
     * @param requestID ID to identify it on switch (Sum, Sub, Multi, Div)
     */
    void checkFunc(Calculator calc1, Calculator calc2, String requestID){
        for(int i = 0; i < calc1.eachArray.length; i++){
            for(int j = 0; j < calc2.eachArray.length; j++){
                if( calc1.eachArray[i].power == calc2.eachArray[j].power){
                    switch (requestID){
                        case "Sum":
                            calc1.eachArray[i].num = numIncrement(calc1.eachArray[i].num , calc2.eachArray[j].num);
                            break;
                        case "Sub":
                            calc1.eachArray[i].num = numDecrement(calc1.eachArray[i].num , calc2.eachArray[j].num);
                            break;
                        case "Mult":
                            calc1.eachArray[i].num = numMultiply(calc1.eachArray[i].num , calc2.eachArray[j].num);
                            if(!calc1.eachArray[i].isAbsolute && !calc1.eachArray[i].isAbsolute){
                                calc1.eachArray[i].isAbsolute = true;
                            }
                            if(calc1.eachArray[i].isAbsolute && !calc2.eachArray[j].isAbsolute){
                                calc1.eachArray[i].isAbsolute = false;
                            }
                            if(!calc1.eachArray[i].isAbsolute && calc2.eachArray[j].isAbsolute){
                                calc1.eachArray[i].isAbsolute = false;
                            }
                            break;
                        case "Div":
                            if(calc2.eachArray[j].num != 0){
                                calc1.eachArray[i].num = numDivision(calc1.eachArray[i].num , calc2.eachArray[j].num);
                                if(!calc1.eachArray[i].isAbsolute && !calc1.eachArray[j].isAbsolute){
                                    calc1.eachArray[i].isAbsolute = true;
                                }
                                if(calc1.eachArray[i].isAbsolute && !calc2.eachArray[j].isAbsolute){
                                    calc1.eachArray[i].isAbsolute = false;
                                }
                                if(!calc1.eachArray[i].isAbsolute && calc2.eachArray[j].isAbsolute){
                                    calc1.eachArray[i].isAbsolute = false;
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        }
    }
    int numIncrement(int f, int f2){
        return f + f2;
    }
    int numDecrement(int f, int f2){
        return f - f2;
    }
    int numMultiply(int f, int f2){
        return f * f2;
    }
    int numDivision(int f, int f2){
            return f / f2;
    }

    /**
     *
     * @param c index of each calc1 array will
     * @return returns a String like "+4x^3-2x^2+8x^1"
     */
    public String finalRegulation(Calculator c){
        String r = "";
        for(int i = 0; i < c.eachArray.length; i++){
            String temp;
            if(c.eachArray[i].num != 0){
                temp = c.eachArray[i].allResult;
                r = r.concat(temp);
            }
        }
        return r;
    }

    /**
     *
     * @param c1 first Calculator param
     * @param c2 second Calculator param
     * cleans up every calculation were made
     */
    public void cleanFunction(Calculator c1, Calculator c2){
        c1.eachArray = null;
        c1.monoArr = null;
        c1.rawMono = null;
        c2.eachArray = null;
        c2.monoArr = null;
        c2.rawMono = null;

    }
}
