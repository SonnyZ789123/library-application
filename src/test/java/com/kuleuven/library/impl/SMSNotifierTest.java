package com.kuleuven.library.impl;

import com.kuleuven.library.domain.Member;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SMSNotifierTest {

    @Test
    void notifyUser() {
        Member member = new Member("Alice");
        SMSNotifier smsNotifier = new SMSNotifier();
        // Since the notifyUser method does not return anything and only prints to console,
        // we can only test that it runs without throwing an exception.

        assertDoesNotThrow(() -> smsNotifier.notifyUser(member, "Test message"));
    }
}