package com.corgit;

import com.corgit.objects.CorgitObject;

public class OneTimeAction implements Action {

    private boolean done;
    private Action action;

    public OneTimeAction(Action action) {
        this.action = action;
    }

    @Override
    public void act(CorgitObject object) {
        if (!done) {
            done = true;
        } else return;
        action.act(object);
    }
}
