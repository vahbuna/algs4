
package edu.assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

/**
 *
 * @author vahbuna
 */
class RandomizedQueueTest {
    private RandomizedQueue<Integer> queue;

    @BeforeAll
    void setUp() {
        queue = new RandomizedQueue<Integer>();
    }

    @Test
    void testIterator() {
        queue.enqueue(3);
        queue.enqueue(13);
        queue.enqueue(31);
        queue.enqueue(39);
        queue.enqueue(93);

        Iterator<Integer> x = queue.iterator();
        List<Integer> unique = new ArrayList<Integer>();
        while(x.hasNext()) {
            Integer temp = x.next();
            if(unique.contains(temp.intValue()))
                fail();
            else
                unique.add(temp.intValue());
        }
    }

    @Test
    void testSample() {
        assertThrows(IllegalArgumentException.class, () -> {queue.sample();});
    }

    @Test
    void enQdQs() {
        queue.enqueue(3);
        queue.enqueue(13);
        queue.enqueue(31);
        queue.enqueue(39);
        queue.enqueue(93);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
    }
}
