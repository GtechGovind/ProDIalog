package com.gtech.pro_dialog

import android.app.Activity
import android.app.AlertDialog
import android.content.res.Resources
import android.graphics.Typeface
import android.view.LayoutInflater
import android.widget.RelativeLayout
import android.widget.Toast
import com.gtech.pro_dialog.databinding.ProDialogBinding


class ProDialogBuilder(private val context: Activity) {

    private val binding: ProDialogBinding = ProDialogBinding.inflate(LayoutInflater.from(context))
    private val alertDialog: AlertDialog = AlertDialog.Builder(context, R.style.pro_dialog).setView(binding.root).create()

    fun title(
        title: String,
        fontStyle: Typeface? = null,
        titleColor: Int = 0
    ): ProDialogBuilder {
        context.runOnUiThread {
            binding.title.text = title.trim()
            if (fontStyle != null) {
                binding.title.typeface = fontStyle
            }
            if (titleColor != 0) {
                binding.title.setTextColor(titleColor)
            }
            binding.title.show()
        }
        return this
    }

    fun background(dialogBackgroundColor: Int? = null): ProDialogBuilder {
        context.runOnUiThread {
            dialogBackgroundColor?.let { binding.mainLayout.setBackgroundResource(it) }
        }
        return this
    }

    fun dialogAnimation(resId: Int): ProDialogBuilder {
        context.runOnUiThread {
            binding.dialogAnimation.setAnimation(resId)
        }
        return this
    }

    fun position(position: ProDialog.POSITIONS = ProDialog.POSITIONS.BOTTOM): ProDialogBuilder {
        context.runOnUiThread {
            val layoutParams = binding.mainLayout.layoutParams as RelativeLayout.LayoutParams
            if (position == ProDialog.POSITIONS.CENTER) {
                layoutParams.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE)
            } else if (position == ProDialog.POSITIONS.BOTTOM) {
                layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
            }
            binding.mainLayout.layoutParams = layoutParams
        }
        return this
    }

    fun description(
        description: String,
        fontStyle: Typeface? = null,
        color: Int = 0
    ): ProDialogBuilder {
        context.runOnUiThread {
            binding.subHeading.text = description.trim()
            binding.subHeading.show()
            if (fontStyle != null) binding.subHeading.typeface = fontStyle
            if (color != 0) binding.subHeading.setTextColor(color)
        }
        return this
    }

    fun type(type: ProDialog.TYPE): ProDialogBuilder {
        context.runOnUiThread {

            val animationResource = when (type) {
                ProDialog.TYPE.SUCCESS -> R.raw.success
                ProDialog.TYPE.INFO -> R.raw.info
                ProDialog.TYPE.ALERT -> R.raw.alert
                ProDialog.TYPE.ERROR -> R.raw.error
            }

            try {
                binding.dialogAnimation.setAnimation(animationResource)
                binding.dialogAnimation.show()
            } catch (e: Resources.NotFoundException) {
                Toast.makeText(
                    context,
                    e.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        return this
    }


    fun onPositive(
        text: String,
        fontStyle: Typeface? = null,
        buttonBackgroundColor: Int? = null,
        textColor: Int? = null,
        shouldIDismissOnClick: Boolean = true,
        action: (() -> Unit)? = null
    ): ProDialogBuilder {
        context.runOnUiThread {
            binding.yesButton.show()
            if (fontStyle != null) binding.yesButton.typeface = fontStyle
            buttonBackgroundColor?.let { binding.yesButton.setBackgroundResource(it) }
            textColor?.let { binding.yesButton.setTextColor(it) }
            binding.yesButton.text = text.trim()
            binding.yesButton.setOnClickListener {
                action?.invoke()
                if (shouldIDismissOnClick) alertDialog.dismiss()
            }
        }
        return this
    }

    fun onNegative(
        text: String,
        fontStyle: Typeface? = null,
        buttonBackgroundColor: Int? = null,
        textColor: Int? = null,
        shouldIDismissOnClick: Boolean = true,
        action: (() -> Unit)? = null
    ): ProDialogBuilder {
        context.runOnUiThread {
            binding.noButton.show()
            binding.noButton.text = text.trim()
            textColor?.let { binding.noButton.setTextColor(it) }
            fontStyle?.let { binding.noButton.typeface = it }
            buttonBackgroundColor?.let { binding.noButton.setBackgroundResource(it) }
            binding.noButton.setOnClickListener {
                action?.invoke()
                if (shouldIDismissOnClick) alertDialog.dismiss()
            }
        }
        return this
    }

    fun hideNegativeButton(hide: Boolean = false): ProDialogBuilder {
        context.runOnUiThread {
            if (hide) binding.noButton.hide()
        }
        return this
    }

    fun show(): AlertDialog {
        alertDialog.show()
        return alertDialog
    }

}

object ProDialog {

    enum class POSITIONS { CENTER, BOTTOM }

    enum class TYPE { SUCCESS, INFO, ALERT, ERROR }

    fun build(context: Activity): ProDialogBuilder = ProDialogBuilder(context)

}
