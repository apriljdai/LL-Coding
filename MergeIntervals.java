/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() <= 1)
            return intervals;
        //sort intervals
        Collections.sort(intervals, new IntervalComparator());
        Interval a = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++){
            Interval b = intervals.get(i);
            if (a.end >= b.start){
                a = new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
            }
            else{
                result.add(a);
                a = b;
            }
        }
        result.add(a);
        return result;
    }
}
class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        return a.start - b.start;
    }
    //int compare(T o1, T o2)
    //Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
}