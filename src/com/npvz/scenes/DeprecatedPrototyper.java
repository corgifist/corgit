package com.npvz.scenes;

import com.corgit.ApplicationAdapter;
import com.corgit.Buffer;
import com.corgit.PredicateAction;
import com.corgit.objects.*;
import com.corgit.util.AtlasMap;
import com.corgit.util.AtlasMapParser;
import com.corgit.util.LinearMap;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Scanner;

public class DeprecatedPrototyper implements ApplicationAdapter {
    private ClearObject clear;
    private Text prototyperSplash;
    private Text selectedCoordinates, selectedAtlas, selectedObject;
    private LinearMap<String, CorgitObject> objects;
    private Scanner scanner;
    private CorgitObject selected;
    private Box selectedMarker;
    private PredicateAction terminalAction;
    private int clock;
    private AtlasMap atlas;
    private String atlasFile;
    private String selectedObjectString;

    @Override
    public void prepare(Buffer frame) {
        this.clear = new ClearObject();
        this.prototyperSplash = new Text(450, 30, "Prototype Room for NativePVZ", Color.CYAN);
        this.selectedCoordinates = new Text(30, 300, "Selected coordinates: ", Color.CYAN);
        this.selectedAtlas = new Text(30, 320, "Selected Atlas: ", Color.CYAN);
        this.selectedObject = new Text(30, 340, "Selected Object: ", Color.CYAN);
        this.objects = new LinearMap<>();
        this.scanner = new Scanner(System.in);
        this.selectedMarker = new Box(0, 0, 20, 20, Color.RED, true);
        this.terminalAction = new PredicateAction(object -> clock > 5, object -> {
            System.out.print(">> ");
            String[] parts = scanner.nextLine().split(" ");
            if (parts[0].equals("draw")) {
                return;
            } else if (parts[0].equals("set_atlas")) {
                atlasFile = parts[1];
                atlas = AtlasMapParser.parse(parts[1]);
            } else if (parts[0].equals("add_image")) {
                selected = new ImageDummy(Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), atlas.get(parts[2]));
                objects.put(parts[1], selected);
                selectedObjectString = parts[1];
            } else if (parts[0].equals("list_objects")) {
                for (String key : objects.getKeys()) {
                    System.out.println(key + " | " + objects.get(key).getX() + " " + objects.get(key).getY());
                }
            } else if (parts[0].equals("x")) {
                selected.setX(Integer.parseInt(parts[1]));
            } else if (parts[0].equals("y")) {
                selected.setY(Integer.parseInt(parts[1]));
            } else if (parts[0].equals("select")) {
                selected = objects.get(parts[1]);
                selectedObjectString = parts[1];
            }
        });
    }

    @Override
    public int update(Buffer frame) {
        clear.draw(frame);
        prototyperSplash.draw(frame);

        if (selected == null) {
            selectedCoordinates.setText("No object selected");
        } else {
            selectedCoordinates.setText("Selected coordinates: " + selected.getX() + " " + selected.getY());
        }
        if (atlasFile == null) {
            selectedAtlas.setText("No atlas selected");
        } else {
            selectedAtlas.setText("Selected atlas: " + atlasFile);
        }
        if (selected == null) {
            selectedMarker.setX(0);
            selectedMarker.setX(0);
        } else {
            selectedMarker.setX(selected.getX());
            selectedMarker.setY(selected.getY());
        }
        if (selectedObjectString == null) {
            selectedObject.setText("No object selected");
        } else {
            selectedObject.setText("Selected object: " + selectedObjectString);
        }


        selectedAtlas.draw(frame);
        selectedCoordinates.draw(frame);
        selectedObject.draw(frame);

        AffineTransform oldTransform = frame.getGraphics().getTransform();

            frame.getGraphics().translate(590,  340);
            selectedMarker.draw(frame);
            for (String key : objects.getKeys()) {
                objects.get(key).draw(frame);
            }

        frame.getGraphics().setTransform(oldTransform);

        terminalAction.act(null);

        clock++;

        return 0;
    }
}
