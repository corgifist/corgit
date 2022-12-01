package com.corgit;

public class ApplicationMaster {
    public static ApplicationAdapter GLOBAL_SCENE;

    public static Display display = new Display(1280, 720, "NativePVZ");

    public static void load(ApplicationAdapter app) {
        GLOBAL_SCENE = app;
    }
}
