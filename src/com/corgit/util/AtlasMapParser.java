package com.corgit.util;

import com.corgit.Buffer;
import com.google.common.base.Splitter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class AtlasMapParser {

    public static AtlasMap parse(String filename) {
        AtlasMap result = new AtlasMap();

        String folder = "";
        String entryString = "";


        try {
            String map = Files.readString(Path.of("assets/" + filename));
            List<String> lines = Splitter.on("\n").splitToList(map);
            for (String line : lines) {
                List<String> parts = Splitter.on(" ").splitToList(line);
                if (parts.get(0).equals("entry")) {
                    entryString = parts.get(1);
                }
                if (parts.get(0).equals("file")) {
                    result.put(entryString, new Buffer(ImageIO.read(new File("assets/" + folder + "/" + parts.get(1)))));
                }
                if (parts.get(0).equals("folder")) {
                    folder = parts.get(1);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


}
