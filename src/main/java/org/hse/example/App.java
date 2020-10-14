package org.hse.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContextExtensionsKt;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Приложение для работы со счастливым
 */
public class App {
    /**
     * Счётчик счастливых билетов
     */
    private static long count = 0; // для грязного хака с лямблами

    /**
     * Основной метод. Вычисляет количество счастливых билетов
     *
     * @param args аргументы
     */
    public static void main(String... args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("org.hse.example");
        Supplier<Long> mealTicketsCounter = context.getBean("evenMealTicketsCounter", Supplier.class);

        System.out.println("Счастливых билетов " + mealTicketsCounter.get());
    }
}
