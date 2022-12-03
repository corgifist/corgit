package com.corgit.objects;

import com.corgit.Buffer;
import com.corgit.animations.Animation;

import java.awt.*;
import java.util.ArrayList;

public class Text implements CorgitObject {

    private int x, y;
    private String text;
    private Font font;
    private Color color;
    private ArrayList<Animation> animations;

    public Text(int x, int y, String text, Font font, Color color) {
        this.x = x;
        this.y = y;
        this.text = text;
        this.font = font;
        this.color = color;
    }

    public Text(int x, int y, String text, Font font) {
        this(x, y, text, font, Color.WHITE);
    }

    public Text(int x, int y, String text) {
        this(x, y, text, new Font("BrianneTod", Font.PLAIN, 24));
    }

    @Override
    public int draw(Buffer buffer) {
        buffer.getGraphics().setColor(color);
        buffer.getGraphics().setFont(font);
        buffer.getGraphics().drawString(text, x, y);
        return 0;
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
    public int getW() {
        return font.getSize() * text.length();
    }

    @Override
    public int getH() {
        return font.getSize() * text.length();
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void setW(int w) {
    }

    @Override
    public void setH(int h) {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
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
}
