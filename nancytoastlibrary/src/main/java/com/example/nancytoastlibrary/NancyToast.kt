package com.example.nancytoastlibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.IntDef

class NancyToast

    (context: Context) : Toast(context) {
    @Retention(AnnotationRetention.SOURCE)
    @IntDef(SUCCESS, WARNING, ERROR, INFO, DEFAULT)
    annotation class LayoutType

    @IntDef(LENGTH_SHORT, LENGTH_LONG)
    @Retention(
        AnnotationRetention.SOURCE
    )
    annotation class Duration
    companion object {
        const val SUCCESS: Int = 1
        const val WARNING: Int = 2
        const val ERROR: Int = 3
        const val INFO: Int = 4
        const val DEFAULT: Int = 5

        const val LENGTH_SHORT: Int = Toast.LENGTH_SHORT
        const val LENGTH_LONG: Int = Toast.LENGTH_LONG

        fun makeText(
            context: Context,
            message: CharSequence?,
            @Duration duration: Int,
            @LayoutType type: Int,
            androidIcon : Boolean
        ): Toast {
            val toast = Toast(context)
            toast.duration = duration
            val layout: View =
                LayoutInflater.from(context).inflate(R.layout.nancytoast_layout, null, false)
            val l1 = layout.findViewById<TextView>(R.id.toast_text)
            val linearLayout = layout.findViewById<LinearLayout>(R.id.toast_type)
            val img = layout.findViewById<ImageView>(R.id.toast_icon)
            val img1 = layout.findViewById<ImageView>(R.id.imageAndroid)
            l1.text = message
            if (androidIcon)
                img1.setVisibility(View.VISIBLE)
            else img1.setVisibility(View.GONE)
            when (type) {
                SUCCESS -> {
                    linearLayout.setBackgroundResource(R.drawable.success_shape)
                    img.setImageResource(R.drawable.round_success_24)
                }
                WARNING -> {
                    linearLayout.setBackgroundResource(R.drawable.warning_shape)
                    img.setImageResource(R.drawable.round_warning_24)
                }
                ERROR -> {
                    linearLayout.setBackgroundResource(R.drawable.error_shape)
                    img.setImageResource(R.drawable.round_error_24)
                }
                INFO -> {
                    linearLayout.setBackgroundResource(R.drawable.info_shape)
                    img.setImageResource(R.drawable.round_info_24)
                }
                DEFAULT -> {
                    linearLayout.setBackgroundResource(R.drawable.default_shape)
                    img.visibility = View.GONE
                }
            }
            toast.setView(layout)
            return toast
        }


        fun makeText(
            context: Context,
            message: CharSequence?,
            @Duration duration: Int,
            @LayoutType type: Int,
            @DrawableRes imageResource: Int,
            androidIcon: Boolean
        ): Toast {
            val toast = Toast(context)
            toast.duration = duration
            val layout: View =
                LayoutInflater.from(context).inflate(R.layout.nancytoast_layout, null, false)
            val l1 = layout.findViewById<TextView>(R.id.toast_text)
            val linearLayout = layout.findViewById<LinearLayout>(R.id.toast_type)
            val img = layout.findViewById<ImageView>(R.id.toast_icon)
            val img1 = layout.findViewById<ImageView>(R.id.imageAndroid)
            l1.text = message
            img.setImageResource(imageResource)
            if (androidIcon)
                img1.setVisibility(View.VISIBLE)
            else img1.setVisibility(View.GONE)
            when (type) {
                SUCCESS -> linearLayout.setBackgroundResource(R.drawable.success_shape)
                WARNING -> linearLayout.setBackgroundResource(R.drawable.warning_shape)
                ERROR -> linearLayout.setBackgroundResource(R.drawable.error_shape)
                INFO -> linearLayout.setBackgroundResource(R.drawable.info_shape)
                DEFAULT -> linearLayout.setBackgroundResource(R.drawable.default_shape)
            }
            toast.setView(layout)
            return toast
        }
    }
}