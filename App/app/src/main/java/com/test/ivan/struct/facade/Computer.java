package com.test.ivan.struct.facade;

public class Computer {

    private CPU cpu;
    private RAM memory;
    private HDD hardDrive;

    public Computer() {
        cpu = new CPU();
        memory = new RAM();
        hardDrive = new HDD();
    }

    public void start() {
        cpu.freeze();
        memory.load(1, hardDrive.read(354L, 20));
        cpu.jump(1);
        cpu.execute();
    }
}
