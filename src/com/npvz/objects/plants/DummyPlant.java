package com.npvz.objects.plants;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import com.corgit.objects.Box;
import com.corgit.objects.CorgitObject;

import java.awt.*;
import java.util.ArrayList;

public class DummyPlant implements CorgitObject {

    private int x, y;
    private Box box;

    public DummyPlant() {
        this.box = new Box(x, y, 89, 89, Color.CYAN, true);
    }

    @Override
    public int draw(Buffer buffer) {
        box.draw(buffer);
        return 0;
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
    public void setY(int y) {
        box.setY(y);
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }
}
