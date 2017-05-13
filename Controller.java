package ua.kpi.tef;

import java.util.Scanner;

class Controller {

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    //The Work method
    void processUser(){
        Scanner scanner = new Scanner(System.in);
        String string = "";

        model.setFirstWord(validateInputWord(scanner, View.HELLO.toLowerCase(), View.INPUT_HELLO));
        model.setSecondWord(validateInputWord(scanner, View.WORLD.toLowerCase(), View.INPUT_WORD));
        view.printMessage(model.getFirstWord() + ", " + model.getSecondWord() + "!");
    }

    //Validation method
    private String validateInputWord(Scanner input, String matcher, String message){
        System.out.println(message);

        String inputLine = input.nextLine().toLowerCase();

        while (!inputLine.equals(matcher)){
            view.printMessage(View.WRONG_INPUT_DATA);
            inputLine = input.nextLine().toLowerCase();
        }

        return inputLine;
    }
}
