package com.corgit.animations;

import com.corgit.objects.CorgitObject;

public interface Animation {

    void animate(CorgitObject object);

    void enable();
    void disable();

}
