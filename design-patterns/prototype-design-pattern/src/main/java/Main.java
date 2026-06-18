public class Main {
    public static void main(String[] args) {
        NPC npc = new NPC(100, 10, "orc");

        NPC npc2 = (NPC) npc.clone();
        NPC npc3 = (NPC) npc.clone();

        System.out.println(npc.getName());
        System.out.println(npc2.getName());
        System.out.println(npc3.getName());
    }
}
