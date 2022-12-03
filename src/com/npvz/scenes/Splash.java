package com.npvz.scenes;

import com.corgit.*;
import com.corgit.objects.*;
import com.corgit.util.PipelineAffections;
import com.npvz.Atlases;
import com.tinysound.Music;

import java.awt.*;

public class Splash implements ApplicationAdapter {

    private ClearObject clearScreen;
    private Music soundtrack;
    private OneTimeAction playMusic;

    private CorgitObject splashIcon1, splashIcon2;
    private Box fadeBox;

    private TransparencyMaker fadeOut;
    private TransparencyMaker splashLayer;
    private PredicateAction unfadeChain1;
    private NullableAction unfadeChain2;
    private ToggleableAction unfadeChain3;

    private Box cyanDummyBox;

    @Override
    public void prepare(Buffer frame) {
        this.clearScreen = new ClearObject();
        this.soundtrack = Sounds.loadMusic("action_music.wav");
        this.playMusic = new OneTimeAction(object -> {
           soundtrack.play(true);
        });
        this.splashIcon1 = new Transformator(new Scaler(0.3, 0.3, new ImageDummy(0, 0, Atlases.CREDITS.get("ea_logo"))), -200, 0);
        this.splashIcon2 = new Transformator(new Scaler(0.5, 0.5, new ImageDummy(0, 0, Atlases.CREDITS.get("popcap_logo"))), 100, 0);
        this.fadeBox = new Box(0, 0, 1280, 720, Color.BLACK, true);
        this.fadeOut = new TransparencyMaker(fadeBox, 1);
        this.splashLayer = new TransparencyMaker(new ImageDummy(0, 0, frame), 1);

        this.cyanDummyBox = new Box(100, 100, 200, 200, Color.CYAN, true);

        this.unfadeChain1 = new PredicateAction(object -> fadeOut.getFactor() == 0.0, object -> {
             this.unfadeChain2.setAction(new DelayedAction(1,dummy -> {
                 unfadeChain3.setActive(true);
             }));
             unfadeChain1 = new PredicateAction();
        });
        this.unfadeChain2 = new NullableAction(null);
        this.unfadeChain3 = new ToggleableAction(false, object -> {
            splashLayer.subFactor(0.01);
            if (splashLayer.getFactor() <= 0) {
                unfadeChain2 = new NullableAction(null);
                unfadeChain3 = new ToggleableAction();
            }
        });
    }

    @Override
    public int update(Buffer frame) {
        clearScreen.draw(frame);
        playMusic.act(null);

        cyanDummyBox.draw(frame);

        if (splashLayer.getFactor() > 0) {
            Buffer splashScreen = new Buffer(frame);
            fadeBox.draw(splashScreen);
            splashIcon1.draw(splashScreen);
            splashIcon2.draw(splashScreen);

            ((ImageDummy) splashLayer.getObject()).setImage(splashScreen);
            splashLayer.draw(frame);
        }

        fadeOut.draw(frame);
        fadeOut.subFactor(0.017);


        unfadeChain1.act(null);
        unfadeChain2.act(null);
        unfadeChain3.act(null);

        PipelineAffections.drawAffections(frame);

        return 0;
    }
}
