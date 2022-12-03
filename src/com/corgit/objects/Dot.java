package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;

import java.awt.*;
import java.util.ArrayList;

public class Dot implements CorgitObject {

    private Box box;

    public Dot(int x, int y, Color color) {
        this.box = new Box(x, y, 1, 1, color, true);
    }

    @Override
    public int draw(Buffer buffer) {
        return box.draw(buffer);
    }

    @Override
    public int getX() {
        return box.getX();
    }

    @Override
    public void setX(int x) {
        box.setX(x);
    }

    @Override
    public int getY() {
        return box.getY();
    }

    @Override
    public void addAnimation(Animation animation) {
        box.addAnimation(animation);
    }

    @Override
    public void tickAnimation() {
        box.tickAnimation();
    }

    @Override
    public Animation getAnimation(int index) {
        return box.getAnimation(index);
    }

    @Override
    public ArrayList<Animation> animations() {
        return box.animations();
    }

    @Override
    public void setY(int y) {
        box.setY(y);
    }

    @Override
    public int getW() {
        return box.getW();
    }

    @Override
    public void setW(int w) {
        box.setW(w);
    }

    @Override
    public int getH() {
        return box.getH();
    }

    @Override
    public void setH(int h) {
        box.setH(h);
    }

    public Color getColor() {
        return box.getColor();
    }

    public void setColor(Color color) {
        box.setColor(color);
    }
}
