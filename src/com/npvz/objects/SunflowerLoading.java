package com.npvz.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import com.corgit.objects.CorgitObject;
import com.corgit.objects.Grouping;
import com.corgit.objects.ImageDummy;
import com.corgit.util.AtlasMap;
import com.corgit.util.AtlasMapParser;

import java.util.ArrayList;

public class SunflowerLoading implements CorgitObject {

    private final ImageDummy sunflower_back;
    private final ImageDummy sunflower_front;
    private final ImageDummy sunflower_smile;
    private final ImageDummy sunflower_eye_r;
    private final ImageDummy sunflower_eye_l;

    private final Grouping sunflower_group;

    public SunflowerLoading(int x, int y) {
        AtlasMap sunflower = AtlasMapParser.parse("sunflower.atlas_map");
        sunflower_back = new ImageDummy(0, 0,  sunflower.get("sunflower_back"));
        sunflower_front = new ImageDummy(20, 15, sunflower.get("sunflower_front"));
        sunflower_smile = new ImageDummy(34, 65, sunflower.get("sunflower_smile"));
        sunflower_eye_r = new ImageDummy(78, 35, sunflower.get("sunflower_eye"));
        sunflower_eye_l = new ImageDummy(45, 35, sunflower.get("sunflower_eye"));

        sunflower_group = new Grouping(x, y, sunflower_back, sunflower_front,
                sunflower_smile, sunflower_eye_r, sunflower_eye_l);
    }

    @Override
    public int draw(Buffer buffer) {
        sunflower_group.draw(buffer);
        return 0;
    }

    @Override
    public void addAnimation(Animation animation) {
        sunflower_group.addAnimation(animation);
    }

    @Override
    public void tickAnimation() {
        sunflower_group.tickAnimation();
    }

    @Override
    public Animation getAnimation(int index) {
        return sunflower_group.getAnimation(index);
    }

    @Override
    public ArrayList<Animation> animations() {
        return sunflower_group.animations();
    }

    @Override
    public int getX() {
        return sunflower_group.getX();
    }

    @Override
    public void setX(int x) {
        sunflower_group.setX(x);
    }

    @Override
    public int getY() {
        return sunflower_group.getY();
    }

    @Override
    public void setY(int y) {
        sunflower_group.setY(y);
    }

    @Override
    public int getW() {
        return sunflower_group.getW();
    }

    @Override
    public void setW(int w) {
        sunflower_group.setW(w);
    }

    @Override
    public int getH() {
        return sunflower_group.getH();
    }

    @Override
    public void setH(int h) {
        sunflower_group.setH(h);
    }
}
