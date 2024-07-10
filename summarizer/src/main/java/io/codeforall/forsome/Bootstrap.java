package io.codeforall.forsome;

import org.academiadecodigo.bootcamp.Prompt;
import javax.persistence.EntityManagerFactory;

public class Bootstrap {

    private EntityManagerFactory entityManagerFactory;

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public Controller wireObjects(){

        Prompt prompt = new Prompt(System.in,System.out);
        Controller controller = new Controller();
        View view = new View();
        Service service = new Service();


        controller.setView(view);
        controller.setService(service);
        view.setController(controller);
        view.setPrompt(prompt);
        service.setEntityManagerFactory(entityManagerFactory);

        return controller;
    }
}