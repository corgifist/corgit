package com.corgit.util;

import com.corgit.Buffer;

import java.util.HashMap;

public class AtlasMap {

    private HashMap<String, Buffer> textures;

    public AtlasMap() {
        this.textures = new HashMap<>();
    }

    public AtlasMap(HashMap<String, Buffer> textures) {
        this.textures = textures;
    }

    public int size() {
        return textures.size();
    }

    public Buffer get(Object key) {
        return textures.get(key);
    }

    public boolean containsKey(Object key) {
        return textures.containsKey(key);
    }

    public Buffer put(String key, Buffer value) {
        return textures.put(key, value);
    }

    public Buffer remove(Object key) {
        return textures.remove(key);
    }

    public void clear() {
        textures.clear();
    }

}
