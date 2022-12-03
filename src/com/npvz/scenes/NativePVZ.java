package com.npvz.scenes;

import com.corgit.*;
import com.corgit.objects.*;
import com.corgit.util.AtlasMap;
import com.corgit.util.GroupMapParser;
import com.npvz.Atlases;

public class NativePVZ implements ApplicationAdapter {

    private ClearObject clear;
    private Scaler sunflower;
    private OneTimeAction loadAction;
    private DelayedAction delayLoad;
    private Thread loadThread;

    private Text disclaimer;

    @Override
    public void prepare(Buffer frame) {
        clear = new ClearObject();
        sunflower = new Scaler(0.5, 0.5, new Rotator(GroupMapParser.parse("plant_groups/loading_sunflower.group_map"), 0));
        disclaimer = new Text(360, 415, "All assets is a property of Electronic Arts and PopCap Games.");
        loadThread = new Thread(() -> {
            AtlasMap loadCause = Atlases.CREDITS;
        });
        loadAction = new OneTimeAction((object) -> {
            loadThread.start();
        });
        delayLoad = new DelayedAction(3, object -> {
           ApplicationMaster.runtimeSwitch(frame, new Splash());
        });
    }

    @Override
    public int update(Buffer frame) {
        clear.draw(frame);
        loadAction.act(null);
        if (!loadThread.isAlive()) {
            delayLoad.act(null);
        }
        Rotator r = ((Rotator) sunflower.getObject());
        r.setDegree(r.getDegree() + 1);
        sunflower.draw(frame);
        disclaimer.draw(frame);
        return 0;
    }
}
