package com.example.praktikum3_235150207111041afifahnabiladevi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.praktikum3_235150207111041afifahnabiladevi.ui.theme.Praktikum3_235150207111041AfifahNabilaDeviTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Praktikum3_235150207111041AfifahNabilaDeviTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Pilih salah satu percobaan untuk dijalankan
                    // CounterApp()
                    // FollowApp()
                    // ProfileCard()
                    // MainApp() // Untuk menjalankan semua tugas
                    MainApp()
                }
            }
        }
    }
}

//PERCOBAAN 1: COUNTER SEDERHANA
@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Counter: $count",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { count++ }
        ) {
            Text("Tambah")
        }
    }
}

//PERCOBAAN 2: TOGGLE BUTTON (TANPA STATE HOISTING)
@Composable
fun FollowButton() {
    var isFollowed by remember { mutableStateOf(false) }

    Button(
        onClick = { isFollowed = !isFollowed }
    ) {
        Text(if (isFollowed) "Unfollow" else "Follow")
    }
}

//PERCOBAAN 3: STATE HOISTING
@Composable
fun FollowButtonWithHoisting(
    isFollowed: Boolean,
    onClick: () -> Unit
) {
    Button(onClick = onClick) {
        Text(if (isFollowed) "Unfollow" else "Follow")
    }
}

@Composable
fun FollowApp() {
    var isFollowed by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Status: ${if (isFollowed) "Following" else "Not Following"}",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        FollowButtonWithHoisting(
            isFollowed = isFollowed,
            onClick = { isFollowed = !isFollowed }
        )
    }
}

//PERCOBAAN 4: PROFILE CARD
@Composable
fun ProfileCard() {
    var isFollowed by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Menggunakan foto profil dari drawable
        Image(
            painter = painterResource(R.drawable.gambar_stego),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(8.dp))
        Text("Nama: Afifah Nabila Devi", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Mahasiswa Teknik Informatika")
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = { isFollowed = !isFollowed }) {
            Text(if (isFollowed) "Unfollow" else "Follow")
        }
    }
}

// TUGAS 1: Counter Plus-Minus
@Composable
fun CounterPlusMinusApp() {
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Counter Plus-Minus",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = count.toString(),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Button(
                        onClick = {
                            if (count > 0) count--
                        },
                        enabled = count > 0
                    ) {
                        Text("- Kurang")
                    }
                    Button(
                        onClick = { count++ }
                    ) {
                        Text("+ Tambah")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Nilai tidak bisa kurang dari 0",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

// TUGAS 2: Toggle Warna
@Composable
fun ToggleColorApp() {
    var isRed by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Klik kotak untuk mengubah warna",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Box(
            modifier = Modifier
                .size(200.dp)
                .background(
                    color = if (isRed) Color.Red else Color.Green
                )
                .clickable { isRed = !isRed },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isRed) "MERAH" else "HIJAU",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Warna saat ini: ${if (isRed) "Merah" else "Hijau"}",
            fontSize = 16.sp
        )
    }
}

// TUGAS 3: Profil Interaktif
@Composable
fun InteractiveProfileApp() {
    var isFollowed by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Foto profil menggunakan Image dari drawable dengan nama gmabar_stegoo
                Image(
                    painter = painterResource(R.drawable.gambar_stego),
                    contentDescription = "Foto Profil",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Afifah Nabila Devi",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "235150207111041",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Mahasiswa Teknik Informatika",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Universitas Brawijaya",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { isFollowed = !isFollowed },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isFollowed) Color.Red else Color.Blue
                    )
                ) {
                    Text(if (isFollowed) "Unfollow" else "Follow")
                }

                Spacer(modifier = Modifier.height(12.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isFollowed)
                            Color.Green.copy(alpha = 0.1f)
                        else
                            Color.Gray.copy(alpha = 0.1f)
                    )
                ) {
                    Text(
                        text = if (isFollowed)
                            "✅ Anda mengikuti akun ini"
                        else
                            "❌ Anda belum mengikuti akun ini",
                        modifier = Modifier.padding(12.dp),
                        fontSize = 14.sp,
                        color = if (isFollowed) Color.Green else Color.Gray
                    )
                }
            }
        }
    }
}

// MAIN APP UNTUK NAVIGASI ANTAR TUGAS
@Composable
fun MainApp() {
    var currentScreen by remember { mutableStateOf("menu") }

    when (currentScreen) {
        "menu" -> MainMenu { screen -> currentScreen = screen }
        "counter" -> CounterPlusMinusApp()
        "color" -> ToggleColorApp()
        "profile" -> InteractiveProfileApp()
        "demo" -> DemoScreen()
    }
}

@Composable
fun MainMenu(onNavigate: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Praktikum 3: State Management",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        MenuButton("Demo Percobaan", "demo", onNavigate)
        Spacer(modifier = Modifier.height(12.dp))
        MenuButton("Tugas 1: Counter Plus-Minus", "counter", onNavigate)
        Spacer(modifier = Modifier.height(12.dp))
        MenuButton("Tugas 2: Toggle Warna", "color", onNavigate)
        Spacer(modifier = Modifier.height(12.dp))
        MenuButton("Tugas 3: Profil Interaktif", "profile", onNavigate)
    }
}

@Composable
fun MenuButton(text: String, screen: String, onNavigate: (String) -> Unit) {
    Button(
        onClick = { onNavigate(screen) },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(text, fontSize = 16.sp)
    }
}

@Composable
fun DemoScreen() {
    var currentDemo by remember { mutableStateOf("counter") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Tab bar untuk demo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            DemoTab("Counter", "counter", currentDemo) { currentDemo = it }
            DemoTab("Follow", "follow", currentDemo) { currentDemo = it }
            DemoTab("Profile", "profile", currentDemo) { currentDemo = it }
        }

        // Content area
        Box(modifier = Modifier.fillMaxSize()) {
            when (currentDemo) {
                "counter" -> CounterApp()
                "follow" -> FollowApp()
                "profile" -> ProfileCard()
            }
        }
    }
}

@Composable
fun DemoTab(text: String, value: String, current: String, onSelect: (String) -> Unit) {
    Button(
        onClick = { onSelect(value) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (current == value)
                MaterialTheme.colorScheme.primary
            else
                Color.Gray
        )
    ) {
        Text(text, fontSize = 12.sp)
    }
}