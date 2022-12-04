package com.corgit.objects;

import com.corgit.ApplicationMaster;
import com.corgit.Buffer;
import com.corgit.animations.Animation;
import com.corgit.util.RenderingMethod;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Transformator implements CorgitObject {

    private CorgitObject object;
    private int x, y;

    public Transformator(CorgitObject object, int x, int y) {
        this.object = object;
        this.x = x;
        this.y = y;
    }

    @Override
    public int draw(Buffer buffer) {
        AffineTransform nullTransform = buffer.getGraphics().getTransform();
        buffer.getGraphics().translate(x, y);
        object.draw(buffer);
        buffer.getGraphics().setTransform(nullTransform);
        return 0;
    }

    @Override
    public void setX(int x) {
        object.setX(x);
    }

    @Override
    public void setY(int y) {
        object.setY(y);
    }

    @Override
    public void setW(int w) {
        object.setW(w);
    }

    @Override
    public void setH(int h) {
        object.setH(h);
    }

    @Override
    public int getX() {
        return object.getX() + x;
    }

    @Override
    public int getY() {
        return object.getY() + y;
    }

    @Override
    public int getW() {
        return object.getW();
    }

    @Override
    public int getH() {
        return object.getH();
    }

    @Override
    public void addAnimation(Animation animation) {
        object.addAnimation(animation);
    }

    @Override
    public void tickAnimation() {
        object.tickAnimation();
    }

    @Override
    public Animation getAnimation(int index) {
        return object.getAnimation(index);
    }

    @Override
    public ArrayList<Animation> animations() {
        return object.animations();
    }
}
