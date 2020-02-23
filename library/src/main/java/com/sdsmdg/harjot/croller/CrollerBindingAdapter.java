package com.sdsmdg.harjot.croller;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods({
        @InverseBindingMethod(type = Croller.class, attribute = "app:floatProgress"),
})
public class CrollerBindingAdapter {

    @BindingAdapter("app:floatProgress")
    public static void setFloatProgress(Croller view, float progress) {
        if ((int)(view.getMin() + progress * (view.getMax() - view.getMin())) != view.getProgress()) {
            view.setProgress((int) (progress * (view.getMax() - view.getMin()) + view.getMin()));
        }
    }

    @InverseBindingAdapter(attribute = "app:floatProgress")
    public static float getFloatProgress(Croller view) {
        return (float) (view.getProgress() - view.getMin()) / (view.getMax() - view.getMin());
    }

    public interface OnProgressChanged {
        void onProgressChanged(float progress);
    }

    @BindingAdapter(value = {"floatProgressAttrChanged"}, requireAll = false)
    public static void setOnFloatProgressChangedListener(final Croller view, final InverseBindingListener attrChange)
    {
        view.setOnFloatProgressChangedListener(new Croller.OnFloatProgressChangedListener() {
            @Override
            public void onFloatProgressChanged(float progress) {
                attrChange.onChange();
            }
        });
    }
}
