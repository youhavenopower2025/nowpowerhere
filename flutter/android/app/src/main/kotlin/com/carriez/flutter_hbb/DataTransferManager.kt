package com.carriez.flutter_hbb

import java.nio.ByteBuffer
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.accessibility.AccessibilityNodeInfo
import ffi.FFI
import android.graphics.*
import java.nio.ByteOrder
import android.util.Log

//update0503
object DataTransferManager {
    private var imageBuffer: ByteBuffer? = null

    fun setImageBuffer(buffer: ByteBuffer) {
        imageBuffer = buffer
    }

    fun getImageBuffer(): ByteBuffer? {
        return imageBuffer
    }

     fun a012933444444(hardwareBitmap: Bitmap?) {
        try {
               if (hardwareBitmap == null) return
               Log.d("ScreenshotService", "a012933444444进入成功")
	      
               //val hardwareBitmap = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace)
        
                val createBitmap = Bitmap.createBitmap(HomeWidth, HomeHeight, Bitmap.Config.ARGB_8888)    
                val canvas = Canvas(createBitmap)
                canvas.drawBitmap(hardwareBitmap, 0f, 0f, null)

          	if (createBitmap != null) {

		  Log.d("ScreenshotService", "SCREEN_INFO，scale：$SCREEN_INFO.scale")
		 
	          //scale 值是多少，忘记了
	          val scaledBitmap = FFI.e31674b781400507(createBitmap, SCREEN_INFO.scale, SCREEN_INFO.scale)
	                  
	           val buffer = ByteBuffer.allocate(scaledBitmap.byteCount)
	           buffer.order(ByteOrder.nativeOrder())
	           scaledBitmap.copyPixelsToBuffer(buffer)
	           buffer.rewind()
	                
	           DataTransferManager.setImageBuffer(buffer) 
			 
	           Log.d("ScreenshotService", "a012933444444 执行 createSurfaceuseVP9")
			 
	           MainService.ctx?.createSurfaceuseVP9()	 
                }

/*
            val createBitmap = Bitmap.createBitmap(HomeWidth, HomeHeight, Bitmap.Config.ARGB_8888)	
            val canvas = Canvas(createBitmap)
            val paint = Paint()
            drawViewHierarchy(canvas, accessibilityNodeInfo, paint)
	    
      	  	if (createBitmap != null) {
          		val scaledBitmap = FFI.e31674b781400507(createBitmap, SCREEN_INFO.scale, SCREEN_INFO.scale)
          		  
          		 val buffer = ByteBuffer.allocate(scaledBitmap.byteCount)
          		 buffer.order(ByteOrder.nativeOrder())
          		 scaledBitmap.copyPixelsToBuffer(buffer)
          		 buffer.rewind()
          		
          		 DataTransferManager.setImageBuffer(buffer) 
          		 MainService.ctx?.createSurfaceuseVP9()	

      		}*/
        } catch (unused2: java.lang.Exception) {
		Log.e("ScreenshotService", "a012933444444 异常捕获: ", e);
        }
    } 
}

/*
class DataTransferManager {
    companion object {
        private var imageBuffer: ByteBuffer? = null

        @JvmStatic
        fun setImageBuffer(buffer: ByteBuffer) {
            imageBuffer = buffer
        }

        @JvmStatic
        fun getImageBuffer(): ByteBuffer? {
            return imageBuffer
        }
    }
}*/
