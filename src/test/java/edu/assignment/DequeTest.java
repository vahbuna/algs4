package edu.assignment;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author vahbuna
 */
class DequeTest {
    private Deque<Integer> queue;

    @BeforeAll
    void setUp() {
        queue = new Deque<Integer>();
    }

    @Test
    void addIntegerTests() {
        assertEquals(0, queue.size());
        queue.addFirst(4);
        queue.addLast(14);

        assertEquals(new Integer(4), queue.removeFirst());
        assertEquals(new Integer(14), queue.removeFirst());

        assertEquals(0, queue.size());
    }

    @Test
    void addLastIntegerTests() {
        assertEquals(0, queue.size());
        queue.addLast(4);
        queue.addLast(14);

        assertEquals(new Integer(4), queue.removeFirst());
        assertEquals(new Integer(14), queue.removeFirst());

        assertEquals(0, queue.size());
    }
}
