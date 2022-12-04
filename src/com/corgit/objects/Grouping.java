package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import org.checkerframework.checker.units.qual.A;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Arrays;

public class Grouping implements CorgitObject {

    private ArrayList<CorgitObject> objects;
    private ArrayList<Animation> animations;

    private int x, y, w, h;

    public Grouping(ArrayList<CorgitObject> objects, int x, int y, int w, int h) {
        this.objects = objects;
        this.animations = new ArrayList<>();
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public Grouping(int x, int y, int w, int h,CorgitObject... objects) {
        this(new ArrayList<>(Arrays.asList(objects)), x, y, w, h);
    }

    public Grouping(int x, int y, CorgitObject... objects) {
        this(x, y, 1, 1, objects);
    }

    @Override
    public int draw(Buffer buffer) {
        AffineTransform oldTransform = buffer.getGraphics().getTransform();
        buffer.getGraphics().translate(x, y);
        for (CorgitObject object : objects) {
            object.draw(buffer);
        }
        buffer.getGraphics().setTransform(oldTransform);
        return 0;
    }

    @Override
    public void addAnimation(Animation animation) {
        animations.add(animation);
    }

    @Override
    public void tickAnimation() {
        for (CorgitObject object : objects) {
            object.tickAnimation();
        }
    }

    @Override
    public Animation getAnimation(int index) {
        return animations.get(index);
    }

    @Override
    public ArrayList<Animation> animations() {
        return new ArrayList<>();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getW() {
        ArrayList<Integer> ws = new ArrayList<>();
        for (CorgitObject object : objects) {
            ws.add(object.getW());
        }

        int candidate = 1;
        for (Integer wc : ws) {
            if (wc > candidate) candidate = wc;
        }
        return candidate;
    }

    @Override
    public void setW(int w) {
        this.w = w;
    }

    @Override
    public int getH() {
        ArrayList<Integer> hs = new ArrayList<>();
        for (CorgitObject object : objects) {
            hs.add(object.getH());
        }

        int candidate = 1;
        for (Integer hc : hs) {
            if (hc > candidate) candidate = hc;
        }
        return candidate;
    }

    @Override
    public void setH(int h) {
        this.h = h;
    }
}
