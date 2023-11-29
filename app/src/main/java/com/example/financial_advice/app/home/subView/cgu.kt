package com.example.financial_advice.app.home.subView

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CguContent() {
    Column(
        androidx.compose.ui.Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color(255, 255, 255, 255))
    ) {
        Title1(txt = "Conditions générales d'utilisation")
        Title(txt = "1. Introduction")
        TextPart(txt = "1.1 Ces Conditions Générales d'Utilisation (ci-après dénommées \"CGU\") régissent l'utilisation de l'application de gestion de compte bancaire personnisable (ci-après dénommée \"l'Application\") fournie par [Votre Nom ou le Nom de Votre Entreprise] (ci-après dénommé \"Nous\" ou \"Notre\").\n" +
                "\n" +
                "1.2 En téléchargeant, installant ou utilisant l'Application, vous acceptez d'être lié par ces CGU. Si vous n'acceptez pas ces CGU, veuillez ne pas utiliser l'Application.")
        Title(txt = "2. Utilisation de l'Application")
        TextPart(txt = "2.1 Vous êtes autorisé à utiliser l'Application à des fins personnelles et non commerciales.\n" +
                "\n" +
                "2.2 Vous êtes responsable de la confidentialité de vos informations de compte et de l'activité qui se produit sous votre compte.\n" +
                "\n" +
                "2.3 Vous acceptez de ne pas utiliser l'Application à des fins illégales ou de manière qui enfreint les droits de tiers.")
        Title(txt = "3. Personnalisation de l'Application")
        TextPart(txt = "3.1 L'Application vous permet de personnaliser l'apparence en choisissant des thèmes, des couleurs et des catégories.\n" +
                "\n" +
                "3.2 Toutes les personnalisations sont enregistrées localement sur votre appareil et ne sont pas partagées en ligne.")
        Title(txt = "4. Collecte et Stockage de Données")
        TextPart(txt = "4.1 L'Application collecte et stocke localement les données que vous entrez, telles que les transactions, catégories, et préférences de personnalisation.\n" +
                "\n" +
                "4.2 Aucune donnée personnelle n'est envoyée ou stockée en ligne sans votre consentement explicite.")
        Title(txt = "5. Sécurité")
        TextPart(txt = "5.1 Nous nous engageons à mettre en place des mesures de sécurité raisonnables pour protéger vos données. Cependant, vous comprenez et acceptez que la sécurité des informations transmises ou stockées ne peut être garantie.\n" +
                "\n" +
                "5.2 Nous ne sommes pas responsables de la perte, du vol ou de la divulgation non autorisée de vos données.")
        Title(txt = "6. Mises à Jour")
        TextPart(txt = "6.1 Nous nous réservons le droit de mettre à jour l'Application à tout moment.\n" +
                "\n" +
                "6.2 Vous pouvez être invité à mettre à jour l'Application régulièrement.")
        Title(txt = "7. Responsabilités")
        TextPart(txt = "7.1 Nous ne sommes pas responsables des dommages directs, indirects, accessoires, spéciaux, consécutifs ou exemplaires résultant de votre utilisation de l'Application ou de toute autre réclamation liée de quelque manière que ce soit à votre utilisation de l'Application.\n" +
                "\n" +
                "7.2 Vous acceptez de nous indemniser et de nous dégager de toute responsabilité, ainsi que nos administrateurs, dirigeants, employés et agents, de toute réclamation ou demande, y compris les honoraires d'avocat raisonnables, faite par un tiers en raison ou découlant de votre utilisation de l'Application ou de votre violation de ces CGU."
        )
        Title(txt = "8. Modifications")
        TextPart(txt = "8.1 Nous nous réservons le droit de modifier ces CGU à tout moment. Les modifications prendront effet dès leur publication dans l'Application.\n" +
                "\n" +
                "8.2 Nous vous encourageons à consulter régulièrement ces CGU pour vous tenir informé de toute modification.")
        Title(txt = "9. Contact")
        TextPart(txt = "9.1 Pour toute question concernant ces CGU, veuillez nous contacter à [votre adresse e-mail].\n" +
                "\n" +
                "En utilisant l'Application, vous acceptez ces CGU. Merci de les lire attentivement.")
        TextPart(txt = "Dernière mise à jour : 29 Novembre 2023")
    }
}

@Composable
fun Title1(txt: String) {
    Text(
        text = txt,
        fontSize = 25.sp,
        fontWeight = FontWeight.Bold,
        color = Color(24, 91, 100, 255),
        modifier = androidx.compose.ui.Modifier
            .padding(0.dp, 20.dp)
    )
}

@Composable
fun Title(txt: String) {
    Text(
        text = txt,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(24, 91, 100, 255),
        modifier = androidx.compose.ui.Modifier
            .padding(20.dp, 5.dp)
    )
}

@Composable
fun TextPart(txt: String) {
    Text(
        text = txt,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        modifier = androidx.compose.ui.Modifier
            .padding(50.dp, 5.dp)
    )
}

