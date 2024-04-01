fun main() {


    val shoppingList = ShoppingItem()
    val productList=shoppingList.productList



    while (true) {
        println("\nPlease select an option:")
        println("1. Add item to list")
        println("2. Remove item from list")
        println("3. View current list")
        println("4. Exit")
        val choice = readLine()?.toIntOrNull()

        when (choice) {
            1 -> addItem(productList)
            2 -> removeItem(productList)
            3 -> viewList(productList)
            4 -> {
                println("Exiting the Shopping List App. Goodbye!")
                return
            }
            else -> println("Invalid choice. Please select a valid option.")
        }

    }


}

// item list add
fun viewList(productList: List<ShoppingList>) {
    if (productList.isEmpty()) {
        println("The list is currently empty.")
    } else {
        println("Current shopping list:")
        productList.forEachIndexed { index, item ->
            println("${index + 1}. ${item.productName} - Price: ${item.productPrice}/- Quantity: ${item.productDescription}")
        }
    }
}

fun addItem(productList: MutableList<ShoppingList>) {
    // input value
    val productName = readLine() ?: ""
    val productPrice = readLine() ?:""
    val productDescription = readLine()?: ""

    if (productName.isEmpty()) {
        println("Invalid Input")
    }else if (productPrice.isEmpty()){
        println("Invalid Input")
    }else if (productDescription.isEmpty()){
        println("Invalid Input")
    }
    else {
        productList.add(ShoppingList(1,productName, productPrice, productDescription))
        println("Product is Added successfully")
    }
}

fun removeItem(productList: MutableList<ShoppingList>) {
    println("Enter The Product Name: ")
    val nameOfRemovedProduct = readLine()?.uppercase() ?: ""
    var isProductRemoved = false
    val updatedProductList = mutableListOf<ShoppingList>()

    productList.forEach { shoppingList ->
        if (!shoppingList.productName.uppercase().contains(nameOfRemovedProduct)) {
            updatedProductList.add(shoppingList)
        } else {
            isProductRemoved = true
        }
    }

    if (!isProductRemoved) {
        println("Product Not Found in the Shopping List")
    } else {
        println("Product Is Removed From The Shopping List")
        productList.clear()
        productList.addAll(updatedProductList)
        viewList(productList)
    }
}