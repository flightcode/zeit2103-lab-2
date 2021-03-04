import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class TimeCollections {
    private String testName;
    private Date startTime;
    private Date endTime;
    private Integer runTime;

    public TimeCollections(String testName) {
        this.testName = testName;
    }

    public TimeCollections(String testName, Date startTime, Date endTime) {
        this.testName = testName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.calculateRunTime(this.startTime,this.endTime);
    }

    public Date getStartTime(){
        return startTime;
    }

    public Date getEndTIme(){
        return endTime;
    }

    public void setStartTime(Date time){
        startTime = time;
    }

    public void setEndTime(Date time){
        endTime = time;
    }

    public Integer calculateRunTime(Date startTime, Date endTime) {
        runTime = (int) (endTime.getTime() - startTime.getTime());
        return runTime;
    }

    public String toString() {
        calculateRunTime(startTime, endTime);
        return "Test: " + testName + " started at " + startTime + " and ended at " + endTime + ". Took " + runTime + "ms.";
    }

    public static void main(String[] args) {
        Integer n = 1000000; //Change to 1000000 when ready.
        
        //Test 1

        TimeCollections test1 = new TimeCollections("staticArray");
        RandomPerson[] test1Array = new RandomPerson[n];

        test1.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test1Array[i] = new RandomPerson();
		}
        test1.setEndTime(new Date());
        System.out.println(test1);
        
        //Test 2

        TimeCollections test2 = new TimeCollections("arrayListAdd");
        ArrayList<RandomPerson> test2Array = new ArrayList<RandomPerson>();

        test2.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test2Array.add(new RandomPerson());
		}
        test2.setEndTime(new Date());
        System.out.println(test2);

        //Test 3

        TimeCollections test3 = new TimeCollections("arrayListAddBeginning");
        ArrayList<RandomPerson> test3Array = new ArrayList<RandomPerson>();

        test3.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test3Array.add(0,new RandomPerson());
		}
        test3.setEndTime(new Date());
        System.out.println(test3);

        //Test 4

        TimeCollections test4 = new TimeCollections("arrayListPreSized200k");
        ArrayList<RandomPerson> test4Array = new ArrayList<RandomPerson>(n/5); //For testing. n/5 at default is 200k, as required.

        test4.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test4Array.add(new RandomPerson());
		}
        test4.setEndTime(new Date());
        System.out.println(test4);

        //Test 5

        TimeCollections test5 = new TimeCollections("linkedList");
        LinkedList<RandomPerson> test5Array = new LinkedList<RandomPerson>();

        test5.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test5Array.add(new RandomPerson());
		}
        test5.setEndTime(new Date());
        System.out.println(test5);

        //Test 6

        TimeCollections test6 = new TimeCollections("linkedListAddBeginning");
        LinkedList<RandomPerson> test6Array = new LinkedList<RandomPerson>();

        test6.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test6Array.add(0,new RandomPerson());
		}
        test6.setEndTime(new Date());
        System.out.println(test6);

        //Test 7

        n = 10000;
        TimeCollections test7 = new TimeCollections("hashSet10k");
        HashSet<RandomPerson> test7Array = new HashSet<RandomPerson>();

        test7.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test7Array.add(new RandomPerson());
		}
        test7.setEndTime(new Date());
        System.out.println(test7);

        //Test 8

        n = 100000;
        TimeCollections test8 = new TimeCollections("hashSet100k");
        HashSet<RandomPerson> test8Array = new HashSet<RandomPerson>();

        test8.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test8Array.add(new RandomPerson());
		}
        test8.setEndTime(new Date());
        System.out.println(test8);

        //Test 9

        n = 1000000;
        TimeCollections test9 = new TimeCollections("hashSet1mil");
        HashSet<RandomPerson> test9Array = new HashSet<RandomPerson>();

        test9.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test9Array.add(new RandomPerson());
		}
        test9.setEndTime(new Date());
        System.out.println(test9);

        //Test 10

        n = 10000;
        TimeCollections test10 = new TimeCollections("treeSet10k");
        TreeSet<RandomPerson> test10Array = new TreeSet<RandomPerson>();

        test10.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test10Array.add(new RandomPerson());
		}
        test10.setEndTime(new Date());
        System.out.println(test10);

        //Test 11

        n = 100000;
        TimeCollections test11 = new TimeCollections("treeSet100k");
        TreeSet<RandomPerson> test11Array = new TreeSet<RandomPerson>();

        test11.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test11Array.add(new RandomPerson());
		}
        test11.setEndTime(new Date());
        System.out.println(test11);

        //Test 12

        n = 1000000;
        TimeCollections test12 = new TimeCollections("treeSet1mil");
        TreeSet<RandomPerson> test12Array = new TreeSet<RandomPerson>();

        test12.setStartTime(new Date());
        for (int i=0; i<n; ++i) {
			test12Array.add(new RandomPerson());
		}
        test12.setEndTime(new Date());
        System.out.println(test12);
    }
}
