/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 */

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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        for(Interval i : intervals) {
            map.put(i.start, Math.max(map.getOrDefault(i.start, 0), i.end));
        }

        ArrayList<Integer> startKey = new ArrayList<>(map.keySet());
        Collections.sort(startKey);

        for(int i = 1; i < startKey.size();) {
            if (startKey.get(i) <= map.get(startKey.get(i - 1))) {
                map.put(startKey.get(i - 1), Math.max(map.get(startKey.get(i - 1)), map.get(startKey.get(i))));
                map.remove(startKey.get(i));
                startKey.remove(i);
            } else {
                i++;
            }
        }

        for(int k : map.keySet()) {
            Interval i = new Interval(k, map.get(k));
            result.add(i);
        }

        return result;
    }
}

public class Solution_simplify {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;
        
        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        
        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }
}