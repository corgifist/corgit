package com.corgit.util;

import com.corgit.Buffer;
import com.corgit.objects.Text;

public class PipelineAffections {

    public static int AFFECTIONS = 0;

    public static Text AFFECTIONS_TEXT = new Text(0, 20, "Pipeline Affections: ");

    public static void drawAffections(Buffer buffer) {
        AFFECTIONS_TEXT.setText("Pipeline Affections: " + AFFECTIONS);
        AFFECTIONS_TEXT.draw(buffer);
    }

}
