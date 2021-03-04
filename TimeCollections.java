import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

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
        Integer n = 100000; //Change to 1000000 when ready.
        
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
    }
}
