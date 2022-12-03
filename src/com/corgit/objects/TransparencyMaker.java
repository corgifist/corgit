package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;

import java.awt.*;
import java.util.ArrayList;

public class TransparencyMaker implements CorgitObject {

    private CorgitObject object;
    private double factor;

    public TransparencyMaker(CorgitObject object, double factor) {
        this.object = object;
        this.factor = factor;
    }

    @Override
    public int draw(Buffer buffer) {
        Composite originalComposite = buffer.getGraphics().getComposite();

        Composite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) (factor < 0 ? 0 : factor));
        buffer.getGraphics().setComposite(alphaComposite);
        object.draw(buffer);

        buffer.getGraphics().setComposite(originalComposite);
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

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public void subFactor(double factor) {
        if (getFactor() - factor < 0) {
            setFactor(0); return;
        }
        setFactor(getFactor() - factor);
    }
}
