package com.fire.designsystem.demo.screen.foundation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.fire.designsystem.demo.Screen
import com.fire.designsystem.demo.component.HorizontalSpacer
import com.fire.designsystem.demo.ext.PreviewWithUiMode
import com.fire.designsystem.foundation.theme.FireTheme

fun NavGraphBuilder.addTypoScreen(
    navController: NavController
) {
    composable(Screen.TYPO.name) {
        TypoScreen(
            onBackPressed = { navController.popBackStack() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TypoScreen(
    onBackPressed: () -> Unit
) {
    val text by remember { mutableStateOf("StudioFire") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Typography",
                        color = FireTheme.colorScheme.onBackground,
                        style = FireTheme.typography.headlineSmall
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(FireTheme.dimension.extraSmall),
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.clickable(onClick = onBackPressed)
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(FireTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
                .padding(it)
        ) {
            TypoItemSet(
                styleText = "display",
                text = text,
                largeStyle = FireTheme.typography.displayLarge,
                mediumStyle = FireTheme.typography.displayMedium,
                smallStyle = FireTheme.typography.displaySmall
            )
            TypoItemSet(
                styleText = "headline",
                text = text,
                largeStyle = FireTheme.typography.headlineLarge,
                mediumStyle = FireTheme.typography.headlineMedium,
                smallStyle = FireTheme.typography.headlineSmall
            )
            TypoItemSet(
                styleText = "title",
                text = text,
                largeStyle = FireTheme.typography.titleLarge,
                mediumStyle = FireTheme.typography.titleMedium,
                smallStyle = FireTheme.typography.titleSmall
            )
            TypoItemSet(
                styleText = "body",
                text = text,
                largeStyle = FireTheme.typography.bodyLarge,
                mediumStyle = FireTheme.typography.bodyMedium,
                smallStyle = FireTheme.typography.bodySmall
            )
            TypoItemSet(
                styleText = "label",
                text = text,
                largeStyle = FireTheme.typography.labelLarge,
                mediumStyle = FireTheme.typography.labelMedium,
                smallStyle = FireTheme.typography.labelSmall
            )
        }
    }
}

@Composable
private fun TypoItemSet(
    styleText: String,
    text: String,
    largeStyle: TextStyle,
    mediumStyle: TextStyle,
    smallStyle: TextStyle,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(FireTheme.colorScheme.background)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = styleText,
            modifier = Modifier.weight(0.2f, true),
            style = FireTheme.typography.titleMedium,
            color = FireTheme.colorScheme.onBackground
        )
        HorizontalSpacer(size = 20.dp)
        Column(
            modifier = Modifier.weight(0.8f, true)
        ) {
            Text(
                text = text,
                style = largeStyle,
                color = FireTheme.colorScheme.onBackground
            )
            Text(
                text = text,
                style = mediumStyle,
                color = FireTheme.colorScheme.onBackground
            )
            Text(
                text = text,
                style = smallStyle,
                color = FireTheme.colorScheme.onBackground
            )
        }
    }
}

@PreviewWithUiMode
@Composable
private fun PreviewTypoScreen() {
    FireTheme {
        TypoScreen(
            onBackPressed = {}
        )
    }
}