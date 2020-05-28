package list;

import java.util.ArrayList;

/**
 * 有序区间插入重叠合并
 *
 * @author Sean
 * @date 2020/05/28
 */
public class InsertInterval {

    public static ArrayList<Interval> merge(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<>();
        if (intervals == null || newInterval == null) {
            return null;
        }
        int insertIndex = 0;
        for (Interval it : intervals) {
            //新区间位于当前区间前
            if (it.start > newInterval.end) {
                res.add(it);
            } else
                //新区间位于当前区间后
                if (newInterval.start > it.end) {
                    res.add(it);
                    //新区间插入位置后移
                    insertIndex++;
                } else {
                    //区间重叠，合并成新区间
                    newInterval.start = Math.min(it.start, newInterval.start);
                    newInterval.end = Math.max(it.end, newInterval.end);
                }
        }
        res.add(insertIndex, newInterval);
        return res;
    }

    public static void main(String[] args) {
        Interval interval = new Interval(3, 4);
        Interval interval1 = new Interval(6, 9);
        ArrayList<Interval> objects = new ArrayList<>();
        objects.add(interval);
        objects.add(interval1);
        Interval interval2 = new Interval(1, 2);
        ArrayList<Interval> merge = merge(objects, interval2);
        for (Interval it : merge) {
            System.out.println(it.toString());
        }
    }
}

class Interval {

    int start;
    int end;

    public Interval() {
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
