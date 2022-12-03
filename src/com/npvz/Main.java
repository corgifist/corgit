package com.npvz;

import com.corgit.ApplicationMaster;
import com.npvz.scenes.NativePVZ;

import static com.corgit.ApplicationMaster.display;

public class Main {
    public static void main(String[] args) {
        ApplicationMaster.load(new NativePVZ());
        display.run();
    }
}