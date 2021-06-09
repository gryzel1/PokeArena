package PokeArenaNetwork;

public enum PokeArenaServerState {
    WAITING_FOR_CLIENT1_TO_JOIN,
    WAITING_FOR_CLIENT2_TO_JOIN,
    WAITING_FOR_CLIENTS_TEAM,
    WAITING_FOR_CLIENT_1_TEAM,
    WAITING_FOR_CLIENT_2_TEAM,
    WAITING_FOR_START,
    IN_BATTLE,
    BATTLE_ENDED,
    WAITING_FOR_CLIENT1_CHANGEPKMN,
    WAITING_FOR_CLIENT2_CHANGEPKMN,
    WAITING_FOR_CLIENTS_ACTIONS,
    WAITING_FOR_CLIENT_1_ACTION,
    WAITING_FOR_CLIENT_2_ACTION,
    PROCESSING_ACTIONS,
}
