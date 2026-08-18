package com.example.twitterfalso.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.twitterfalso.R

@Composable
fun LogoApp (
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.logo_twitter),
        contentDescription = stringResource(R.string.logo_twitter_description),
        modifier = modifier
    )
}

@Composable
fun AppButton(
    textoBoton: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /* Acción al hacer clic en el botón */ },
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.blue_twitter)
        ),
        modifier = modifier
    ) {
        Text(textoBoton)
    }
}