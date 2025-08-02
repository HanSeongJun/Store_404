package Store404.backend.ApiDocs.Category.getAll;

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
@Operation(summary = "모든 카테고리 조회", description = "모든 카테고리 조회")
@ApiResponse(
        responseCode = "200",
        description = "카테고리 리스트 조회 성공",
        content = @Content(
                mediaType = "application/json",
                examples = @ExampleObject(
                        value = "{\n" +
                                "  \"code\": \"SU\",\n" +
                                "  \"message\": \"Success\",\n" +
                                "  \"data\": [\n" +
                                "    { \"id\": 1, \"name\": \"test1\", \"description\": \"테스트용 1\" },\n" +
                                "    { \"id\": 2, \"name\": \"test2\", \"description\": \"테스트용 2\" }\n" +
                                "  ]\n" +
                                "}"
                )
        )
)
public @interface GetAllCategoryApiDocs {
}
