package com.codeup.springblog.repositories;

import com.codeup.springblog.models.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface ImageRepository extends JpaRepository<PostImage, Integer> {
}
