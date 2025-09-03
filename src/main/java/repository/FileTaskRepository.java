package repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import config.Config;
import model.Task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;                 // Java 8 (umesto Path.of)
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileTaskRepository implements TaskRepository {

    private static final Gson GSON = new Gson();
    private final Path path = Paths.get(Config.getInstance().getDataPath());
    private static final Type LIST_TYPE = new TypeToken<List<Task>>() {}.getType();

    @Override
    public void save(Task task) {
        List<Task> all = findAll();
        all.add(task);
        saveAll(all);
    }

    @Override
    public List<Task> findAll() {
        try {
            if (!Files.exists(path)) {
                return new ArrayList<>();
            }
            try (BufferedReader br = Files.newBufferedReader(path)) {
                List<Task> data = GSON.fromJson(br, LIST_TYPE);
                return (data != null) ? data : new ArrayList<Task>();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void saveAll(List<Task> tasks) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            try (BufferedWriter bw = Files.newBufferedWriter(
                    path,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING)) {
                GSON.toJson(tasks, bw);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}

