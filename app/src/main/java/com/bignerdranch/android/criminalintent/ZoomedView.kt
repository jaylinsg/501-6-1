package com.bignerdranch.android.criminalintent

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment;
import java.io.File


class ZoomedView : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.zoomed_version, container, false)
        val imageView = view.findViewById<ImageView>(R.id.zoom_image_view)

        val photoFileName = arguments?.getSerializable("PHOTO_URI") as String

        // Load and set the zoomed-in photo
        val photoFile = File(requireContext().filesDir, photoFileName)
        val bitmap = BitmapFactory.decodeFile(photoFile.path)

        imageView.setImageBitmap(bitmap)
        return view
    }

    companion object {
        fun newInstance(photoFileName: String): ZoomedView {
            val frag = ZoomedView()
            val args = Bundle()
            args.putSerializable("PHOTO_URI", photoFileName)
            frag.arguments = args
            return frag
        }
    }
}
