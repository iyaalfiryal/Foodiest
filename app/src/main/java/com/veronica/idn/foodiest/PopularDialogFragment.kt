package com.veronica.idn.foodiest


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.veronica.idn.foodiest.model.Foods

/**
 * A simple [Fragment] subclass.
 */
class PopularDialogFragment : DialogFragment() {
    private var optionDialogListener: OnOptionDialogListener? = null
    companion object{
        const val KEY_FOOD = "food"
    }
    private var foods:Foods? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_dialog, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}

interface OnOptionDialogListener {
    fun onOptionChosen(text: String?)
}
