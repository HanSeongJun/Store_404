package Store404.backend.Common;

public interface ResponseMessage {

    // HTTP Status 200
    String SUCCESS = "Success";

    // HTTP Status 400
    String VALIDATION_FAILED = "Validation Failed.";

    // HTTP Status 400 - 회원가입
    String DUPLICATE_EMAIL = "Duplicate Email.";
    String DUPLICATE_TEL_NUMBER = "Duplicate Tel Number.";
    String NOT_EXIST_USER = "This user does not exist.";

    // HTTP Status 400 - 카테고리
    String NOT_EXIST_CATEGORY = "This category does not exist.";
    String DUPLICATE_CATEGORY_NAME = "Duplicate Category Name.";

    // HTTP Status 401
    String SIGN_IN_FAIL = "Login Information Mismatch.";
    String AUTHORIZATION_FAIL = "Authorization Failed.";

    // HTTP Status 403
    String NO_PERMISSION = "Do not have permission.";

    // HTTP Status 500
    String DATABASE_ERROR = "Database Error.";
}
