package me.dio.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.web.api.handler.CampoObrigatorioException;
import me.dio.web.api.model.Usuario;
import me.dio.web.api.repository.UsuarioRepository;

@Component
@RestController
@RequestMapping("/users")
public class UsuarioController implements CommandLineRunner {
    @Autowired
    private UsuarioRepository repository;

    public UsuarioController(){
    }

    @GetMapping("/")
    public List<Usuario> getUsers(){
        return repository.findAll();
    }

    @GetMapping("/{username}")
    public Usuario getOne(@PathVariable("username") String username){
        return repository.findByUsername(username);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @PostMapping("/")
    public void postUsers(@RequestBody Usuario usuario){
        save(usuario);
    }
    @PutMapping("/")
    public void putUsers(@RequestBody Usuario usuario){
        save(usuario);
    }

    private void save(Usuario usuario){
        if(usuario.getLogin() == null){
            throw new CampoObrigatorioException("login");
        }
        if(usuario.getPassword() == null){
            throw new CampoObrigatorioException("password");
        }
        repository.save(usuario);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Usuario("Bruno","senhamestre"));
        repository.save(new Usuario("Ana","senhacomum"));
    }
}
