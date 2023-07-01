package com.emresahna.openapiexample.controller;

import com.emresahna.openapiexample.dto.CreatePostRequest;
import com.emresahna.openapiexample.dto.PostResponse;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @GetMapping
    @Operation(
            tags = {"PostController"},
            summary = "Get all posts summary",
            operationId = "getPosts",
            description = "Get all posts description",
            externalDocs = @ExternalDocumentation(
                    description = "Posts Get Wiki Documentation",
                    url = "postsget.wiki.com"
            )
    )
    public List<PostResponse> getPosts(){
        return Arrays.asList(
                new PostResponse(1L, "Post Title 1", "Post Content 1"),
                new PostResponse(2L, "Post Title 2", "Post Content 2"),
                new PostResponse(3L, "Post Title 3", "Post Content 3")
        );
    }

    @GetMapping("/{id}")
    @Operation(
            tags = {"PostController"},
            summary = "Get one post summary",
            operationId = "getPost",
            description = "Get one post description",
            parameters = {
                    @Parameter(name = "id", description = "Post id", required = true, example = "1")
            },
            externalDocs = @ExternalDocumentation(
                    description = "Post Get Wiki Documentation",
                    url = "postget.wiki.com"
            )
    )
    public PostResponse getPostById(@PathVariable Long id){
        return new PostResponse(id, "Post Title", "Post Content");
    }

    @PostMapping("/create")
    @Operation(
            tags = {"PostController"},
            summary = "Create a post summary",
            operationId = "createPost",
            description = "Create a post description",
            requestBody = @RequestBody(
                    description = "Post object that needs to be created",
                    content = @Content(
                            schema = @Schema(
                                    implementation = CreatePostRequest.class
                            )
                    )
            ),
            parameters = {
                    @Parameter(name = "title", description = "Post title", required = true, example = "Post Title"),
                    @Parameter(name = "content", description = "Post content", required = true, example = "Post Content")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Post created successfully",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = PostResponse.class
                                    ),
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    name = "Post created successfully",
                                                    value = "{\n" +
                                                            "  \"id\": 1,\n" +
                                                            "  \"title\": \"Post Title\",\n" +
                                                            "  \"content\": \"Post Content\"\n" +
                                                            "}"
                                            )
                                    }
                            )
                    )
            },
            externalDocs = @ExternalDocumentation(
                    description = "Post Create Wiki Documentation",
                    url = "postcreate.wiki.com"
            ),
            security = {
                    @SecurityRequirement(
                            name = "BearerJWT"
                    )
            }
    )
    public PostResponse createPost(@RequestBody CreatePostRequest createPostRequest){
        return new PostResponse(1L, createPostRequest.getTitle(), createPostRequest.getContent());
    }
}
