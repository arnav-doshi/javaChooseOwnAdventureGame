public class Story {
    
    private Tree t2 = new Tree();
    private Node currentNode;   
    boolean playIsOn = false;
    
       //constructor
    /**
     * Story constructor that initializes the tree and sets playOn as true or false depending on the current Node
     * 
     */
    public Story()
    {
        initTree();
        currentNode = t2.root;
        if(currentNode != null)
            playIsOn = true;
    } 

    
    /**
     * An accessor method that returns the current node data
     * @return the current node data String
     */
    public String getCurrentNodeData() {
        return currentNode.getNodeData();
    }   

    /**
     * An accessor method that returns the left node data for a node AKA the choice A
     * @return the currentNode's left node data AKA choice A
     */
    public String getCurrentChoiceA() {
        return currentNode.left.getNodeData();
    }   
    /**
     * An accessor method that returns the right node data for a node AKA the choice B
     * @return the currentNode's right choice data AKA choice B
     */
    public String getCurrentChoiceB() {
        return currentNode.right.getNodeData();
    }   
    
    /**
     * Returns the left node. Not the data!
     * @return Node - the current node's left node.
     */
    public Node getCurrentNodeLeft() {
        return currentNode.getNodeLeft();
    }       

    /**
     * Returns the right node. Not the data!
     * @return Node - the current node's right node
     */
    public Node getCurrentNodeRight() {
        return currentNode.getNodeRight();
    }   
    
    /**
     * A method that sets the current node to a new node (setter method)
     * @param newCurrentNode the node parameter to set to the current node
     */
    public void setCurrentNode(Node newCurrentNode) {
        currentNode = newCurrentNode;
    }   
    
    /**
     * A method that checks whether a node ends and is surrounded by null nodes. 
     * @return true or false depending on whether it is a terminating node
     */
    public boolean isTerminatingNode() {
        boolean terminatingNode = false;
        
        if((currentNode.left == null) && (currentNode.right == null)) {
            terminatingNode = true;
            playIsOn = false;
        }
        return terminatingNode;
    }
    
    /**
     * A boolean method that returns true or false depending on whether it is the end of the tree or not
     * @return true or false whether the tree has ended or not
     */
    public boolean isEnd() {
        if(currentNode != null) 
            playIsOn = true;
        else
            playIsOn = false;
        
        return playIsOn;
    }

    /**
     * A method that initializes an ordered binary tree from an array
     */
    public void initTree() {
        String[] story = new String[19];
        story[0] = ("Would you like to travel to the fire desert(A) or the mystical forest(B)?");
        story[1] = ("You choose the fire desert and walk in the barren lands of the desert. It's extremely humid and you immediately become parched. Do you run to a nearby lake(A), or wait it out and continue walking(B)?");
        story[2] = ("You choose the Mystic Forest and go down the dark alley. Soon, your vision deteriorates as you stumble into the dark forest. Do you light a torch for your path(A) or blindly continue to walk ahead?(B)");
        story[3] = ("You see a nearby lake and run towards it, only for it to get further. As you fall to your knees you realize that the lake is merely a mirage. You pass out and die from dehydration.");
        story[4] = ("Foolishly, you continue to keep on walking in hopes of stumbling upon a new and more reliable water source. Suddenly, you run into a strange looking monster speaking in crude English. It offers a simple deal: it will give you water in exchange for a favor. Do you accept the trade?(A)");
        story[5] = ("You dig in your adventure pack and strike a torch for your path. You look ahead with this newfound light and catch yourself about to fall into a large ravine. Close call. You walk across the shaky rope bridge built to take travellers across the ravine when you encounter a hostile monster. Do you subdue the monster and try to find information about it(A) or kill it out of self-defense?(B)");
        story[6] = ("Blind and in the dark, your foot slips off an edge and you lose your balance. You tumble down the ravine to your death. Your last thought is *Why didn’t I light the torch in my bag?*");
        story[7] = ("You accept the monster’s favor out of desperation. The monster proceeds to hand you a small jar of water. The monster asks you to guard a mysterious elixir of his while he is out. You agree and after what seems like an eternity, you are tempted to steal the elixir for your journey. Do you drink all your water and fill your empty jar with elixir(A), or conserve your water and guard the elixir as you were told to do?(B)");
        story[8] = ("You decline the monster’s offer since it seemed too sketchy, but soon your legs become heavy and your throat becomes too dry. You fall to your knees after passing up 2 opportunities to get water. You pass out and die from dehydration.");
        story[9] = ("You decide to subdue the monster and find more information about its boss. After quickly disarming the monster, your sword is at its throat when you ask about its leader. The monster tells you about a shortcut through the forest to get to the evil monster’s fortress. You thank it and in exchange for the information you spare the monster's life. You have no other choice but to go to the castle.");
        story[10] = ("You kill the now heavily injured monster to put it out of its misery and dismiss it as self-defense. You continue to walk and after a while you arrive at a fork in the road. Both sides have a large tunnel. At the end of one tunnel, there is pure darkness. At the end of the other, there is light at the end of the tunnel. Which tunnel do you go down, the dark(A) or the light(B) one?");
        story[11] = ("You decide to drink all of the water in your jar and fill it with the mysterious elixir. It returns and you realize the monster is one of the monster king’s minions by its clothing. The monster then sees its elixir in the jar and is flung into a rage. It attacks you relentlessly. As a last hope, you drink the elixir and are suddenly revitalized and slay the monster. More minions quickly arrive at the base. Quick! Do you run away and hide(A) or use your quick wits to get out of this confrontation(B).");
        story[12] = ("The monster returns and everything seems to be going well until you realize that the monster really works for the monster king and was sent there on a mission. You try to assassinate the monster when suddenly it whips around and catches you. The monster quickly overpowers you and kills you. You die.");
        story[13] = ("You walk down the dark path, and after what seems like an hour of stumbling around in the dark you see a light and arrive at a clearing. You have no other choice but to walk forward towards the building. (A || B).");
        story[14] = ("You walk down the lighter path, your eyes fixated on the bright ending of the tunnel. Your eyes are fixed straight ahead that you don't even notice the trap on the ground before it’s too late. A trap wraps around your leg, ouch! Do you wait for the owner of the trap to come back(A), or cut off your leg in an attempt to escape?(B)");
        story[15] = ("In an attempt to run away and hide you step into a small hole of loose sand. Suddenly pounds of sand drop from underneath you! It was a booby trap setup by the monsters! Unfortunately you cannot escape this crafty trap and fall to your death. You die.");
        story[16] = ("You use your quick wits and act confident you can defeat these minions. You stand up with your chest out and boast to the other minions about how easily it was to kill one of their kind. They cower in fear and you say that you’ll spare their lives if they tell you information about their leader. They comply, and you “let them leave” knowing full well that one of them could have destroyed you. You breathe a sigh of relief and walk down a windy passageway towards the castle.");
        story[17] = ("You decide to wait it out until the monster comes back. After hours of waiting in agony, the monster that set the trap comes by. With a crazy coincidence the monster is the exact same species that you killed before, in fact, it notices the blood on your armor and now knows you killed its brother! What a coincidence! The monster swiftly gets revenge by ending your life with no mercy (just like you did its brother). You die.");
        story[18] = ("You take out your sword and begin to cut off your leg. Halfway through you think Why did I believe this was a good idea? and pass out from blood loss. You die.");

        String[] bossFight = new String[12];
        bossFight[0] = ("After all your adventures to get the castle you shake in fear and decide to go home. In the kingdom of Fulk your friends and family taunt you and the king laughs when he hears your story. You die of embarrassment. After all that?");
        bossFight[1] = ("You enter the castle and meet the massive monster king. You challenge him to a duel and thankfully the monster is honorful. He asks you to choose a weapon for him to provide for the fight. Do you choose the bow(A) or the sword?(B)");
        bossFight[2] = ("You choose the bow and the monster laughs as he gives you no arrows. He taunts you and then proceeds to destroy you. You die.");
        bossFight[3] = ("You choose the sword like any great hero and the duel begins. The monster charges at you immediately. Quick! Do you fight it head on(A) or dodge the attack?(B)");
        bossFight[4] = ("You take a heavy blow from the attack and now you’re injured and limping. Do you play dead(A) or get back up and fight?(B)");
        bossFight[5] = ("The monster king charges past you, and while the monster has its back turned on you, you land one good shot with your sword. Nice! The monster king charges again once before you can react. You get heavily hit and get back up, remembering the reason you’re fighting. Do you beg for mercy(A) or keep fighting?(B)");
        bossFight[6] = ("You play dead and while the monster has its back turned you get up and kill it! Nice! \n You get back home and tell your story to all the civilians to the kingdom of Fulk, about your great adventures and how you craftily killed the monster king. \n You even get to talk to the king, though once you tell him your story, he’s puzzled by the end. He says you just committed a war crime by playing dead and stabbing the enemy in the back and sentences you to a life of prison. Though you lived and are hailed as one of the greatest adventurers that ever lived, you spend the rest of your life in prison. \n The end. (BAD HERO ENDING)");
        bossFight[7] = ("You’re heavily injured when you get back up. The monster king laughs and delivers a sick monologue before easily defeating you. You die at the hand of the monster king.");
        bossFight[8] = ("You beg for mercy and the monster king surprisingly spares you. He then enlists you in his army for being such a great warrior. After a long time serving the monster king, Fulkian soldiers find and capture you on patrol and you are sentenced to death for tyranny in the kingdom of Fulk.");
        bossFight[9] = ("You get up to fight! You use your sword to help you stand back up and finally hold it up to the monster king. It laughs and charges one last time. Do you fight it head on(A) or attempt to dodge again?(B)");
        bossFight[10] = ("The monster king charges at you at full-force, aiming to end the battle this time. You stand your ground and raise your sword. The monster king did not expect a puny human to fight it head on, though it was too late. \n You plunge the sword deep into the monster king’s head and its massive body falls to the ground. You killed it! Nice! You get all the way back home and tell all the civilians of Fulk about how you craftily killed the monster king. \n You even get a chance to talk to the king, and once you tell him your story he smiles widely and gives you a large reward. You’re awarded with a life of pleasure and leisure and you are crowned as the hero of the kingdom of Fulk. \n The end. (GOOD HERO ENDING)");
        bossFight[11] = ("The monster king is surprisingly smart and has adapted to your dodging. This time, he steers and gets a direct hit on you. Ouch! You fall to the ground and pass out, not to wake up again. You die at the hand of the monster king. ");

        // Build the tree now

        Node levelN, levelM, bossCastle, levelK;

        t2.root = new Node(story[0]);
        t2.root.left = new Node(story[1]);
        t2.root.right = new Node(story[2]);

        bossCastle = new Node("You have arrived upon a massive fortress presumably owned by the monster king. Do you leave and go home or enter the castle to fight?");

        // RIGHT SUBTREE

        levelN = t2.root.right;
        levelN.left = new Node(story[5]);
        levelN.right = new Node(story[6]);

        levelM = levelN.left;
        levelM.left = new Node(story[9]);
        levelM.right = new Node(story[10]);

        levelK = levelM.left;
        levelK.left = bossCastle;
        levelK.right = bossCastle;
        levelK.nextStep = true;

        levelN = levelM.right;
        levelN.left = new Node(story[13]);
        levelN.right = new Node(story[14]);

        levelK = levelN.left;
        levelK.left = bossCastle;
        levelK.right = bossCastle;
        levelK.nextStep = true;

        levelM = levelN.right;
        levelM.left = new Node(story[17]);
        levelM.right = new Node(story[18]);

        // LEFT SUBTREE
        levelN = t2.root.left;
        levelN.left = new Node(story[3]);
        levelN.right = new Node(story[4]);

        levelM = levelN.right;
        levelM.left = new Node(story[7]);
        levelM.right = new Node(story[8]);

        levelN = levelM.left;
        levelN.left = new Node(story[11]);
        levelN.right = new Node(story[12]);

        levelM = levelN.left;
        levelM.left = new Node(story[15]);
        levelM.right = new Node(story[16]);

        levelK = levelM.right;
        levelK.left = bossCastle;
        levelK.right = bossCastle;
        levelK.nextStep = true;

        // BOSS FIGHT ----

        bossCastle.left = new Node(bossFight[0]);
        bossCastle.right = new Node(bossFight[1]);

        levelN = bossCastle.right;
        levelN.left = new Node(bossFight[2]);
        levelN.right = new Node(bossFight[3]);

        levelM = levelN.right;
        levelM.left = new Node(bossFight[4]);
        levelM.right = new Node(bossFight[5]);

        // LEFT SUBTREE
        levelN = levelM.left;
        levelN.left = new Node(bossFight[6]);
        levelN.right = new Node(bossFight[7]);

        // RIGHT SUBTREE
        levelN = levelM.right;
        levelN.left = new Node(bossFight[8]);
        levelN.right = new Node(bossFight[9]);

        levelM = levelN.right;
        levelM.left = new Node(bossFight[10]);
        levelM.right = new Node(bossFight[11]);

    }
}
