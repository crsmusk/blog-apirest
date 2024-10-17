package blog.blog.Service.Interface;
import java.util.List;
import java.util.Optional;


import blog.blog.Model.DTOs.UsuarioDTO;

public interface IUsuario {
   
    public List<UsuarioDTO>getAllUsuarios();
    public UsuarioDTO findByEmail(String email);
    public UsuarioDTO findById(Long id);
    public UsuarioDTO findByNickName(String nickName);
    public UsuarioDTO save(UsuarioDTO usuarioDt);
    public UsuarioDTO updateBasicData(Long id,UsuarioDTO usuarioDt);
    public void deleteById(Long id);
    public UsuarioDTO updateRol(Long id,List<String>roles);
    
}
