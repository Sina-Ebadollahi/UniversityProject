import java.util.Scanner;

/**
 * @author Melika Maleki
 * @author Sina Ebadollahi
 * @version 1.0
 */
public class CalcMain {
    static Scanner textScanner = new Scanner(System.in);
    public static void main(String[] args) {
        mainMenuLoop : while(true){
            System.out.println("1.Enter for GUI Program\n2.Enter for CLI Program\n3.Exit The Program");
            int userChoice = textScanner.nextInt();
            switch (userChoice){
                case 1:
                    // GUI mode
                    UI ui = new UI();
                    ui.mainFunction();
                     break;
                case 2:
                    // CLI mode
                    mainFunctionCLI();
                    break;
                case 3:
                    break mainMenuLoop;
            }
        }
    }

    /**
     * Command Line mode function
     */
    static void mainFunctionCLI(){
        System.out.print("1.Enter 1 to exit to main menu\nEnter Your Math Object or Choice : ");
        textScanner.nextLine();
        String cliChoice = textScanner.nextLine();
            if(cliChoice.equals("1")){
                return;
            }else{
                    System.out.print("Enter Your Second Math Object : ");
                    String secondMath = textScanner.nextLine();
                    if(!secondMath.isBlank()){
                        System.out.print("1.To Summarize both math objects\n2.To Subtraction both math objects\n3.To Multiply both math objects\n4.To Divide both math objects : ");
                        int lastChoice = textScanner.nextInt();
                        switch (lastChoice){
                            case 1:
                                cliCallbackFunction(cliChoice, secondMath, "Sum");
                                break;
                            case 2:
                                cliCallbackFunction(cliChoice, secondMath, "Sub");
                                break;
                            case 3:
                                cliCallbackFunction(cliChoice, secondMath, "Mult");
                                break;
                            case 4:
                                cliCallbackFunction(cliChoice, secondMath, "Div");
                                break;
                            default:
                                break;

                        }
                    }else{
                        return;
                    }
            }
    }
    static void cliCallbackFunction(String fr1, String fr2, String requestID){
        sum s = new sum();
        String result = s.mainAction(fr1, fr2, requestID);
        if(result.equals("")){
            System.out.println("0");
        }else {
            if (result.charAt(0) == '+' && result.charAt(1) == '-') {
                System.out.println(result.split("\\+")[1]);
            } else {
                System.out.println(result);
            }
        }
    }
}
