package com.corgit;

import com.corgit.util.RenderingMethod;

public class ApplicationMaster {
    public static ApplicationAdapter GLOBAL_SCENE;

    public static Display display = new Display(1280, 720, "NativePVZ");

    public static RenderingMethod RMETHOD = RenderingMethod.PERFORMANCE;

    public static void load(ApplicationAdapter app) {
        GLOBAL_SCENE = app;
    }

    public static void runtimeSwitch(Buffer frame, ApplicationAdapter app) {
        app.prepare(frame);
        GLOBAL_SCENE = app;
    }
}
