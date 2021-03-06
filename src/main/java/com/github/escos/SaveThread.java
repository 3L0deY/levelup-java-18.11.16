package com.github.escos;

import java.util.List;

public class SaveThread extends Thread {

    @Override
    public void run() {
        Serialization serialization = new Serialization();
        List<Task> tasks = serialization.readFromSerializeFile();
        for (int i = 0; i < tasks.size(); i++) {
            serialization.serializeTask(tasks.get(i),
                    "src\\main\\tasks\\" + i + "_task.txt");
            System.out.printf("\r % 5d %%__|", (i + 1) * 100 / tasks.size());
        }
    }
}
