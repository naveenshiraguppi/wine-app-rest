package com.challenge.wineapprest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class WineJsonReaderService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private ObjectMapper objectMapper = new ObjectMapper();

    public List<WineLot> readWineLots() {
        File fileFolder = null;
        fileFolder = readWinesDirectory(fileFolder);
        return Arrays.stream(fileFolder.listFiles()).filter(f -> f.getName().endsWith(".json")).map(file -> readWineLot(file)).filter(l->l != null).collect(Collectors.toList());
    }

    private File readWinesDirectory(File fileFolder) {
        try {
            fileFolder = ResourceUtils.getFile("classpath:wines");
        } catch (FileNotFoundException e) {
            logger.error("Exception while creating wines directory" , e);
        }
        return fileFolder;
    }

    private WineLot readWineLot(File file) {
        try {
            return objectMapper.readValue(new FileInputStream(file), WineLot.class);
        } catch (IOException e) {
            logger.error("Exception while reading file " + file.getName(), e);
        }
        return null;
    }
}
