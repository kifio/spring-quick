package me.kifio.model;

import org.springframework.data.annotation.Id;

public record Account(@Id int id, String name, int amount) { }
