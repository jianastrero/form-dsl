package dev.jianastrero.formdslexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.jianastrero.formdsl.VerticalForm
import dev.jianastrero.formdslexample.ui.theme.FormDSLTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormDSLTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    VerticalForm(modifier = Modifier.fillMaxSize()) {
                        page {
                            title(text = "Title 1")
                            subtitle(text = "Subtitle 1")
                        }
                        page {
                            title(text = "Title 2")
                            subtitle(text = "Subtitle 2")
                        }
                        page {
                            title(text = "Title 3")
                            subtitle(text = "Subtitle 3")
                        }
                        page {
                            title(text = "Title 4")
                            subtitle(text = "Subtitle 4")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FormDSLTheme {
        Greeting("Android")
    }
}
