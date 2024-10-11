
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ReadingGoals(currentBook: String, booksReadThisYear: Int, yearlyGoal: Int) {
    Column {
        Text("Currently Reading: $currentBook")
        Text("Books Read This Year: $booksReadThisYear / $yearlyGoal")
        LinearProgressIndicator(
            progress = booksReadThisYear.toFloat() / yearlyGoal,
            modifier = Modifier.fillMaxWidth()
        )
    }
}