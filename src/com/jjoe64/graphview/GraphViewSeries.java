package com.jjoe64.graphview;

import java.util.ArrayList;
import java.util.List;

public class GraphViewSeries {
	/**
	 * graph series style: color and thickness
	 */
	static public class GraphViewSeriesStyle {
		public int color = 0xff0077cc;
		public int thickness = 3;
		private ValueDependentColor valueDependentColor;

		public GraphViewSeriesStyle() {
			super();
		}
		public GraphViewSeriesStyle(int color, int thickness) {
			super();
			this.color = color;
			this.thickness = thickness;
		}
		public void setValueDependentColor(ValueDependentColor valueDependentColor) {
			this.valueDependentColor = valueDependentColor;
		}
		public ValueDependentColor getValueDependentColor() {
			return valueDependentColor;
		}
	}

	final String description;
	final GraphViewSeriesStyle style;
	private final List<GraphView> graphViews = new ArrayList<GraphView>();
    float[] xValues;
    float[] yValues;
    int seriesLength;

    // The size limit for the arrays. This keeps the arrays from continually growing.
    private static final int ARRAY_GROWTH_SIZE_LIMIT = 2000;

    public GraphViewSeries(float[] xValues, float[] yValues) {
        this(null, null, xValues, yValues);
	}

    public GraphViewSeries(String description, GraphViewSeriesStyle style, float[] xValues,
            float[] yValues) {
        super();
		this.description = description;
		if (style == null) {
			style = new GraphViewSeriesStyle();
		}
		this.style = style;

        if (xValues.length != yValues.length) {
            throw new RuntimeException(
                    "The size of the X and Y GraphViewSeries data must be the same. Size of x array == "
                            + xValues.length + ", Size of y array == " + yValues.length);
        }

        this.xValues = xValues;
        this.yValues = yValues;
        seriesLength = xValues.length;
	}

    /**
     * Get the minimum x value. It is assumed that the
     * smallest x value is the first value in the series.
     * 
     * @param
     * @return largest value
     */
    public float getMinX() {
        if (xValues == null)
            return 0.0f;
        return xValues[0];
    }

    /**
     * Get the maximum x value. It is assumed that the
     * largest x value is the last value in the series.
     * 
     * @param
     * @return largest value
     */
    public float getMaxX() {
        if (xValues == null)
            return 10.0f;
        return xValues[seriesLength - 1];
    }

    /**
     * Get the minimum y value.
     * 
     * @param
     * @return largest value
     */
    public float getMinY() {
        if (yValues == null)
            return -1.0f;
        float smallest = Float.MAX_VALUE;
        for (int i = 0; i < seriesLength; i++) {
            if (yValues[i] < smallest)
                smallest = yValues[i];
        } // for i
        return smallest;
    }

    /**
     * Get the maximum y value.
     * 
     * @param
     * @return largest value
     */
    public float getMaxY() {
        if (yValues == null)
            return 1.0f;
        float largest = Float.MIN_VALUE;
        for (int i = 0; i < seriesLength; i++) {
            if (yValues[i] > largest)
                largest = yValues[i];
        } // for i
        return largest;
    }

	/**
	 * this graphview will be redrawn if data changes
	 * @param graphView
	 */
	public void addGraphView(GraphView graphView) {
		this.graphViews.add(graphView);
	}

	/**
	 * add one data to current data
	 * @param value the new data to append
	 * @param scrollToEnd true => graphview will scroll to the end (maxX)
	 */
    public void appendData(float xValue, float yValue, boolean scrollToEnd) {

        // Grow the array if we have filled it up
        if (xValues.length == seriesLength) {
            // Double the array sizes
            float newXVals[] = new float[xValues.length * 2];
            float newYVals[] = new float[yValues.length * 2];

            System.arraycopy(xValues, 0, newXVals, 0, seriesLength);
            System.arraycopy(yValues, 0, newYVals, 0, seriesLength);

            xValues = newXVals;
            yValues = newYVals;
        }

        xValues[seriesLength] = xValue;
        yValues[seriesLength] = yValue;

        // Increment the length after adding the values to the array so it can act as the index
        // first and then the length last
        seriesLength++;

        if (scrollToEnd) {
            for (GraphView g : graphViews) {
                g.scrollToEnd();
            }
        }
	}

	/**
	 * clears the current data and set the new.
	 * redraws the graphview(s)
	 * @param values new data
	 */
    public void resetData(float[] xValues, float[] yValues) {
        this.xValues = xValues;
        this.yValues = yValues;
		for (GraphView g : graphViews) {
			g.redrawAll();
		}
	}
}
