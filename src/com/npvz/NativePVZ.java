package com.npvz;

import com.corgit.ApplicationAdapter;
import com.corgit.Buffer;
import com.corgit.animations.SinMagnitude;
import com.corgit.animations.XShift;
import com.corgit.objects.Box;
import com.corgit.objects.ClearObject;
import com.corgit.objects.ImageDummy;
import com.corgit.objects.Rotator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NativePVZ implements ApplicationAdapter {

    private Box box;
    private ImageDummy img;
    private ClearObject clear;
    private Rotator rotator;

    @Override
    public void prepare(Buffer frame) {
        box = new Box(100, 100, 100, 100, Color.BLUE, true);
        box.addAnimation(new XShift());
        box.addAnimation(new SinMagnitude());
        try {
            img = new ImageDummy(200, 300, 250, 300, new Buffer(ImageIO.read(new File("assets/PLANTSUNFLOWER_1536_00.PNG"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        img.addAnimation(new SinMagnitude());

        rotator = new Rotator(box, 1);
        clear = new ClearObject();
    }

    @Override
    public int update(Buffer frame) {
        clear.draw(frame);
        rotator.tickAnimation();
        rotator.draw(frame);
        rotator.setDegree(rotator.getDegree() + 1);
        img.tickAnimation();
        img.draw(frame);
        return 0;
    }
}
