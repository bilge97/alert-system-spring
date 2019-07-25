package guru.springframework.spring5webapp.Service;

import guru.springframework.spring5webapp.model.Alert;
import guru.springframework.spring5webapp.repository.AlertRepository;
import guru.springframework.spring5webapp.service.AlertServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AlertServiceImpTest {

    @Mock
    AlertRepository alertRepository;//mock

    @InjectMocks
    AlertServiceImp serviceImp;

    @Test
    void findAll() {

        //given
        Alert alert = new Alert();
        List<Alert> alerts = new ArrayList<Alert>();
        alerts.add(alert);
        given(alertRepository.findAll()).willReturn(alerts);
        //when(alertRepository.findAll()).thenReturn(alerts);

        //when
        List<Alert> foundAlerts = serviceImp.findAll();

        //then
        then(alertRepository).should().findAll();
        //verify(alertRepository).findAll();
        assertThat(foundAlerts).hasSize(1);

    }

    @Test
    void saveAllTest() {

        //given
        Alert alert = new Alert();
        given(alertRepository.save(any(Alert.class))).willReturn(alert);
        //when(alertRepository.save(any(Alert.class))).thenReturn(alert);

        //when
        Alert savedAlert = serviceImp.save(new Alert());

        //then
        then(alertRepository).should().save(any(Alert.class));
        //verify(alertRepository).save(any(Alert.class));
        assertThat(savedAlert).isNotNull();

    }

    @Test
    void findbyIdTest() {

        //given
        Alert alert = new Alert();//mockta geri döndürmek için
        given(alertRepository.findById(1L)).willReturn(Optional.of(alert));
        //when(alertRepository.findById(1l)).thenReturn(Optional.of(alert));

        //when
        Alert foundAlert = serviceImp.findById(1L);


        //then
        then(alertRepository).should().findById(anyLong());
        //verify(alertRepository).findById(1l);//1 defa
        assertThat(foundAlert).isNotNull();
    }

    @Test
    void findByIdBDD() {

        //given
        Alert alert = new Alert();
        given(alertRepository.findById(1l)).willReturn(Optional.of(alert));

        //when
        Alert foundAlert = serviceImp.findById(1l);

        //then
        assertThat(foundAlert).isNotNull();
        //verify(alertRepository).findById(1l);//1 defa
        then(alertRepository).should().findById(anyLong());
        then(alertRepository).shouldHaveNoMoreInteractions();

    }

    @Test
    void findByIdTestThrows() {

        given(alertRepository.findById(1l)).willThrow(new RuntimeException("boom"));

        assertThrows(RuntimeException.class , () -> serviceImp.findById(1l));

        then(alertRepository).should().findById(1l);

    }

    @Test
    void deleteAlert() {
        //given-none

        //when
        serviceImp.deleteAlertById(1l);
        serviceImp.deleteAlertById(1l);

        //then
        //verify(alertRepository).deleteById(anyLong());
        then(alertRepository).should(times(2)).deleteById(anyLong());
    }

    @Test
    void deleteAlerttestDoThrow(){

        doThrow(new RuntimeException("boom")).when(alertRepository).deleteById(anyLong());

        assertThrows(RuntimeException.class , () -> alertRepository.deleteById(anyLong()));

        verify(alertRepository).deleteById(anyLong());

    }


}