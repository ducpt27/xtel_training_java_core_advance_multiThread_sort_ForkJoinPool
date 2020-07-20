package com.xtel.training.ptd.sort.config;

public class SortFileConfig extends AbsConfig {

    public static String FILE_INPUT;
    public static String FILE_OUTPUT;

    public SortFileConfig(String pathFile) {
        super(pathFile);
    }

    public void init() throws Exception {
        execute();
    }

    @Override
    protected void loadConfig() throws Exception {
        FILE_INPUT = getString("file[0].input", "E:\\input.txt");
        FILE_OUTPUT = getString("file[0].ouput", "E:\\output.txt");
    }
}
