package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import com.corgit.util.AtlasMap;
import com.corgit.util.LinearMap;
import org.checkerframework.checker.units.qual.A;

import javax.swing.*;
import java.util.*;

public class ParsedGroup implements CorgitObject {

    private HashMap<String, AtlasMap> atlases;
    private LinearMap<String, CorgitObject> group;

    private Grouping renderLayer;

    public ParsedGroup(HashMap<String, AtlasMap> atlases, LinearMap<String, CorgitObject> group) {
        this.atlases = atlases;
        this.group = group;
        ArrayList<CorgitObject> objects = group.getValues();
        Collections.reverse(objects);
        this.renderLayer = new Grouping(0, 0, objects.toArray(new CorgitObject[] {}));
    }

    @Override
    public int draw(Buffer buffer) {
        return renderLayer.draw(buffer);
    }

    @Override
    public void addAnimation(Animation animation) {
        renderLayer.addAnimation(animation);
    }

    @Override
    public void tickAnimation() {
        renderLayer.tickAnimation();
    }

    @Override
    public Animation getAnimation(int index) {
        return renderLayer.getAnimation(index);
    }

    @Override
    public ArrayList<Animation> animations() {
        return renderLayer.animations();
    }

    @Override
    public int getX() {
        return renderLayer.getX();
    }

    @Override
    public void setX(int x) {
        renderLayer.setX(x);
    }

    @Override
    public int getY() {
        return renderLayer.getY();
    }

    @Override
    public void setY(int y) {
        renderLayer.setY(y);
    }

    @Override
    public int getW() {
        return renderLayer.getW();
    }

    @Override
    public void setW(int w) {
        renderLayer.setW(w);
    }

    @Override
    public int getH() {
        return renderLayer.getH();
    }

    @Override
    public void setH(int h) {
        renderLayer.setH(h);
    }
}
