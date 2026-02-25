module sn.Bouya.panierclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires java.sql;
    opens sn.bouya.panierclient.Model to org.hibernate.orm.core, java.persistence;
    opens sn.bouya.panierclient to javafx.fxml;
    opens sn.bouya.panierclient.Controller to javafx.fxml;
    exports sn.bouya.panierclient;
}