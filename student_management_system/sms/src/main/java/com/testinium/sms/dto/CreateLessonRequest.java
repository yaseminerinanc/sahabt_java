package com.testinium.sms.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLessonRequest {

    @NotNull(message = "lessonName should not be null!")
    @NotEmpty(message = "lessonName should not be empty!")
    private String lessonName;

    private String description;

    private String imageId;

    private int availableItemCount;

}