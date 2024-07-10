package io.codeforall.forsome;

public class Controller {

    private int correct;
    private Service service;
    private View view;

    public void setService(Service service) {
        this.service = service;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void incrementCorrect() {
        ++this.correct;
    }

    public void init() {
        view.startMenu();

        while (service.getStage() < 11) {
            service.presentStage();

            int stage = service.getStage() -1;
            String question = service.getQuestion();
            String[] answers = service.getAnswers();
            String solution =  service.getSolution();
            String explanation = (stage != 10) ? service.getExplanation() : "Transient - not associated with persistence, no id value, no db representation, eligible for garbage collection;\nPersistent - associated with persistence, has id, db representation, sync with db;\nRemoved - associated with persistence, has id, marked for removal;\nDetached - no longer in sync with db, not associated with persistence, eligible for garbage collection";



            view.show(stage,question, answers, solution, explanation);
            view.interlude();
        }

        System.out.println("\n\nEND OF THE QUIZ!");

        switch (this.correct) {
            case 0:
            case 1:
            case 2:
            case 4:
                System.out.println("You got " + correct + " out of 10. Hopefully now you more this subject.");
                break;
            case 5:
            case 6:
            case 7:
                System.out.println("You got " + correct + " out of 10. Good job!");
                break;
            case 8:
            case 9:
                System.out.println("You got " + correct + " out of 10! Amazing job!");
                break;
            case 10:
                System.out.println("CONGRATULATIONS! You got " + correct + " out of 10!");
                break;
        }

    }
}