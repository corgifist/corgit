package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.Display;
import com.corgit.animations.Animation;

public interface CorgitObject {
    int draw(Buffer buffer);

    void setX(int x);
    void setY(int y);

    void setW(int w);
    void setH(int h);

    int getX();
    int getY();

    int getW();
    int getH();

    void addAnimation(Animation animation);
    void tickAnimation();
    Animation getAnimation(int index);
}
