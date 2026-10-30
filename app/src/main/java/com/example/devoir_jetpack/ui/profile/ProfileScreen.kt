package com.example.devoir_jetpack.ui.profile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devoir_jetpack.ui.theme.DevoirjetpackTheme

@Composable
fun ProfileScreen(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    contact: String,
    availability: String,
    availabilityDescription: String,
    onAvailabilityClick: () -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Padding externe : l'écran décide de l'espace autour de la fiche.
    ProfileCard(
        name = name,
        role = role,
        description = description,
        skills = skills,
        contact = contact,
        availability = availability,
        availabilityDescription = availabilityDescription,
        onAvailabilityClick = onAvailabilityClick,
        onContactClick = onContactClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}

@Composable
fun ProfileCard(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    contact: String,
    availability: String,
    availabilityDescription: String,
    onAvailabilityClick: () -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp
    ) {
        // Padding interne : la fiche décide de l'espace entre son bord et son contenu.
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileHeader(name = name, role = role)
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 12.dp)
            )
            SkillList(
                skills = skills,
                modifier = Modifier.padding(top = 16.dp)
            )
            ProfileInfo(
                label = "Contact",
                value = contact,
                modifier = Modifier.padding(top = 16.dp)
            )
            AvailabilityZone(
                text = availability,
                actionDescription = availabilityDescription,
                onClick = onAvailabilityClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            ProfileAction(
                text = "Contacter",
                onClick = onContactClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = role,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun SkillList(
    skills: List<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "Compétences",
            style = MaterialTheme.typography.titleSmall
        )
        skills.forEach { skill ->
            SkillItem(
                skill = skill,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "• $skill",
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
    )
}

@Composable
fun ProfileInfo(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun AvailabilityZone(
    text: String,
    actionDescription: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Le clic est placé avant le padding interne : toute la zone reste cliquable.
    Surface(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = onClick
            )
            .semantics {
                contentDescription = actionDescription
            },
        color = MaterialTheme.colorScheme.secondaryContainer
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun ProfileAction(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenAndroidJuniorPreview() {
    DevoirjetpackTheme {
        ProfileScreen(
            name = "Camille Durand",
            role = "Développeuse Android junior",
            description = "Étudiante en informatique, je crée des applications mobiles avec Kotlin et Jetpack Compose.",
            skills = listOf("Kotlin", "Jetpack Compose", "Git"),
            contact = "camille.durand@example.com",
            availability = "Disponible pour un stage",
            availabilityDescription = "Proposer un stage à Camille Durand",
            onAvailabilityClick = { },
            onContactClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenFullStackPreview() {
    DevoirjetpackTheme {
        ProfileScreen(
            name = "Sacha Martin",
            role = "Développeur full-stack",
            description = "Freelance depuis cinq ans, je conçois des applications web et leurs services backend.",
            skills = listOf("TypeScript", "React", "Node.js", "PostgreSQL", "Docker"),
            contact = "sacha.martin@example.com",
            availability = "Non disponible actuellement",
            availabilityDescription = "Consulter les prochaines disponibilités de Sacha Martin",
            onAvailabilityClick = { },
            onContactClick = { }
        )
    }
}
