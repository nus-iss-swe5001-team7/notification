package com.nus.edu.se.notification;

public record MessageRequest(String userId, String orderId, StatusEnum status) {
}
