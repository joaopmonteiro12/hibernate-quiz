package io.codeforall.forsome;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class Service {

    private int stage;
    private EntityManagerFactory entityManagerFactory;
    private String question;
    private String[] answers;
    private String solution;
    private String explanation;

    public Service() {
        this.stage = 1;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void incrementStage() {
        ++this.stage;
    }

    public void presentStage() {
        EntityManager manager = createManager();

        this.question = setQuestion(manager);
        this.answers = setAnswers(manager);
        this.solution = setSolution(manager);
        this.explanation = setExplanation(manager);

        incrementStage();

        manager.close();
    }

    private String setExplanation(EntityManager manager) {
        String solutionQuery = "SELECT explanation FROM questions INNER JOIN solutions ON questions.question_id = solutions.question_id WHERE questions.question_id=" + this.stage;
        return manager.createNativeQuery(solutionQuery).getSingleResult().toString();
    }

    private String setSolution(EntityManager manager) {
        String solutionQuery = "SELECT solution FROM questions INNER JOIN solutions ON questions.question_id = solutions.question_id WHERE questions.question_id=" + this.stage;
        return manager.createNativeQuery(solutionQuery).getSingleResult().toString();
    }

    private String[] setAnswers(EntityManager manager) {

        String answersQuery = "SELECT answer FROM questions INNER JOIN answers ON questions.question_id = answers.question_id WHERE questions.question_id=" + this.stage;
        List<String> answersList = manager.createNativeQuery(answersQuery).getResultList();
        return answersList.stream()
                .toArray(String[]::new);
    }

    private String setQuestion(EntityManager manager) {
        String questionQuery = "SELECT question FROM questions WHERE question_id=" + this.stage;
        return manager.createNativeQuery(questionQuery).getSingleResult().toString();
    }

    public int getStage() {
        return stage;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getSolution() {
        return solution;
    }

    public String getExplanation() {
        return explanation;
    }

    private EntityManager createManager() {
        return entityManagerFactory.createEntityManager();
    }
}