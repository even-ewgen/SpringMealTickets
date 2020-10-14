package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

@Service("evenMealTicketsCounter")
public class EvenMealTicketsCounter  implements Supplier<Long> {
    private final Iterator<MealTicket> ticketIterator;

    @Autowired
    public EvenMealTicketsCounter(
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
                .filter(MealTicket::getEven)
                .peek(System.out::println)
                .count();
    }
}
