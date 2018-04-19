package com.deilsky.conciselayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by 帷幕 on 2018/2/5.
 */

public class ConciseLayout extends RelativeLayout {
    enum Margin {
        ALL, TOP, LEFT, RIGHT, BOTTOM
    }


    private static final String TAG = "ConciseLayout";
    private ImageView icon_left, icon_right;
    private TextView leftText, rightText, centerText, pointText;
    private View left, right;

    private ConciseLayoutListener onClickListener;
    private int pointFillColor = 0XFFFF0000;


    public ConciseLayout(Context context) {
        super(context);
    }

    public ConciseLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ConciseLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs) {
        View view = View.inflate(context, R.layout.concise_layout, this);
        left = view.findViewById(R.id.left);
        right = view.findViewById(R.id.right);
        icon_left = view.findViewById(R.id.icon_left);
        icon_right = view.findViewById(R.id.icon_right);
        leftText = view.findViewById(R.id.left_text);
        rightText = view.findViewById(R.id.right_text);
        centerText = view.findViewById(R.id.center_text);
        pointText = view.findViewById(R.id.point_text);
        pointFillColor = ContextCompat.getColor(context, R.color.red);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ConciseLayout);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            /**是否显示左侧图标**/
            if (index == R.styleable.ConciseLayout_icon_left_show) {
                visible(typedArray, icon_left, index);
            }
            /**设置左侧图标**/
            if (index == R.styleable.ConciseLayout_icon_left_image) {
                image(typedArray, icon_left, index);
            }
            /**左侧图标margin**/
            if (index == R.styleable.ConciseLayout_icon_left_margin) {
                margin(typedArray, icon_left, index, Margin.ALL);
            }
            if (index == R.styleable.ConciseLayout_icon_left_margin_left) {
                margin(typedArray, icon_left, index, Margin.LEFT);
            }
            if (index == R.styleable.ConciseLayout_icon_left_margin_top) {
                margin(typedArray, icon_left, index, Margin.TOP);
            }
            if (index == R.styleable.ConciseLayout_icon_left_margin_right) {
                margin(typedArray, icon_left, index, Margin.RIGHT);
            }
            if (index == R.styleable.ConciseLayout_icon_left_margin_bottom) {
                margin(typedArray, icon_left, index, Margin.BOTTOM);
            }
            /**是否显示左侧文字**/
            if (index == R.styleable.ConciseLayout_left_text_show) {
                visible(typedArray, leftText, index);
            }
            /**设置左侧文字**/
            if (index == R.styleable.ConciseLayout_left_text) {
                text(typedArray, leftText, index);
            }
            /**左侧文字大小**/
            if (index == R.styleable.ConciseLayout_left_text_size) {
                textSize(typedArray, leftText, index);
            }
            /**左侧文字颜色**/
            if (index == R.styleable.ConciseLayout_left_text_color) {
                textColor(typedArray, leftText, index);
            }

            /**是否显示右侧图标**/
            if (index == R.styleable.ConciseLayout_icon_right_show) {
                visible(typedArray, icon_right, index);
            }
            /**设置右侧图标**/
            if (index == R.styleable.ConciseLayout_icon_right_image) {
                image(typedArray, icon_right, index);
            }
            /**右侧图标margin**/
            if (index == R.styleable.ConciseLayout_icon_right_margin) {
                margin(typedArray, icon_right, index, Margin.ALL);
            }
            if (index == R.styleable.ConciseLayout_icon_right_margin_left) {
                margin(typedArray, icon_right, index, Margin.LEFT);
            }
            if (index == R.styleable.ConciseLayout_icon_right_margin_top) {
                margin(typedArray, icon_right, index, Margin.TOP);
            }
            if (index == R.styleable.ConciseLayout_icon_right_margin_right) {
                margin(typedArray, icon_right, index, Margin.RIGHT);
            }
            if (index == R.styleable.ConciseLayout_icon_right_margin_bottom) {
                margin(typedArray, icon_right, index, Margin.BOTTOM);
            }
            /**是否显示左侧文字**/
            if (index == R.styleable.ConciseLayout_right_text_show) {
                visible(typedArray, rightText, index);
            }
            /**设置右侧文字**/
            if (index == R.styleable.ConciseLayout_right_text) {
                text(typedArray, rightText, index);
            }
            /**右侧文字大小**/
            if (index == R.styleable.ConciseLayout_right_text_size) {
                textSize(typedArray, rightText, index);
            }
            /**右侧文字颜色**/
            if (index == R.styleable.ConciseLayout_right_text_color) {
                textColor(typedArray, rightText, index);
            }
            /**是否显示标题文字**/
            if (index == R.styleable.ConciseLayout_center_text_show) {
                visible(typedArray, centerText, index);
            }
            /**设置标题文字**/
            if (index == R.styleable.ConciseLayout_center_text) {
                text(typedArray, centerText, index);
            }

            /**标题文字大小**/
            if (index == R.styleable.ConciseLayout_center_text_size) {
                textSize(typedArray, centerText, index);
            }
            /**标题文字颜色**/
            if (index == R.styleable.ConciseLayout_center_text_color) {
                textColor(typedArray, centerText, index);
            }

            /**圆点是否显示**/
            if (index == R.styleable.ConciseLayout_point_show) {
                visible(typedArray, pointText, index);
            }
            /**圆点文字**/
            if (index == R.styleable.ConciseLayout_point_text) {
                text(typedArray, pointText, index);
            }
            /**圆点字体大小**/
            if (index == R.styleable.ConciseLayout_point_text_size) {
                textSize(typedArray, pointText, index);
            }
            /**圆点填充颜色 **/
            if (index == R.styleable.ConciseLayout_point_color) {
                pointFillColor = typedArray.getColor(index, pointFillColor);
            }
            /**圆点文字颜色**/
            if (index == R.styleable.ConciseLayout_point_text_color) {
                textColor(typedArray, pointText, index);
            }
            /**设置圆点大小**/
            if (index == R.styleable.ConciseLayout_point_size) {
                viewSize(typedArray, pointText, index);
            }
        }
    }

    private void viewSize(TypedArray typedArray, View view, int index) {
        float _size = typedArray.getDimension(index, 10);
        float size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, _size, getContext().getResources().getDisplayMetrics());
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        int sizes = Math.round(size);
        lp.width = sizes;
        lp.height = sizes;
        view.setLayoutParams(lp);
    }

    private void visible(TypedArray typedArray, View view, int index) {
        boolean visible = typedArray.getBoolean(index, false);
        if (visible) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }

    private void image(TypedArray typedArray, ImageView view, int index) {
        view.setImageDrawable(typedArray.getDrawable(index));
    }

    private void text(TypedArray typedArray, TextView view, int index) {
        view.setText(typedArray.getText(index));
    }

    private void textSize(TypedArray typedArray, TextView view, int index) {
        float _size = typedArray.getDimension(index, 15);
        float size = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, _size, getContext().getResources().getDisplayMetrics());
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    private void textColor(TypedArray typedArray, TextView view, int index) {
        int color = typedArray.getColor(index, 0X00000000);
        view.setTextColor(color);
    }

    private void margin(TypedArray typedArray, ImageView view, int index, Margin margin) {
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        int margins = typedArray.getDimensionPixelSize(index, 0);
        int left = lp.leftMargin;
        int top = lp.topMargin;
        int right = lp.rightMargin;
        int bottom = lp.bottomMargin;
        switch (margin) {
            case ALL:
                lp.setMargins(margins, margins, margins, margins);
                break;
            case TOP:
                lp.setMargins(left, margins, right, bottom);
                break;
            case LEFT:
                lp.setMargins(margins, top, right, bottom);
                break;
            case RIGHT:
                lp.setMargins(left, top, margins, bottom);
                break;
            case BOTTOM:
                lp.setMargins(left, top, right, margins);
                break;
        }
        view.setLayoutParams(lp);
    }

    public ConciseLayout leftClickable(boolean able) {
        if (able) {
            left.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onLeftClick();
                }
            });
        }
        return this;
    }

    public ConciseLayout rightClickable(boolean able) {
        if (able) {
            right.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onRightClick();
                }
            });
        }
        return this;
    }

    public ConciseLayout centerClickable(boolean able) {
        if (able) {
            centerText.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onCenterClick();
                }
            });
        }
        return this;
    }

    public ImageView findLeftImage() {
        return icon_left;
    }

    public ImageView findRightImage() {
        return icon_right;
    }

    public TextView findLeftText() {
        return leftText;
    }

    public TextView findCenterText() {
        return centerText;
    }

    public TextView findRightText() {
        return rightText;
    }

    public TextView findPointText() {
        return pointText;
    }

    public void setOnClickListener(ConciseLayoutListener listener) {
        this.onClickListener = listener;
    }
}
