package com.npvz.scenes;

import com.corgit.*;
import com.corgit.objects.*;
import com.corgit.util.PipelineAffections;
import com.npvz.Atlases;
import com.npvz.objects.BackgroundType;
import com.npvz.objects.Board;
import com.npvz.objects.BufferObject;
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

    private Board battleBoard;
    private Transformator pvz2Logo;

    private DelayedAction logoChain1;
    private ToggleableAction logoChain2;

    private PredicateAction predicateShift;

    private PredicateAction logoShift;

    private int clock;

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

        this.battleBoard = new Board(BackgroundType.EGYPT);

        this.unfadeChain1 = new PredicateAction(object -> fadeOut.getFactor() == 0.0, object -> {
             this.unfadeChain2.setAction(new DelayedAction(1,dummy -> {
                 unfadeChain3.setActive(true);
             }));
             unfadeChain1 = new PredicateAction();
        });
        this.unfadeChain2 = new NullableAction(null);
        this.unfadeChain3 = new ToggleableAction(false, object -> {
            splashLayer.subFactor(0.02);
            if (splashLayer.getFactor() <= 0) {
                unfadeChain2 = new NullableAction(null);
                unfadeChain3 = new ToggleableAction();
            }
        });

        this.pvz2Logo = new Transformator(new Scaler(0.5, 0.5,
                new ImageDummy(0, 0, Atlases.CREDITS.get("pvz2_logo"))),
                0, 0);

        this.logoChain1 = new DelayedAction(1, object -> {
             logoChain2.setActive(true);
             Sounds.loadMusic("giant_boom.wav").play(false);
        });
        this.logoChain2 = new ToggleableAction(false, object -> {
            pvz2Logo.draw(frame);
        });

        this.predicateShift = new PredicateAction(object -> clock % 3 == 0, object -> {
            battleBoard.setxShift(battleBoard.getxShift() - 1);
        });

        int LOGO_SHIFT = -490;

        this.logoShift = new PredicateAction(object -> pvz2Logo.getY() > LOGO_SHIFT && logoChain2.isActive(), object -> {
            pvz2Logo.setY(pvz2Logo.getY() - 45);
        });
    }

    @Override
    public int update(Buffer frame) {
        clearScreen.draw(frame);
        playMusic.act(null);

        // Battle drawing!

        if (splashLayer.getFactor() < 0.8) {
            battleBoard.draw(frame);

            logoChain1.act(null);
            logoChain2.act(null);
            predicateShift.act(null);
            logoShift.act(null);
        }

        // Splash drawing!

        if (splashLayer.getFactor() > 0) {
            Buffer splashScreen = new Buffer(frame);
            fadeBox.draw(splashScreen);
            splashIcon1.draw(splashScreen);
            splashIcon2.draw(splashScreen);

            ((ImageDummy) splashLayer.getObject()).setImage(splashScreen);
            splashLayer.draw(frame);
        }

        if (fadeOut.getFactor() != 0) {
            fadeOut.draw(frame);
            fadeOut.subFactor(0.02);
        }


        unfadeChain1.act(null);
        unfadeChain2.act(null);
        unfadeChain3.act(null);

        clock++;

        return 0;
    }
}
