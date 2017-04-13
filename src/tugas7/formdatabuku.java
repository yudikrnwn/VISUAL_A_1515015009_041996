
package tugas7;

import tugas6.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class formdatabuku extends javax.swing.JFrame {

    private DefaultTableModel model;//membuat model pada tabel
    private Connection con=koneksi.getConnection();//membuat koneksi
    private Statement stt;//mengeksekusi database
    private ResultSet rss;//menampung data dari database
    private int baris;//mendeklarasikan sebuah variabel dengan tipe integer
    private boolean cek=true;//variabel cek yang di gunakan dalam proses validasi
    
    public formdatabuku() {//method dari formdatabuku
        initComponents();
    }

    public void IniTable(){//method yang menghubungkan inputan dengan tabel
        model= new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("JUDUL");
        model.addColumn("PENULIS");
        model.addColumn("HARGA");
        tabel.setModel(model);
        
    }
    private void TampilData(){//untuk menampilkan isi database pada tabel
        try{
            String sql="SELECT *FROM buku";//query untuk mengambil data dari database dan di tampilkan di tabel
            stt=con.createStatement();
            rss=stt.executeQuery(sql);
            while(rss.next()){
                Object[]o=new Object[4];
                o[0]=rss.getInt("id");
                o[1]=rss.getString("judul");
                o[2]=rss.getString("penulis");
                o[3]=rss.getString("harga");
                model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void TambahData(String judul, String penulis, String harga){//method untuk menambahkan data
        try{
            String sql=
                    "INSERT INTO buku VALUES(NULL,'"+judul+"','"+penulis+"',"+harga+")";//query untuk menambahkan data pada tabel
            stt=con.createStatement();
            stt.executeUpdate(sql);
           
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private void UbahData(String judul,String penulis, String harga, String id){//method untuk mengubah data
        try {
            
            String sql = "UPDATE buku SET "
                         + "judul='"+judul+"',"
                         + "penulis='"+penulis+"',"
                         + "harga='"+harga+"'"
                         + "WHERE id='"+id+"'";//data yang di pilih akan dan telah di ubah akan di update
            stt = con.createStatement();
            stt.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void carijudul(){//mencari data berdasarkan judul
        try {
            String sql = "SELECT * FROM buku where judul='"+caridata.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getInt("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void HapusData(String id,int baris){//method untuk menghapus data
        try {
            
            String sqldelete = 
                    "DELETE FROM buku WHERE id='"+id+"'";
            stt = con.createStatement();
            stt.executeUpdate(sqldelete);
            model.removeRow(baris);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void cariid(){//mencari data menggunakan id
        try {
            String sql = "SELECT * FROM buku where id='"+caridata.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getInt("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void caripenulis(){//mencari data menggunakan penulis
        try {
            String sql = "SELECT * FROM buku where penulis='"+caridata.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getInt("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void cariharga(){//cari data berdasarkan harga
        try {
            String sql = "SELECT * FROM buku where harga='"+caridata.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getInt("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void validasi(String judul, String penulis, String harga){//validasi data agar data tidak ada yang sama
        try{
            String sql="SELECT *FROM buku";
            stt=con.createStatement();
            ResultSet rss= stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[2];
                o[0] = rss.getString("judul").toLowerCase();
                o[1] = rss.getString("penulis").toLowerCase();
                if(o[0].equals(judul.toLowerCase())&&o[1].equals(penulis.toLowerCase())){
                    JOptionPane.showMessageDialog(null,"data sudah ada");
                    cek=false;
                    break;
                }
            }
            if(cek==true){
                TambahData(judul, penulis, harga);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtjudul = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        cboxpenulis = new javax.swing.JComboBox();
        ubah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        lihat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        caridata = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        by = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jLabel1.setText("form data buku");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("judul");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("penulis");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("harga");

        cboxpenulis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih--", "tera liye", "w.s rendra", "felix siauw", "asma nadia", "dewi lestari" }));

        ubah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ubah.setText("ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        simpan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        simpan.setText("simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        hapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        hapus.setText("hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        keluar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        keluar.setText("keluar");
        keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                keluarMouseClicked(evt);
            }
        });

        lihat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lihat.setText("lihat data");
        lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtharga)
                            .addComponent(txtjudul)
                            .addComponent(cboxpenulis, 0, 219, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(simpan)
                        .addGap(18, 18, 18)
                        .addComponent(ubah)
                        .addGap(18, 18, 18)
                        .addComponent(hapus)
                        .addGap(18, 18, 18)
                        .addComponent(lihat)
                        .addGap(18, 18, 18)
                        .addComponent(keluar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtjudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboxpenulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubah)
                    .addComponent(simpan)
                    .addComponent(hapus)
                    .addComponent(keluar)
                    .addComponent(lihat))
                .addContainerGap())
        );

        tabel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "judul", "penulis", "harga"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("cari data");

        cari.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cari.setText("cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        by.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "pilih--", "Id", "Judul", "Penulis", "Harga" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("by");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(caridata, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cari)
                    .addComponent(by, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(caridata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(by, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
    //IniTable();
    //TampilData();// TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
    //event untuk menyimpan data
    String judul=txtjudul.getText();
    String penulis=cboxpenulis.getSelectedItem().toString();
    String harga=txtharga.getText();
    validasi(judul,penulis,harga);
    
    IniTable();
    TampilData();
    }//GEN-LAST:event_simpanActionPerformed

    private void keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_keluarMouseClicked
    //event untuk keluar
        System.exit(0);
    }//GEN-LAST:event_keluarMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        //event menghapus data
        int baris = tabel.getSelectedRow();
        String id = tabel.getValueAt(baris, 0).toString();
        HapusData(id, baris);
    }//GEN-LAST:event_hapusActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
    //event untuk mengisi field pada saat data pada tabel di klik
        int baris = tabel.getSelectedRow();
        
        String id=tabel.getValueAt(baris,0).toString();
        String judul=tabel.getValueAt(baris,1).toString();
        String penulis=tabel.getValueAt(baris,2).toString();
        String harga=tabel.getValueAt(baris,3).toString();
        
        
        
        txtjudul.setText(judul);
        cboxpenulis.setSelectedItem(penulis);
        txtharga.setText(harga);
    }//GEN-LAST:event_tabelMouseClicked

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
    //event untuk menghapus data
        int baris = tabel.getSelectedRow();       
        
        tabel.setValueAt(txtjudul.getText(),baris,1);
        tabel.setValueAt(cboxpenulis.getSelectedItem(),baris,2);
        tabel.setValueAt(txtharga.getText(),baris,3); 
        String id=tabel.getValueAt(baris,0).toString();
        String judul=tabel.getValueAt(baris,1).toString();
        String penulis=tabel.getValueAt(baris,2).toString();
        String harga=tabel.getValueAt(baris,3).toString();

        txtjudul.setText(judul);
        cboxpenulis.setSelectedItem(penulis);
        txtharga.setText(harga);
        
        UbahData(judul,penulis,harga,id);
    }//GEN-LAST:event_ubahActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        //event untuk mencari data
        if(caridata.getText().equals("")){
            JOptionPane.showMessageDialog(null,"cari apa le!!!!","opsss..",JOptionPane.INFORMATION_MESSAGE);
        }
        
        else{
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            if(by.getSelectedItem().equals("Id")){
                cariid();
            }
            else if(by.getSelectedItem().equals("Judul")){
                carijudul();
            }
            else if(by.getSelectedItem().equals("Penulis")){
                caripenulis();
            }
            else{
                cariharga();
            }
        }
        
    }//GEN-LAST:event_cariActionPerformed

    private void lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatActionPerformed
    //untuk menampilkan semua data yang ada pada database
    IniTable();
    TampilData();
    }//GEN-LAST:event_lihatActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formdatabuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox by;
    private javax.swing.JButton cari;
    private javax.swing.JTextField caridata;
    private javax.swing.JComboBox cboxpenulis;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton keluar;
    private javax.swing.JButton lihat;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtjudul;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
