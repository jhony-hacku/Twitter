package com.example.twitterfalso.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import com.example.twitterfalso.R
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Modifier
import com.example.twitterfalso.ui.utils.AppButton
import com.example.twitterfalso.ui.utils.BackgroundImage
import com.example.twitterfalso.ui.utils.LogoApp


// 1. Todo composable recibe como parametro opcional un modifier
// 2. El componente de primer nivel usa como modificador el modifier que viene como parametro
// 3. El componente padre gana la habilidad de modificar el componente hijo, por ejemplo para agregar padding, margin, etc
//    Los compoentes que no son de primer nivel usan Modifier

@Composable
fun MensajeBienvenida(
    nombre: String,
    modifier: Modifier = Modifier
){
    Text(
        text = stringResource(R.string.welcome_message, nombre),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(R.color.blue_twitter),
        modifier = modifier
    )
}

@Composable
@Preview(showBackground = true)
fun MensajeBienvenidaPreview(){
    MensajeBienvenida(stringResource(R.string.app_name))
}


@Composable
@Preview(showBackground = true)
fun LogoAppPreview() {
    LogoApp()
}

@Composable
@Preview(showBackground = true)
fun AppButtonPreview() {
    AppButton(stringResource(R.string.login_button_text))
}

@Composable
fun ExternalLogo(
    idImage: Int,
    modifier: Modifier = Modifier,
    description: String? = null
) {
    Image(
        painter = painterResource(idImage),
        contentDescription = description,
        modifier = modifier
            .padding(8.dp)
            .height(48.dp)
            .width(48.dp)
    )
}

@Composable
@Preview(showBackground = false)
fun ExternalLogoPreview() {
    ExternalLogo(R.drawable.facebook)
}

@Composable
fun BodyHomeScreen(
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LogoApp()
        MensajeBienvenida(
            stringResource(R.string.app_name),
            modifier = Modifier.padding(16.dp)
        )
        AppButton(stringResource(
            R.string.login_button_text),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        AppButton(stringResource(
            R.string.create_account_button_text),
            modifier = Modifier.padding(bottom = 8.dp))

        Row {
            ExternalLogo(R.drawable.facebook, description = stringResource(R.string.facebook_description))
            ExternalLogo(R.drawable.google, description = stringResource(R.string.google_description))
            ExternalLogo(R.drawable.github, description = stringResource(R.string.github_description))
            ExternalLogo(R.drawable.instagram, description = stringResource(R.string.instagram_description))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BodyHomeScreenPreview() {
    BodyHomeScreen()
}

@Composable
fun Homescreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImage()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.weight(1F))
            BodyHomeScreen(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1F))
            Text(stringResource(R.string.rights_reserved_text))
        }
    }
}

@Composable
@Preview(showBackground = false)
fun HomescreenPreview() {
    Homescreen()
}