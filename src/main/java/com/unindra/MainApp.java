package com.unindra;

import com.formdev.flatlaf.FlatLightLaf;

import com.unindra.view.SelectRoleView;
import java.util.Locale;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {
	public static void main(String[] args) throws UnsupportedLookAndFeelException {

            UIManager.setLookAndFeel(new FlatLightLaf());
            Locale.setDefault(Locale.forLanguageTag("id-ID"));
            
            SpringApplication app = new SpringApplication(MainApp.class);
            app.setHeadless(false); // <-- aktifkan GUI
            ConfigurableApplicationContext context = app.run(args);

            SelectRoleView view = context.getBean(SelectRoleView.class);
            SwingUtilities.invokeLater(() -> view.setVisible(true));
	}

}
