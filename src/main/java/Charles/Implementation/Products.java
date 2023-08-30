package Charles.Implementation;

import Charles.Domain.ProductProperties;
import Charles.Services.CATEGORY;
import Charles.Services.ProductManagement;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Products implements ProductManagement {
    private static Map<String, ProductProperties> food = new HashMap<>();
    private static Map<String, ProductProperties> drinks = new HashMap<>();

    public Products() {

    }

    public Map<String, ProductProperties> getFoods() {
        return food;
    }

    public Map<String, ProductProperties> getDrinks() {
        return drinks;
    }

    //    public static Map<String, ProductProperties> getProductList() {
//        return productList;
//    }

    @Override
    public boolean addProductsToStore() {
        File file = new File("./src/main/resources/productList.csv");
        String line = "";

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                //System.out.println(Arrays.toString(row));
                if(!row[0].equalsIgnoreCase("name")) {
                    if(row[1].equalsIgnoreCase("drinks")){
                        ProductProperties newProduct = new ProductProperties();
                        newProduct.setName(row[0]);
                        newProduct.setCAT(CATEGORY.DRINKS);
                        newProduct.setPrice(Integer.parseInt(row[2]));
                        newProduct.setQuantity(Integer.parseInt(row[3]));
                        //System.out.println(newProduct);

                        //Adding created product to drinks Map
                        drinks.put(row[0], newProduct);
                    }
                    if(row[1].equalsIgnoreCase("food")){
                        ProductProperties newProduct = new ProductProperties();
                        newProduct.setName(row[0]);
                        newProduct.setCAT(CATEGORY.FOOD);
                        newProduct.setPrice(Integer.parseInt(row[2]));
                        newProduct.setQuantity(Integer.parseInt(row[3]));
                        //System.out.println(newProduct);

                        //Adding created product to food Map
                        food.put(row[0], newProduct);
                    }
                    return true;
                }
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("Input or output error " + e);
        }
        return false;
    }

    @Override
    public boolean updateStoreRecord() {
        return false;
    }

    public void viewItems(Map<String, ProductProperties> productPropertiesMap) {
        System.out.println("Name" +"        " + "Price" + "         " + "Quantity");
        for(var item : productPropertiesMap.values()) {
            System.out.printf("%-18s %-18s %-18s", item.getName(),item.getPrice(),item.getQuantity());
        }
    }
}
