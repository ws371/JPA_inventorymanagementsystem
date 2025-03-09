package com;
import com.entities.Category;
import com.entities.Product;
import com.entities.Supplier;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");
    static EntityManager em = emf.createEntityManager();

    private static void addCategory(Category cat) {
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
        System.out.println("Category has been added: " + cat.toString());}

    private static void addProduct(Product product, int categoryId, int supplierId) {
        em.getTransaction().begin();
        Category category = em.find(Category.class, categoryId);
        Supplier supplier = em.find(Supplier.class, supplierId);
        product.setSupplier(supplier);
        product.setCategory(category);
        em.persist(product);
        em.getTransaction().commit();
        System.out.println("Product has been added: " + product.toString());}
    private static void findProductById(int id) {
        Product product = em.find(Product.class, id);
        System.out.println("Found Product: " + product.toString());}
    private static void updateProduct(int id, Product updatedProduct) {
        em.getTransaction().begin();
        Product existingProduct = em.find(Product.class, id);
        System.out.println("Before Update: " + existingProduct.toString());
        existingProduct.setPRODUCT_NAME(updatedProduct.getPRODUCT_NAME());
        existingProduct.setPRICE(updatedProduct.getPRICE());
        existingProduct.setSTOCK_QUANTITY(updatedProduct.getSTOCK_QUANTITY());
        existingProduct.setREORDER_LEVEL(updatedProduct.getREORDER_LEVEL());
        existingProduct.setDESCRIPTION(updatedProduct.getDESCRIPTION());
        existingProduct = em.merge(existingProduct);
        em.getTransaction().commit();
        System.out.println("Product updated: " + existingProduct.toString());}
    private static void deleteProduct(int id) {
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
            em.remove(product);
            em.getTransaction().commit();
            System.out.println("Product with ID " + id + " has been deleted.");}

    private static void updateCategory() {
        em.getTransaction().begin();
        Category cat = em.find(Category.class, 1);
        System.out.println(cat.toString() + " BEFORE updated");
        cat.setCATEGORY_NAME("FDM-printed");
        cat.setDESCRIPTION("Finished FDM-printed products");
        cat = em.merge(cat);
        em.getTransaction().commit();
        System.out.println(cat.toString() + " has been updated");}
    private static void deleteCategory(int id) {
        em.getTransaction().begin();
        Category cat = em.find(Category.class, id);
        if (cat != null) {
            em.remove(cat);
            System.out.println(cat.toString() + " has been deleted...");
        } else {
            System.out.println("Category with ID " + id + " not found.");}
        em.getTransaction().commit();}
    private static void findCategoryById(int id) {
        Category cat = em.find(Category.class, id);
        System.out.println(cat.toString());}

    public static List<Category> getAllCategories() {
        EntityManager em = emf.createEntityManager();
        List<Category> Categories = em.createQuery("SELECT e FROM Category e", Category.class).getResultList();
        em.close();
        return Categories;}

    public static List<Product> getAllProducts() {
        EntityManager em = emf.createEntityManager();
        List<Product> Product = em.createQuery("SELECT p FROM Product p", Product.class).getResultList();
        em.close();
            return Product;
    }
    public static void main(String[] args) {

        //Category cat = new Category();
        //cat.setCATEGORY_NAME("SLS-printed");
        //cat.setDESCRIPTION("Category for SLS 3D-printed products");
        //addCategory(cat);
        //findCategoryById(2);
        //deleteCategory(3);
        //updateCategory();


        Product p = new Product();
        p.setPRODUCT_NAME("SLS Gear");
        p.setPRICE(new BigDecimal("49.99"));
        p.setSTOCK_QUANTITY(100);
        p.setREORDER_LEVEL(10);
        p.setDESCRIPTION("High-strength SLS printed gear");
        addProduct(p, 1, 1);

        findProductById(1); //read

        Product updatedProduct = new Product();
        updatedProduct.setPRODUCT_NAME("Updated Gear");
        updatedProduct.setPRICE(new BigDecimal("55.99"));
        updatedProduct.setSTOCK_QUANTITY(90);
        updatedProduct.setREORDER_LEVEL(5);
        updatedProduct.setDESCRIPTION("Updated description");
        updateProduct(1, updatedProduct); //update

        deleteProduct(1); //delete

        //List<Category> cats = getAllCategories();
        //System.out.println("Category_id \t Category_name \t Category_description");
        //System.out.println(" " +
                //"-----------------------------------");
        //for (Category e : cats)
            //System.out.println(e.getCATEGORY_ID() + "\t\t" + e.getCATEGORY_NAME() + "\t\t" + e.getDESCRIPTION());

        //List<Product> Product = getAllProducts();
        //System.out.println("\nProduct_id \t Product_name \t Price \t Stock \t Category");
        //System.out.println("-----------------------------------------------------");
        //for (Product pItem : Product) {
            //System.out.println(pItem.getPRODUCT_ID() + "\t\t" + pItem.getPRODUCT_NAME() + "\t\t" + pItem.getPRICE() +
                    //"\t" + pItem.getSTOCK_QUANTITY() + "\t" + pItem.getCategory().getCATEGORY_NAME());}
    }
}