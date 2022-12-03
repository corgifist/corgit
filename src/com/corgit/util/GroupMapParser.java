package com.corgit.util;

import com.corgit.Buffer;
import com.corgit.objects.CorgitObject;
import com.corgit.objects.ImageDummy;
import com.corgit.objects.ParsedGroup;
import com.google.common.base.Splitter;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class GroupMapParser {

    public static CorgitObject parse(String filename) {
        try {
            List<String> lines = Splitter.on("\n").splitToList(Files.readString(Path.of("assets/" + filename)));
            HashMap<String, AtlasMap> atlases = new HashMap<>();
            LinearMap<String, CorgitObject> group = new LinearMap<>();


            String element = "";

            CorgitObject object = null;
            Color color = Color.WHITE;
            Buffer image = null;
            for (String line : lines) {
                List<String> parts = Splitter.on(" ").splitToList(line);
                if (parts.get(0).equals("new_atlas_map")) {
                    atlases.put(parts.get(1), AtlasMapParser.parse(parts.get(2)));
                }
                if (parts.get(0).equals("atlas_get_image")) {
                    image = atlases.get(parts.get(1)).get(parts.get(2));
                }
                if (parts.get(0).equals("image")) {
                    List<String> coords = Splitter.on("x").splitToList(parts.get(1));
                    int x = Integer.parseInt(coords.get(0));
                    int y = Integer.parseInt(coords.get(1));
                    assert image != null;
                    object = new ImageDummy(x, y, image);
                }
                if (parts.get(0).equals("element")) {
                    element = parts.get(1);
                }
                if (parts.get(0).equals("add")) {
                    group.put(element, object);
                }
            }
            return new ParsedGroup(atlases, group);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
