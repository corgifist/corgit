package com.npvz;

import com.corgit.ApplicationAdapter;
import com.corgit.Buffer;
import com.corgit.animations.SinMagnitude;
import com.corgit.animations.XShift;
import com.corgit.objects.*;
import com.corgit.util.AtlasMap;
import com.corgit.util.AtlasMapParser;
import com.npvz.objects.SunflowerLoading;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class NativePVZ implements ApplicationAdapter {

    private ClearObject clear;
    private Rotator sunflower;

    @Override
    public void prepare(Buffer frame) {
        clear = new ClearObject();
        sunflower = new Rotator(new Scaler(0.5, 0.5, new SunflowerLoading(1100, 600)), 0);
    }

    @Override
    public int update(Buffer frame) {
        clear.draw(frame);
        sunflower.setDegree(sunflower.getDegree() + 1);
        sunflower.draw(frame);
        return 0;
    }
}
