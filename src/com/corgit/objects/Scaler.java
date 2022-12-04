package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import org.checkerframework.checker.units.qual.A;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Scaler implements CorgitObject {

    private double sx, sy;
    private CorgitObject object;

    public Scaler(double sx, double sy, CorgitObject object) {
        this.sx = sx;
        this.sy = sy;
        this.object = object;
    }

    public Scaler(CorgitObject object) {
        this(1, 1, object);
    }

    @Override
    public int draw(Buffer buffer) {
        int width = buffer.getBuffer().getWidth();
        int height = buffer.getBuffer().getHeight();
        AffineTransform oldTransform = buffer.getGraphics().getTransform();
        AffineTransform at = buffer.getGraphics().getTransform();
        at.translate((width - object.getW() * sx) / 2,
                        (height - object.getH() * sy) / 2);
        at.scale(sx, sy);

        buffer.getGraphics().setTransform(at);
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

    public void setSXY(double sx, double sy) {
        setSx(sx); setSy(sy);
    }

    public double getSx() {
        return sx;
    }

    public void setSx(double sx) {
        this.sx = sx;
    }

    public double getSy() {
        return sy;
    }

    public void setSy(double sy) {
        this.sy = sy;
    }

    public CorgitObject getObject() {
        return object;
    }

    public void setObject(CorgitObject object) {
        this.object = object;
    }
}
