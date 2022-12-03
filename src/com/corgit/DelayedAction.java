package com.corgit;

import com.corgit.objects.CorgitObject;

public class DelayedAction implements Action {

    private int delay, target;

    private Action action;

    public DelayedAction(int target, Action action) {
        this.delay = 0;
        this.target = target * 60;
        this.action = action;
    }

    @Override
    public void act(CorgitObject object) {
        if (delay == target) action.act(object);
        delay++;
    }
}
