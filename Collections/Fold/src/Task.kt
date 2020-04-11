// Return the set of products that were ordered by all customers
fun Shop.getProductsOrderedByAll(): Set<Product> =
    customers.fold(HashSet()) {acc, customer ->
        acc.addAll(customer.getOrderedProducts())
        acc
    }


fun Customer.getOrderedProducts(): List<Product> =
        orders.flatMap { it.products }