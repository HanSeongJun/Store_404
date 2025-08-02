package Store404.backend.ApiDocs.Auth.SignUp;

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
@Operation(summary = "회원가입", description = "사용자 정보를 받아 회원가입 처리")
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "회원가입 성공",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = Success.class),
                        examples = @ExampleObject(value = "{ \"code\": \"SU\", \"message\": \"Success\" }")
                )
        ),
        @ApiResponse(
                responseCode = "400",
                description = "잘못된 요청 (중복된 이메일/닉네임/전화번호)",
                content = @Content(
                        mediaType = "application/json",
                        schema = @Schema(implementation = SignUpBadRequest.class),
                        examples = {
                                @ExampleObject(name = "이메일 중복", value = "{ \"code\": \"DE\", \"message\": \"Duplicate Email.\" }"),
                                @ExampleObject(name = "전화번호 중복", value = "{ \"code\": \"DT\", \"message\": \"Duplicate Tel Number.\" }")
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
public @interface SignUpApiDocs {
}
