package com.tirexmurina.nonpatternapp.utils

import androidx.fragment.app.Fragment
import com.tirexmurina.patternapp.presentation.MainActivity

val Fragment.mainActivity: MainActivity
    get() = requireActivity() as MainActivity