package me.kifio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class Kid {

    String name;

    @Autowired
    Parrot parrot;

    @PostConstruct
    void init() {
        name = "Leo";
    }

    @Override
    public String toString() {
        return "У мальчика по имени " + name +
                " есть папуга " + parrot + ".";
    }
}
