package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.model.Ingredient;
import org.example.model.Meal;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Sastojci
        Ingredient ing1 = new Ingredient();
        ing1.setName("Tomato");
        em.persist(ing1);

        Ingredient ing2 = new Ingredient();
        ing2.setName("Pasta");
        em.persist(ing2);

        Ingredient ing3 = new Ingredient();
        ing3.setName("Beef");
        em.persist(ing3);

        Ingredient ing4 = new Ingredient();
        ing4.setName("Prawn");
        em.persist(ing4);

        Ingredient ing5 = new Ingredient();
        ing5.setName("Linguine");
        em.persist(ing5);

        Ingredient ing6 = new Ingredient();
        ing6.setName("Spinach");
        em.persist(ing6);

        Ingredient ing7 = new Ingredient();
        ing7.setName("Strawberry");
        em.persist(ing7);

        Ingredient ing8 = new Ingredient();
        ing8.setName("Pineapple");
        em.persist(ing8);

        Ingredient ing9 = new Ingredient();
        ing9.setName("Banana");
        em.persist(ing9);

        //Jelo
        Meal meal1 = new Meal();
        meal1.setName("Bolognese");
        meal1.getIngredients().add(ing1);
        meal1.getIngredients().add(ing2);
        meal1.getIngredients().add(ing3);
        em.persist(meal1);

        Meal meal2 = new Meal();
        meal2.setName("King Prawn Linguine");
        meal2.getIngredients().add(ing4);
        meal2.getIngredients().add(ing5);
        meal2.getIngredients().add(ing6);
        em.persist(meal2);

        Meal meal3 = new Meal();
        meal3.setName("Fruit Salad");
        meal3.getIngredients().add(ing7);
        meal3.getIngredients().add(ing8);
        meal3.getIngredients().add(ing9);
        em.persist(meal3);

        List<Meal> meals = em.createQuery("SELECT m FROM Meal m", Meal.class).getResultList();
        for (Meal m : meals) {
            System.out.println("Meal: " + m.getName());
            for (Ingredient i : m.getIngredients()) {
                System.out.println("Ingredient: " + i.getName());
            }
            System.out.println();
        }

        tx.commit();
        em.close();
        emf.close();
    }
}