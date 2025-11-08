package com.kuleuven.library.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    @Test
    void getRole() {
        Member member = new Member("Alice");

        assertEquals("MEMBER", member.getRole());
    }
}