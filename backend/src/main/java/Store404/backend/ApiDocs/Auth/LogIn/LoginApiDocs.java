package Store404.backend.ApiDocs.Auth.LogIn;

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
@Operation(summary = "로그인", description = "사용자 정보를 받아 로그인 처리")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "로그인 성공",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Success.class),
                        examples = @ExampleObject(value = "{ \"code\": \"SU\", \"message\": \"Success\", \"token\": \"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c\", \"expirationTime\": \"3600\" }")
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "유효성 검사 실패",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = LoginBadRequest.class),
                        examples = {
                                @ExampleObject(name = "유효성 검사 실패", value = "{ \"code\": \"VF\", \"message\": \"Validation failed.\" }"),
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
public @interface LoginApiDocs {
}
