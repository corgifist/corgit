package com.corgit.animations;

import com.corgit.objects.CorgitObject;

public class XShift implements Animation {

    private int xs;

    private boolean enabled;

    public XShift() {
        enabled = true;
    }

    @Override
    public void animate(CorgitObject object) {
        if (!enabled) return;
        object.setX((xs += 1));
    }

    @Override
    public void enable() {
        enabled = true;
    }

    @Override
    public void disable() {
        enabled = false;
    }
}
