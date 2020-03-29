import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        VotingSystem votingSystem = new VotingSystem();

        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();

        list1.add("choice1");
        list1.add("choice2");

        list2.add("option1");
        list2.add("option2");
        list2.add("option3");
        list2.add("option4");

        votingSystem.createVoting("Choose one:" ,0 ,list1);
        votingSystem.createVoting("Choose some:", 1, list2);

        Person p1 = new Person("Roholla", "Ahmadzadeh");
        Person p2 = new Person("Rachel", "Green");
        Person p3 = new Person("Ross", "Geller");
        Person p4 = new Person("Chandler", "Bing");

        ArrayList<String> voteList = new ArrayList<String>();

        //Printing the questions
        votingSystem.printVotingQuestions();

        //Voting 1
        votingSystem.printVoting(0);

        //I vote to choice1
        voteList.add("choice1");
        votingSystem.vote(0, p1, voteList);
        voteList.clear();

        //Rachel votes randomly
        int rand = random.nextInt(2);
        voteList.add(list1.get(rand));
        votingSystem.vote(0, p2, voteList);
        voteList.clear();

        //Ross wants to vote twice, and then an error is shown!
        voteList.add("choice1");
        voteList.add("choice2");
        votingSystem.vote(0, p3, voteList);
        voteList.clear();

        //Chandler votes to choice2
        voteList.add("choice2");
        votingSystem.vote(0, p4, voteList);
        voteList.clear();

        //The result
        votingSystem.printResults(0);


        //Voting2
        votingSystem.printVoting(1);

        //I Vote to option1 & option2
        voteList.add("option1");
        voteList.add("option2");
        votingSystem.vote(1, p1, voteList);
        voteList.clear();

        //Rachel votes to option2 & option3 & option4
        voteList.add("option2");
        voteList.add("option3");
        voteList.add("option4");
        votingSystem.vote(1, p2, voteList);
        voteList.clear();

        //Ross votes to option2
        voteList.add("option2");
        votingSystem.vote(1, p3, voteList);
        voteList.clear();

        //Chandler votes to option4
        voteList.add("option4");
        votingSystem.vote(1, p4, voteList);
        voteList.clear();

        //Chandler tries to vote again, and then an error is shown
        voteList.add("option1");
        votingSystem.vote(1, p4, voteList);

        //The result
        votingSystem.printResults(1);




    }


}
