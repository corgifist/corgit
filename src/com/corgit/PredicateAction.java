package com.corgit;

import com.corgit.objects.CorgitObject;

public class PredicateAction implements Action {

    private Predicate predicate;
    private Action action;

    public PredicateAction(Predicate predicate, Action action) {
        this.predicate = predicate;
        this.action = action;
    }

    public PredicateAction() {
        this(object -> false, object -> {});
    }

    @Override
    public void act(CorgitObject object) {
        if (predicate.predicate(object))
            action.act(object);
    }
}
