package com.nus.edu.se.notification;

import java.time.LocalDateTime;

public record Message(String message, LocalDateTime created) {
}
