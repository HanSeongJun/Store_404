package Store404.backend.ApiDocs.Category.Create;


import Store404.backend.ApiDocs.Auth.SignUp.SignUpBadRequest;
import Store404.backend.ApiDocs.InternalServerError;
import Store404.backend.ApiDocs.Success;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Operation(summary = "카테고리 생성", description = "카테고리 정보를 받아 카테고리 생성")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "카테고리 생성 성공",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Success.class),
                        examples = @ExampleObject(value = "{ \"code\": \"SU\", \"message\": \"Success\", \"data\": { \"id\": 1, \"name\": \"test\", \"description\": \"테스트용\" } }")
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "중복된 카테고리 이름",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = CreateCategoryBadRequest.class),
                        examples = {
                                @ExampleObject(name = "카테고리 이름 중복", value = "{ \"code\": \"DCN\", \"message\": \"Duplicate Category Name.\" }")

                        }
                )
        ),
        @ApiResponse(
                responseCode = "500",
                description = "DB 에러",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = InternalServerError.class),
                        examples = @ExampleObject(value = "{ \"code\": \"DBE\", \"message\": \"Database Error.\" }")
                )
        )
})
public @interface CreateCategoryApiDocs {
}
