import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class butonodev2{

//main içinde 4x4 lük buton tanımlanır.

    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4,4));

//butona tıklandığında gidilen adres tanımlanır.
        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                GrapQLbutton   button=new GrapQLbutton("button"+(i*4+j+1));
                button.setGraphqlsemaadres("https://api.example.com/graphql");

                frame.add(button);
            }
            frame.setSize(400,400);
            frame.setVisible(true);
        }

    }
// JButon extends edilip değişkenler tanımlanır.
    static class GrapQLbutton extends JButton {


        private boolean isaktif ;
        private String graphqlsemaadres;
        private Color aktifcolor;
        private Color pasifcolor;


        public GrapQLbutton(String text) {
            super(text);
            this.graphqlsemaadres = "https://api.example.com/graphql";
            this.aktifcolor = Color.ORANGE;
            this.pasifcolor = Color.GRAY;
            this.isaktif = false;

            setpasifalan();
            addActionListener(new butonbasıldıgında());
        }


        public void setGraphqlsemaadres(String graphqlsemaadres) {
            this.graphqlsemaadres = graphqlsemaadres;

        }
// buton aktif ve pasif durumları tanımlanır.
        public void setAktifcolor(Color renk) {
            this.aktifcolor = renk;
        }

        public void setPasifcolor(Color renk) {
            this.pasifcolor = renk;

        }

        private void setpasifalan() {
            setBackground(pasifcolor);
            setText("pasif");
            isaktif = false;

        }

        public void setaktifalan() {
            setBackground(aktifcolor);
            setText("aktif");
            isaktif = true;

        }
// buton basıldığındaki durumu ve çıktıda ne olacağı tanımlanır.
        private class butonbasıldıgında implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (isaktif) {
                    setpasifalantıklananhariç();
                } else {
                    setaktifalan();
                    System.out.println("çalışmaya başladı:"+graphqlsemaadres);
                }
            }
        }

        private void setpasifalantıklananhariç() {
            for (Component component : getParent().getComponents()) {
                if (component instanceof GrapQLbutton && component != this) {
                    ((GrapQLbutton) component).setpasifalan();
                }
            }
        }

    }

}

