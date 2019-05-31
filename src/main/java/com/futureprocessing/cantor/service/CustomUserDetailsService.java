package com.futureprocessing.cantor.service;

import com.futureprocessing.cantor.model.*;
import com.futureprocessing.cantor.repository.UserRolesRepository;
import com.futureprocessing.cantor.repository.UsersRepository;
import com.futureprocessing.cantor.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Override //Email is unique, so I'm using it as an account name
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("We could not find this Account"));
        return optionalUser.map(CustomUserDetails::new).get();
    }

    public void saveUser(User user) {
        usersRepository.save(user);
    }

    public void saveUserWithRole(UserRegistrationDto userRegistrationDto) {
        User currentUser = addUserToDatabase(userRegistrationDto);
        UserRoles userRoles = new UserRoles();
        userRoles.setUser_id(currentUser.getId());
        userRoles.setRoleId(1);
        userRolesRepository.save(userRoles);
    }

    public void updateUserWallet(Wallet wallet, UserDetails currentUser) {
        User userToUpdate = (User) loadUserByUsername(currentUser.getUsername());
        Wallet newWallet = prepareWallet(wallet, userToUpdate);
        usersRepository.save(prepareUser(userToUpdate, newWallet));
    }

    private User prepareUser(User userToUpdate, Wallet newWallet) {
        User newUser = new User();
        newUser.setWallet(newWallet);
        newUser.setName(userToUpdate.getName());
        newUser.setSurname(userToUpdate.getSurname());
        newUser.setEmail(userToUpdate.getEmail());
        newUser.setPassword(userToUpdate.getPassword());
        newUser.setActive(userToUpdate.isActive());
        newUser.setId(userToUpdate.getId());
        newUser.setRoles(userToUpdate.getRoles());
        return newUser;
    }

    private Wallet prepareWallet(Wallet wallet, User userToUpdate) {
        Wallet newWallet = userToUpdate.getWallet();
        newWallet.setPLN(wallet.getPLN());
        newWallet.setUSD(wallet.getUSD());
        newWallet.setEUR(wallet.getEUR());
        newWallet.setCHF(wallet.getCHF());
        newWallet.setRUB(wallet.getRUB());
        newWallet.setCZK(wallet.getCZK());
        newWallet.setGBP(wallet.getGBP());
        return newWallet;
    }

    private User addUserToDatabase(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setWallet(saveUserWallet(userRegistrationDto));
        user.setName(userRegistrationDto.getFirstName());
        user.setSurname(userRegistrationDto.getSurname());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(userRegistrationDto.getPassword());

        return usersRepository.save(user);
    }

    private Wallet saveUserWallet(UserRegistrationDto userRegistrationDto) {
        Wallet wallet = new Wallet();
        wallet.setUSD(new BigDecimal(userRegistrationDto.getUsd()));
        wallet.setEUR(new BigDecimal(userRegistrationDto.getEur()));
        wallet.setCHF(new BigDecimal(userRegistrationDto.getChf()));
        wallet.setRUB(new BigDecimal(userRegistrationDto.getRub()));
        wallet.setCZK(new BigDecimal(userRegistrationDto.getCzk()));
        wallet.setGBP(new BigDecimal(userRegistrationDto.getGbp()));
        wallet.setPLN(new BigDecimal(userRegistrationDto.getPln()));

        return walletRepository.save(wallet);
    }
}
