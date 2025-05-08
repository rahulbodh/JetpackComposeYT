package com.example.jetpactwithphillpp

import android.R.style
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpactwithphillpp.ui.theme.JetpactWithPhillppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            ColoredBox()
            ListExample()


//            JetpactWithPhillppTheme {
//                val painter = painterResource(id = R.drawable.iron_man)
//                ImageCard(
//                    painter = painter,
//                    contentDescription = "Image is pretty cool",
//                    title = "Image is pretty cool"
//                )

//                TextStyling()
//            }

        }
    }
}

@Composable
fun ListExample(modifier: Modifier = Modifier) {
    Column {
        for (i in 1..30) {
            Text(
                text = "Item $i",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun ColoredBox(modifier: Modifier = Modifier) {

    val color = remember { mutableStateOf(Color.Red) }
    Box(
        modifier = modifier
            .background(color.value)
            .fillMaxSize()
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )

            }
    )
}

@Composable
fun TextStyling(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Red, fontStyle = FontStyle.Italic)) {
                    append("J")
                }
                withStyle(style = SpanStyle(color = Color.Blue, fontStyle = FontStyle.Italic)) {
                    append("etpack ")
                }

                withStyle(style = SpanStyle(color = Color.Red, fontStyle = FontStyle.Italic)) {
                    append("C")
                }
                withStyle(style = SpanStyle(color = Color.Blue, fontStyle = FontStyle.Italic)) {
                    append("ompose")
                }
            },
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline,
            letterSpacing = 2.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        Text(
            text = "Jetpack Compose",
            lineHeight = 30.sp,
            fontSize = 30.sp,
            letterSpacing = 2.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(elevation = 2.dp, shape = RoundedCornerShape(8.dp))
        )

        Text(
            text = "Headline Text",
            fontSize = 30.sp,
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.5f),
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            ),
            modifier = Modifier
                .padding(16.dp)
                .background(Color.Yellow, shape = RoundedCornerShape(8.dp))
        )

        Text(
            text = "Underline and Striketroough text",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 20.sp,
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.Underline,
                    TextDecoration.LineThrough
                )
            ),
            modifier = Modifier.padding(16.dp)
        )

        // Linear Gradient
        Text(
            text = "Hello, Rahul",
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Red, Color.Blue),
                    start = Offset(0f, 0f),
                    end = Offset(100f, 100f)
                ),
                fontSize = 30.sp
            ),
            modifier = Modifier.padding(16.dp)
        )

        // Radial Gradient
        Text(
            text = "Welcome to Gemini",
            style = TextStyle(
                brush = Brush.radialGradient(
                    colors = listOf(Color.Red, Color.Blue),
                    center = Offset(80f, 80f),
                    radius = 100f
                ),
                fontSize = 30.sp
            ),
            modifier = Modifier.padding(16.dp)
        )

        // Sweep Gradient text
        Text(
            text = "How can I help you?",
            style = TextStyle(
                brush = Brush.sweepGradient(
                    colors = listOf(Color.Red, Color.Blue),
                    center = Offset(50f, 50f),
                ),
                fontSize = 30.sp
            ),
            modifier = Modifier.padding(16.dp)
        )

        // Gradient Backround in ImageCard - like composable
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color.Blue, Color.Green),
                            start = Offset(0f, 0f),
                            end = Offset(0f, 200f)
                        )
                    )
            ) {
                Text(
                    text = "Gradient Card",
                    style = TextStyle(
                        brush = Brush.radialGradient(
                            colors = listOf(Color.White, Color.Yellow),
                            radius = 100f
                        ),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
        }

        Text(
            text = "This is a very long text that will be truncated with an ellipsis. This ",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 16.dp)
                .clickable {

                }
        )

        SelectionContainer {
            Text(
                text = "Selectable Text",
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp, 16.dp)
            )
        }

    }
}


@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box(modifier = Modifier.height(300.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            // Black shadow (gradient) at the bottom
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 100f // Start gradient 60% from the top
                        )
                    )
            )
            // Text over the image
            Text(
                text = title,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
                    .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(8.dp))
                    .padding(8.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ImagePreview() {
//    val painter = painterResource(id = R.drawable.iron_man)
//    ImageCard(
//        painter = painter,
//        contentDescription = "Image is pretty cool",
//        title = "Image is pretty cool"
//    )
//}

@Preview(showBackground = true)
@Composable
fun FunctionPreview() {
    ColoredBox()
//    TextStyling()
}