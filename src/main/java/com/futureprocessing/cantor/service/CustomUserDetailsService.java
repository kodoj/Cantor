package com.futureprocessing.cantor.service;

import com.futureprocessing.cantor.model.CustomUserDetails;
import com.futureprocessing.cantor.model.User;
import com.futureprocessing.cantor.model.UserRegistrationDto;
import com.futureprocessing.cantor.model.Wallet;
import com.futureprocessing.cantor.repository.UsersRepository;
import com.futureprocessing.cantor.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override //Email is unique, so I'm using it as an account name
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("We could not find this Account"));
        return optionalUser.map(CustomUserDetails::new).get();
    }

    public User save(UserRegistrationDto userRegistrationDto) {
        User user = new User();
        user.setWalletId(createUserWalletId(userRegistrationDto));
        user.setName(userRegistrationDto.getFirstName());
        user.setSurname(userRegistrationDto.getSurname());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(userRegistrationDto.getPassword());

        return usersRepository.save(user);
    }

    private int createUserWalletId(UserRegistrationDto userRegistrationDto) {
        Wallet wallet = new Wallet();
        wallet.setUSD(userRegistrationDto.getUSD());
        wallet.setEUR(userRegistrationDto.getEUR());
        wallet.setCHF(userRegistrationDto.getCHF());
        wallet.setRUB(userRegistrationDto.getRUB());
        wallet.setCZK(userRegistrationDto.getCZK());
        wallet.setGBP(userRegistrationDto.getGBP());
        wallet.setPLN(userRegistrationDto.getPLN());

        return saveWallet(wallet);
    }

    private int saveWallet(Wallet wallet) {
        Wallet.walletIdTrackerPlusOne();
        walletRepository.save(wallet);

        return Wallet.getWalletIdTracker();
    }
}
