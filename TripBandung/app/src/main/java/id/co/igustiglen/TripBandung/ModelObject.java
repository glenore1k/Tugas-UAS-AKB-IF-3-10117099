package id.co.igustiglen.TripBandung;



/**
 * Created by I Gusti Glen on 11-Agustus-20.
 * Nim :10117099
 * Kelas :IF-3
 */

public enum ModelObject {


    WISATA(R.string.wisata, R.layout.slider_wisata)
            ;

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}