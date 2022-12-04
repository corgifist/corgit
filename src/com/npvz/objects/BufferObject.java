package com.npvz.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;
import com.corgit.objects.CorgitObject;

import java.util.ArrayList;

public class BufferObject implements CorgitObject {

    private Buffer buffer;

    public BufferObject(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public int draw(Buffer buffer) {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void setW(int w) {

    }

    @Override
    public void setH(int h) {

    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getW() {
        return 0;
    }

    @Override
    public int getH() {
        return 0;
    }

    @Override
    public void addAnimation(Animation animation) {

    }

    @Override
    public void tickAnimation() {

    }

    @Override
    public Animation getAnimation(int index) {
        return null;
    }

    @Override
    public ArrayList<Animation> animations() {
        return null;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public void setBuffer(Buffer buffer) {
        this.buffer = buffer;
    }
}
