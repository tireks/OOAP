package com.tirexmurina.nonpatternapp.utils

import androidx.fragment.app.Fragment
import com.tirexmurina.nonpatternapp.presentation.MainActivity

val Fragment.mainActivity: MainActivity
    get() = requireActivity() as MainActivity