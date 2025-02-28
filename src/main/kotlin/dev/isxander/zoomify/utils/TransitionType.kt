package dev.isxander.zoomify.utils

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

enum class TransitionType(val translationKey: String) : Transition {
    INSTANT("zoomify.transition.instant") {
        override fun apply(t: Double) =
            throw UnsupportedOperationException("TransitionType.INSTANT does not support apply()")
    },
    LINEAR("zoomify.transition.linear") {
        override fun apply(t: Double) =
            t
    },
    EASE_IN_SINE("zoomify.transition.ease_in_sine") {
        override fun apply(t: Double): Double =
            1 - cos((t * PI) / 2)
    },
    EASE_OUT_SINE("zoomify.transition.ease_out_sine") {
        override fun apply(t: Double): Double =
            sin((t * PI) / 2)
    },
    EASE_IN_OUT_SINE("zoomify.transition.ease_in_out_sine") {
        override fun apply(t: Double): Double =
            -(cos(PI * t) - 1) / 2
    },
    EASE_IN_QUAD("zoomify.transition.ease_in_quad") {
        override fun apply(t: Double): Double =
            t * t
    },
    EASE_OUT_QUAD("zoomify.transition.ease_out_quad") {
        override fun apply(t: Double): Double =
            1 - (1 - t) * (1 - t)
    },
    EASE_IN_OUT_QUAD("zoomify.transition.ease_in_out_quad") {
        override fun apply(t: Double): Double =
            if (t < 0.5)
                2 * t * t
            else
                1 - (-2 * t + 2).pow(2) / 2
    },
    EASE_IN_CUBIC("zoomify.transition.ease_in_cubic") {
        override fun apply(t: Double): Double =
            t.pow(3)
    },
    EASE_OUT_CUBIC("zoomify.transition.ease_out_cubic") {
        override fun apply(t: Double): Double =
            1 - (1 - t).pow(3)
    },
    EASE_IN_OUT_CUBIC("zoomify.transition.ease_in_out_cubic") {
        override fun apply(t: Double): Double =
            if (t < 0.5)
                4 * t * t * t
            else
                1 - (-2 * t + 2).pow(3) / 2
    }
}

fun interface Transition {
    fun apply(t: Double): Double
}
