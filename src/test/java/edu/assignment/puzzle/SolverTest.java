
package edu.assignment.puzzle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *
 * @author anu
 */
class SolverTest {
   @Test
   void solvableTest() {
       Solver solver = new Solver(
               new Board(
                       PuzzleChecker.readFile("data/puzzle/puzzle3x3-10.txt")));
       assertTrue(solver.isSolvable());
       assertEquals(10, solver.moves());
   }

   @Test
   void notSolvableTest() {
       Solver solver = new Solver(
               new Board(
                       PuzzleChecker.readFile(
                               "data/puzzle/puzzle3x3-unsolvable1.txt")));
       assertFalse(solver.isSolvable());
       assertNull(solver.solution());
   }
}
