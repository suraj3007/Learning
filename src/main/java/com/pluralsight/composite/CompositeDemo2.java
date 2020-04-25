package main.java.com.pluralsight.composite;


/**
 * Composite pattern: Maintains hierarchical structure.
 * It compose objects into tree structure
 * Can simplify things too much
 * Easier for client as it can handle any object addition gracefully
 */
public class CompositeDemo2 {

    public static void main(String[] args) {

        Menu mainMenu = new Menu("Main", "/main");                          //Creating main menu
        MenuItem safetyMenuItem = new MenuItem("Safety", "/safety");        //Creating sub menu
        //Adding menuItem
        mainMenu.add(safetyMenuItem);

        Menu claimsSubMenu = new Menu("Claims", "/claims");
        //Adding menu here. It denotes that it is easier for client to add any object gracefully
        mainMenu.add(claimsSubMenu);

        MenuItem personalClaimsMenu = new MenuItem("PersonalClaims", "/personalClaims");
        mainMenu.add(personalClaimsMenu);

        System.out.println("---After Adding---");
        System.out.println(mainMenu);

        mainMenu.remove(claimsSubMenu);                                                //Removing sub-menu from the main menu
        System.out.println("---After Removing----");
        System.out.println(mainMenu);

    }
}
