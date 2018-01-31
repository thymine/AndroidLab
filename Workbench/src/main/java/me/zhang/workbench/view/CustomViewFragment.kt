package me.zhang.workbench.view

import android.graphics.*
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import me.zhang.workbench.R
import me.zhang.workbench.view.CustomViewActivity.FRAGMENT_TITLE

/**
 * Created by Zhang on 8/19/2017 6:52 PM.
 */
class CustomViewFragment : Fragment() {

    private var mCustomImage: ImageView? = null
    private var mScaleBitmapImage: ImageView? = null

    companion object {
        fun newInstance(title: String): CustomViewFragment {
            val args = Bundle()
            args.putString(FRAGMENT_TITLE, title)

            val fragment = CustomViewFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_custom_view, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCustomImage = view!!.findViewById(R.id.custom_image)
        mCustomImage!!.setImageBitmap(getDrawnBitmap())

        mScaleBitmapImage = view.findViewById(R.id.scale_bitmap)
        mScaleBitmapImage?.setImageBitmap(getScaleBitmap())
    }

    private fun getDrawnBitmap(): Bitmap {
        val width = 480
        val height = 480
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(bitmap)

        val radius = 24f
        val cx = width / 2f
        val cy = height / 2f

        /* draw circle */
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL
        canvas.drawCircle(cx, cy, radius, paint)

        /* draw rectangle */
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        val offset = 60f
        canvas.drawRect(cx - offset, cy - offset, cx + offset, cy + offset, paint)

        return bitmap
    }

    private fun getScaleBitmap(): Bitmap {
        val bitmapBuffer = Bitmap.createBitmap(800, 500, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(bitmapBuffer)

        val bitmap = BitmapFactory.decodeResource(resources, R.mipmap.ic_launcher)
        canvas.drawBitmap(bitmap, 0f, 0f, null)

        /* 从bitmap中抠出一块大小为src的区域，绘制到dst区域 */
        val width = bitmap.width
        val height = bitmap.height
        val src = Rect(width / 2, height / 2, width, height)
        val dst = Rect(width, 0, width * 4, height * 3)
        canvas.drawBitmap(bitmap, src, dst, null)
        return bitmapBuffer
    }

}