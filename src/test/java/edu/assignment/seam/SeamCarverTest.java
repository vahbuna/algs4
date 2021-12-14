package edu.assignment.seam;

import edu.princeton.cs.algs4.Picture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author vahbuna
 */
class SeamCarverTest {
    private SeamCarver seam;

    @BeforeAll
    void init() {
        Picture picture = new Picture("/Users/anu/Projects/algs4/target/classes"
                + "/data/seam/6x5.png");
        seam = new SeamCarver(picture);
    }

    @Test
    void testHeight() {
        assertEquals(5, seam.height());
    }

    @Test
    void testWidth() {
        assertEquals(6, seam.width());
    }

    @Test
    void incorrectPixel() {
        assertThrows(IllegalArgumentException.class, () -> {seam.energy(-1, 0);});
    }

    @Test
    void testEnergy() {
        assertEquals(0, Double.compare(151.0231770292229, seam.energy(2, 1)));
    }

    @Test
    void vertSeam() {
        int[] answer = new int[] {3, 4, 3, 2, 3};
        assertThat(seam.findVerticalSeam()).containsExactly(answer);
    }

    @Test
    void horizSeam() {
        int[] answer = new int[] {1, 2, 1, 2, 1, 0};
        assertThat(seam.findHorizontalSeam()).containsExactly(answer);
    }

    @Test
    void removeSeam() {
        int[] answer = new int[] {3, 4, 3, 2, 3};
        seam.removeVerticalSeam(answer);
    }

    @Test
    void removeHorizSeam() {
        int[] answer = new int[] {1, 2, 1, 2, 1, 0};
        seam.removeHorizontalSeam(answer);
    }

    @Test
    void invalidSeam() {
        int[] answer = new int[] {-1, 0, 1, 0, -1};
        assertThrows(IllegalArgumentException.class, () -> {seam.removeVerticalSeam(answer);});
    }
}
