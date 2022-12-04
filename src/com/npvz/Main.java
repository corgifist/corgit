package com.npvz;

import com.corgit.ApplicationMaster;
import com.corgit.util.RenderingMethod;
import com.npvz.scenes.IntersectTest;
import com.npvz.scenes.NativePVZ;

import static com.corgit.ApplicationMaster.display;

public class Main {
    public static void main(String[] args) {
        if (ApplicationMaster.RMETHOD == RenderingMethod.PERFORMANCE) {
            System.setProperty("sun.java2d.d3d", "True");
        }
        ApplicationMaster.load(new NativePVZ());
        display.run();
    }
}