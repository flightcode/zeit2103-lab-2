import java.sql.Time;
import java.util.Date;

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
        TimeCollections test1 = new TimeCollections("staticArray");
        Integer n = 1000000;
        RandomPerson[] test1Array = new RandomPerson[n];

        test1.setStartTime(new Date());
        for (int i=0; i<n; ++i)
		{
			RandomPerson p = new RandomPerson();
			test1Array[i] = p;
		}
        test1.setEndTime(new Date());
        System.out.println(test1);
    }
}
