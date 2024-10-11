import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kamath.bookdigest.ui.screens.account.UserBio
import com.kamath.bookdigest.ui.screens.common.ButtonsRow
import com.kamath.bookdigest.ui.screens.common.FollowersRow
import com.kamath.bookdigest.ui.screens.common.ProfileImageAndName

@Composable
fun AccountScreen(
    name: String,
    username: String,
    bio: String,
    bookListed: Int,
    following: Int,
    followers: Int,
    currentBook: String,
    booksReadThisYear: Int,
    yearlyGoal: Int,
    recentActivities: List<String>,
    favoriteGenres: List<String>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            ProfileImageAndName(name = name, username = username)
            Spacer(modifier = Modifier.height(16.dp))
            UserBio(bio = bio)
            Spacer(modifier = Modifier.height(16.dp))
            ButtonsRow(
                onEditClick = { /* Handle edit button click */ },
                onMyBooksClick = { /* Handle my books button click */ },
                //onSettingsClick = { /* Handle settings button click */ }
            )
            Spacer(modifier = Modifier.height(16.dp))
            FollowersRow(bookListed = bookListed, following = following, followers = followers)
            Spacer(modifier = Modifier.height(16.dp))
            ReadingGoals(currentBook = currentBook, booksReadThisYear = booksReadThisYear, yearlyGoal = yearlyGoal)
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text("Recent Activity", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(recentActivities) { activity ->
            Text(activity)
            Spacer(modifier = Modifier.height(4.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Favorite Genres", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(favoriteGenres) { genre ->
            Text(genre)
            Spacer(modifier = Modifier.height(4.dp))
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Book Listing", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(3) { index ->
            Text("Book ${index + 1}")
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}