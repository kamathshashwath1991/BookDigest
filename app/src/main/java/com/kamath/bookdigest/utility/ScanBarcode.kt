import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.kamath.bookdigest.ui.screens.common.Accordion
import com.kamath.bookdigest.viewModels.BooksViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanBarcode(
    navController: NavHostController,
    onScanBarcode: suspend () -> Unit,
    barcodeValue: String?
) {
    val scope = rememberCoroutineScope()
    val booksViewModel: BooksViewModel = hiltViewModel()
    val bookDetails by booksViewModel.bookDetailLiveData.observeAsState()
    val book = bookDetails?.book
    val textFieldValue = remember { mutableStateOf(TextFieldValue()) }
    val sellPrice = remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current

    if (barcodeValue != null) {
        LaunchedEffect(barcodeValue) {
            textFieldValue.value = TextFieldValue(barcodeValue)
            booksViewModel.searchBookByIsbn(barcodeValue)
        }
    }

    val scrollState = rememberLazyListState()

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = scrollState,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            contentPadding = PaddingValues(16.dp)
        ) {
            if (book == null) {
                item {
                    TextField(
                        value = textFieldValue.value,
                        onValueChange = { textFieldValue.value = it },
                        placeholder = { Text("Scan Barcode") },
                        leadingIcon = {
                            IconButton(
                                onClick = { scope.launch { onScanBarcode() } }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.QrCodeScanner,
                                    contentDescription = "Scan Barcode"
                                )
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
                        readOnly = true
                    )
                }
                item { Spacer(modifier = Modifier.height(16.dp)) }
            } else {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Image(
                                painter = rememberImagePainter(book.image),
                                contentDescription = "Book Image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    Accordion(
                        title = "Title",
                        content = { Text(book.title ?: "Unknown Title") }
                    )
                }
                item {
                    Accordion(
                        title = "Synopsis",
                        content = { Text(book.synopsis ?: "Unknown Description") }
                    )
                }
                item {
                    Accordion(
                        title = "Price",
                        content = { Text("Price: ${book.msrp ?: "Unknown"}") }
                    )
                }
                item {
                    Accordion(
                        title = "Published Date",
                        content = { Text("Published on: ${book.date_published ?: "Unknown Date"}") }
                    )
                }
                item {
                    Accordion(
                        title = "Sell Price",
                        content = {
                            TextField(
                                value = sellPrice.value,
                                onValueChange = { sellPrice.value = it },
                                placeholder = { Text("Enter Sell Price") },
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    )
                }
            }
        }
        // Floating Action Button
        FloatingActionButton(
            onClick = {
                //Toast.makeText(context, "Book has been added!!", Toast.LENGTH_SHORT).show()
                navController.navigate("sell")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Sell, // You can use another icon here
                contentDescription = "Sell",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Sell", color = Color.White)
        }
    }
}