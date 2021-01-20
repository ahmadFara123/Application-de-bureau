import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IntervalleTest {
    @Test
    void testAppartient1() {
        Intervalle i = new Intervalle( 1, 2 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( 0 ) );
        assertTrue( i.appartient( 1 ) );
        assertFalse( i.appartient( 2 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient2() {
        Intervalle i = new Intervalle( -2, -1 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( -3 ) );
        assertTrue( i.appartient( -2 ) );
        assertFalse( i.appartient( -1 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient3() {
        Intervalle i = new Intervalle( 0, 1 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( -1 ) );
        assertTrue( i.appartient( 0 ) );
        assertFalse( i.appartient( 1 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient4() {
        Intervalle i = new Intervalle( -3, 3 );

        assertFalse( i.appartient( -5 ) );
        assertFalse( i.appartient( -4 ) );
        assertTrue( i.appartient( -3 ) );
        assertTrue( i.appartient( -2 ) );
        assertTrue( i.appartient( -1 ) );
        assertTrue( i.appartient( 0 ) );
        assertTrue( i.appartient( 1 ) );
        assertTrue( i.appartient( 2 ) );
        assertFalse( i.appartient( 3 ) );
        assertFalse( i.appartient( 4 ) );
        assertFalse( i.appartient( 5 ) );
    }

    @Test
    void testAppartient5() {
        Intervalle i = new Intervalle( Integer.MIN_VALUE, 3 );

        assertTrue( i.appartient( Integer.MIN_VALUE ) );
        assertTrue( i.appartient( Integer.MIN_VALUE + 1 ) );
        assertTrue( i.appartient( 2 ) );
        assertFalse( i.appartient( 3 ) );
    }

    @Test
    void testAppartient6() {
        Intervalle i = new Intervalle( -3, Integer.MAX_VALUE );

        assertFalse( i.appartient( -4 ) );
        assertTrue( i.appartient( -3 ) );
        assertTrue( i.appartient( Integer.MAX_VALUE - 1 ) );
        assertFalse( i.appartient( Integer.MAX_VALUE ) );
    }

    @Test
    void testEquals1() {
        Intervalle i = new Intervalle( 1, 2 );

        assertFalse( i.equals( null ) );
    }

    @SuppressWarnings("unlikely-arg-type")
    @Test
    void testEquals2() {
        Intervalle i = new Intervalle( 1, 2 );
        Integer x = new Integer( 2 );

        assertFalse( i.equals( x ) );
    }

    @Test
    void testEquals3() {
        Intervalle i = new Intervalle( 1, 2 );

        assertTrue( i.equals( i ) );
    }

    @Test
    void testEquals4() {
        Intervalle i1 = new Intervalle( 1, 2 );
        Intervalle i2 = new Intervalle( 1, 2 );

        assertTrue( i1.equals( i2 ) );
    }

    @Test
    void testEquals5() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 2, 3 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals6() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 4 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals7() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 5 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals8() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 6 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals9() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals10() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 5 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals11() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 6 );

        assertTrue( i1.equals( i2 ) );
    }

    @Test
    void testEquals12() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals13() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 6 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals14() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals15() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 6, 7 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testEquals16() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 7, 8 );

        assertFalse( i1.equals( i2 ) );
    }

    @Test
    void testUnion1() {
        Intervalle i = new Intervalle( 4, 6 );

        assertEquals( i, i.union( i ).get( 0 ) );
    }

    @Test
    void testUnion2() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 6 );

        assertEquals( i1, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion3() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 4 );
        Intervalle ir = new Intervalle( 3, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion4() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 5 );
        Intervalle ir = new Intervalle( 3, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion5() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 6 );
        Intervalle ir = new Intervalle( 3, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion6() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 7 );
        Intervalle ir = new Intervalle( 3, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion7() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 5 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion8() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 7 );
        Intervalle ir = new Intervalle( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion9() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 6 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion10() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 7 );
        Intervalle ir = new Intervalle( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion11() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 6, 7 );
        Intervalle ir = new Intervalle( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testUnion12() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 2, 3 );

        Contrainte c = i1.union( i2 );

        assertEquals( i2, c.get( 0 ) );
        assertEquals( i1, c.get( 1 ) );
    }

    @Test
    void testUnion13() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 7, 8 );

        Contrainte c = i1.union( i2 );

        assertEquals( i1, c.get( 0 ) );
        assertEquals( i2, c.get( 1 ) );
    }

    @Test
    void testUnion14() {
        Intervalle i1 = new Intervalle( 4, 7 );
        Intervalle i2 = new Intervalle( 5, 6 );
        Intervalle ir = new Intervalle( 4, 7 );

        assertEquals( ir, i1.union( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection1() {
        Intervalle i = new Intervalle( 4, 6 );

        assertEquals( i, i.intersection( i ).get( 0 ) );
    }

    @Test
    void testIntersection2() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 6 );

        assertEquals( i1, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection3() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 4 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection4() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 5 );
        Intervalle ir = new Intervalle( 4, 5 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection5() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 6 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection6() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 7 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection7() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 5 );
        Intervalle ir = new Intervalle( 4, 5 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection8() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 7 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection9() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 6 );
        Intervalle ir = new Intervalle( 5, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection10() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 7 );
        Intervalle ir = new Intervalle( 5, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testIntersection11() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 6, 7 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection12() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 2, 3 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection13() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 7, 8 );

        assertTrue( i1.intersection( i2 ).isEmpty() );
    }

    @Test
    void testIntersection14() {
        Intervalle i1 = new Intervalle( 4, 7 );
        Intervalle i2 = new Intervalle( 5, 6 );
        Intervalle ir = new Intervalle( 5, 6 );

        assertEquals( ir, i1.intersection( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction1() {
        Intervalle i = new Intervalle( 4, 6 );

        assertTrue( i.soustraction( i ).isEmpty() );
    }

    @Test
    void testSoustraction2() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 6 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction3() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 4 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction4() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 5 );
        Intervalle ir = new Intervalle( 5, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction5() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 6 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction6() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 3, 7 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction7() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 5 );
        Intervalle ir = new Intervalle( 5, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction8() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 4, 7 );

        assertTrue( i1.soustraction( i2 ).isEmpty() );
    }

    @Test
    void testSoustraction9() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 6 );
        Intervalle ir = new Intervalle( 4, 5 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction10() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 5, 7 );
        Intervalle ir = new Intervalle( 4, 5 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction11() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 6, 7 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction12() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 2, 3 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction13() {
        Intervalle i1 = new Intervalle( 4, 6 );
        Intervalle i2 = new Intervalle( 7, 8 );
        Intervalle ir = new Intervalle( 4, 6 );

        assertEquals( ir, i1.soustraction( i2 ).get( 0 ) );
    }

    @Test
    void testSoustraction14() {
        Intervalle i1 = new Intervalle( 4, 7 );
        Intervalle i2 = new Intervalle( 5, 6 );
        Intervalle ir1 = new Intervalle( 4, 5 );
        Intervalle ir2 = new Intervalle( 6, 7 );

        Contrainte c = i1.soustraction( i2 );

        assertEquals( ir1, c.get( 0 ) );
        assertEquals( ir2, c.get( 1 ) );
    }
}
