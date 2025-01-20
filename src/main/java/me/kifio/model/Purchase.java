package me.kifio.model;

import java.math.BigDecimal;

public record Purchase(int id, String product, BigDecimal price) { }
