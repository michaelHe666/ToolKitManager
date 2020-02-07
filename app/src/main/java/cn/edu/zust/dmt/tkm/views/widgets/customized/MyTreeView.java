package cn.edu.zust.dmt.tkm.views.widgets.customized;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import cn.edu.zust.dmt.common.utils.LogUtil;
import cn.edu.zust.dmt.tkm.R;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.widgets.customized
 * @description $
 * @time 2/5/2020 12:28
 * copyright(c) all rights reserved by MR.M
 **/
public class MyTreeView extends BaseAnimateView {

    private final ReentrantReadWriteLock mLock = new ReentrantReadWriteLock();

    private final int MY_DURATION = 6000;
    private int mDuration = 0;

    private final float mTrunkMaxRotateRadian = (float) Math.toRadians(50);
    private final int mTreeGeneration = 4;
    private final float mStepGrow = 3.0f;

//    private int mTrunkCount = 0;

    private final class MyTrunkPoint {
        float mXCoordinate = 0;
        float mYCoordinate = 0;
        float mRadius = 0;
    }

    private final class MyTrunk {
        List<MyTrunkPoint> mTrunkPointList = new ArrayList<>();
        List<MyTrunk> mChildTrunkList = new ArrayList<>();
        int mGeneration = 0;
        boolean hasFinished = false;
        float mWidth = 0;
        float mRadian = 0;
        float mXRemain = 0;
        float mYRemain = 0;
        float mMaxRotateRadian = 0;
    }

    private MyTrunk myTree = new MyTrunk();

    /**
     * @description flags for view to judge whether start draw
     */
    private boolean hasVariablesInitialized = false;
    private boolean hasSizesInitialized = false;

    /**
     * @description attrs resources
     */
    private int mTreeBaseColor = 0;

    /**
     * @description view size
     */
    private int mViewHeight = 0;
    private int mViewWidth = 0;

    /**
     * @description tree attributes
     */
    private float mBaseTrunkWidth = 0;
    private float mTrunkMaxHeight = 0;
    private float mTrunkMaxWidth = 0;

    /**
     * @description coordinates of tree root point
     */
    private float mRootPointX = 0;
    private float mRootPointY = 0;

    /**
     * @description painters
     */
    private Paint mTreeTrunkPainter = null;

    public MyTreeView(Context context) {
        this(context, null);
    }

    public MyTreeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyTreeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeViews(context, attrs);
    }

    /**
     * @param myFlag int flag during animate
     */
    @Override
    public void setMyFlag(int myFlag) {
        if (myFlag - mDuration > 10) {
            mDuration = myFlag;
//            LogUtil.showDebugLog(mDuration + "redraw!");
            postInvalidate();
        }
    }

    @Override
    protected final int getDuration() {
        return MY_DURATION;
    }

    private void initializeViews(@NotNull Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyTreeView);
        mTreeBaseColor = typedArray.getColor(R.styleable.MyTreeView_myTreeViewBaseColor, mTreeBaseColor);
        typedArray.recycle();

        hasSizesInitialized = false;
        hasVariablesInitialized = false;

        if (mTreeBaseColor != 0) {
            initializeMemberVariables();
        }
    }

    /**
     * @description initialize variables after view instance is created
     */
    private void initializeMemberVariables() {
        //set trunk painter
        mTreeTrunkPainter = new Paint();
        mTreeTrunkPainter.setAntiAlias(true);
        mTreeTrunkPainter.setColor(mTreeBaseColor);
        mTreeTrunkPainter.setStyle(Paint.Style.STROKE);

        hasVariablesInitialized = true;
    }

    @Override
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!hasSizesInitialized) {
            mLock.writeLock().lock();
            if (!hasSizesInitialized) {
                initializeMemberSizes();
            }
            mLock.writeLock().unlock();
        }
        if (hasVariablesInitialized && hasSizesInitialized) {

            updateTreePoints(myTree);

            mLock.readLock().lock();
            drawTreeTrunk(canvas, myTree);
            mLock.readLock().unlock();
        }
    }

    /**
     * @description initialize size variables after view measured
     */
    private void initializeMemberSizes() {
        mViewWidth = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        mViewHeight = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();

        mRootPointX = mViewWidth * 1.0f / 2;
        mRootPointY = mViewHeight * 2.0f / 3;

        mBaseTrunkWidth = mViewWidth * 1.0f / 32;
        //todo:control more accurate limit here
        mTrunkMaxWidth = mViewWidth * 1.0f / (mTreeGeneration * 2 - 1);
        mTrunkMaxHeight = (mViewHeight * 2.0f / 3) / mTreeGeneration;

        mTreeTrunkPainter.setStrokeWidth(mBaseTrunkWidth);

        mTrunkMaxHeight = mViewHeight * 1.0f / 6;

        //todo:control min height and width
        if (mBaseTrunkWidth > 1 && mTrunkMaxHeight > 1) {
            MyTrunkPoint myTrunkPoint = new MyTrunkPoint();
            myTrunkPoint.mXCoordinate = mRootPointX;
            myTrunkPoint.mYCoordinate = mRootPointY;
            myTrunkPoint.mRadius = mBaseTrunkWidth / 2;
            myTree = new MyTrunk();
            myTree.mRadian = (float) Math.toRadians(90);
            myTree.mWidth = mBaseTrunkWidth;
            myTree.mXRemain = mTrunkMaxWidth;
            myTree.mYRemain = mTrunkMaxHeight;
            myTree.mMaxRotateRadian = mTrunkMaxRotateRadian;
            myTree.mTrunkPointList.add(myTrunkPoint);
            myTree.mGeneration = 1;
            hasSizesInitialized = true;
        } else {
            hasSizesInitialized = false;
        }
    }

    /**
     * @param myTrunk Traversal myTrunk and children(which represents a tree)
     *                to find all end points,add new points follow or open
     *                new trunks or do nothing.
     *                In a word, this method will refresh myTrunk as a growing
     *                tree points set.
     */
    private void updateTreePoints(MyTrunk myTrunk) {
        mLock.writeLock().lock();
        int sizeTemp = myTrunk.mChildTrunkList.size();
        if (sizeTemp > 0) {
            mLock.writeLock().unlock();

            for (int i = 0; i < sizeTemp; i++) {
                updateTreePoints(myTrunk.mChildTrunkList.get(i));
            }
        } else {
            if (myTrunk.hasFinished) {
                mLock.writeLock().unlock();
                return;
            }
            //check whether to add a new point
            float xRemainTemp = myTrunk.mXRemain;
            float yRemainTemp = myTrunk.mYRemain;
            double radianTemp = myTrunk.mRadian + myTrunk.mMaxRotateRadian * (Math.random() - 0.5);
            MyTrunkPoint lastPoint = myTrunk.mTrunkPointList.get(myTrunk.mTrunkPointList.size() - 1);
            float lastPointX = lastPoint.mXCoordinate;
            float lastPointY = lastPoint.mYCoordinate;

            float xMove = (float) Math.cos(radianTemp) * mStepGrow;
            float yMove = (float) Math.sin(radianTemp) * mStepGrow;
            xRemainTemp = xRemainTemp - Math.abs(xMove);
            yRemainTemp = yRemainTemp - Math.abs(yMove);

            if (xRemainTemp < 0 || yRemainTemp < 0) {
                LogUtil.showDebugLog(mDuration + "new finish!");
                myTrunk.hasFinished = true;
                int generationTemp = myTrunk.mGeneration;
                if (generationTemp < 4) {
                    myTrunk.mXRemain = 0;
                    myTrunk.mYRemain = 0;
                    int a = (int) (3 * Math.random() + 2);
                    float newWidth = myTrunk.mWidth / a;
                    a = a * 2;
                    float pieceRadian = (float) (Math.toRadians(80) + radianTemp) / a;
                    float currentRadian = pieceRadian;
                    while (a > 0) {
                        MyTrunkPoint startPoint = new MyTrunkPoint();
                        startPoint.mXCoordinate = lastPointX - (float) Math.cos(currentRadian) * mStepGrow;
                        startPoint.mYCoordinate = lastPointY - (float) Math.sin(currentRadian) * mStepGrow;
                        startPoint.mRadius = newWidth / 2;

                        MyTrunk newTrunk = new MyTrunk();
                        newTrunk.mTrunkPointList.add(startPoint);
                        newTrunk.mWidth = newWidth;
                        newTrunk.mXRemain = mTrunkMaxWidth;
                        newTrunk.mYRemain = mTrunkMaxHeight;
                        newTrunk.mRadian = currentRadian;
                        newTrunk.mMaxRotateRadian = mTrunkMaxRotateRadian;
                        newTrunk.mGeneration = generationTemp + 1;

                        LogUtil.showDebugLog(mDuration + "new added!");

                        myTrunk.mChildTrunkList.add(newTrunk);
                        a = a - 2;
                        currentRadian = currentRadian + pieceRadian * 2;
                    }
                }
                mLock.writeLock().unlock();
            } else {
                MyTrunkPoint myTrunkPoint = new MyTrunkPoint();
                myTrunkPoint.mXCoordinate = lastPointX - xMove;
                myTrunkPoint.mYCoordinate = lastPointY - yMove;
                myTrunk.mXRemain = xRemainTemp;
                myTrunk.mYRemain = yRemainTemp;
                myTrunkPoint.mRadius = (float) (myTrunk.mWidth / 2 * (0.95 + 0.1 * Math.random()));

                myTrunk.mTrunkPointList.add(myTrunkPoint);
                mLock.writeLock().unlock();
            }
        }
    }

    /**
     * @param canvas draw the tree according to points recorded in myTree
     */
    private void drawTreeTrunk(Canvas canvas, MyTrunk myTrunk) {
        for (int i = 0; i < myTrunk.mTrunkPointList.size(); i++) {
            MyTrunkPoint myTrunkPoint = myTrunk.mTrunkPointList.get(i);
            canvas.drawCircle(myTrunkPoint.mXCoordinate, myTrunkPoint.mYCoordinate
                    , myTrunkPoint.mRadius, mTreeTrunkPainter);
        }
        int sizeTemp = myTrunk.mChildTrunkList.size();
        if (sizeTemp > 0) {
            for (int i = 0; i < sizeTemp; i++) {
                drawTreeTrunk(canvas, myTrunk.mChildTrunkList.get(i));
            }
        }
    }
}