package Ex_01;

public class SilentAttackStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Atacas pela caladinha");
    }
}