package org.ayo.view.status;

import android.content.Context;
import android.view.View;

/**
 */
public class DefaultStatusProvider {

    public static class DefaultLoadingStatusView extends StatusProvider {

        public DefaultLoadingStatusView(Context context, String status, View contentView, OnStatusViewCreateCallback callback) {
            super(context, status, contentView, callback);
        }

        @Override
        public View getStatusView() {
            return View.inflate(mContext, R.layout.su_view_loading, null);
        }

        @Override
        public String getStatusViewflag() {
            return "loading";
        }
    }

    public static class DefaultEmptyStatusView extends StatusProvider{

        public DefaultEmptyStatusView(Context context, String status, View contentView, OnStatusViewCreateCallback callback) {
            super(context, status, contentView, callback);
        }

        @Override
        public View getStatusView() {
            return View.inflate(mContext, R.layout.su_view_empty, null);
        }

        @Override
        public String getStatusViewflag() {
            return null;
        }
    }

    public static class DefaultServerErrorStatusView extends StatusProvider{

        public DefaultServerErrorStatusView(Context context, String status, View contentView, OnStatusViewCreateCallback callback) {
            super(context, status, contentView, callback);
        }

        @Override
        public View getStatusView() {
            return View.inflate(mContext, R.layout.su_view_error_server, null);
        }

        @Override
        public String getStatusViewflag() {
            return "netoff";
        }
    }

    public static class DefaultNetOffStatusView extends StatusProvider{

        public DefaultNetOffStatusView(Context context, String status, View contentView, OnStatusViewCreateCallback callback) {
            super(context, status, contentView, callback);
        }

        @Override
        public View getStatusView() {
            return View.inflate(mContext, R.layout.su_view_error_server, null);
        }

        @Override
        public String getStatusViewflag() {
            return "netoff";
        }
    }

    public static class DefaultLogicFailStatusView extends StatusProvider{

        public DefaultLogicFailStatusView(Context context, String status, View contentView, OnStatusViewCreateCallback callback) {
            super(context, status, contentView, callback);
        }

        @Override
        public View getStatusView() {
            return View.inflate(mContext, R.layout.su_view_error_local, null);
        }

        @Override
        public String getStatusViewflag() {
            return null;
        }
    }

    public static class DefaultLocalErrorStatusView extends StatusProvider{

        public DefaultLocalErrorStatusView(Context context, String status, View contentView, OnStatusViewCreateCallback callback) {
            super(context, status, contentView, callback);
        }

        @Override
        public View getStatusView() {
            return View.inflate(mContext, R.layout.su_view_error_local, null);
        }

        @Override
        public String getStatusViewflag() {
            return null;
        }
    }

}
