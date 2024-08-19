import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.kamath.bookdigest.viewModels.BooksViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanBarcode(
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {
    val scope = rememberCoroutineScope()
    val booksViewModel: BooksViewModel = hiltViewModel()
    val bookDetails = booksViewModel.bookDetailLiveData.observeAsState()
    val bookDetailsValue = bookDetails.value
    val book = bookDetailsValue?.book
    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }

    if (barcodeValue != null) {
        LaunchedEffect(barcodeValue) {
            barcodeValue.let {
                textFieldValue.value = TextFieldValue(it)
                booksViewModel.searchBookByIsbn(it)
            }
        }
    }

    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            TextField(
                value = textFieldValue.value,
                onValueChange = {
                    textFieldValue.value = it
                },
                placeholder = {
                    Text("Scan Barcode")
                },
                leadingIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                onScanBarcode()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.QrCodeScanner,
                            contentDescription = "Scan Barcode"
                        )
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                ),
                readOnly = true
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        book?.let {
            item {
                val imageSize by remember {
                    derivedStateOf {
                        lerp(200.dp, 100.dp, scrollState.firstVisibleItemScrollOffset / 600f)
                    }
                }
                Image(
                    painter = rememberImagePainter(book.image),
                    contentDescription = "Book Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageSize)
                        .graphicsLayer {
                            scaleX = 1f
                            scaleY = 1f
                        }
                )
            }
            item{
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Text(text = book.title ?: "Unknown Title")
            }
        }
    }
}