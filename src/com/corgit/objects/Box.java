package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;

import java.awt.*;
import java.util.ArrayList;

public class Box implements CorgitObject {

    private int x, y, w, h;
    private Color color;
    private boolean fill;

    private ArrayList<Animation> animations;

    public Box(int x, int y, int w, int h, Color color, boolean fill) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        this.fill = fill;
        this.animations = new ArrayList<>();
    }

    public Box(int x, int y, int w, int h, Color color) {
        this(x, y, w, h, color, false);
    }

    public Box(int x, int y, int w, int h) {
        this(x, y, w, h, Color.WHITE);
    }

    @Override
    public int draw(Buffer buffer) {
        buffer.getGraphics().setColor(color);
        if (fill) {
            buffer.getGraphics().fillRect(x, y, w, h);
        } else {
            buffer.getGraphics().drawRect(x, y, w, h);
        }
        return 0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void addAnimation(Animation animation) {
        animations.add(animation);
    }

    @Override
    public void tickAnimation() {
        for (Animation anim : animations) {
            anim.animate(this);
        }
    }

    @Override
    public Animation getAnimation(int index) {
        return animations.get(index);
    }

    @Override
    public ArrayList<Animation> animations() {
        return animations;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
