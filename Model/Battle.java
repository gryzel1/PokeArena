package Model;

/**
 * Class décrivant un combat Pokémon. Non définitif (à remplacer par une interface sûrement).
 */
public class Battle {
    public TrainerAction trainer1;
    public TrainerAction trainer2;

    private static BattleGround bg;  //Terrain de combat

    public Battle(Trainer left, Trainer right, BattleGround bg) {
        trainer1 = new TrainerAction(left, null);
        trainer2 = new TrainerAction(right, null);
        Battle.bg = bg;
    }

    public void takeTurns (Action T1action, Action T2action) {
        trainer1.pairWith(T1action);
        trainer2.pairWith(T2action);
        TrainerAction firstToAct = calculatePriority();
        TrainerAction secondToAct = (firstToAct == trainer1 ? trainer2 : trainer1);
        apply(firstToAct);
        if (!secondToAct.getTrainer().getLeadingPkmn().isKO()) {
            apply(secondToAct);
            if (firstToAct.getTrainer().getLeadingPkmn().isKO()) {
                if (!firstToAct.getTrainer().hasPokemonLeft()) {
                    endBattle(secondToAct.getTrainer());
                } else {
                    firstToAct.getTrainer().changePokemon(((ChangePkmn) firstToAct.getAction()).getIndex());
                }
            }
        }
        else {
            if (!secondToAct.getTrainer().hasPokemonLeft()) {
                endBattle(firstToAct.getTrainer());
            } else {
                secondToAct.getTrainer().changePokemon(((ChangePkmn) secondToAct.getAction()).getIndex());
            }
        }
    }

    public void apply (TrainerAction current) {
        if (current.getAction() instanceof Move) {
            Pokemon target = (current == trainer1 ? trainer2.getTrainer().getLeadingPkmn() : trainer1.getTrainer().getLeadingPkmn());
            current.getTrainer().getLeadingPkmn().attack(target, (Move) current.getAction());
        }
        else if (current.getAction() instanceof ChangePkmn) {
            current.getTrainer().changePokemon(((ChangePkmn) current.getAction()).getIndex());
        }
    }

    public TrainerAction calculatePriority() {
        TrainerAction firstToAct;
        if (trainer1.getAction().getPriority() > trainer2.getAction().getPriority()) {
            firstToAct = trainer1;
        }
        else if (trainer1.getAction().getPriority() < trainer2.getAction().getPriority()) {
            firstToAct = trainer2;
        }
        else {
            firstToAct = (trainer1.getTrainer().getLeadingPkmn().isFaster(trainer2.getTrainer().getLeadingPkmn()) ? trainer1 : trainer2);
        }
        return firstToAct;
    }

    public void endBattle(Trainer w) {
        System.out.println(w.getDisplayName() + " remporte le combat.");
    }
}
