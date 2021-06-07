package PokeArenaNetwork;

public class PokeArenaUpdatePacket extends PokeArenaPacket {

    private Update update;

    public PokeArenaUpdatePacket() {
        super(PokeArenaPacketType.UPDATE);
    }

    public PokeArenaUpdatePacket(Update update) {
        this();
        this.update = update;
    }

    public Update getUpdate() {
        return update;
    }

}
