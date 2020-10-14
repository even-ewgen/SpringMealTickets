package org.hse.example;

/*
* Сервис, выполняющий счет счастливых билетов
* */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

@Service("mealTicketsCounter")
@Primary
public class MealTicketsCounter implements Supplier<Long> {

    private final Iterator<MealTicket> ticketIterator;

    @Autowired
    public MealTicketsCounter(
            @Qualifier("smallTicketsGenerator") Iterator<MealTicket> ticketIterator) {
        this.ticketIterator = ticketIterator;
    }

    /*
    * Выводит счастливые бмлеты и считает их количество
    *
    * @return Long
    */
    @Override
    public Long get() {
        Iterable<MealTicket> tickets = () -> ticketIterator;
        return StreamSupport.stream(tickets.spliterator(), false)
        .filter(MealTicket::isMealTicket)
        .peek(System.out::println)
        .count();
    }
}
