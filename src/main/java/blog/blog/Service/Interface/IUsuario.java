package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;


import blog.blog.Model.DTOs.UsuarioDTO;

public interface IUsuario {
   
    public List<UsuarioDTO>GetAllUsuarios();
    public Optional<UsuarioDTO>FindByEmail(String email);
    public Optional<UsuarioDTO>FindById(Long id);
    public Optional<UsuarioDTO>FindByNickName(String NickName);
    public Optional<UsuarioDTO> Save(UsuarioDTO usuarioDt);
    public Optional<UsuarioDTO> Update(Long id,UsuarioDTO usuarioDt);
    public void DeleteById(Long id);
    
}
