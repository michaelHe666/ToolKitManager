package cn.edu.zust.dmt.tkm.views.dialogs;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

import cn.edu.zust.dmt.common.utils.DateUtil;
import cn.edu.zust.dmt.tkm.R;
import cn.edu.zust.dmt.tkm.views.widgets.combined.MyFormBar;

import static cn.edu.zust.dmt.common.utils.DateUtil.myyyyMMddSlash2Format;

/**
 * @author MR.M
 * @projectName tkm
 * @packageName cn.edu.zust.dmt.tkm.views.fragments
 * @description $
 * @time 1/8/2020 9:09
 * copyright(c) all rights reserved by MR.M
 **/
public class BottomDatePickerFragment extends DialogFragment {
    /**
     * @description callback view RID
     */
    private int mObjectViewRId;
    /**
     * @description datePicker max loopName
     */
    private String mMinDateString;
    /**
     * @description datePicker min loopName
     */
    private String mMaxDateString;

    private Button mDismissButton;
    private Button mConfirmButton;
    private DatePicker mDatePicker;

    /**
     * @attention super class also has an empty constructor
     */
    public BottomDatePickerFragment() {
    }

    /**
     * @description get bundles to initialize member variables
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMinDateString = getArguments().getString("KEYMinDate");
            mMaxDateString = getArguments().getString("KEYMaxDate");
            mObjectViewRId = getArguments().getInt("KEYObjectViewRId");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_selector_date_picker, null, false);
        bindMemberViews(view);
        initializeDismissButton();
        initializeConfirmButton();
        initializeDatePicker();
        return view;
    }

    /**
     * @description set dialog view attributes
     */
    @Override
    public void onStart() {
        super.onStart();

        getDialog().setCanceledOnTouchOutside(false);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams params = window.getAttributes();
            params.gravity = Gravity.BOTTOM;
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(params);
        }
    }

    private void bindMemberViews(@NonNull View view) {
        mDismissButton = view.findViewById(R.id.fragmentSelectorDatePickerDismissButton);
        mConfirmButton = view.findViewById(R.id.fragmentSelectorDatePickerConfirmButton);
        mDatePicker = view.findViewById(R.id.fragmentSelectorDatePickerDatePicker);
    }

    private void initializeDismissButton() {
        mDismissButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {

                                              }
                                          }
        );
    }

    private void initializeConfirmButton() {
        mConfirmButton.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  if (getActivity() != null) {
                                                      Calendar calendar = Calendar.getInstance();
                                                      calendar.set(mDatePicker.getYear(),
                                                              mDatePicker.getMonth(),
                                                              mDatePicker.getDayOfMonth());//默认一号
                                                      String selectedDateString = DateUtil.convertDateToString(calendar.getTime(),
                                                              myyyyMMddSlash2Format);
                                                      ((MyFormBar) getActivity().findViewById(mObjectViewRId)).setContentText(selectedDateString);
                                                  }
                                                  getDialog().dismiss();
                                              }
                                          }
        );
    }

    private void initializeDatePicker() {
        mDatePicker.setDescendantFocusability(DatePicker.FOCUS_BLOCK_DESCENDANTS);
        if (mMinDateString != null) {
            mDatePicker.setMinDate(DateUtil.convertStringToDate(mMinDateString, myyyyMMddSlash2Format).getTime());
        }
        if (mMaxDateString != null) {
            mDatePicker.setMaxDate(DateUtil.convertStringToDate(mMaxDateString, myyyyMMddSlash2Format).getTime());
        }
    }
}
