/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.assignment.collinear;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author vahbuna
 */
class BruteCollinearPointsTest {

    @Test
    void sixInputs() {
        In in = new In("data/collinear/input6.txt");
        int n = in.readInt();
        assertEquals(6, n);
        Point[] points = new Point[n];
        int i = 0;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            points[i++] = new Point(p, q);
        }
        BruteCollinearPoints temp = new BruteCollinearPoints(points);
        assertEquals(3, temp.numberOfSegments());
        LineSegment[] answer = temp.segments();
        for (int j = 0; j < answer.length; j++) {
            System.out.println(answer[j].toString());
        }
    }

    @Test
    void nullList() {
        assertThrows(IllegalArgumentException.class, () -> {new BruteCollinearPoints(null);});
    }

    @Test
    void nullPoint() {
        Point one = new Point(3, 4);
        Point[] points = new Point[2];
        points[0] = one;
        points[1] = null;
        assertThrows(IllegalArgumentException.class, () -> {new BruteCollinearPoints(points);});
    }

    @Test
    void duplicatePoints() {
        Point one = new Point(3, 4);
        Point two = new Point(3, 4);
        Point[] points = new Point[2];
        points[0] = one;
        points[1] = two;
        assertThrows(IllegalArgumentException.class, () -> {new BruteCollinearPoints(points);});
    }
}
