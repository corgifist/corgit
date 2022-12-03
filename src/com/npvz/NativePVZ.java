package com.npvz;

import com.corgit.ApplicationAdapter;
import com.corgit.Buffer;
import com.corgit.OneTimeAction;
import com.corgit.Sounds;
import com.corgit.objects.*;
import com.corgit.util.GroupMapParser;
import org.checkerframework.checker.units.qual.A;

public class NativePVZ implements ApplicationAdapter {

    private ClearObject clear;
    private Scaler sunflower;
    private Text text;
    private OneTimeAction ambient;

    @Override
    public void prepare(Buffer frame) {
        clear = new ClearObject();
        sunflower = new Scaler(0.5, 0.5, new Rotator(GroupMapParser.parse("plant_groups/loading_sunflower.group_map"), 0));
        text = new Text(100, 100, "PopCap presents");
        this.ambient = new OneTimeAction((object -> {
            Sounds.loadMusic("egypt_normal.wav").play(false);
        }));
    }

    @Override
    public int update(Buffer frame) {
        ambient.act(clear);
        clear.draw(frame);
        Rotator r = ((Rotator) sunflower.getObject());
        r.setDegree(r.getDegree() + 1);
        sunflower.draw(frame);
        text.draw(frame);
        return 0;
    }
}
