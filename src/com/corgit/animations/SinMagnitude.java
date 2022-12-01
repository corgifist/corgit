package com.corgit.animations;

import com.corgit.GameClock;
import com.corgit.OneTimeAction;
import com.corgit.objects.CorgitObject;

public class SinMagnitude implements Animation {

    private boolean enabled;

    private OneTimeAction saveSources;
    private int sourceW, sourceH, sourceX, sourceY;

    public SinMagnitude() {
        this.enabled = true;
        this.saveSources = new OneTimeAction((object -> {
            sourceW = object.getW();
            sourceH = object.getH();
        }));
    }

    @Override
    public void animate(CorgitObject object) {
        if (!enabled) return;
        saveSources.act(object);
        int RHYTM = 12;
        int time = (int) (GameClock.time);
        object.setW((int) (sourceW + (Math.sin(time) * RHYTM)));
        object.setH((int) (sourceH + (Math.cos(time) * RHYTM)));
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
