package com.example.medupe;

public class SweetAlertDialog {
    public static final Object WARNING_TYPE = 0;
    public static final Object ERROR_TYPE = 0;
    public static final Object SUCCESS_TYPE = 0;
    public static final Object PROGRESS_TYPE = 0;

    public SweetAlertDialog(DoctorMenuActivity menuActivity , Object warningType) {

    }

    public void setConfirmText(String yes) {

    }

    public void setCancelText(String no) {

    }

    public void setContentText(String s) {

    }

    public void setTitleText(String close_application) {

    }

    public void show() {

    }

    public void cancel() {

    }

    public Object findViewById(int confirm_button) {
        return null;
    }

    public void setConfirmClickListener(OnSweetClickListener onSweetClickListener) {
        
    }

    public void hide() {

    }

    public Object getProgressHelper() {
        return null;
    }

    public void setCancelable(boolean b) {

    }

    public void setCancelClickListener(OnSweetClickListener onSweetClickListener) {

    }

    public abstract static class OnSweetClickListener {
        public abstract void onClick(SweetAlertDialog sweetAlertDialog);
    }
}
