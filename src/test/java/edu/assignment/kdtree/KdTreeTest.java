/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.assignment.kdtree;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vahbuna
 */
class KdTreeTest {

    /**
     * check for empty.
     */
    @Test
    void testIsEmpty() {
        KdTree points = new KdTree();
        assertTrue(points.isEmpty());
    }

    /**
     * test for null exception.
     */
    @Test
    void testInsertNull() {
        KdTree points = new KdTree();
        assertThrows(IllegalArgumentException.class, () -> {points.insert(null);});
    }

    @Test
    void nearestPointTest() {
        In in = new In("data/kdtree/circle10.txt");
        KdTree brute = new KdTree();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            brute.insert(p);
        }

        Point2D search = new Point2D(0.208, 0.66);
        assertFalse(brute.contains(search));

        Point2D answer = brute.nearest(search);
        Point2D expectedAnswer = new Point2D(0.024472, 0.654508);
        assertEquals(expectedAnswer, answer);
    }
}
