package problems.topcoder;

/**
 * Created by hardCode on 2/26/2017.
 */
public class PassingGrade {


   /* public static void main(String[] args) {

        System.out.println(new PassingGrade().pointsNeeded(new int[]{600,600,600,600,600,600,600,600,600,600, 600,600,600,600,600,600,600,600,600,600}   ,new int[]{1000,1000,1000,1000,1000,1000,1000,1000, 1000,1000,1000,1000,1000,1000,1000,1000, 1000,1000,1000,901} ,3000));
    }
*/
    public int  pointsNeeded(int[] pointsEarned, int[] pointsPossible, int finalExam){

        int total=finalExam,marksObtained=0,n=pointsEarned.length;

        for (int i = 0; i < n; i++) {
            total += pointsPossible[i];
            marksObtained += pointsEarned[i];
        }
        int marksNeeded= (int) Math.ceil(total*0.65);

        //System.out.println(marksNeeded+" "+total+" "+marksObtained);
        if (marksObtained>=marksNeeded)return 0;

        if ((marksNeeded - marksObtained) < finalExam) {
            return marksNeeded - marksObtained;
        }
        return -1;

    }

}
