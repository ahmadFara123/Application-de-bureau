import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ContrainteTest {
    public static final Intervalle i_1_2 = new Intervalle( 1, 2 );
    public static final Intervalle i_1_3 = new Intervalle( 1, 3 );
    public static final Intervalle i_1_4 = new Intervalle( 1, 4 );
    public static final Intervalle i_1_5 = new Intervalle( 1, 5 );
    public static final Intervalle i_1_6 = new Intervalle( 1, 6 );
    public static final Intervalle i_1_7 = new Intervalle( 1, 7 );
    public static final Intervalle i_1_8 = new Intervalle( 1, 8 );
    public static final Intervalle i_1_9 = new Intervalle( 1, 9 );
    public static final Intervalle i_1_10 = new Intervalle( 1, 10 );
    public static final Intervalle i_2_3 = new Intervalle( 2, 3 );
    public static final Intervalle i_2_5 = new Intervalle( 2, 5 );
    public static final Intervalle i_2_10 = new Intervalle( 2, 10 );
    public static final Intervalle i_3_4 = new Intervalle( 3, 4 );
    public static final Intervalle i_4_5 = new Intervalle( 4, 5 );
    public static final Intervalle i_4_6 = new Intervalle( 4, 6 );
    public static final Intervalle i_4_7 = new Intervalle( 4, 7 );
    public static final Intervalle i_4_8 = new Intervalle( 4, 8 );
    public static final Intervalle i_4_9 = new Intervalle( 4, 9 );
    public static final Intervalle i_5_6 = new Intervalle( 5, 6 );
    public static final Intervalle i_5_7 = new Intervalle( 5, 7 );
    public static final Intervalle i_6_7 = new Intervalle( 6, 7 );
    public static final Intervalle i_6_8 = new Intervalle( 6, 8 );
    public static final Intervalle i_6_9 = new Intervalle( 6, 9 );
    public static final Intervalle i_7_8 = new Intervalle( 7, 8 );
    public static final Intervalle i_7_9 = new Intervalle( 7, 9 );
    public static final Intervalle i_8_9 = new Intervalle( 8, 9 );
    public static final Intervalle i_9_10 = new Intervalle( 9, 10 );
    public static final Intervalle i_10_11 = new Intervalle( 10, 11 );
    public static final Intervalle i_11_12 = new Intervalle( 11, 12 );
    public static final Intervalle i_12_13 = new Intervalle( 12, 13 );
    public static final Intervalle i_14_15 = new Intervalle( 14, 15 );

    @Test
    void testContrainte1() {
        Contrainte c = new Contrainte();

        assertTrue( c.isEmpty() );
    }

    @Test
    void testContrainteCollectionOfIntervalle1() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2 );
        Contrainte c = new Contrainte( xs );

        assertIterableEquals( xs, c );
    }

    @Test
    void testContrainteCollectionOfIntervalle2() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_4_5 );
        Contrainte c = new Contrainte( xs );

        assertIterableEquals( xs, c );
    }

    @Test
    void testContrainteCollectionOfIntervalle3() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_4_5, i_7_8 );
        Contrainte c = new Contrainte( xs );

        assertIterableEquals( xs, c );
    }

    @Test
    void testContrainteCollectionOfIntervalle4() {
        List< Intervalle > xs =
                Arrays.asList( i_7_8, i_4_5, i_1_2 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_4_5, i_7_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle1() {
        Contrainte c = new Contrainte();
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle2() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle3() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle4() {
        List< Intervalle > xs =
                Arrays.asList( i_1_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle5() {
        List< Intervalle > xs =
                Arrays.asList( i_1_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle6() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle7() {
        List< Intervalle > xs =
                Arrays.asList( i_4_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle8() {
        List< Intervalle > xs =
                Arrays.asList( i_4_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle9() {
        List< Intervalle > xs =
                Arrays.asList( i_7_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle10() {
        List< Intervalle > xs =
                Arrays.asList( i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle11() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_4_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle12() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4, i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle13() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_7_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle14() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4, i_7_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle15() {
        List< Intervalle > xs =
                Arrays.asList( i_1_5, i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_7, i_8_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle16() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_6_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2 , i_4_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle17() {
        List< Intervalle > xs =
                Arrays.asList( i_1_5, i_6_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_9 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle18() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_7 );

        c.add( i_1_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle19() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_7 );

        c.add( i_1_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle20() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_8 );

        c.add( i_1_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle21() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        c.add( i_4_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle22() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        c.add( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle23() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_8 );

        c.add( i_4_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle24() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        c.add( i_5_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testAddIntervalle25() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_8 );

        c.add( i_4_8 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle1() {
        Contrainte c = new Contrainte();

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle2() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle3() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_4 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle4() {
        List< Intervalle > xs =
                Arrays.asList( i_1_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_4 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle5() {
        List< Intervalle > xs =
                Arrays.asList( i_1_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_4, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle6() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5 );
        Contrainte c = new Contrainte( xs );

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle7() {
        List< Intervalle > xs =
                Arrays.asList( i_4_7 );
        Contrainte c = new Contrainte( xs );

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle8() {
        List< Intervalle > xs =
                Arrays.asList( i_4_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle9() {
        List< Intervalle > xs =
                Arrays.asList( i_7_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle10() {
        List< Intervalle > xs =
                Arrays.asList( i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle11() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle12() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4, i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_4, i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle13() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_7_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle14() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4, i_7_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_4, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle15() {
        List< Intervalle > xs =
                Arrays.asList( i_1_5, i_8_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_4, i_8_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle16() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_6_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle17() {
        List< Intervalle > xs =
                Arrays.asList( i_1_5, i_6_9 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_1_4, i_7_9 );

        c.remove( i_4_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle18() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_6_7 );

        c.remove( i_1_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle19() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );

        c.remove( i_1_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle20() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );

        c.remove( i_1_8 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle21() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_6_7 );

        c.remove( i_4_6 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle22() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );

        c.remove( i_4_7 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle23() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );

        c.remove( i_4_8 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testRemoveIntervalle24() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );
        List< Intervalle > r =
                Arrays.asList( i_4_5 );

        c.remove( i_5_7 );

        assertIterableEquals( r, c );
    }

    @Test
    void testRemoveIntervalle25() {
        List< Intervalle > xs =
                Arrays.asList( i_4_5, i_6_7 );
        Contrainte c = new Contrainte( xs );

        c.remove( i_4_8 );

        assertTrue( c.isEmpty() );
    }

    @Test
    void testAppartient1() {
        Contrainte c = new Contrainte();

        assertFalse( c.appartient( 2 ) );
    }

    @Test
    void testAppartient2() {
        List< Intervalle > xs =
                Arrays.asList( i_4_7 );
        Contrainte c = new Contrainte( xs );

        assertFalse( c.appartient( 3 ) );
        assertTrue( c.appartient( 4 ) );
        assertTrue( c.appartient( 5 ) );
        assertTrue( c.appartient( 6 ) );
        assertFalse( c.appartient( 7 ) );
        assertFalse( c.appartient( 8 ) );
    }

    @Test
    void testAppartient3() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4, i_6_9 );
        Contrainte c = new Contrainte( xs );

        assertFalse( c.appartient( 0 ) );
        assertTrue( c.appartient( 1 ) );
        assertTrue( c.appartient( 2 ) );
        assertTrue( c.appartient( 3 ) );
        assertFalse( c.appartient( 4 ) );
        assertFalse( c.appartient( 5 ) );
        assertTrue( c.appartient( 6 ) );
        assertTrue( c.appartient( 7 ) );
        assertTrue( c.appartient( 8 ) );
        assertFalse( c.appartient( 9 ) );
    }

    @Test
    void testAppartient4() {
        List< Intervalle > xs =
                Arrays.asList( i_1_4, i_5_7 );
        Contrainte c = new Contrainte( xs );

        assertTrue( c.appartient( 3 ) );
        assertFalse( c.appartient( 4 ) );
        assertTrue( c.appartient( 5 ) );
    }

    @Test
    void testAppartient5() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_4_5, i_7_8 );
        Contrainte c = new Contrainte( xs );

        assertFalse( c.appartient( 3 ) );
        assertTrue( c.appartient( 4 ) );
        assertFalse( c.appartient( 5 ) );
        assertFalse( c.appartient( 6 ) );
    }

    @Test
    void testTaille1() {
        Contrainte c = new Contrainte();

        assertEquals( 0, c.taille() );
    }

    @Test
    void testTaille2() {
        List< Intervalle > xs =
                Arrays.asList( i_4_7 );
        Contrainte c = new Contrainte( xs );

        assertEquals( 3, c.taille() );
    }

    @Test
    void testTaille3() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_4_7 );
        Contrainte c = new Contrainte( xs );

        assertEquals( 4, c.taille() );
    }

    @Test
    void testTaille4() {
        List< Intervalle > xs =
                Arrays.asList( i_1_2, i_4_7, i_8_9 );
        Contrainte c = new Contrainte( xs );

        assertEquals( 5, c.taille() );
    }

    @Test
    void testIntersection1() {
        Contrainte c1 = new Contrainte();
        Contrainte c2 = new Contrainte();

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection2() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte();

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection3() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte();
        Contrainte c2 = new Contrainte( xs1 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection4() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs1 );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testIntersection5() {
        List< Intervalle > xs1 =
                Arrays.asList( i_2_3 );
        List< Intervalle > xs2 =
                Arrays.asList( i_1_2 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection6() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_2, i_3_4 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_3, i_4_5 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection7() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_2, i_5_6 );
        List< Intervalle > xs2 =
                Arrays.asList( i_3_4, i_7_8 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );

        assertTrue( c1.intersection( c2 ).isEmpty() );
    }

    @Test
    void testIntersection8() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_3, i_4_6, i_7_8 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_5, i_9_10 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_2_3, i_4_5 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testIntersection9() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_3, i_4_5, i_6_7, i_8_9, i_11_12 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_10 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_2_3, i_4_5, i_6_7, i_8_9 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testIntersection10() {
        List< Intervalle > xs1 =
                Arrays.asList( i_2_3, i_4_6, i_7_9, i_10_11, i_12_13 );
        List< Intervalle > xs2 =
                Arrays.asList( i_1_5, i_6_8, i_14_15 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_2_3, i_4_5, i_7_8 );

        assertIterableEquals( r, c1.intersection( c2 ) );
    }

    @Test
    void testUnion1() {
        Contrainte c1 = new Contrainte();
        Contrainte c2 = new Contrainte();

        assertTrue( c1.union( c2 ).isEmpty() );
    }

    @Test
    void testUnion2() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte();
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion3() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte();
        Contrainte c2 = new Contrainte( xs1 );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion4() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs1 );
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion5() {
        List< Intervalle > xs1 =
                Arrays.asList( i_2_3 );
        List< Intervalle > xs2 =
                Arrays.asList( i_1_2 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_3 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion6() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_2, i_3_4 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_3, i_4_5 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_5 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion7() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_2, i_5_6 );
        List< Intervalle > xs2 =
                Arrays.asList( i_3_4, i_7_8 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_3_4, i_5_6, i_7_8 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion8() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_3, i_4_6, i_7_8 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_5, i_9_10 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_6, i_7_8, i_9_10 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion9() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_3, i_4_5, i_6_7, i_8_9, i_11_12 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_10 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_10, i_11_12 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testUnion10() {
        List< Intervalle > xs1 =
                Arrays.asList( i_2_3, i_4_6, i_7_9, i_10_11, i_12_13 );
        List< Intervalle > xs2 =
                Arrays.asList( i_1_5, i_6_8, i_14_15 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_9, i_10_11, i_12_13, i_14_15 );

        assertIterableEquals( r, c1.union( c2 ) );
    }

    @Test
    void testSoustraction1() {
        Contrainte c1 = new Contrainte();
        Contrainte c2 = new Contrainte();

        assertTrue( c1.soustraction( c2 ).isEmpty() );
    }

    @Test
    void testSoustraction2() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte();
        List< Intervalle > r =
                Arrays.asList( i_4_7 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction3() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte();
        Contrainte c2 = new Contrainte( xs1 );

        assertTrue( c1.soustraction( c2 ).isEmpty() );
    }

    @Test
    void testSoustraction4() {
        List< Intervalle > xs1 =
                Arrays.asList( i_4_7 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs1 );

        assertTrue( c1.soustraction( c2 ).isEmpty() );
    }

    @Test
    void testSoustraction5() {
        List< Intervalle > xs1 =
                Arrays.asList( i_2_3 );
        List< Intervalle > xs2 =
                Arrays.asList( i_1_2 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_2_3 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction6() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_2, i_3_4 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_3, i_4_5 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_3_4 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction7() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_2, i_5_6 );
        List< Intervalle > xs2 =
                Arrays.asList( i_3_4, i_7_8 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_5_6 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction8() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_3, i_4_6, i_7_8 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_5, i_9_10 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_5_6, i_7_8 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction9() {
        List< Intervalle > xs1 =
                Arrays.asList( i_1_3, i_4_5, i_6_7, i_8_9, i_11_12 );
        List< Intervalle > xs2 =
                Arrays.asList( i_2_10 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_1_2, i_11_12 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }

    @Test
    void testSoustraction10() {
        List< Intervalle > xs1 =
                Arrays.asList( i_2_3, i_4_6, i_7_9, i_10_11, i_12_13 );
        List< Intervalle > xs2 =
                Arrays.asList( i_1_5, i_6_8, i_14_15 );
        Contrainte c1 = new Contrainte( xs1 );
        Contrainte c2 = new Contrainte( xs2 );
        List< Intervalle > r =
                Arrays.asList( i_5_6, i_8_9, i_10_11, i_12_13 );

        assertIterableEquals( r, c1.soustraction( c2 ) );
    }
}
