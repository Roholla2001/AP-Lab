import java.util.ArrayList;


/**
 * A class to keep and control a number of votings
 * @version 1.0
 * @author Roholla Ahmadzadeh
 */
public class VotingSystem {
    private ArrayList<Voting> votingList;

    /**
     * Constructs a new voting system
     */
    public VotingSystem() {
        votingList = new ArrayList<Voting>();
    }

    /**
     * Creats a new voting and adds it to the list
     * @param question The question of the voting
     * @param type the type of the voting (0: single choice, 1: multi-choice)
     * @param choices the list of the choices to choose from
     */
    public void createVoting(String question, int type, ArrayList<String> choices) {
        Voting voting = new Voting(type, question);
        for(String choice: choices)
            voting.createChoice(choice);
        votingList.add(voting);
    }

    /**
     * Prints the questions of the votings in the list
     * to the standard output
     */
    public void printVotingQuestions() {
        int i = 1;
        for(Voting voting: votingList)
            System.out.println(i++ + ". " + voting.getQuestion());

    }

    /**
     * Prints the question and the choices of a voting
     * @param index the index of the voting to be printed in the list
     */
    public void printVoting(int index) {
        Voting voting = votingList.get(index);
        System.out.println(voting.getQuestion());
        for(String choice: voting.getChoices())
            System.out.println(choice);
        System.out.println();
    }

    /**
     * Makes a vote to the specified voting
     * @param index the index of the voting
     * @param voter the person who is voting
     * @param voteList the list of the choices to be voted to
     */
    public void vote(int index, Person voter, ArrayList<String> voteList) {
        votingList.get(index).vote(voter, voteList);
    }

    /**
     * Prints the result of a voting to the standard output
     * @param index the index of the voting
     */
    public void printResults(int index) {
        votingList.get(index).printVotes();
    }


}
