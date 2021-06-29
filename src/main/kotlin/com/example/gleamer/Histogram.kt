package com.example.gleamer

import org.springframework.stereotype.Service
import java.awt.image.BufferedImage


@Service
class Histogram {
    fun toGrayscaleImage(srcImage: BufferedImage): BufferedImage {
        val grayImage = BufferedImage(
            srcImage.width, srcImage.height,
            BufferedImage.TYPE_BYTE_GRAY
        )
        val wr = srcImage.raster
        val gr = grayImage.raster
        for (i in 0 until wr.width) {
            for (j in 0 until wr.height) {
                gr.setSample(i, j, 0, wr.getSample(i, j, 0))
            }
        }
        grayImage.data = gr
        return grayImage
    }

    fun equalize(inImage: BufferedImage): BufferedImage? {
        val outImage = BufferedImage(
            inImage.width, inImage.height,
            BufferedImage.TYPE_BYTE_GRAY
        )
        val inRaster = inImage.raster
        val outRaster = outImage.raster
        val resolution = inRaster.width * inRaster.height
        val histogram = IntArray(256)
        for (x in 0 until inRaster.width) {
            for (y in 0 until inRaster.height) {
                histogram[inRaster.getSample(x, y, 0)]++
            }
        }
        val cumulativeDistribution = IntArray(256)
        cumulativeDistribution[0] = histogram[0]
        for (i in 1..255) {
            cumulativeDistribution[i] = cumulativeDistribution[i - 1] + histogram[i]
        }
        val h = FloatArray(256)
        for (i in 0..255) {
            h[i] = (cumulativeDistribution[i] * 255.0 / resolution.toFloat()).toFloat()
        }
        for (x in 0 until inRaster.width) {
            for (y in 0 until inRaster.height) {
                val nVal = h[inRaster.getSample(x, y, 0)].toInt()
                outRaster.setSample(x, y, 0, nVal)
            }
        }
        outImage.data = outRaster
        return outImage
    }
}