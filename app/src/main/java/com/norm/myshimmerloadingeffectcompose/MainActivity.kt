package com.norm.myshimmerloadingeffectcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.norm.myshimmerloadingeffectcompose.ui.theme.MyShimmerLoadingEffectComposeTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyShimmerLoadingEffectComposeTheme {
                var isLoading by remember {
                    mutableStateOf(true)
                }
                LaunchedEffect(key1 = true) {
                    delay(10000)
                    isLoading = false
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(20) {
                            ShimmerListItem(
                                isLoading = isLoading,
                                contentAfterLoading = {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Person,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(128.dp)
                                        )
                                        Spacer(
                                            modifier = Modifier
                                                .height(16.dp)
                                        )
                                        Text(
                                            text = "First name: Sergey\n" +
                                                    "Phone 1: (555)555-1245\n" +
                                                    "Phone 2: +7(952)812-***-***\n" +
                                                    "Address: Kirova street, 88"
                                        )

                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}