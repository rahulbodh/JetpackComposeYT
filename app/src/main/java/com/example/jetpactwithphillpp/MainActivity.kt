package com.example.jetpactwithphillpp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpactwithphillpp.ui.theme.JetpactWithPhillppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpactWithPhillppTheme {
                val painter = painterResource(id = R.drawable.iron_man)
                ImageCard(
                    painter = painter,
                    contentDescription = "Image is pretty cool",
                    title = "Image is pretty cool"
                )
            }

        }
    }
}

@Composable
fun TextStyling( modifier: Modifier = Modifier) {
    Column ( modifier = modifier
        .fillMaxSize()
        .background(Color.Cyan)){
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
                    offset = Offset(4f ,4f),
                    blurRadius = 8f
                )
            ),
            modifier = Modifier.padding(16.dp)
                .background(Color.Yellow , shape = RoundedCornerShape(8.dp))
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
    TextStyling()
}