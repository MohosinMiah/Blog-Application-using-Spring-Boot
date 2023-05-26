package com.blogapplication.blogapplication.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
    description = "Post DTO Model Class"
)
public class PostDTO {
    private long id;

    // title should not be null  or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    @Schema(
        description = "Blog Post Title"
    )
    private String title;

    // post description should be not null or empty
    // post description should have at least 10 characters

    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    @Schema(
        description = "Blog Post Description"
    )
    private String description;

    // post content should not be null or empty
    @Schema(
        description = "Blog Post Content"
    )
    @NotEmpty
    private String content;

    @NotNull
    @Schema(
        description = "Blog Post Category ID"
    )
    private Long categoryId;
}
