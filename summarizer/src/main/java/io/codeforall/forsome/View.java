package io.codeforall.forsome;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class View {

    private Prompt prompt;
    private Controller controller;

    public void setPrompt(Prompt prompt) {
        this.prompt = prompt;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void startMenu(){
        System.out.println("\n\nWELCOME TO THE BEST QUIZ EVER!");

        StringInputScanner stringInputScanner = new StringInputScanner();
        stringInputScanner.setMessage("Are you ready? (Y/N): ");
        String answer = prompt.getUserInput(stringInputScanner);

        if(answer.toUpperCase().equals("N")){
            System.out.println("See you next time...");
            System.exit(1);
        }
        System.out.println("LET'S GO!!");

    }

    public void show(int stage, String question, String[] answers,String solution, String explanation){

        MenuInputScanner menu = new MenuInputScanner(answers);
        menu.setError("Option not available.");
        menu.setMessage("Question " + stage + ": " + question.toUpperCase());

        int option = prompt.getUserInput(menu) - 1;

        if (!answers[option].equals(solution)){
            System.out.print("INCORRECT! ");
            System.out.println("The correct answer is: " + solution);
            System.out.println(explanation);
            return;
        }

        System.out.print("CORRECT! ");
        controller.incrementCorrect();

        System.out.println(explanation);

    }

    public void interlude() {
        StringInputScanner stringInputScanner = new StringInputScanner();
        stringInputScanner.setMessage("\nReady to continue? (Y/N): ");
        prompt.getUserInput(stringInputScanner);
    }
}