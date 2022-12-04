package com.npvz.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import com.corgit.objects.*;
import com.npvz.Atlases;
import com.npvz.objects.plants.DummyPlant;

import java.awt.geom.AffineTransform;
import java.util.ArrayList;

public class Board implements CorgitObject {

    private CorgitObject[] plants;

    private CorgitObject endBackground, midBackground, begBackground;

    private Grouping groupBackground;

    private static int WIDTH = 9;
    private static int HEIGHT = 5;

    private int xShift;
    private int yShift;

    public Board(BackgroundType bgType) {
        switch (bgType) {
            case EGYPT -> {
                endBackground = new Transformator(
                        new Scaler(0.47, 0.47, new ImageDummy(0,0, Atlases.LOCATIONS.get("egypt_end"))),
                        -510, 0);
                midBackground = new Transformator(
                        new Scaler(0.47, 0.47, new ImageDummy(0, 0, Atlases.LOCATIONS.get("egypt_mid"))),
                        100, 0
                );
                begBackground = new Transformator(
                        new Scaler(0.47, 0.47, new ImageDummy(0, 0, Atlases.LOCATIONS.get("egypt_beg"))),
                        890, 0
                );
            }
        }

        groupBackground = new Grouping(0, 0, endBackground, midBackground, begBackground);
        plants = new CorgitObject[WIDTH * HEIGHT];
    }

    @Override
    public int draw(Buffer buffer) {
        AffineTransform oldTransform = buffer.getGraphics().getTransform();
        buffer.getGraphics().translate(xShift, yShift);
        groupBackground.draw(buffer);

        // Drawing plants
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                CorgitObject object = get(x, y);
                if (object == null) continue;
                int xc = 75 * x;
                int yc = 90 * y;
                object.setX(xc + 500);
                object.setY(yc + 190);
                object.draw(buffer);
            }
        }
        buffer.getGraphics().setTransform(oldTransform);
        return 0;
    }

    public void add(int x, int y, CorgitObject plant) {
        plants[x + y * WIDTH] = plant;
    }

    public CorgitObject get(int x, int y) {
        return plants[x + y * WIDTH];
    }

    @Override
    public void setX(int x) {
        // unnecessary
    }

    @Override
    public void setY(int y) {
        // unnecessary
    }

    @Override
    public void setW(int w) {
        // unnecessary
    }

    @Override
    public void setH(int h) {
        // unnecessary
    }

    @Override
    public int getX() {
        // unnecessary
        return 0;
    }

    @Override
    public int getY() {
        // unnecessary
        return 0;
    }

    @Override
    public int getW() {
        // unnecessary
        return 0;
    }

    @Override
    public int getH() {
        // unnecessary
        return 0;
    }

    @Override
    public void addAnimation(Animation animation) {
        // unnecessary
    }

    @Override
    public void tickAnimation() {
        // unnecessary
    }

    @Override
    public Animation getAnimation(int index) {
        // unnecessary
        return null;
    }

    @Override
    public ArrayList<Animation> animations() {
        // unnecessary
        return null;
    }

    public int getxShift() {
        return xShift;
    }

    public void setxShift(int xShift) {
        this.xShift = xShift;
    }

    public int getyShift() {
        return yShift;
    }

    public void setyShift(int yShift) {
        this.yShift = yShift;
    }
}
