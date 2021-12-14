package edu.assignment;

import static org.junit.jupiter.api.Assertions.*;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author vahbuna
 */
class PercolationTest {
    private Percolation grid;
   
    @BeforeAll
    void setUp() {
        grid = new Percolation(10);
    }
    
    @Test
    void openExtremeNodes() {
        grid.open(1, 1);
        
        assertTrue(grid.isFull(1, 1));
        grid.open(1, 10);
        grid.open(10, 1);
        assertFalse(grid.isFull(10, 1));
        grid.open(10, 10);
        assertEquals(4, grid.numberOfOpenSites());
        assertFalse(grid.percolates());
    }  
    
    @Test
    void openOneNode() {
        grid.open(1, 1);
        grid.open(1, 1);
        assertEquals(1, grid.numberOfOpenSites());
        
        assertFalse(grid.percolates());
    }  
    
    @Test
    void percolationTest() {
        for(int i=1; i <11; i++) {
            grid.open(i, 1);    
        }
        assertEquals(10, grid.numberOfOpenSites());
        assertTrue(grid.percolates());
    }
    
    @Test
    void inputFifty() {
        // following code taken from PercolationVisualizer.java
        In in = new In("data/percolation/input50.txt");      // input file
        int n = in.readInt();         // n-by-n percolation system
        Percolation perc = new Percolation(n);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertEquals(1412, perc.numberOfOpenSites());
        assertTrue(perc.percolates());
    }
    
    @Test
    void inputTwentyFull() {
        // following code taken from PercolationVisualizer.java
        In in = new In("data/percolation/input20.txt");      // input file
        int n = in.readInt();         // n-by-n percolation system
        Percolation perc = new Percolation(n);
        while (!in.isEmpty()) {
            int i = in.readInt();
            int j = in.readInt();
            perc.open(i, j);
        }
        assertEquals(250, perc.numberOfOpenSites());
        assertTrue(perc.percolates());
        assertFalse(perc.isFull(18, 1));
    }
}
