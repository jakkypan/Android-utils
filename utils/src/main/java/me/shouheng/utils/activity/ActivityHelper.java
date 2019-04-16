package me.shouheng.utils.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ActivityHelper is a helper class used to start your activity defined in your manifest or
 * start other activities by intent. You can easily prepare the values by the builder and connect
 * all the methods like a chain, which is rather elegant than using the raw intent.
 *
 * @author shouh
 * @version $Id: ActivityHelper, v 0.1 2018/11/17 17:29 shouh Exp$
 */
public final class ActivityHelper {

    private ActivityHelper() {
        throw new UnsupportedOperationException("U can't initialize me!");
    }

    /**
     * Start given activity.
     *
     * @param context the context to start activity
     * @param activity the destination activity
     */
    public static void start(Context context, Class<? extends Activity> activity) {
        context.startActivity(new Intent(context, activity));
    }

    /**
     * Start given activity and try to get the result.
     *
     * @param activity starter activity
     * @param activityClass target activity
     * @param requestCode the request code
     */
    public static void start(Activity activity, Class<? extends Activity> activityClass, int requestCode) {
        activity.startActivityForResult(new Intent(activity, activityClass), requestCode);
    }

    /**
     * Start given activity and try to get the result.
     *
     * @param fragment starter fragment
     * @param activityClass the target activity
     * @param requestCode the request code
     */
    public static void start(Fragment fragment, Class<? extends Activity> activityClass, int requestCode) {
        fragment.startActivityForResult(new Intent(fragment.getContext(), activityClass), requestCode);
    }

    /**
     Get an {@link Builder} instance used to build the intent to start an activity.
     *
     * @param activity the destination activity
     * @param <T> the activity type
     * @return the builder
     */
    public static <T extends Activity> Builder<T> open(Class<T> activity) {
        return new Builder<>(activity);
    }

    /**
     * Get an builder to build an intent to start an third part activity
     *
     * @return the builder used to build intent
     */
    public static Builder open() {
        return new Builder();
    }

    /**
     * A builder used to build intent to start activity
     *
     * @param <T> the activity type
     */
    public static class Builder<T extends Activity> {

        private Class<T> clz;

        private Intent intent = new Intent();

        /**
         * Builder with no params used to open the third part activity by intent.
         */
        Builder() {}

        /**
         * Builder with given type activity used to open the activity defined in your manifest
         *
         * @param clz the activity to launch
         */
        Builder(Class<T> clz) {
            this.clz = clz;
        }

        public Builder<T> setClass(Context packageContext, Class<T> clz) {
            intent.setClass(packageContext, clz);
            return this;
        }

        public Builder<T> setAction(String action) {
            intent.setAction(action);
            return this;
        }

        public Builder<T> setData(Uri data) {
            intent.setData(data);
            return this;
        }

        public Builder<T> setFlags(int flags) {
            intent.setFlags(flags);
            return this;
        }

        public Builder<T> setType(String type) {
            intent.setType(type);
            return this;
        }

        public Builder<T> addCategory(String category) {
            intent.addCategory(category);
            return this;
        }

        public Builder<T> put(String key, byte b) {
            intent.putExtra(key, b);
            return this;
        }

        public Builder<T> put(String key, char c) {
            intent.putExtra(key, c);
            return this;
        }

        public Builder<T> put(String key, short s) {
            intent.putExtra(key, s);
            return this;
        }

        public Builder<T> put(String key, int i) {
            intent.putExtra(key, i);
            return this;
        }

        public Builder<T> put(String key, long l) {
            intent.putExtra(key, l);
            return this;
        }

        public Builder<T> put(String key, float f) {
            intent.putExtra(key, f);
            return this;
        }

        public Builder<T> put(String key, double d) {
            intent.putExtra(key, d);
            return this;
        }

        public Builder<T> put(String key, String s) {
            intent.putExtra(key, s);
            return this;
        }

        public Builder<T> put(String key, CharSequence cs) {
            intent.putExtra(key, cs);
            return this;
        }

        public Builder<T> put(String key, Serializable s) {
            intent.putExtra(key, s);
            return this;
        }

        public Builder<T> put(String key, Parcelable p) {
            intent.putExtra(key, p);
            return this;
        }

        public Builder<T> put(String key, boolean[] bs) {
            intent.putExtra(key, bs);
            return this;
        }

        public Builder<T> put(String key, byte[] bs) {
            intent.putExtra(key, bs);
            return this;
        }

        public Builder<T> put(String key, short[] ss) {
            intent.putExtra(key, ss);
            return this;
        }

        public Builder<T> put(String key, char[] cs) {
            intent.putExtra(key, cs);
            return this;
        }

        public Builder<T> put(String key, int[] is) {
            intent.putExtra(key, is);
            return this;
        }

        public Builder<T> put(String key, long[] ls) {
            intent.putExtra(key, ls);
            return this;
        }

        public Builder<T> put(String key, float[] fs) {
            intent.putExtra(key, fs);
            return this;
        }

        public Builder<T> put(String key, double[] ds) {
            intent.putExtra(key, ds);
            return this;
        }

        public Builder<T> put(String key, String[] ss) {
            intent.putExtra(key, ss);
            return this;
        }

        public Builder<T> put(String key, CharSequence[] css) {
            intent.putExtra(key, css);
            return this;
        }

        public Builder<T> put(String key, Bundle bundle) {
            intent.putExtra(key, bundle);
            return this;
        }

        public Builder<T> put(String key, Parcelable[] ps) {
            intent.putExtra(key, ps);
            return this;
        }

        public Builder<T> putParcelableList(String key, ArrayList<? extends Parcelable> pl) {
            intent.putParcelableArrayListExtra(key, pl);
            return this;
        }

        public Builder<T> putIntegerList(String key, ArrayList<Integer> il) {
            intent.putIntegerArrayListExtra(key, il);
            return this;
        }

        public Builder<T> putStringList(String key, ArrayList<String> sl) {
            intent.putStringArrayListExtra(key, sl);
            return this;
        }

        public Builder<T> putCharSequenceList(String key, ArrayList<CharSequence> csl) {
            intent.putCharSequenceArrayListExtra(key, csl);
            return this;
        }

        public Intent getIntent(Context context) {
            if (clz != null) {
                intent.setClass(context, clz);
            }
            return intent;
        }

        public void launch(@NonNull Context context) {
            Intent i = getIntent(context);
            context.startActivity(i);
        }

        public void launch(@NonNull Activity activity, int requestCode) {
            Intent i = getIntent(activity);
            activity.startActivityForResult(i, requestCode);
        }

        public void launch(@NonNull Fragment fragment, int requestCode) {
            Intent i = getIntent(fragment.getActivity());
            fragment.startActivityForResult(i, requestCode);
        }
    }
}