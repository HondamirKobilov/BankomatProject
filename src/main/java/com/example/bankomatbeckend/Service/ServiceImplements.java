package com.example.bankomatbeckend.Service;
import com.example.bankomatbeckend.DTO.ApiResponse;
import com.example.bankomatbeckend.DTO.BankomatDTO.*;
import com.example.bankomatbeckend.DTO.KartaDTO.*;
import com.example.bankomatbeckend.DTO.LoginDto;
import com.example.bankomatbeckend.Entity.Abstrakt.LavozimConstanta;
import com.example.bankomatbeckend.Entity.BankomatEntity.*;
import com.example.bankomatbeckend.Entity.Enum.MijozStatus;
import com.example.bankomatbeckend.Entity.KartaEntity.*;
import com.example.bankomatbeckend.Repository.BankomatRepository.*;
import com.example.bankomatbeckend.Repository.KatraRepository.*;
import com.example.bankomatbeckend.Repository.ManzilRepository;
import com.example.bankomatbeckend.Token.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ServiceImplements implements LoyihalashService, UserDetailsService {

    @Autowired
    BankRepository bankRepository;

    @Autowired
    ManzilRepository manzilRepository;

    @Autowired
    KartaTuriRepository kartaTuriRepository;

    @Autowired
    KartaRepository katraRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    MuddatRepository muddatRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    LavozimRepository lavozimRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TokenGenerator tokenGenerator;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    HisobotRepositoriy hisobotRepositoriy;


    @Override
    public ApiResponse postBank(BankDto bankDto) {
        boolean b1 = manzilRepository.existsByViloyatAndTumanAndKocha(bankDto.getViloyat(), bankDto.getTuman(), bankDto.getKocha());
        boolean b = bankRepository.existsByNomi(bankDto.getNomi());
        if((!b1 && !b) || (b1 && !b) || (!b1 && b)){
                Manzil manzil=new Manzil();
                manzil.setViloyat(bankDto.getViloyat());
                manzil.setTuman(bankDto.getTuman());
                manzil.setKocha(bankDto.getKocha());
                manzilRepository.save(manzil);
                Bank bank=new Bank();
                bank.setNomi(bankDto.getNomi());
                bank.setManzil(manzil);
                bankRepository.save(bank);
                return new ApiResponse("Ma'lumotlar saqlandi",true);
        }
       return new ApiResponse("Bu manzilda siz yaratmoqchi bo'lgan Bank mavjud!!",false);
    }

    @Override
    public ApiResponse kartaTuriPost(KartaTuriDto kartaTuriDto) {
        boolean b = kartaTuriRepository.existsByNomi(kartaTuriDto.getNomi());
        if(!b){
            KartaTuri kartaTuri=new KartaTuri();
            kartaTuri.setNomi(kartaTuriDto.getNomi());
            kartaTuri.setBoshlanishKodi(kartaTuriDto.getBoshlanishKodi());
            kartaTuriRepository.save(kartaTuri);
            return new ApiResponse("Ma'lumotlar saqlandi",true);
        }
        return new ApiResponse("Bunday nomli karta mavjud!",false);
    }


    @Override
    public ApiResponse kartaPost(KartaDto kartaDto, Integer bankId, Integer kartaTuriId, Integer muddatId) {
//        Optional<Bank> byId = bankRepository.findById(bankId);
//        if(byId.isPresent()){
//            Optional<KartaTuri> byId1 = kartaTuriRepository.findById(kartaTuriId);
//            if(byId1.isPresent()){
//                Optional<Muddat> byId2 = muddatRepository.findById(muddatId);
//                if(byId2.isPresent()){
//                    //Random rand = new Random();
//                    Karta karta=new Karta();
//
//                    long smallest = 1000_0000_00L;
//                    long biggest =  9999_9999_99L;
//                    long random = ThreadLocalRandom.current().nextLong(smallest, biggest+1);
//
//                    if(kartaTuriId==1){
//                        String kartaRaqam="986001";
//                        karta.setMaxsusRaqam(Long.parseLong(kartaRaqam+random));
//                    }
//                    if(kartaTuriId==2){
//                        String kartaRaqam1="860002";
//                        karta.setMaxsusRaqam(Long.parseLong(kartaRaqam1+random));
//                    }
//                    karta.setBalans(kartaDto.getBalans());
//                    karta.setPinKod(kartaDto.getPinKod());
//                    karta.setMaxsusRaqam(kartaDto.getMaxsusParoli4());
//                    karta.setBank(byId.get());
//                    karta.setKatraTuri(byId1.get());
//                    karta.setMuddat(byId2.get());
//                    boolean a = usersRepository.existsByEmail(kartaDto.getEmail());
//                    if(!a){
//                        Manzil manzil=new Manzil();
//                        manzil.setViloyat(kartaDto.getViloyat());
//                        manzil.setTuman(kartaDto.getTuman());
//                        manzil.setKocha(kartaDto.getKocha());
//                        manzilRepository.save(manzil);
//                        Users users=new Users();
//                        users.setFish(kartaDto.getFish());
//                        users.setEmail(kartaDto.getEmail());
//                        users.setTelRaqam(kartaDto.getTelRaqam());
//                        users.setManzil(manzil);
//                        usersRepository.save(users);
//                        karta.setUsers(users);
//                        katraRepository.save(karta);
//                        return new ApiResponse("Ma'lumotlar muvaffaqiyatli bazaga joylandi",true);
//                   }
//                    return new ApiResponse("Bunday foydalanuvchi bazada mavjud!!!",false);
//                }
//                return new ApiResponse("Bunday muddat mavjud emas!!!",false);
//            }
//          return new ApiResponse("Bunday karta turi bazada mavjud emas!!!",false);
//        }
//        return  new ApiResponse("Bunday bank mavjud emas!!!",false);
        return null;
    }


    @Override
    public ApiResponse addMuddat(MuddatDto muddatDto, Integer bankId, Integer kartaTuriId) {
        boolean b = muddatRepository.existsByBankIdAndKartaTuriIdAndMuddati(bankId,kartaTuriId, muddatDto.getMuddat());
        if(!b){
            Muddat muddat=new Muddat();
            muddat.setMuddati(muddatDto.getMuddat());
            Optional<Bank> byId = bankRepository.findById(bankId);
            if(byId.isPresent()){
                muddat.setBank(byId.get());
                Optional<KartaTuri> byId1 = kartaTuriRepository.findById(kartaTuriId);
                if(byId1.isPresent()){
                    muddat.setKartaTuri(byId1.get());
                    muddatRepository.save(muddat);
                    return new ApiResponse("Saqlandi",true);
                }
                return new ApiResponse("Bunday karta turi mavjud emas!!!",false);
            }
            return new ApiResponse("Bunday Bank mavjud emas!!!",false);
        }
        return new ApiResponse("Bunday muddat allaqachon bazaga qo'shilgan!!!",false);
    }


    @Override
    public ApiResponse kartaAdd(KartaMijozDto kartaMijozDto, Integer muddatId) {
        if(kartaMijozDto.getMijozStatus().equals(MijozStatus.ADD) && !usersRepository.existsByPassportRaqam(kartaMijozDto.getUsers().getPassportRaqam())){
            Manzil manzil=new Manzil(kartaMijozDto.getManzil().getViloyat(),kartaMijozDto.getManzil().getTuman(),kartaMijozDto.getManzil().getKocha());
            manzilRepository.save(manzil);
            boolean b = usersRepository.existsByTelRaqamAndEmail(kartaMijozDto.getUsers().getTelRaqam(), kartaMijozDto.getUsers().getEmail());
            if(b) return new ApiResponse("Bunday telRaqam va Email bazada mavjud",false);
            Users users=new Users(kartaMijozDto.getUsers().getFish(),kartaMijozDto.getUsers().getTelRaqam(),kartaMijozDto.getUsers().getEmail(),kartaMijozDto.getUsers().getPassportRaqam(),manzil);
            usersRepository.save(users);
            Karta karta=new Karta();
            long code=new Random().nextInt(99999);
            long code1=new Random().nextInt(99999);
            Optional<Muddat> byId = muddatRepository.findById(muddatId);
            karta.setMaxsusRaqam(byId.get().getKartaTuri().getBoshlanishKodi()+code+code1);
            karta.setPinKod(kartaMijozDto.getPinKod());
            karta.setUsers(users);
            karta.setMuddat(LocalDate.now().plusYears(byId.get().getMuddati()));
            Optional<Bank> byId1 = bankRepository.findById(byId.get().getBank().getId());
            karta.setBank(byId1.get());
            Optional<KartaTuri> byId2 = kartaTuriRepository.findById(byId.get().getKartaTuri().getId());
            karta.setKatraTuri(byId2.get());
            katraRepository.save(karta);
            return new ApiResponse("Ma'lumotlar saqlandi!",true);
        }
        if(kartaMijozDto.getMijozStatus().equals(MijozStatus.EDIT) && usersRepository.existsByPassportRaqam(kartaMijozDto.getUsers().getPassportRaqam())){
            Optional<Users> byPassportRaqam = usersRepository.findByPassportRaqam(kartaMijozDto.getUsers().getPassportRaqam());
            Users users = byPassportRaqam.get();
            Karta karta=new Karta();
            long code=new Random().nextInt(99999);
            long code1=new Random().nextInt(99999);
            Optional<Muddat> byId = muddatRepository.findById(muddatId);
            karta.setMaxsusRaqam(byId.get().getKartaTuri().getBoshlanishKodi()+code+code1);
            karta.setPinKod(kartaMijozDto.getPinKod());
            karta.setUsers(users);
            karta.setMuddat(LocalDate.now().plusYears(byId.get().getMuddati()));
            Optional<Bank> byId1 = bankRepository.findById(byId.get().getBank().getId());
            karta.setBank(byId1.get());
            Optional<KartaTuri> byId2 = kartaTuriRepository.findById(byId.get().getKartaTuri().getId());
            karta.setKatraTuri(byId2.get());
            katraRepository.save(karta);
            return new ApiResponse("Yangi karta qo'shildi!",true);

        }
        return new ApiResponse("Bunday foydalanuvchi bazada mavjud!!!",false);
    }

    @Autowired
    XodimRepository xodimRepository;


    @Override
    public ApiResponse xodimRegistor(XodimDto xodimDto) {
        if(xodimRepository.existsByUsername(xodimDto.getUsername()))
            return new ApiResponse("Bunday username ro'yhatdan o'tkazilgan!!",false);

        if(xodimRepository.existsByTelRaqam(xodimDto.getTelRaqam()))
            return new ApiResponse("Bunday telefon raqam oldin ro'yxatdan o'tkazilgan", false);

        if(xodimDto.getPassword().equals(xodimDto.getRepassword())){
            Manzil manzil=new Manzil(xodimDto.getManzil().getViloyat(),xodimDto.getManzil().getTuman(),xodimDto.getManzil().getKocha());
            manzilRepository.save(manzil);
            Xodim xodim=new Xodim();
            xodim.setFish(xodimDto.getFish());
            xodim.setUsername(xodimDto.getUsername());
            xodim.setPassword(passwordEncoder.encode(xodimDto.getPassword()));
            xodim.setTelRaqam(xodimDto.getTelRaqam());
            xodim.setLavozim(lavozimRepository.findByNomi(LavozimConstanta.XODIM).get());
            xodim.setManzil(manzil);
            String code= UUID.randomUUID().toString().substring(0,6);
            xodim.setEmailKod(code);
            boolean b=XabarYuborish(xodimDto.getUsername(),code);
            if(b){
                xodimRepository.save(xodim);
                return new ApiResponse("Ro'yxatdan o'tdingiz, Hisobni faollashtirish uchun emailga xabar yuborildi",true);
            }
            return new ApiResponse("Email adresingizda xatolik mavjud. Qayta tekshirib urinib ko'ring!", false);
        }
        return new ApiResponse("Parollar mos emas!!!",false);
    }



    public boolean XabarYuborish(String email, String emailkod){
        try {
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setTo(email);
            simpleMailMessage.setFrom("hondamirkobilov02@gmail.com");
            simpleMailMessage.setSubject("Tasdiqlash kodi: ");
            simpleMailMessage.setText("<a href='http://localhost:8080/Users/tasdiqlash?email="+email+"&emailkod="+emailkod+"'>Emailni tasdiqlash</a>");
            javaMailSender.send(simpleMailMessage);
            return true;
        }
        catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }

    public ApiResponse Faollashtirish(String email, String emailkod) {
        Optional<Xodim> byUsernameAndEmailKod = xodimRepository.findByUsernameAndEmailKod(email, emailkod);
        if (byUsernameAndEmailKod.isPresent()){
            Xodim xodim = byUsernameAndEmailKod.get();
            xodim.setEmailKod(null);
            xodim.setEnabled(true);
            xodimRepository.save(xodim);
            return new ApiResponse("Hisobingiz muvoffaqiyatli faollashtirildi", true);
        }
        return new ApiResponse("Siz hisobni oldin faollashtirgansiz", false);
    }

    @Override
    public ApiResponse XodimLogin(LoginDto loginDto) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
        if (authenticate.isAuthenticated()){
            Optional<Xodim> byUsernameAndEmailKod = xodimRepository.findByUsernameAndEmailKod(loginDto.getUsername(), null);
            if (byUsernameAndEmailKod.isPresent()){
                Xodim principal = (Xodim) authenticate.getPrincipal();
                return new ApiResponse("Profilga xush kelibsiz "+byUsernameAndEmailKod.get().getFish()+"!\n"+tokenGenerator.TokenOlish(principal.getUsername(), principal.getLavozim()),true);
            }
            return new ApiResponse("Accountingiz faollashtirilmagan", false);
        }
        return new ApiResponse("Login yoki parol xato", false);
    }


    public UserDetails loadUserByUsername(String username) {
        Optional<Xodim> byUsername = xodimRepository.findByUsername(username);
        if (byUsername.isPresent()){
            return byUsername.get();
        }
        throw new UsernameNotFoundException("Bunday foydalanuvchi mavjud emas");
    }

//Lavozimlar

    @Override
    public ApiResponse LavozimAdd(LavozimDto lavozimDto) {
        boolean b = lavozimRepository.existsByNomi(lavozimDto.getNomi());
        if(b){
            return new ApiResponse("Bunday lavozim avval yaratilgan!!!",false);
        }
        Lavozim lavozim=new Lavozim(
                lavozimDto.getNomi(),
                lavozimDto.getIzoh(),
                lavozimDto.getXuquqlarList()
        );
        lavozimRepository.save(lavozim);
        return new ApiResponse("Lavozim muvaffaqiyatli qo'shildi!",true);
    }

    @Autowired
    KommissiyaRepositary kommissiyaRepositary;

    @Override
    public ApiResponse AddKommissiya(KommissiyaDto kommissiyaDto, Integer bankId, Integer kartaTurId) {
        boolean b = kommissiyaRepositary.existsByBankIdAndKartaTuriId(bankId, kartaTurId);
        if(b) return new ApiResponse("Bu bankda bunday karta turi mavjud",false);
        Optional<Bank> byId = bankRepository.findById(bankId);
        if(byId.isPresent()){
            Optional<KartaTuri> byId1 = kartaTuriRepository.findById(kartaTurId);
            if(byId1.isPresent()){
                Kommissiya kommissiya=new Kommissiya();
                kommissiya.setFoiz(kommissiyaDto.getFoiz());
                kommissiya.setBank(byId.get());
                kommissiya.setKartaTuri(byId1.get());
                kommissiyaRepositary.save(kommissiya);
                return new ApiResponse("Ma'lumotlar saqlandi",true);
            }
            return new ApiResponse("Bunday Karta turi mavjud emas!!!",false);
        }
        return new ApiResponse("Bunday bank mavjud emas!!",false);

    }


    @Autowired
    KupuyraRepository kupuyraRepository;

    @Override
    public ApiResponse KupuraSoniAdd(KupuyraDto kupuyraDto) {
        Kupyura kupyura=new Kupyura();
        kupyura.setMing5(kupuyraDto.getMing5());
        kupyura.setMing10(kupuyraDto.getMing10());
        kupyura.setMing20(kupuyraDto.getMing20());
        kupyura.setMing50(kupuyraDto.getMing50());
        kupyura.setMing100(kupuyraDto.getMing100());
        kupyura.setMing200(kupuyraDto.getMing200());
        kupuyraRepository.save(kupyura);
        return new ApiResponse("Kupuyralar soni saqlandi!!",true);
    }

    @Override
    public ApiResponse KupuraSoniEdit(KupuyraDto kupuyraDto, Integer id, Integer xodimId, Integer bankomatId) {
        Optional<Bankomat> byId1 = bankomatRepository.findById(bankomatId);
        Optional<Xodim> byId = xodimRepository.findById(xodimId);
        Optional<Kupyura> byId3 = kupuyraRepository.findById(id);
        if(byId1.isPresent()){
            if (byId.isPresent()){
                Optional<Bankomat> byId2 = bankomatRepository.findById(bankomatId);
                Bankomat bankomat = byId2.get();
                Double summa = null;
                Kupyura kupyura= byId3.get();
                kupyura.setMing5(kupuyraDto.getMing5());
                summa=summa+kupyura.getMing5()*5000;
                kupyura.setMing10(kupuyraDto.getMing10());
                summa=summa+kupyura.getMing10()*10000;
                kupyura.setMing20(kupuyraDto.getMing20());
                summa=summa+kupyura.getMing20()*20000;
                kupyura.setMing50(kupuyraDto.getMing50());
                summa=summa+kupyura.getMing50()*50000;
                kupyura.setMing100(kupuyraDto.getMing100());
                summa=summa+kupyura.getMing100()*100000;
                kupyura.setMing200(kupuyraDto.getMing200());
                summa=summa+kupyura.getMing200()*200000;
                kupuyraRepository.save(kupyura);
                bankomat.setBalans(Double.valueOf(summa));
                bankomatRepository.save(bankomat);
                return new ApiResponse("Kupuyralar soni tahrirlandi!!!",true);
            }
            return new ApiResponse("Bunday idli xodim mavjud emas!!!",false);
        }
        return new ApiResponse("Bunday idli bankomat mavjud emas!!!",false);
    }

    @Autowired
    BankomatRepository bankomatRepository;

    @Autowired
    BankomatAndKartaTurRepository bankomatAndKartaTurRepository;

    @Override
    public ApiResponse addBankomat(BankomatDto bankomatDto, Integer xodimId, Integer bankId) {
        boolean b = manzilRepository.existsByViloyatAndTumanAndKocha(bankomatDto.getManzil().getViloyat(), bankomatDto.getManzil().getTuman(), bankomatDto.getManzil().getKocha());
        Optional<Bankomat> byId2 = bankomatRepository.findById(bankId);
        Optional<Bank> byId3 = bankRepository.findById(bankId);
        if((!byId2.isPresent() && !b) || (byId2.isPresent() && !b) || (!byId2.isPresent() && b)){
            Manzil manzil=new Manzil(bankomatDto.getManzil().getViloyat(),bankomatDto.getManzil().getTuman(),bankomatDto.getManzil().getKocha());
            manzilRepository.save(manzil);
            Kupyura kupyura = new Kupyura(
                    bankomatDto.getKupyura().getMing200(),
                    bankomatDto.getKupyura().getMing100(),
                    bankomatDto.getKupyura().getMing50(),
                    bankomatDto.getKupyura().getMing20(),
                    bankomatDto.getKupyura().getMing10(),
                    bankomatDto.getKupyura().getMing5()
            );
            kupuyraRepository.save(kupyura);
            Optional<Xodim> byId = xodimRepository.findById(xodimId);
            if(byId.isPresent()){
                Bankomat bankomat = new Bankomat();
                bankomat.setMaxPulMiqdori(bankomatDto.getMaxPulMiqdor());
                bankomat.setMaxPulYechish(bankomatDto.getMaxPulYechish());
                bankomat.setMinPulYechish(bankomatDto.getMinPulYechish());
                bankomat.setHisobotChegara(bankomatDto.getHisobotChegara());
                bankomat.setIkkiYuzMing(kupyura.getMing200());
                bankomat.setYuzMing(kupyura.getMing100());
                bankomat.setEllikMing(kupyura.getMing50());
                bankomat.setYigirmaMing(kupyura.getMing20());
                bankomat.setOnMing(kupyura.getMing10());
                bankomat.setBeshMing(kupyura.getMing5());
                bankomat.setBalans((kupyura.getMing5()*5000+kupyura.getMing10()*10000+kupyura.getMing20()*20000+kupyura.getMing50()*50000+kupyura.getMing100()*100000+kupyura.getMing200()*200000));
                bankomat.setManzil(manzil);
                bankomat.setKupyura(kupyura);
                bankomat.setXodim(byId.get());
                bankomat.setBank(byId3.get());
                Bankomat save = bankomatRepository.save(bankomat);
                for(Integer kartaTuriId:bankomatDto.getKartaTuri()){
                    Optional<KartaTuri> byId1 = kartaTuriRepository.findById(kartaTuriId);
                    if(byId1.isPresent()){
                        BankomatAndKartaTurId bankomatAndKartaTurId = new BankomatAndKartaTurId();
                        bankomatAndKartaTurId.setBankomat(save);
                        bankomatAndKartaTurId.setKartaTuri(byId1.get());
                        bankomatAndKartaTurRepository.save(bankomatAndKartaTurId);
                    }
                }
                return new ApiResponse("Ma'lumotlar mavaffaqiyatli saqlandi!",true);
            }
            return new ApiResponse("Bunday xodim mavjud emas!!!",false);
        }
        return new ApiResponse("Bu manzilda siz yaratmoqchi bo'lgan Bankomat mavjud!!",false);
    }


//    @Override
//    public ApiResponse AddBalansBankomat(BalansDto balansDto, Integer bankomatId) {
//        Optional<Bankomat> byId = bankomatRepository.findById(bankomatId);
//        if(byId.isPresent()){
//            Bankomat bankomat=byId.get();
//            bankomat.setBalans(balansDto.getBalans());
//            return new ApiResponse("Bankomatga balans qo'shildi",true);
//        }
//        return new ApiResponse("Bunday Bankomat mavjud emas!!!",false);
//    }

    @Override
    public ApiResponse KartaBalansAdd(BalansKartaDto balansKartaDto) {
        Optional<Karta> byMaxsusRaqam = katraRepository.findByMaxsusRaqam(balansKartaDto.getMaxsusRaqam());
        if(byMaxsusRaqam.isPresent()){
            Karta karta=byMaxsusRaqam.get();
            karta.setBalans(karta.getBalans()+balansKartaDto.getBalans());
            katraRepository.save(karta);
            return  new ApiResponse("Hisobingiz to'ldirildi",true);
        }
        return new ApiResponse("Bunday karta raqam mavjud emas",false);
    }
    @Override
    public ApiResponse BankomatPulYechish(Integer bankomatId, PulYechishDto pulYechishDto) {
        Optional<Karta> byRaqamiAndPinKod = katraRepository.findByMaxsusRaqamAndPinKod(pulYechishDto.getMaxsusRaqam(), pulYechishDto.getPinKod());
        Optional<Bankomat> byId = bankomatRepository.findById(bankomatId);
        Bankomat bankomat=byId.get();
        if(byRaqamiAndPinKod.isPresent()){
            LocalDate date=LocalDate.now();
            if(!date.equals(pulYechishDto.getMuddat())){
                Optional<BankomatAndKartaTurId> byBankomatIdAndKartaTuriId = bankomatAndKartaTurRepository.findByBankomatIdAndKartaTuriId(bankomatId, byRaqamiAndPinKod.get().getKatraTuri().getId());
                if(byBankomatIdAndKartaTuriId.isPresent()){
                    Karta karta=byRaqamiAndPinKod.get();
                    if(bankomat.getBalans()>pulYechishDto.getSumma() ) {
                        if (bankomat.getMaxPulYechish()>pulYechishDto.getSumma() && pulYechishDto.getSumma()>bankomat.getMinPulYechish()){
                            boolean holat=true;
                            double sum=0;
                            while (holat){
                                if (bankomat.getIkkiYuzMing()>0 && pulYechishDto.getSumma()>=200000 && pulYechishDto.getSumma()<=karta.getBalans()){
                                    bankomat.setBalans(bankomat.getBalans()-200000);
                                    pulYechishDto.setSumma(pulYechishDto.getSumma()-200000);
                                    bankomat.setIkkiYuzMing(bankomat.getIkkiYuzMing()-1);
                                    karta.setBalans(karta.getBalans()-200000);
                                    sum+=200000;
                                }
                                else {
                                    holat=false;
                                }
                            }
                            holat=true;
                            while (holat){
                                if (bankomat.getYuzMing()>0 && pulYechishDto.getSumma()>=100000 && pulYechishDto.getSumma()<=karta.getBalans()){
                                    bankomat.setBalans(bankomat.getBalans()-100000);
                                    pulYechishDto.setSumma(pulYechishDto.getSumma()-100000);
                                    bankomat.setYuzMing(bankomat.getYuzMing()-1);
                                    karta.setBalans(karta.getBalans()-100000);
                                    sum+=100000;
                                }
                                else {
                                    holat=false;
                                }
                            }
                            holat=true;
                            while (holat){
                                if (bankomat.getEllikMing()>0 && pulYechishDto.getSumma()>=50000 && pulYechishDto.getSumma()<=karta.getBalans()){
                                    bankomat.setBalans(bankomat.getBalans()-50000);
                                    pulYechishDto.setSumma(pulYechishDto.getSumma()-50000);
                                    bankomat.setEllikMing(bankomat.getEllikMing()-1);
                                    karta.setBalans(karta.getBalans()-50000);
                                    sum+=50000;
                                }
                                else {
                                    holat=false;
                                }
                            }
                            holat=true;
                            while (holat){
                                if (bankomat.getYigirmaMing()>0 && pulYechishDto.getSumma()>=20000 && pulYechishDto.getSumma()<=karta.getBalans()){
                                    bankomat.setBalans(bankomat.getBalans()-20000);
                                    pulYechishDto.setSumma(pulYechishDto.getSumma()-20000);
                                    bankomat.setYigirmaMing(bankomat.getYigirmaMing()-1);
                                    karta.setBalans(karta.getBalans()-20000);
                                    sum+=20000;
                                }
                                else {
                                    holat=false;
                                }
                            }
                            holat=true;
                            while (holat){
                                if (bankomat.getOnMing()>0 && pulYechishDto.getSumma()>=10000 && pulYechishDto.getSumma()<=karta.getBalans()){
                                    bankomat.setBalans(bankomat.getBalans()-10000);
                                    pulYechishDto.setSumma(pulYechishDto.getSumma()-10000);
                                    bankomat.setOnMing(bankomat.getOnMing()-1);
                                    karta.setBalans(karta.getBalans()-10000);
                                    sum+=10000;
                                }
                                else {
                                    holat=false;
                                }
                            }
                            holat=true;
                            while (holat){
                                if (bankomat.getBeshMing()>0 && pulYechishDto.getSumma()>=5000 && pulYechishDto.getSumma()<=karta.getBalans()){
                                    bankomat.setBalans(bankomat.getBalans()-5000);
                                    pulYechishDto.setSumma(pulYechishDto.getSumma()-5000);
                                    bankomat.setBeshMing(bankomat.getBeshMing()-1);
                                    karta.setBalans(karta.getBalans()-5000);
                                    sum+=5000;
                                }
                                else {
                                    holat=false;
                                }
                            }
                            String nomi = byRaqamiAndPinKod.get().getBank().getNomi().toLowerCase();
                            String nomi1 = bankomat.getBank().getNomi().toLowerCase();
                            if (nomi==nomi1){
                                karta.setBalans(karta.getBalans()-(sum * 0.5) / 100);
                            }
                            else {
                                karta.setBalans(karta.getBalans()-(sum * 1) / 100);
                            }
                            katraRepository.save(karta);
                            bankomatRepository.save(bankomat);
                            if (bankomat.getBalans() < bankomat.getHisobotChegara()) {
                                xabarYuborish("hondamirkobilov02@gmail.com");
                                return new ApiResponse("Bankomatda pul kam qoldi hisob chegarasidan kam qoldi!!!",false);
                            }
                            return new ApiResponse(" so'm Pul muvaffaqiyatli yechildi", true);
                        }
                        return new ApiResponse("siz kiritilgan qiymat minimaldan kichik yoki maxsimaldan katta bo'lishi mumkin!!!",false);
                    }
                    return new ApiResponse("Bankomatda pul qolmadi yoki siz kiritgan summadan kam mablag' qoldi!!!",false);
                }
                return new ApiResponse("Bunday kartaga bankomat xizmat ko'rsatmaydi",false);
            }
            return new ApiResponse("Kartani muddati tugagan",false);
        }
        return new ApiResponse("Bunday karta bazada mavjud emas",false);
    }


    public boolean xabarYuborish(String email){
        try {
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setTo(email);
            simpleMailMessage.setFrom("hondamirkobilov02@gmail.com");
            simpleMailMessage.setSubject("Tasdiqlash kodi: ");
            simpleMailMessage.setText("<a href='http://localhost:8080/Xisobot>Bankomatda 1mlndan kam mablag' qoldi</a>");
            javaMailSender.send(simpleMailMessage);
            return true;
        }
        catch (Exception e){
            e.getStackTrace();
            return false;
        }
    }

    public ApiResponse pulQuyish(Integer bankomatId, Integer xodimId, PulQuyishDTO pulQuyishDto) {
        Optional<Bankomat> byIdAndXodimId = bankomatRepository.findByIdAndXodimId(bankomatId, xodimId);
        LocalDateTime localDateTime=LocalDateTime.now();
        if(!byIdAndXodimId.isPresent()){
            return new ApiResponse("Bu xodim bankomatga xizmat ko'rsatmaydi",false);
        }
        else {
            Bankomat bankomat=byIdAndXodimId.get();
            double v = pulQuyishDto.getSumma() + bankomat.getBalans();
            if (v<=bankomat.getMaxPulMiqdori()){
                bankomat.setBalans(bankomat.getBalans()+pulQuyishDto.getSumma());
                bankomat.setIkkiYuzMing(bankomat.getKupyura().getMing200());
                bankomat.setYuzMing(bankomat.getKupyura().getMing100());
                bankomat.setEllikMing(bankomat.getKupyura().getMing50());
                bankomat.setYigirmaMing(bankomat.getKupyura().getMing20());
                bankomat.setOnMing(bankomat.getKupyura().getMing10());
                bankomat.setBeshMing(bankomat.getKupyura().getMing5());
                Optional<Xodim> xodim=xodimRepository.findById(xodimId);
                Hisobot hisobot=new Hisobot(
                        pulQuyishDto.getSumma(),
                        localDateTime,
                        xodim.get(),
                        bankomat
                );
                hisobotRepositoriy.save(hisobot);
                bankomatRepository.save(bankomat);
                return new ApiResponse("Bankomat muvaffaqiyatli to'ldirildi",true);
            }
            return new ApiResponse("Siz tuldirmoqchi bo'lgan summa ortib qoladi!!!",false);
        }
    }



    public ApiResponse korish(Integer bankomatId, Integer xodimId) {
        Optional<Bankomat> byIdAndXodimId = bankomatRepository.findByIdAndXodimId(bankomatId, xodimId);
        if(!byIdAndXodimId.isPresent())
            return new ApiResponse("Bu xodim bankomatga xizmat ko'rsatmaydi",false);
        else
        {
            Bankomat bankomat=byIdAndXodimId.get();
            return new ApiResponse("Bankomatdagi pul miqdori:"+bankomat.getMaxPulMiqdori()+"\n"+
                    "Qolgan pul miqdori:"+bankomat.getBalans()+"\n"+
                    "200 ming soni:"+ bankomat.getIkkiYuzMing()+"  Hajmi:"+bankomat.getIkkiYuzMing()*200000+"\n"+
                    "100 ming soni:"+bankomat.getYuzMing()+"  Hajmi:"+bankomat.getYuzMing()*100000+"\n"+
                    "50 ming soni:"+bankomat.getEllikMing()+"  Hajmi:"+bankomat.getEllikMing()*50000+"\n"+
                    "20 ming soni:"+bankomat.getYigirmaMing()+"  Hajmi:"+bankomat.getYigirmaMing()*20000+"\n"+
                    "10 ming soni:"+bankomat.getOnMing()+"  Hajmi:"+bankomat.getOnMing()*10000+"\n"+
                    "5 ming soni:"+bankomat.getBeshMing()+"  Hajmi:"+bankomat.getBeshMing()*5000+"",true);
        }
    }

    public ApiResponse readBankomat(Integer id) {
        Optional<Bankomat> byId = bankomatRepository.findById(id);
        if (byId.isPresent()){
            Bankomat bankomat = byId.get();
            return new ApiResponse(bankomat.toString(),true);
        }
        return new ApiResponse("Bunday idli bankomat mavjud emas!!!",false);
    }
}



