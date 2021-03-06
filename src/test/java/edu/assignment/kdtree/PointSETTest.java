/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.assignment.kdtree;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Point2D;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


/**
 *
 * @author vahbuna
 */
public class PointSETTest {
    /**
     * check for empty.
     */
    @Test
    public void testIsEmpty() {
        PointSET points = new PointSET();
        assertTrue(points.isEmpty());
    }

    /**
     * test for null exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInsertNull() {
        PointSET points = new PointSET();
        points.insert(null);
    }

    @Test
    public void nearestPointTest() {
        In in = new In("data/kdtree/circle10.txt");
        PointSET brute = new PointSET();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            brute.insert(p);
        }

        Point2D search = new Point2D(0.7, 0.9);
        assertFalse(brute.contains(search));

        Point2D answer = brute.nearest(search);
        Point2D expectedAnswer = new Point2D(0.793893, 0.904508);
        assertTrue(expectedAnswer.equals(answer));
    }

    /**
     * test the points are unique.
     */
    @Test
    public void numberOfPoints() {
        final int expectedSize = 10;
        In in = new In("data/kdtree/circle10.txt");
        PointSET brute = new PointSET();
        while (!in.isEmpty()) {
            double x = in.readDouble();
            double y = in.readDouble();
            Point2D p = new Point2D(x, y);
            brute.insert(p);
        }
        Point2D p = new Point2D(0.793893, 0.904508);
        brute.insert(p);

        assertEquals(expectedSize, brute.size());
    }
}
