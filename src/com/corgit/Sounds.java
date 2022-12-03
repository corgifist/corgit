package com.corgit;

import com.tinysound.Music;
import com.tinysound.TinySound;

import java.io.File;

public class Sounds {

    public static Music loadMusic(String filename) {
        return TinySound.loadMusic(new File("assets/sounds/" + filename));
    }
}
