package com.npvz;

import com.corgit.util.AtlasMap;
import com.corgit.util.AtlasMapParser;
import org.checkerframework.checker.units.qual.A;

public class Atlases {

    public static AtlasMap LOCATIONS = AtlasMapParser.parse("locations.atlas_map");
    public static AtlasMap CREDITS = AtlasMapParser.parse("credits.atlas_map");
    public static AtlasMap SUNFLOWER = AtlasMapParser.parse("sunflower.atlas_map");

}
