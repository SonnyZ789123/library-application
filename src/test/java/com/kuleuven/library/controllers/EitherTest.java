package com.kuleuven.library.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EitherTest {

    @Test
    void isLeft() {
        Either<String, Integer> either = Either.left("error");

        assertTrue(either.isLeft());
        assertFalse(either.isRight());
        assertEquals("error", either.left);
        assertNull(either.right);
    }

    @Test
    void isRight() {
        Either<String, Integer> either = Either.right(42);

        assertTrue(either.isRight());
        assertFalse(either.isLeft());
        assertEquals(42, either.right);
        assertNull(either.left);
    }

    @Test
    void left() {
        Either<String, Integer> either = Either.left("bad request");

        assertTrue(either.isLeft());
        assertEquals("bad request", either.left);
        assertNull(either.right);
    }
}
