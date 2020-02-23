package com.sdsmdg.harjot.crollerTest;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods({
        @InverseBindingMethod(type = Croller.class, attribute = "android:progress"),
})
public class CrollerBindingAdapter {

    @BindingAdapter("android:progress")
    public static void setProgress(Croller view, float progress) {
        if ((int)(view.getMin() + progress * (view.getMax() - view.getMin())) != view.getProgress()) {
            view.setProgress((int) (progress * (view.getMax() - view.getMin()) + view.getMin()));
        }
    }

    public interface OnProgressChanged {
        void onProgressChanged(float progress);
    }

    @BindingAdapter(value = {"android:onProgressChanged"}, requireAll = false)
    public static void setOnProgressChangedListener(final Croller view, final OnProgressChanged progressChanged)
    {
        if (progressChanged != null)
        {
            view.setOnCrollerChangeListener(new Croller.OnCrollerChangeListener() {
                boolean touch = false;
                @Override
                public void onProgressChanged(Croller croller, int progress) {
                    if (!touch)
                    {
                        progressChanged.onProgressChanged((float) (progress - view.getMin()) / (view.getMax() - view.getMin()));
                    }
                }

                @Override
                public void onStartTrackingTouch(Croller croller) {
                    touch = true;
                }

                @Override
                public void onStopTrackingTouch(Croller croller) {
                    touch = false;
                }
            });
        }else {
            view.setOnCrollerChangeListener(null);
        }

    }
}
