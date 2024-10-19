package kz.narxoz.android1

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MedicalStyleList(navController: NavController, modifier: Modifier = Modifier) {
    val itemList = listOf(
        ItemData("Лечение кариеса", "Полное удаление кариеса и пломбирование", "2024-09-26", image = R.drawable.dental),
        ItemData("Консультация терапевта", "Проверка общего состояния здоровья", "2024-09-25", image = R.drawable.therapy),
        ItemData("Консультация дерматолога", "Диагностика и лечение кожных заболеваний", "2024-09-24", image = R.drawable.dermatology)
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(itemList) { item ->
            ListItemCard(item) {
                navController.navigate("detail/${item.title}/${item.description}/${item.date}")
            }
        }
    }
}
