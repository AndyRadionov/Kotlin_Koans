// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> {
    val allOrdered = customers.flatMap(Customer::getOrderedProducts).toSet()

    return customers.fold(allOrdered) { acc, customer ->
        acc.intersect(customer.getOrderedProducts())
    }
}


fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }