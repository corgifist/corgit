package com.npvz.objects.plants;

import com.corgit.Buffer;
import com.corgit.GameClock;
import com.corgit.animations.Animation;
import com.corgit.objects.*;
import com.corgit.util.GroupMapParser;
import com.npvz.Atlases;

import java.awt.*;
import java.util.ArrayList;

public class Sunflower implements CorgitObject {

    private int x, y;

    private ParsedGroup sunflowerHead;
    private ImageDummy sunflowerTreeTop;
    private ImageDummy sunflowerTreeDown, sunflowerTreeDownMirror;
    private ImageDummy sunflowerLeaf1, sunflowerLeaf2;

    private CorgitObject plant;

    private int originalHeadX;
    private int originalHeadY;

    private int originalLeafX, originalLeaf1X;

    public Sunflower() {
        this.sunflowerHead = (ParsedGroup) GroupMapParser.parse("plant_groups/loading_sunflower.group_map");
        this.sunflowerTreeTop = new ImageDummy(50, 80, Atlases.SUNFLOWER.get("sunflower_tree_top"));
        this.sunflowerTreeDown = new ImageDummy(32, 130, Atlases.SUNFLOWER.get("sunflower_tree_low"));
        this.sunflowerTreeDownMirror = new ImageDummy(52, 130, Atlases.SUNFLOWER.get("sunflower_tree_low_mirror"));
        this.sunflowerLeaf1 = new ImageDummy(35, 114, Atlases.SUNFLOWER.get("sunflower_tree_mid"));
        this.sunflowerLeaf2 = new ImageDummy(55, 105, Atlases.SUNFLOWER.get("sunflower_tree_mid_mirror"));
        this.plant = new Transformator(new Scaler(0.6, 0.6, new Grouping(x, y, sunflowerLeaf2, sunflowerTreeDownMirror, sunflowerTreeTop, sunflowerLeaf1, sunflowerTreeDown, sunflowerHead)),
                        -400, -280);

        this.originalHeadX = sunflowerHead.getX();
        this.originalHeadY = sunflowerHead.getY();

        this.originalLeafX = sunflowerLeaf2.getW();
        this.originalLeaf1X = sunflowerLeaf1.getW();
    }

    @Override
    public int draw(Buffer buffer) {
        sunflowerHead.setX((int) (originalHeadX + Math.sin(GameClock.time) * 2));
        sunflowerHead.setY((int) (originalHeadY + Math.sin(GameClock.time) * 2));

        sunflowerLeaf1.setW((int) (originalLeaf1X + Math.sin(GameClock.time) * 2));
        sunflowerLeaf2.setW((int) (originalLeafX + Math.sin(GameClock.time) * 2));
        plant.draw(buffer);
        return 0;
    }

    @Override
    public void addAnimation(Animation animation) {
        plant.addAnimation(animation);
    }

    @Override
    public void tickAnimation() {
        plant.tickAnimation();
    }

    @Override
    public Animation getAnimation(int index) {
        return plant.getAnimation(index);
    }

    @Override
    public ArrayList<Animation> animations() {
        return plant.animations();
    }

    @Override
    public int getX() {
        return plant.getX();
    }

    @Override
    public void setX(int x) {
        plant.setX(x);
    }

    @Override
    public int getY() {
        return plant.getY();
    }

    @Override
    public void setY(int y) {
        plant.setY(y);
    }

    @Override
    public int getW() {
        return plant.getW();
    }

    @Override
    public void setW(int w) {
        plant.setW(w);
    }

    @Override
    public int getH() {
        return plant.getH();
    }

    @Override
    public void setH(int h) {
        plant.setH(h);
    }
}
