package com.omelchenkoaleks.animals.screens.sort

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.omelchenkoaleks.animals.R

class SortPreferenceFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        return
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addPreferencesFromResource(R.xml.sort)
    }
}