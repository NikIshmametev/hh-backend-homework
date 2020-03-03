package ru.hh.backend;

import ru.hh.nab.starter.NabApplication;

public class Main {
    public static void main(String[] args) {
        build().run(AppConfig.class);
    }

    public static NabApplication build() {
        return NabApplication.builder()
                .configureJersey().bindToRoot()
                .build();
    }
}
