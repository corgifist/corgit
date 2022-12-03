package com.corgit;

import com.corgit.util.PipelineAffections;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.channels.Pipe;

public class Buffer {

    private BufferedImage buffer;
    private Graphics2D graphics;

    public Buffer(BufferedImage buffer) {
        this.buffer = buffer;
        this.graphics = buffer.createGraphics();
    }

    public Buffer(Buffer template) {
        this(template.getBuffer().getWidth(), template.getBuffer().getHeight());
    }

    public Buffer(BufferedImage buffer, Graphics2D graphics) {
        this.buffer = buffer;
        this.graphics = graphics;
    }

    public Buffer(int width, int height) {
        this(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
    }

    public void clear() {
        graphics.clearRect(0, 0, buffer.getWidth(), buffer.getHeight());
    }

    public Graphics2D getGraphics() {
        PipelineAffections.AFFECTIONS++;
        return graphics;
    }

    public BufferedImage getBuffer() {
        return buffer;
    }

    public void setBuffer(BufferedImage buffer) {
        this.buffer = buffer;
    }

    public void setGraphics(Graphics2D graphics) {
        this.graphics = graphics;
    }
}
