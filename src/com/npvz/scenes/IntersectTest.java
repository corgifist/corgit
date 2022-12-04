package com.npvz.scenes;

import com.corgit.ApplicationAdapter;
import com.corgit.Buffer;
import com.corgit.objects.Box;
import com.corgit.objects.ClearObject;
import com.corgit.objects.Text;
import com.corgit.util.ObjectBounds;
import org.checkerframework.checker.units.qual.C;

import java.awt.*;

public class IntersectTest implements ApplicationAdapter {

    private ClearObject clear;
    private Box box1, box2;
    private Text intersect;

    public IntersectTest() {
    }

    @Override
    public void prepare(Buffer frame) {
        this.clear = new ClearObject();
        this.box1 = new Box(500, 200, 100, 300, Color.CYAN, true);
        this.box2 = new Box(0, 200, 200, 200, Color.RED, true);
        this.intersect = new Text(400, 30, "Intersection!");
    }

    @Override
    public int update(Buffer frame) {
        clear.draw(frame);
        box2.setX(box2.getX() + 1);
        box1.draw(frame);
        box2.draw(frame);
        if (ObjectBounds.intersects(box1, box2)) {
            intersect.draw(frame);
        }
        return 0;
    }
}
