import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        List<Job> jobList = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++) {
            jobList.add(new Job(jobs[i][0], jobs[i][1], i));
        }

        Collections.sort(jobList, (a, b) -> {
            if(a.s != b.s) return Integer.compare(a.s, b.s);
            else if(a.l != b.l) return Integer.compare(a.l, b.l);
            else return Integer.compare(a.index, b.index);
        });

        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if(a.l != b.l) return Integer.compare(a.l, b.l);
            else if(a.s != b.s) return Integer.compare(a.s, b.s);
            else return Integer.compare(a.index, b.index);
        });
        
        int currentTime = 0;
        int totalTurnaround = 0;
        int jobsProcessed = 0;
        int idx = 0;
        
        while(jobsProcessed < jobList.size()) {
            while(idx < jobList.size() && jobList.get(idx).s <= currentTime) {
                pq.offer(jobList.get(idx));
                idx++;
            }
            
            if(pq.isEmpty()) {
                currentTime = jobList.get(idx).s;
                continue;
            }
            
            Job job = pq.poll();
            currentTime = Math.max(currentTime, job.s) + job.l;
            totalTurnaround += currentTime - job.s;
            jobsProcessed++;
        }
        
        return totalTurnaround / jobs.length;
    }
    
    static class Job {
        int s;
        int l;
        int index;
        
        public Job(int s, int l, int index) {
            this.s = s;
            this.l = l;
            this.index = index;
        }
    }
}
