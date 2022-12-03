package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;

import java.util.ArrayList;

public class DummyObject implements CorgitObject {
    @Override
    public int draw(Buffer buffer) {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void setW(int w) {

    }

    @Override
    public void setH(int h) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getW() {
        return 0;
    }

    @Override
    public int getH() {
        return 0;
    }

    @Override
    public void addAnimation(Animation animation) {

    }

    @Override
    public void tickAnimation() {

    }

    @Override
    public Animation getAnimation(int index) {
        return null;
    }

    @Override
    public ArrayList<Animation> animations() {
        return null;
    }
}
