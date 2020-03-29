import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This class represents a voting.
 * You can make a vote to the choices and see the results
 * @author Roholla Ahmadzadeh
 * @version 1.0
 */
public class Voting {
    private int type;
    private String question;
    private ArrayList<Person> voters;
    private ArrayList<String> choices;
    private HashMap<String, HashSet<Vote>> ChoiceToVotes;

    /**
     * Constructs a voting with a specified type and question
     * @param type the type of the voting (0: single choice, 1: multi-choice)
     * @param question The question of the voting
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        choices = new ArrayList<String>();
        ChoiceToVotes = new HashMap<String, HashSet<Vote>>();
    }

    /**
     * @return the question of the voting
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Creates a new choice
     * @param choice the choice to be added
     */
    public void createChoice(String choice) {
        choices.add(choice);
        ChoiceToVotes.put(choice, new HashSet<Vote>());
    }

    /**
     * Makes a new vote to each of the choices in the list
     * @param voter the person voting
     * @param voteList the list of choices to vote to
     */
    public void vote(Person voter, ArrayList<String> voteList) {
        if(voters.contains(voter)) {
            System.out.println("This person has already voted once!");
            return;
        }
        if(type == 0 && voteList.size() > 1) {
            System.out.println("You can't choose more than one option!");
            return;
        }
        Vote vote = new Vote(voter, new JalaliCalendar().toString());
        voters.add(voter);
        for(String choice: voteList)
            ChoiceToVotes.get(choice).add(vote);
    }

    /**
     * Prints the name of the voters to the standard output
     */
    public void getVoters() {
        for(Person voter: voters)
            System.out.print(voter + " ");
        System.out.println();
    }

    /**
     * shows the winner and the people who voted to him/her/it
     */
    public void printVotes() {
        int voteCount = 0;
        String winner = "";
        for(String choice: choices)
            if(ChoiceToVotes.get(choice).size() > voteCount) {
                voteCount = ChoiceToVotes.get(choice).size();
                winner = choice;
            }
        System.out.println(winner + " won! voters: " + ChoiceToVotes.get(winner));
    }

    /**
     * @return the list of the choices
     */
    public ArrayList<String> getChoices() {
        return choices;
    }
}
