package com.nora.events;

import java.time.Instant;

public record OrderEvent (String orderId, int seq, String eventType, Instant ts){}

