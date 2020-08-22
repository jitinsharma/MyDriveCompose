package `in`.jitinsharma.mydrivecompose.ui

import `in`.jitinsharma.mydrivecompose.R
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.asFontFamily
import androidx.compose.ui.text.font.font
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val typography = Typography(
        body1 = TextStyle(
                fontFamily = font(R.font.poppins_medium).asFontFamily(),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        ),
        h6 = TextStyle(
                fontFamily = font(R.font.poppins_semibold).asFontFamily(),
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
        ),
        subtitle1 = TextStyle(
                fontFamily = font(R.font.poppins_regular).asFontFamily(),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
        ),
        caption = TextStyle(
                fontFamily = font(R.font.poppins_light).asFontFamily(),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp
        )
        /* Other default text styles to override
button = TextStyle(
fontFamily = FontFamily.Default,
fontWeight = FontWeight.W500,
fontSize = 14.sp
),
caption = TextStyle(
fontFamily = FontFamily.Default,
fontWeight = FontWeight.Normal,
fontSize = 12.sp
)
*/
)