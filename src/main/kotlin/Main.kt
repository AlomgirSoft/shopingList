fun main() {


    val shoppingList = mutableListOf<String>()

    println("Welcome to the Shopping List App!")

    while (true) {
        println("\nPlease select an option:")
        println("1. Add item to list")
        println("2. Remove item from list")
        println("3. View current list")
        println("4. Exit")

        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> addItem(shoppingList)
            2 -> removeItem(shoppingList)
            3 -> viewList(shoppingList)
            4 -> {
                println("Exiting the Shopping List App. Goodbye!")
                return
            }
            else -> println("Invalid choice. Please select a valid option.")
        }
    }


}

fun addItem(list: MutableList<String>) {
    println("Enter the item you want to add:")
    val item = readLine()
    if (item != null) {
        list.add(item)
        println("$item has been added to the list.")
    } else {
        println("Invalid input. Please try again.")
    }
}

fun removeItem(list: MutableList<String>) {
    println("Enter the item you want to remove:")
    val item = readLine()
    if (item != null) {
        if (list.remove(item)) {
            println("$item has been removed from the list.")
        } else {
            println("$item is not in the list.")
        }
    } else {
        println("Invalid input. Please try again.")
    }
}

fun viewList(list: List<String>) {
    if (list.isEmpty()) {
        println("The list is currently empty.")
    } else {
        println("Current shopping list:")
        list.forEachIndexed { index, item ->
            println("${index + 1}. $item")
        }
    }
}