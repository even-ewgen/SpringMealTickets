package org.hse.example;

import org.springframework.context.annotation.Bean;

/**
 * Предоставляет методя для работы со счастливыми билетами
 */
public interface MealTicket {
    /**
     * @return true, если билет счастливый
     */
    boolean isMealTicket();

}
