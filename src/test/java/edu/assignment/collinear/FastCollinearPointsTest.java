/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.assignment.collinear;

import edu.princeton.cs.algs4.In;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author vahbuna
 */
class FastCollinearPointsTest {

    @Test
    void nullList() {
        assertThrows(IllegalArgumentException.class, () -> {new FastCollinearPoints(null);});
    }

    @Test
    void nullPoint() {
        Point one = new Point(3, 4);
        Point[] points = new Point[2];
        points[0] = one;
        points[1] = null;
        assertThrows(IllegalArgumentException.class, () -> {new FastCollinearPoints(points);});
    }

    @Test
    void duplicatePoints() {
        Point one = new Point(3, 4);
        Point two = new Point(3, 4);
        Point[] points = new Point[2];
        points[0] = one;
        points[1] = two;
        assertThrows(IllegalArgumentException.class, () -> {new FastCollinearPoints(points);});
    }

    @ParameterizedTest
    @CsvSource(
            { "6, 1, data/collinear/input6.txt",
              "8, 2, data/collinear/input8.txt",
              "15, 4, data/collinear/equidistant.txt"
            })
    void variousInputs(int count, int numSeq, String file) {
        In in = new In(file);
        int n = in.readInt();
        assertEquals(count, n);
        Point[] points = new Point[n];
        int i = 0;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            points[i++] = new Point(p, q);
        }
        FastCollinearPoints temp = new FastCollinearPoints(points);
        assertEquals(numSeq, temp.numberOfSegments());
    }

    @Test
    void horizontalInputs() {
        In in = new In("data/collinear/horizontal5.txt");
        int n = in.readInt();
        assertEquals(20, n);
        Point[] points = new Point[n];
        int i = 0;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            points[i++] = new Point(p, q);
        }

        FastCollinearPoints temp = new FastCollinearPoints(points);
        assertEquals(5, temp.numberOfSegments());
        LineSegment[] answer = temp.segments();
        for (int j = 0; j < answer.length; j++) {
            System.out.println(answer[j].toString());
        }
    }

    @Test
    void noLines() {
        In in = new In("data/collinear/random23.txt");
        int n = in.readInt();
        assertEquals(23, n);
        Point[] points = new Point[n];
        int i = 0;
        while (!in.isEmpty()) {
            int p = in.readInt();
            int q = in.readInt();
            points[i++] = new Point(p, q);
        }

        FastCollinearPoints temp = new FastCollinearPoints(points);
        assertEquals(0, temp.numberOfSegments());
        LineSegment[] answer = temp.segments();
    }
}
