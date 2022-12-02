package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import com.npvz.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ImageDummy implements CorgitObject {

    private int x, y;
    private int w, h;
    private Buffer image;
    private ArrayList<Animation> animations;


    public ImageDummy(int x, int y, int w, int h, Buffer image) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.image = image;
        this.animations = new ArrayList<>();
    }

    public ImageDummy(int x, int y, Buffer image) {
        this(x, y, image.getBuffer().getWidth(), image.getBuffer().getHeight(), image);
    }

    @Override
    public int draw(Buffer buffer) {
        Buffer scaleBuffer = new Buffer(w, h);
        scaleBuffer.getGraphics().drawImage(image.getBuffer(), 0, 0, w, h, null);

        buffer.getGraphics().drawImage(scaleBuffer.getBuffer(), x, y, null);
        return 0;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void addAnimation(Animation animation) {
        animations.add(animation);
    }

    @Override
    public void tickAnimation() {
        for (Animation animation : animations) {
            animation.animate(this);
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

    @Override
    public int getW() {
        return w;
    }

    @Override
    public void setW(int w) {
        this.w = w;
    }

    @Override
    public int getH() {
        return h;
    }

    @Override
    public void setH(int h) {
        this.h = h;
    }
}
