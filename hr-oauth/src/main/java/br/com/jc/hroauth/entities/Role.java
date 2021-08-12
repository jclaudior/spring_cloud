package br.com.jc.hroauth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Role implements Serializable {
    private static final long serialVersionUID = 268880128860251469L;

    private Long id;
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

}
