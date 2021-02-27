import java.io.*;
import java.util.*;


/** 
 * Generates details for a new random person with name, sex, age.
 * <p>
 * Requires data files: male.names.txt, female.names.txt, last.names.txt
 * in current directory to run.
 *
 * @author Lawrie Brown &amp; Graham Freeman
 * @version 08/11/2018 (Updated by Saber Elsayed)
 */

public class RandomPerson implements Comparable
{
	// attributes of a RandomPerson
	// first name 
	protected String firstname;
	// surname 
	protected String surname;
	// sex 
	protected char sex;
	// age
	protected int age;

	// internal data structures used for name components and fractions
	// array of male names read from file male.names.txt 
	protected static final String [] MALENAMES = readFile("male.names.txt");
	// array of female names read from file female.names.txt 
	protected static final String [] FEMALENAMES = readFile("female.names.txt");
	// array of surnames read from file last.names.txt 
	protected static final String [] LASTNAMES = readFile("last.names.txt");
	// array of common male names 
	protected static final String [] COMMONMALENAMES =
		{"John", "Peter", "David", "Michael", "Stephen", "Robert", "Paul",
				"William", "James", "Richard", "Ian", "Phillip", "Mark", "Henry"};
	//array of common female names 
	protected static final String [] COMMONFEMAKENAMES =
		{"Mary", "Christine", "Anne", "Maria", "Elizabeth", "Sarah", "Diane",
				"Susan", "Joan", "Janet", "Julia", "Jean", "Glenda", "Barbara"};
	//fraction of first names which are common 
	private static final float P_COMMON = 0.4F;
	// fraction of persons with unspecified sex 
	private static final float P_SEX_X = 0.01F;
	//fraction of persons with male sex (after X fraction, rest female) 
	private static final float P_SEX_M = 0.5F;
	//minimum age to generate 
	private static final int MIN_AGE = 12;
	// maximum age to generate 
	private static final int MAX_AGE = 80;
	//initial array size when reading names from file 
	private static final int ARRAY_SIZE = 200;

	//random number generator
	private static Random rnd = new Random();

	/** 
	 * Constructs a new RandomPerson with sex, name and age.
	 * <p>
	 * First the sex is chosen randomly with a given probability.
	 * <p>
	 * Next the name is constructed based on the selected sex, as follows:
	 * <p> 
	 * - First name is chosen randomly to be either from a common names list or other names;
	 * <p>
	 * - Last name is chosen from a given list. 
	 * <p>  
	 * Next the age is chosen randomly between a given range.
	 */
	public RandomPerson()
	{
		// decide person's sex
		float r = rnd.nextFloat();
		if (r < P_SEX_X)      sex = 'X';
		else if (r < P_SEX_M) sex = 'M';
		else                sex = 'F';

            // decide person's first name given their sex
            switch (sex) {
            // if sex unspecified randomly choose either male or female
                case 'X':
                    if (rnd.nextFloat() < P_COMMON)     // choose common name with given probability
                    {
                        firstname = (rnd.nextFloat() < P_SEX_M) ?
                                COMMONMALENAMES[rnd.nextInt(COMMONMALENAMES.length)] :
                                COMMONFEMAKENAMES[rnd.nextInt(COMMONFEMAKENAMES.length)];
                    }
                    else                                // otherwise choose some other name
                    {
                        firstname = (rnd.nextFloat() < P_SEX_M) ?
                                MALENAMES[rnd.nextInt(MALENAMES.length)] :
                                FEMALENAMES[rnd.nextInt(FEMALENAMES.length)];
                    }
                    break;
            // male first name
                case 'M':
                    if (rnd.nextFloat() < P_COMMON)     // choose common name with given probability
                        firstname = COMMONMALENAMES[rnd.nextInt(COMMONMALENAMES.length)];
                    else                                // other name
                        firstname = MALENAMES[ rnd.nextInt(MALENAMES.length) ] ;
                    break;
            // female first name
                default:
                    if (rnd.nextFloat() < P_COMMON)     // common name
                        firstname = COMMONFEMAKENAMES[rnd.nextInt(COMMONFEMAKENAMES.length)];
                    else                                // other name
                        firstname = FEMALENAMES[ rnd.nextInt(FEMALENAMES.length) ];
                    break;
            }

		// decide surname
		surname = LASTNAMES[ rnd.nextInt(LASTNAMES.length) ];

		// decide age
		age = (int)(rnd.nextInt(MAX_AGE-MIN_AGE) + MIN_AGE);
	}

	/**
	 * Gets person's first name
	 *
	 * @return first name
	 */
	public String getFirstName()
	{
		return firstname;
	}

	/** 
	 * gets person's surname
	 * 
	 * @return surname
	 */      
	public String getSurname()
	{
		return surname;
	}

	/** 
	 * Gets person's sex
	 * 
	 *  @return sex
	 */
	public char getSex()
	{
		return sex;
	}

	/** 
	 * Gets person's age
	 * 
	 * @return age
	 */
	public int getAge()
	{
		return age;
	}


	/** 
	 * Compares two RandomPerson objects to implement Comparable interface
	 * 
	 * Compares surnames, first names age and sex in order as needed
	 * 
	 * @param  other   other person
	 * @return comparison
	 */
        @Override
	public int compareTo(Object other)
	{
		if ( ! (other instanceof RandomPerson) )
			throw new IllegalArgumentException(
					"Unable to compare with something other than a RandomPerson");

		// grab attributes of other
		String oLast = ((RandomPerson)other).surname;
		String oFirst = ((RandomPerson)other).firstname;
		int oAge = ((RandomPerson)other).age;
		int oSex = ((RandomPerson)other).sex;

		// compare this with other's surname, first name, age & sex in order
		int cLast = surname.compareTo(oLast);
		int cFirst = firstname.compareTo(oFirst);
		if (cLast != 0)		return cLast;
		else if (cFirst != 0)	return cFirst;
		else if (age != oAge)   return (age - oAge);
		else                    return (sex - oSex);
	}

	/** 
	 * Gets description of this random person (name, age, sex)
	 * 
	 * @return description of person
	 */
        @Override
	public String toString()
	{
		String desc = firstname + " " + surname + ", " + age + " year old ";
            switch (sex) {
                case 'F':
                    desc += "female";
                    break;
                case 'M':
                    desc += "male";
                    break;
                default:
                    desc += "person";
                    break;
            }
		return desc;
	}

	/** 
	 * Reads the specified file of names into a string array
	 *
	 * @param firstname filename of names to read
	 * @return array of names read from file
	 */
	static String[] readFile(String firstname)
	{
		try
		{
			BufferedReader datin = new BufferedReader(new FileReader(firstname));
			String line;				// next line in file
			String[] sarr = new String[10];		// array of output type
			ArrayList<String> v = new ArrayList<>(ARRAY_SIZE);	// name list
			while ((line=datin.readLine()) != null)	v.add(line);
			return v.toArray(sarr);
		}
		catch (IOException ioe)
		{
			System.err.println("Error reading name file, aborting: " + ioe);
			System.exit(100);
			return null;
		}
	}

	/** 
	 * Self-test main routine.
	 *
	 * @param args command-line arguments
	 * @throws IOException if there is any issues with reading the name files
	 */
	public static void main( String [] args ) throws IOException
	{

		int number = 10;
		if (args.length > 0) number = Integer.parseInt(args[0]);

		// generate new random person & test the getter methods
		RandomPerson p = new RandomPerson();
		System.out.println("Created " + p);
		System.out.println("First name: " + p.getFirstName());
		System.out.println("Surname: " + p.getSurname());
		System.out.println("Sex: " + p.getSex());
		System.out.println("Age: " + p.getAge());
		System.out.println("Comparing with self gives: " + p.compareTo(p));

		// generate another random person and compare with the above person
		RandomPerson q = new RandomPerson();
		System.out.println("\nAlso created " + q);
		System.out.println("Comparing these 2 persons gives: " + p.compareTo(q));

		// generate and display the specified number of random persons
		System.out.println("\nGenerating " + number + " random persons.");
		for (int i=0; i<number; ++i)
		{
			p = new RandomPerson();
			System.out.println(p);
		}
	}

}
