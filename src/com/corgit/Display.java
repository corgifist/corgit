package com.corgit;

import com.corgit.util.PipelineAffections;
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

    public static GraphicsConfiguration bufferConfig;

    private int width, height;

    public Display(int width, int height, String title) {
        this.width = width;
        this.height = height;

        Dimension d = new Dimension(width, height);
        setPreferredSize(d);
        setMaximumSize(d);
        setMaximumSize(d);


        frame = new JFrame();
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle(title);
        frame.setVisible(true);
    }

    public void run() {
        frameBuffer = new Buffer(width, height);

        createBufferStrategy(1);
        frameStrategy = getBufferStrategy();
        frameGraphics = frameStrategy.getDrawGraphics();
        bufferGraphics = frameBuffer.getGraphics();


        ApplicationMaster.GLOBAL_SCENE.prepare(frameBuffer);
        long lastTime = 0;
        double fps = 0;
        String oldTitle = frame.getTitle();
        TinySound.init();
        while (true) {
            lastTime = System.nanoTime();
            ((Graphics2D) bufferGraphics).setRenderingHint(RenderingHints.KEY_RENDERING,
                                                            RenderingHints.VALUE_RENDER_SPEED);
            try {
                if (ApplicationMaster.GLOBAL_SCENE.update(frameBuffer) != 0) {
                    throw new RuntimeException(oldTitle + " has encountered an error!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(oldTitle + " has encountered an error!");
            }
            PipelineAffections.drawAffections(frameBuffer);
            swapBuffers();
            fps = 1000000000.0 / (System.nanoTime() - lastTime);
            GameClock.delta = (System.nanoTime() - lastTime);
            GameClock.time += GameClock.step;
            frame.setTitle(oldTitle + " | FPS: " + fps);
            PipelineAffections.AFFECTIONS = 0;
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
