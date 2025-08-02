package Store404.backend.ApiDocs.Category.Delete;

import Store404.backend.ApiDocs.Category.Create.CreateCategoryBadRequest;
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
@Operation(summary = "카테고리 삭제", description = "카테고리 ID를 받아 삭제")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "카테고리 삭제 성공",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Success.class),
                        examples = @ExampleObject(value = "{ \"code\": \"SU\", \"message\": \"Success\", \"data\": { \"id\": 1, \"name\": \"test\", \"description\": \"테스트용\" } }")
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "존재하지 않는 카테고리",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = CreateCategoryBadRequest.class),
                        examples = {
                                @ExampleObject(name = "존재하지 않는 카테고리", value = "{ \"code\": \"NC\", \"message\": \"This category does not exist.\" }")

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
public @interface DeleteCategoryApiDocs {
}
