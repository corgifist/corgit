package com.corgit;

import com.corgit.objects.CorgitObject;

public class ToggleableAction implements Action {

    private boolean active;
    private Action action;

    public ToggleableAction(boolean active, Action action) {
        this.active = active;
        this.action = action;
    }

    public ToggleableAction() {
        this(false, object -> {});
    }

    @Override
    public void act(CorgitObject object) {
        if (active) action.act(object);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
