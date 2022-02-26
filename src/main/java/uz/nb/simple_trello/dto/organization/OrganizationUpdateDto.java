package uz.nb.simple_trello.dto.organization;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.nb.simple_trello.dto.base.GenericDto;

@Getter
@Setter
@NoArgsConstructor
public class OrganizationUpdateDto extends GenericDto {
    private String name;
    private String code;
    private String email;


    @Builder(builderMethodName = "childBuilder")
    public OrganizationUpdateDto(Long id, String name, String code, String email) {
        super(id);
        this.name = name;
        this.code = code;
        this.email = email;
    }
}
