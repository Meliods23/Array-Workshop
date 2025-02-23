package se.lexicon;

import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0]; // element format should be ["firstName lastName", "firstName lastName"]


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(final String[] names) {
        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        return names.clone();
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(final String fullName) {
        for (int i = 0; i < names.length; i++)
        {
            if(names[i].equalsIgnoreCase(fullName))
            {
                return names[i];
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(final String fullName) {
        if(find(fullName) == null)
        {
            String[] temp = names;
            names = new String[names.length + 1];
            for(int i = 0; i < names.length - 1; i++)
            {
                names[i] = temp[i];
            }
            names[names.length - 1] = fullName;
            return true;
        }
        return false;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(final String firstName) {
        String[] namesFound = new String[0];

        for (String name : names)
        {
            String[] temp00 = name.split(" ");

            if(temp00[0].equalsIgnoreCase(firstName))
            {
                namesFound = expandStringArray(name, namesFound);
            }
        }

        return namesFound;
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(final String lastName) {
        String[] namesFound = new String[0];

        for (String name : names)
        {
            String[] temp00 = name.split(" ");

            if(temp00[1].equalsIgnoreCase(lastName))
            {
                namesFound = expandStringArray(name, namesFound);
            }
        }

        return namesFound;
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(final String original, final String updatedName) {

        for (int i = 0; i < names.length; i++)
        {
            // Updates name if found and returns true
            if(names[i].equalsIgnoreCase(original))
            {
                names[i] = updatedName;
                return true;
            }
            // Returns false if new name is found
            else if (names[i].equalsIgnoreCase(updatedName)) {
                return false;
            }
        }

        // Returns false if original name not found
        return false;
    }


    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     */
    public static boolean remove(final String fullName) {

        int temp = names.length;

        names = reduceStringArray(fullName, names);

        if(names.length < temp)
        {
            return true;
        }

        return false;
    }




    private static String[] expandStringArray(String string, String[] array)
    {
        String[] expanded = new String[array.length + 1];

        for (int i = 0; i < array.length; i++)
        {
            expanded[i] = array[i];
        }

        expanded[expanded.length - 1] = string;

        return expanded;
    }

    private static String[] reduceStringArray(String string, String[] array)
    {
        String[] reduced = new String[0];

        for (int i = 0; i < array.length; i++)
        {
            if(array[i].equalsIgnoreCase(string))
            {

            }
            else
            {
                reduced = expandStringArray(array[i], reduced);
            }
        }

        return reduced;
    }
}