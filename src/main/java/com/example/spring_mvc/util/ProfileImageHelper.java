package com.example.spring_mvc.util;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@Component
public class ProfileImageHelper {
    private static final String RESOURCES_PATH = "images";
    private static final String DEFAULT_PROFILE = "/no-image.png";

    private final String profileImageRealPath;

    public ProfileImageHelper(ResourceLoader resourceLoader) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + RESOURCES_PATH);
        profileImageRealPath = resource.getURI().getPath();
    }

    public String uploadProfileImage(MultipartFile profileImage) throws IOException {
        if (Objects.isNull(profileImage) || profileImage.isEmpty()) {
            return null;
        }

        String fileName = UUID.randomUUID() + "." + FilenameUtils.getExtension(profileImage.getOriginalFilename());
        String filePath = profileImageRealPath + fileName;

        File file = new File(filePath);
        profileImage.transferTo(file);
        return fileName;
    }

    public String getProfileImage(String profileImagePath) {
        String filePath = profileImageRealPath + profileImagePath;
        File file = new File(filePath);

        if (file.exists() && file.isFile()) {
            return "/" + RESOURCES_PATH + "/" + profileImagePath;
        }

        return "/" + RESOURCES_PATH + DEFAULT_PROFILE;
    }
}
