/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.assignment.baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author vahbuna
 */
class BaseballEliminationTest {
    private static BaseballElimination baseballGames;
    private static BaseballElimination baseballGamesV2;

    @BeforeAll
    static void readFile() {
        baseballGames = new BaseballElimination("data/baseball/teams4.txt");
        baseballGamesV2 = new BaseballElimination("data/baseball/teams5.txt");
    }

    @Test
    void testNumberOfTeams() {
        Assertions.assertEquals(4, baseballGames.numberOfTeams());
    }

    @Test
    void testWins() {
        Assertions.assertEquals(80, baseballGames.wins("Philadelphia"));
    }

    @Test
    void testLosses() {
        Assertions.assertEquals(71, baseballGames.losses("Atlanta"));
    }

    @Test
    void testRemaining() {
        Assertions.assertEquals(3, baseballGames.remaining("Montreal"));
    }

    @Test
    void testAgainst() {
        Assertions.assertEquals(2, baseballGames.against("Montreal",
                "Philadelphia"));
    }

    @Test
    void testElimination() {
        Assertions.assertTrue(baseballGamesV2.isEliminated("Detroit"));
        Assertions.assertFalse(baseballGamesV2.isEliminated("Boston"));
        Assertions.assertFalse(baseballGamesV2.isEliminated("Baltimore"));
        for (String team : baseballGames.teams()) {
            if (baseballGames.isEliminated(team)) {
                System.out.print(team + " is eliminated by the subset R = { ");
                for (String t : baseballGames.certificateOfElimination(team)) {
                    System.out.print(t + " ");
                }
                System.out.println("}");
            } else {
                System.out.println(team + " is not eliminated");
            }
        }
    }

    @Test
    void teamNotFound() {
        assertThrows(IllegalArgumentException.class, () -> {baseballGames.losses("California");});
    }
}
