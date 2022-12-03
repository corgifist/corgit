package com.corgit;

import com.corgit.objects.CorgitObject;

public class NullableAction implements Action {

    private Action action;

    public NullableAction(Action action) {
        this.action = action;
    }

    @Override
    public void act(CorgitObject object) {
        if (action != null) action.act(object);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
