package org.prepper.ieltspracticejava.enums;

import lombok.Getter;

@Getter
public enum CambridgeListeningItemType {
    PROLOGUE(0),
    CONTENT(1),
    INTERLUDE(2),
    EPILOGUE(3),
    ;

    private final byte value;

    CambridgeListeningItemType(int value) {
        this.value = (byte) value;
    }

    public static CambridgeListeningItemType valueOf(byte value) {
        for (CambridgeListeningItemType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }
}
