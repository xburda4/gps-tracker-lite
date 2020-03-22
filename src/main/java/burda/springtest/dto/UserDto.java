package burda.springtest.dto;

import burda.springtest.annotations.PasswordMatches;
import burda.springtest.annotations.PasswordRightFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@EqualsAndHashCode
@PasswordMatches
@PasswordRightFormat
@AllArgsConstructor
@Builder
public final class UserDto {

    public static UserDto emptyUser() {
        return new UserDto(null,null, null,null,null);
    }

    @NotNull
    @NotEmpty
    private final
    String firstName;

    @NotNull
    @NotEmpty
    private final
    String lastName;

    @NotNull
    @NotEmpty
    private final
    String password;
    private final String matchingPassword;

    @NotNull
    @NotEmpty
    private final String email;

    public String toString() {
        return "UserDto(firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", password=" + this.getPassword() + ", matchingPassword=" + this.getMatchingPassword() + ", email=" + this.getEmail() + ")";
    }
}
