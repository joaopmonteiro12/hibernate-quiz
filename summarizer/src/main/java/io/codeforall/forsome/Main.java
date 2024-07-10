package io.codeforall.forsome;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {


        Bootstrap bootstrap = new Bootstrap();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("quiz");
        bootstrap.setEntityManagerFactory(entityManagerFactory);

        Controller controller = bootstrap.wireObjects();

        controller.init();

        entityManagerFactory.close();
    }
}