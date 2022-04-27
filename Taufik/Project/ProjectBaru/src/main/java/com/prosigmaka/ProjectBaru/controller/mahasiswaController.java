package com.prosigmaka.ProjectBaru.controller;

import com.prosigmaka.ProjectBaru.Repository.Mahasiswarepo;
import com.prosigmaka.ProjectBaru.model.dto.DefaultResponse;
import com.prosigmaka.ProjectBaru.model.dto.MahasiswaDto;
import com.prosigmaka.ProjectBaru.model.entity.Mahasiswa;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/home")
public class mahasiswaController {
    private final Mahasiswarepo mahasiswarepo;

    public mahasiswaController(Mahasiswarepo mahasiswarepo) {
        this.mahasiswarepo = mahasiswarepo;
    }


    @GetMapping("/Daftar/M")
    public List<MahasiswaDto> getlist(){
        MahasiswaDto m = new MahasiswaDto();
        MahasiswaDto n = new MahasiswaDto();
        m.setNama("Andi");
        m.setAlamat("cirebon");
        n.setAlamat("bandung");
        n.setNama("agus");
        //MahasiswaDto mm;
        List<MahasiswaDto> l=new ArrayList<>();
        l.add(m);
        l.add(n);
        return l;

    }
    @PostMapping("/login")//methode buat login
    public DefaultResponse<MahasiswaDto> loginstatus(@RequestBody MahasiswaDto mahasiswaDto){
        Mahasiswa mahasiswa=convertDtoToEntity(mahasiswaDto);
        DefaultResponse<MahasiswaDto>responselogin=new DefaultResponse<>();
        Optional<Mahasiswa>optional=mahasiswarepo.findById(mahasiswa.getNIM());
        if(optional.isPresent()){
        responselogin.setMassage("login berhasil! untuk menu berikutnya diakhir alamat host tambahkan /sukseslogin");
        responselogin.setData(convertEntityToDto(mahasiswa));

        }else{
            responselogin.setMassage("login gagal,silahakn masukan id yang benar atau silahkan registrasi");
            responselogin.setData(null);
        }
        return responselogin;
    }
    public List<MahasiswaDto>listdata(){
        List<MahasiswaDto>list=new ArrayList<MahasiswaDto>();
        for(Mahasiswa m :mahasiswarepo.findAll()){
            list.add(convertEntityToDto(m));
        }
        return list;
    }
    @GetMapping("/searchnama/{nama}/sukseslogin")
    public List<MahasiswaDto> searchNama(@PathVariable String nama){
        List<MahasiswaDto>list=listdata();
        MahasiswaDto vari = new MahasiswaDto();
        List<MahasiswaDto>listBynama=new ArrayList<>();
        for(MahasiswaDto m : list) {
            if (((m.getNama()).toLowerCase()).matches((nama+".*").toLowerCase())) {
                vari=m;
                listBynama.add(vari);
            }
        }
        return listBynama;
    }

//    private DefaultResponse<MahasiswaDto> ers(@PathVariable String nama) {
//        DefaultResponse<MahasiswaDto>hasillogin=new DefaultResponse<>();
//        hasillogin=loginstatus();// pengen dapet data dari sespon login
//        List<MahasiswaDto>list=listdata();
//        MahasiswaDto vari = new MahasiswaDto();
//        List<MahasiswaDto>listBynama=new ArrayList<>();
//        for(MahasiswaDto m : list) {
//            if (((m.getNama()).toLowerCase()).matches((nama+".*").toLowerCase())) {
//                vari=m;
//                listBynama.add(vari);
//            }
//        }
//        return hasillogin;
//    }

    @GetMapping("/searchalamat/{alamat}/sukseslogin")
    public List<MahasiswaDto> searchalamat(@PathVariable String alamat){
        List<MahasiswaDto>list=listdata();
         MahasiswaDto vari = new MahasiswaDto();
        List<MahasiswaDto>listByalamat=new ArrayList<>();
        for(MahasiswaDto m : list) {
            if (((m.getAlamat()).toLowerCase()).matches((alamat+".*").toLowerCase())) {
                vari=m;
                listByalamat.add(vari);
            }
        }
        return listByalamat;
    }
    @PostMapping("/add/")
    public DefaultResponse<MahasiswaDto> saveMahasiswa(@RequestBody MahasiswaDto mahasiswaDto){//karena nggak ada entity di kita
        Mahasiswa mahasiswa=convertDtoToEntity(mahasiswaDto);
        DefaultResponse<MahasiswaDto>response=new DefaultResponse<>();
        Optional<Mahasiswa>opsional=mahasiswarepo.findById(mahasiswa.getNIM());

      //for(MahasiswaDto m :listdata()){
            if(opsional.isPresent()){
                //if(m.getNIM()!=mahasiswaDto.getNIM()){
                response.setMassage("Data sudah terdaftar");
            }
//            else if(m.getNama()==mahasiswaDto.getNama()){
//                mahasiswarepo.save(convertDtoToEntity(m));
//                n=m;
//                n.setNama("Id sudah digunakan");
//                n.setAlamat(null);
//                n.setNIM(null);
            else{
                mahasiswarepo.save(mahasiswa);
                response.setMassage("Berhasil save data ID: "+String.valueOf(mahasiswa.getNIM()));
                response.setData(convertEntityToDto(mahasiswa));
            }
       // }
        return response;
    }
    @PostMapping("/save")
    public MahasiswaDto saveTry(@RequestBody MahasiswaDto mahasiswaDto){
        Mahasiswa mahasiswa=convertDtoToEntity(mahasiswaDto);
        mahasiswarepo.save(mahasiswa);
        return convertEntityToDto(mahasiswa);
    }

    @PostMapping("/add/banyak")
    public MahasiswaDto[] addmahasiswabanyak(@RequestBody MahasiswaDto[] listbanyak){
        for(MahasiswaDto m : listbanyak){
            mahasiswarepo.save(convertDtoToEntity(m));
        }
        return listbanyak;
    }
    public MahasiswaDto convertEntityToDto(Mahasiswa mahasiswa){
        MahasiswaDto mahasiswaDto = new MahasiswaDto();
        mahasiswaDto.setNama(mahasiswa.getNama());
        mahasiswaDto.setAlamat(mahasiswa.getAlamat());
        mahasiswaDto.setNIM(mahasiswa.getNIM());
        return mahasiswaDto;
    }
    public Mahasiswa convertDtoToEntity(MahasiswaDto mahasiswaDto){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama(mahasiswaDto.getNama());
        mahasiswa.setAlamat(mahasiswaDto.getAlamat());
        mahasiswa.setNIM(mahasiswaDto.getNIM());
        return mahasiswa;
    }
//        @PostMapping("/add/banyaklist")
//    public List<MahasiswaDto> addmahasiswabanyak(@RequestBody List<MahasiswaDto> listbanyak){
//        for(MahasiswaDto m : listbanyak){
//            mahasiswarepo.save(m);
//        }
//        return listbanyak;
//    }
//    @PostMapping("/add/banyakarray")
//    public MahasiswaDto [] addmahasiswabanyakarray(@RequestBody MahasiswaDto [] listbanyak){
//        for(MahasiswaDto m : listbanyak){
//            mahasiswarepo.save(m);
//        }
//        return listbanyak;
//    }

}
