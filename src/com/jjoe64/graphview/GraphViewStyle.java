package com.jjoe64.graphview;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;

/**
 * Styles for the GraphView
 * Important: Use GraphViewSeries.GraphViewSeriesStyle for series-specify styling
 *
 */
public class GraphViewStyle {
	private int vLabelsColor;
	private int hLabelsColor;
	private int gridColor;
    private float titleTextSize;
    private float vLabelsTextSize;
    private float hLabelsTextSize;

    private final Context context;

    public GraphViewStyle(Context context) {
		vLabelsColor = Color.WHITE;
		hLabelsColor = Color.WHITE;
		gridColor = Color.DKGRAY;

        this.context = context;

        titleTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 20, this.context
                .getResources().getDisplayMetrics());
        vLabelsTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, this.context
                .getResources().getDisplayMetrics());
        hLabelsTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12, this.context
                .getResources().getDisplayMetrics());
	}

    public GraphViewStyle(Context context, int vLabelsColor, int hLabelsColor, int gridColor) {
        this(context);
		this.vLabelsColor = vLabelsColor;
		this.hLabelsColor = hLabelsColor;
		this.gridColor = gridColor;
	}

	public int getVerticalLabelsColor() {
		return vLabelsColor;
	}

	public int getHorizontalLabelsColor() {
		return hLabelsColor;
	}

	public int getGridColor() {
		return gridColor;
	}

	public void setVerticalLabelsColor(int c) {
		vLabelsColor = c;
	}

	public void setHorizontalLabelsColor(int c) {
		hLabelsColor = c;
	}

	public void setGridColor(int c) {
		gridColor = c;
	}

    public void setTitleTextSize(int spValue) {
        titleTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, this.context
                .getResources().getDisplayMetrics());
    }

    public float getTitleTextSize() {
        return titleTextSize;
    }

    public void setVLabelsTextSize(int spValue) {
        vLabelsTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context
                .getResources().getDisplayMetrics());
    }

    public float getVLabelsTextSize() {
        return vLabelsTextSize;
    }

    public void setHLabelsTextSize(int spValue) {
        hLabelsTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context
                .getResources().getDisplayMetrics());
    }

    public float getHLabelsTextSize() {
        return hLabelsTextSize;
    }
}
