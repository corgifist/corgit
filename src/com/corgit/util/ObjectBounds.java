package com.corgit.util;

import com.corgit.objects.CorgitObject;

import java.awt.*;

public class ObjectBounds {

    public static Rectangle rect(CorgitObject object) {
        return new Rectangle(object.getX(), object.getY(), object.getW(), object.getH());
    }

    public static boolean intersects(CorgitObject a, CorgitObject b) {
        return rect(a).intersects(rect(b));
    }

}
