package com.example.Proiect_Data;

import com.example.Proiect_Data.Domain.BaseEntity;
import com.example.Proiect_Data.Domain.Echipa;
import com.example.Proiect_Data.Domain.Tricou;
import com.example.Proiect_Data.Domain.User;
import org.junit.jupiter.api.Test;
import  static  org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import java.util.ArrayList;
import java.util.HashMap;


public class test {

    @Test
    public void TricouCreate() {

        Echipa echipa_test = new Echipa();
        echipa_test.setId(1L);
//        Tricou tricou=new Tricou("Fc2012","S",10,echipa_test,2,2025);
//        assertThat(tricou.isIs_active()).isEqualTo(true);
    }
}
