package com.corgit;

import com.tinysound.TinySound;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Display extends Canvas {

    private JFrame frame;
    private Buffer frameBuffer;
    private BufferStrategy strategy;
    private Graphics bufferGraphics;
    private Graphics frameGraphics;
    private BufferStrategy frameStrategy;

    private AffineTransform bufferTransform;

    public Display(int width, int height, String title) {
        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        setMaximumSize(d);
        setMaximumSize(d);

        frameBuffer = new Buffer(width, height);

        frame = new JFrame();
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setVisible(true);

        bufferGraphics = frameBuffer.getGraphics();

        createBufferStrategy(1);
        frameStrategy = getBufferStrategy();
        frameGraphics = frameStrategy.getDrawGraphics();

        bufferTransform = ((Graphics2D) frameGraphics).getTransform();
    }

    public void run() {
        ApplicationMaster.GLOBAL_SCENE.prepare(frameBuffer);
        long lastTime = 0;
        double fps = 0;
        String oldTitle = frame.getTitle();
        TinySound.init();
        while (true) {
            if (!frame.isActive()) continue;
            lastTime = System.nanoTime();
            try {
                if (ApplicationMaster.GLOBAL_SCENE.update(frameBuffer) != 0) {
                    throw new RuntimeException("NativePVZ has encountered an error!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("NativePVZ has encountered an error!");
            }
            swapBuffers();
            fps = 1000000000.0 / (System.nanoTime() - lastTime);
            GameClock.delta = (System.nanoTime() - lastTime);
            GameClock.time += GameClock.step;
            frame.setTitle(oldTitle + " | FPS: " + fps);
        }
    }

    public void swapBuffers() {
        frameGraphics.drawImage(frameBuffer.getBuffer(), 0, 0, null);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public Buffer getFrameBuffer() {
        return frameBuffer;
    }

    public void setFrameBuffer(Buffer frameBuffer) {
        this.frameBuffer = frameBuffer;
    }

    public BufferStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(BufferStrategy strategy) {
        this.strategy = strategy;
    }

    public Graphics getBufferGraphics() {
        return bufferGraphics;
    }

    public void setBufferGraphics(Graphics bufferGraphics) {
        this.bufferGraphics = bufferGraphics;
    }

    public Graphics getFrameGraphics() {
        return frameGraphics;
    }

    public void setFrameGraphics(Graphics frameGraphics) {
        this.frameGraphics = frameGraphics;
    }

    public BufferStrategy getFrameStrategy() {
        return frameStrategy;
    }

    public void setFrameStrategy(BufferStrategy frameStrategy) {
        this.frameStrategy = frameStrategy;
    }
}
