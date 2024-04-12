import java.lang.reflect.Array;
import java.util.*;
public class Election {
    LinkedList<String> candidates = new LinkedList<>();
    HashMap<String, Integer> ballot = new HashMap<>();
    Queue<String> ranking;

    Election(LinkedList candidates){
        this.candidates = candidates;
        initializeCandidates(candidates);
        ranking = new PriorityQueue<>((a, b) -> ballot.get(b) - ballot.get(a));
    }

    public HashMap<String, Integer> initializeCandidates(LinkedList<String> candidates){
        for(String c: candidates){
            ballot.put(c,0);
        }
        return ballot;
    }
    public void castVotes(String candidate){
        if(ballot.containsKey(candidate)) {
            int votes = ballot.get(candidate);
            ballot.put(candidate, votes + 1);
            updatePriorityQueue();
        }
        else{
            System.out.println("Candidate does not exist.");
        }

    }
    public void castRandomVote(){
        Random gen = new Random(candidates.size());
        String lucky = candidates.get(gen.nextInt());
        int votes = ballot.get(lucky);
        ballot.put(lucky, votes + 1);
        updatePriorityQueue();

    }
    public void rigElection(String candidate){
        String topCandidate = ranking.peek();
        int topCandidateVotes = ballot.get(topCandidate);
        int remainingVotes =  topCandidateVotes - ballot.get(candidate);
        ballot.put(candidate, remainingVotes + 2);
        updatePriorityQueue();
    }
    public ArrayList<String> getTopKCandidates(int k){
        ArrayList<String> topGs = new ArrayList<>();
        for(int i = 0; i < k; i++){
            topGs.add(ranking.poll());
        }
        for(String Gs: topGs){
            ranking.offer(Gs);
        }

        return topGs;
    }
    public void auditElection(){
        for(String candidate : ranking){
            System.out.println(candidate + " : " + ballot.get(candidate));
        }

    }
    private void updatePriorityQueue(){
        ranking.clear();
        ranking.addAll(ballot.keySet());
    }
}
