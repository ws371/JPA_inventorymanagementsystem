package com;
import com.entities.Category;
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
    public static void main(String[] args) {
        Category cat = new Category();
        cat.setCATEGORY_NAME("SLS-printed");
        cat.setDESCRIPTION("Category for SLS 3D-printed products");
        addCategory(cat);
        findCategoryById(2);
        deleteCategory(3);
        updateCategory();
        List<Category> cats = getAllCategories();
        System.out.println("Category_id \t Category_name \t Category_description");
        System.out.println(" " +
                "-----------------------------------");
        for (Category e : cats)
            System.out.println(e.getCATEGORY_ID() + "\t\t" + e.getCATEGORY_NAME() + "\t\t" + e.getDESCRIPTION());
    }
}
