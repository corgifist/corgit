package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Rotator implements CorgitObject {

    private CorgitObject object;
    private double degree;

    public Rotator(CorgitObject object, double degree) {
        this.object = object;
        this.degree = degree;
    }

    @Override
    public int draw(Buffer buffer) {
        AffineTransform oldTransform = buffer.getGraphics().getTransform();
        ((Graphics2D) buffer.getGraphics()).rotate(Math.toRadians(degree),
                object.getX() + (float) object.getW() / 2,
                    object.getY() + (float) object.getH() / 2);
        object.draw(buffer);
        buffer.getGraphics().setTransform(oldTransform);
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
        return object.getX();
    }

    @Override
    public int getY() {
        return object.getY();
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

    public CorgitObject getObject() {
        return object;
    }

    public void setObject(CorgitObject object) {
        this.object = object;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }
}
