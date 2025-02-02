package se.lexicon;


public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        // call more methods as needed

        NameRepository.add("Loai ALwan");
        NameRepository.add("Loai ALwan00");
        NameRepository.add("Loai ALwan01");

        System.out.println("----------------------------------");
        System.out.println("Listing all names in repo!");
        System.out.println("----------------------------------");
        // Testing the add function
        for (String name : NameRepository.findAll())
        {
            System.out.println(name);
        }

        System.out.println("----------------------------------");
        System.out.println("Search by first name!");
        System.out.println("----------------------------------");
        // Testing the search function
        for (String name : NameRepository.findByFirstName("Loai"))
        {
            System.out.println(name);
        }

        System.out.println("----------------------------------");
        System.out.println("Search by last name!");
        System.out.println("----------------------------------");
        // Testing the search function
        for (String name : NameRepository.findByLastName("ALwan"))
        {
            System.out.println(name);
        }


        System.out.println("----------------------------------");
        System.out.println("Updating name!");
        System.out.println("----------------------------------");
        for (String name : NameRepository.findAll())
        {
            System.out.println(name);
        }
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        NameRepository.update("Loai ALwan", "New Name");

        for (String name : NameRepository.findAll())
        {
            System.out.println(name);
        }

    }
}
