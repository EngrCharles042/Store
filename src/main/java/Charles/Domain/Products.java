package Charles.Domain;

import java.util.HashMap;
import java.util.Map;

public class Products {
    private static Map<String, Integer> productList = new HashMap<>();

    public Products() {

    }
    public static Map<String, Integer> getProductList() {
        return productList;
    }
}
