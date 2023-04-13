/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.xforce.db;

import com.xforce.model.Admin;
import com.xforce.model.User;
import com.xforce.model.Cliente;
import com.xforce.model.Instructor;
import com.xforce.model.UserType;
import java.util.Optional;

/**
 *
 * @author Hamoncho
 */
public interface DataBase {

    public Optional<? extends User> logIn(String password, String username);

    public void signIn(User user) throws Exception, IllegalArgumentException;

    public boolean userExists(User user);

    public boolean adminExists(Admin admin);

    public boolean clienteExists(Cliente cliente);

    public boolean instructorExists(Instructor instructor);

    public boolean userNameExists(String userName);

    public boolean emailExists(String email);

    public Optional<Integer> getIdUsuario(String username, String password);

    public void becomeAdmin(User current, Admin target)
            throws Exception, IllegalArgumentException;

    public void becomeCliente(User current, Cliente target)
            throws Exception, IllegalArgumentException;

    public void becomeInstructor(User current, Instructor target)
            throws Exception, IllegalArgumentException;

    public void becomeUsuario(User user)
            throws Exception, IllegalArgumentException;

    public Optional<? extends User> getUser(int id)
            throws Exception, IllegalArgumentException;

    public void addUser(User user)throws Exception, IllegalArgumentException;

    public void deleteUser(int id)throws Exception, IllegalArgumentException;

    public void updateUser(int id, User userUpdate)
            throws Exception, IllegalArgumentException;
}
