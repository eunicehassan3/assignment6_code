import java.util.LinkedList;

public class ElectionSystem {
    public static void main(String[] args) {
        LinkedList<String> candi = new LinkedList<>();
        candi.add("Bob");
        candi.add("Rick");
        candi.add("Sally");
        candi.add("Norma");
        Election e = new Election(candi);

        System.out.println(e.initializeCandidates(candi));
        e.castVotes("Bob");
        e.castVotes("Bob");
        e.castVotes("Rick");
        e.castVotes("Rick");
        e.castVotes("Rick");
        e.castVotes("Sally");
        e.castVotes("Sally");
        e.castVotes("Norma");

        System.out.println(e.getTopKCandidates(3));
        e.auditElection();

        e.rigElection("Norma");
        System.out.println(e.getTopKCandidates(3));
        e.auditElection();

    }
}
