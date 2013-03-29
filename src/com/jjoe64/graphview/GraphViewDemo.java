package com.jjoe64.graphview;

import android.app.Activity;
import android.os.Bundle;

/**
 * GraphViewDemo creates some dummy data to demonstrate the GraphView component.
 *
 * IMPORTANT: For examples take a look at GraphView-Demos (https://github.com/jjoe64/GraphView-Demos)
 *
 * Copyright (C) 2011 Jonas Gehring
 * Licensed under the GNU Lesser General Public License (LGPL)
 * http://www.gnu.org/licenses/lgpl.html
 */
public class GraphViewDemo extends Activity {

    private static final int GRAPH_DATA_SIZE_THRESHOLD = 500;

    /**
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LineGraphView graphView = new LineGraphView(
                this
                , "GraphViewDemo"
                );
        graphView.addSeries(new GraphViewSeries(new float[] { 1f, 2f, 3f, 4f, 5f },
                new float[] { 2.1f, 1.2f, 3.3f, 1.4f, 2.5f }, GRAPH_DATA_SIZE_THRESHOLD));

        setContentView(graphView);
    }
}
