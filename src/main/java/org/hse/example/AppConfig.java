package org.hse.example;

/*
* Класс конфигурирует спринг
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Iterator;
import java.util.function.Supplier;

@Configuration
public class AppConfig {
    @Bean("ticketLength")
    public Integer getTicketLength() {
        return 4;
    }


    @Bean("mealTicketsCounter")
    @Primary
    @Autowired
    public Supplier<Long> getTicketsCount(@Qualifier("smallTicketsGenerator")
                                              final Iterator<MealTicket> ticketIterator) {
        return new MealTicketsCounter(ticketIterator);
    }
}
