package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class datosultimaemp extends GXProcedure
{
   public datosultimaemp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( datosultimaemp.class ), "" );
   }

   public datosultimaemp( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short[] aP1 ,
                             byte[] aP2 ,
                             String[] aP3 ,
                             byte[] aP4 ,
                             byte[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             boolean[] aP8 ,
                             byte[] aP9 ,
                             int[] aP10 ,
                             String[] aP11 ,
                             short[] aP12 ,
                             short[] aP13 ,
                             short[] aP14 ,
                             String[] aP15 )
   {
      datosultimaemp.this.aP16 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 ,
                        byte[] aP2 ,
                        String[] aP3 ,
                        byte[] aP4 ,
                        byte[] aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 ,
                        boolean[] aP8 ,
                        byte[] aP9 ,
                        int[] aP10 ,
                        String[] aP11 ,
                        short[] aP12 ,
                        short[] aP13 ,
                        short[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 ,
                             byte[] aP2 ,
                             String[] aP3 ,
                             byte[] aP4 ,
                             byte[] aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             boolean[] aP8 ,
                             byte[] aP9 ,
                             int[] aP10 ,
                             String[] aP11 ,
                             short[] aP12 ,
                             short[] aP13 ,
                             short[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 )
   {
      datosultimaemp.this.AV8CliCod = aP0;
      datosultimaemp.this.aP1 = aP1;
      datosultimaemp.this.aP2 = aP2;
      datosultimaemp.this.aP3 = aP3;
      datosultimaemp.this.aP4 = aP4;
      datosultimaemp.this.aP5 = aP5;
      datosultimaemp.this.aP6 = aP6;
      datosultimaemp.this.aP7 = aP7;
      datosultimaemp.this.aP8 = aP8;
      datosultimaemp.this.aP9 = aP9;
      datosultimaemp.this.aP10 = aP10;
      datosultimaemp.this.aP11 = aP11;
      datosultimaemp.this.aP12 = aP12;
      datosultimaemp.this.aP13 = aP13;
      datosultimaemp.this.aP14 = aP14;
      datosultimaemp.this.aP15 = aP15;
      datosultimaemp.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01SD2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01SD2_A3CliCod[0] ;
         A1792EmpTipoExp = P01SD2_A1792EmpTipoExp[0] ;
         A1802EmpPromDesde = P01SD2_A1802EmpPromDesde[0] ;
         A1811EmpPerVacDes = P01SD2_A1811EmpPerVacDes[0] ;
         A1812EmpPerVacHas = P01SD2_A1812EmpPerVacHas[0] ;
         A1813EmpFracVacAnt = P01SD2_A1813EmpFracVacAnt[0] ;
         A1533EmpActComercial = P01SD2_A1533EmpActComercial[0] ;
         A2259EmpVacExpLim = P01SD2_A2259EmpVacExpLim[0] ;
         A2260EmpVacExpTie = P01SD2_A2260EmpVacExpTie[0] ;
         A2261EmpVacDisMax = P01SD2_A2261EmpVacDisMax[0] ;
         A44EmpZonCod = P01SD2_A44EmpZonCod[0] ;
         n44EmpZonCod = P01SD2_n44EmpZonCod[0] ;
         A46PaiCod = P01SD2_A46PaiCod[0] ;
         n46PaiCod = P01SD2_n46PaiCod[0] ;
         A47ProvCod = P01SD2_A47ProvCod[0] ;
         n47ProvCod = P01SD2_n47ProvCod[0] ;
         A48LocCod = P01SD2_A48LocCod[0] ;
         n48LocCod = P01SD2_n48LocCod[0] ;
         A43ActCodigo = P01SD2_A43ActCodigo[0] ;
         n43ActCodigo = P01SD2_n43ActCodigo[0] ;
         A45TipEmpleCod = P01SD2_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P01SD2_n45TipEmpleCod[0] ;
         A1EmpCod = P01SD2_A1EmpCod[0] ;
         AV9EmpCod = A1EmpCod ;
         AV10EmpTipoExp = A1792EmpTipoExp ;
         AV11EmpPromDesde = A1802EmpPromDesde ;
         AV12EmpPerVacDes = A1811EmpPerVacDes ;
         AV13EmpPerVacHas = A1812EmpPerVacHas ;
         AV14EmpFracVacAnt = A1813EmpFracVacAnt ;
         AV15EmpActComercial = A1533EmpActComercial ;
         AV16EmpVacExpLim = A2259EmpVacExpLim ;
         AV24EmpVacExpTie = A2260EmpVacExpTie ;
         AV17EmpVacDisMax = A2261EmpVacDisMax ;
         AV20EmpZonCod = A44EmpZonCod ;
         AV18PaiCod = A46PaiCod ;
         AV23ProvCod = A47ProvCod ;
         AV22LocCod = A48LocCod ;
         AV21ActCodigo = A43ActCodigo ;
         AV19TipEmpleCod = A45TipEmpleCod ;
         AV20EmpZonCod = A44EmpZonCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = datosultimaemp.this.AV9EmpCod;
      this.aP2[0] = datosultimaemp.this.AV10EmpTipoExp;
      this.aP3[0] = datosultimaemp.this.AV11EmpPromDesde;
      this.aP4[0] = datosultimaemp.this.AV12EmpPerVacDes;
      this.aP5[0] = datosultimaemp.this.AV13EmpPerVacHas;
      this.aP6[0] = datosultimaemp.this.AV14EmpFracVacAnt;
      this.aP7[0] = datosultimaemp.this.AV15EmpActComercial;
      this.aP8[0] = datosultimaemp.this.AV16EmpVacExpLim;
      this.aP9[0] = datosultimaemp.this.AV24EmpVacExpTie;
      this.aP10[0] = datosultimaemp.this.AV17EmpVacDisMax;
      this.aP11[0] = datosultimaemp.this.AV20EmpZonCod;
      this.aP12[0] = datosultimaemp.this.AV18PaiCod;
      this.aP13[0] = datosultimaemp.this.AV23ProvCod;
      this.aP14[0] = datosultimaemp.this.AV22LocCod;
      this.aP15[0] = datosultimaemp.this.AV21ActCodigo;
      this.aP16[0] = datosultimaemp.this.AV19TipEmpleCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11EmpPromDesde = "" ;
      AV14EmpFracVacAnt = DecimalUtil.ZERO ;
      AV15EmpActComercial = "" ;
      AV20EmpZonCod = "" ;
      AV21ActCodigo = "" ;
      AV19TipEmpleCod = "" ;
      scmdbuf = "" ;
      P01SD2_A3CliCod = new int[1] ;
      P01SD2_A1792EmpTipoExp = new byte[1] ;
      P01SD2_A1802EmpPromDesde = new String[] {""} ;
      P01SD2_A1811EmpPerVacDes = new byte[1] ;
      P01SD2_A1812EmpPerVacHas = new byte[1] ;
      P01SD2_A1813EmpFracVacAnt = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01SD2_A1533EmpActComercial = new String[] {""} ;
      P01SD2_A2259EmpVacExpLim = new boolean[] {false} ;
      P01SD2_A2260EmpVacExpTie = new byte[1] ;
      P01SD2_A2261EmpVacDisMax = new int[1] ;
      P01SD2_A44EmpZonCod = new String[] {""} ;
      P01SD2_n44EmpZonCod = new boolean[] {false} ;
      P01SD2_A46PaiCod = new short[1] ;
      P01SD2_n46PaiCod = new boolean[] {false} ;
      P01SD2_A47ProvCod = new short[1] ;
      P01SD2_n47ProvCod = new boolean[] {false} ;
      P01SD2_A48LocCod = new short[1] ;
      P01SD2_n48LocCod = new boolean[] {false} ;
      P01SD2_A43ActCodigo = new String[] {""} ;
      P01SD2_n43ActCodigo = new boolean[] {false} ;
      P01SD2_A45TipEmpleCod = new String[] {""} ;
      P01SD2_n45TipEmpleCod = new boolean[] {false} ;
      P01SD2_A1EmpCod = new short[1] ;
      A1802EmpPromDesde = "" ;
      A1813EmpFracVacAnt = DecimalUtil.ZERO ;
      A1533EmpActComercial = "" ;
      A44EmpZonCod = "" ;
      A43ActCodigo = "" ;
      A45TipEmpleCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.datosultimaemp__default(),
         new Object[] {
             new Object[] {
            P01SD2_A3CliCod, P01SD2_A1792EmpTipoExp, P01SD2_A1802EmpPromDesde, P01SD2_A1811EmpPerVacDes, P01SD2_A1812EmpPerVacHas, P01SD2_A1813EmpFracVacAnt, P01SD2_A1533EmpActComercial, P01SD2_A2259EmpVacExpLim, P01SD2_A2260EmpVacExpTie, P01SD2_A2261EmpVacDisMax,
            P01SD2_A44EmpZonCod, P01SD2_n44EmpZonCod, P01SD2_A46PaiCod, P01SD2_n46PaiCod, P01SD2_A47ProvCod, P01SD2_n47ProvCod, P01SD2_A48LocCod, P01SD2_n48LocCod, P01SD2_A43ActCodigo, P01SD2_n43ActCodigo,
            P01SD2_A45TipEmpleCod, P01SD2_n45TipEmpleCod, P01SD2_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10EmpTipoExp ;
   private byte AV12EmpPerVacDes ;
   private byte AV13EmpPerVacHas ;
   private byte AV24EmpVacExpTie ;
   private byte A1792EmpTipoExp ;
   private byte A1811EmpPerVacDes ;
   private byte A1812EmpPerVacHas ;
   private byte A2260EmpVacExpTie ;
   private short AV9EmpCod ;
   private short AV18PaiCod ;
   private short AV23ProvCod ;
   private short AV22LocCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short A48LocCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV17EmpVacDisMax ;
   private int A3CliCod ;
   private int A2261EmpVacDisMax ;
   private java.math.BigDecimal AV14EmpFracVacAnt ;
   private java.math.BigDecimal A1813EmpFracVacAnt ;
   private String AV11EmpPromDesde ;
   private String AV15EmpActComercial ;
   private String AV20EmpZonCod ;
   private String AV21ActCodigo ;
   private String AV19TipEmpleCod ;
   private String scmdbuf ;
   private String A1802EmpPromDesde ;
   private String A1533EmpActComercial ;
   private String A44EmpZonCod ;
   private String A43ActCodigo ;
   private String A45TipEmpleCod ;
   private boolean AV16EmpVacExpLim ;
   private boolean A2259EmpVacExpLim ;
   private boolean n44EmpZonCod ;
   private boolean n46PaiCod ;
   private boolean n47ProvCod ;
   private boolean n48LocCod ;
   private boolean n43ActCodigo ;
   private boolean n45TipEmpleCod ;
   private String[] aP16 ;
   private short[] aP1 ;
   private byte[] aP2 ;
   private String[] aP3 ;
   private byte[] aP4 ;
   private byte[] aP5 ;
   private java.math.BigDecimal[] aP6 ;
   private String[] aP7 ;
   private boolean[] aP8 ;
   private byte[] aP9 ;
   private int[] aP10 ;
   private String[] aP11 ;
   private short[] aP12 ;
   private short[] aP13 ;
   private short[] aP14 ;
   private String[] aP15 ;
   private IDataStoreProvider pr_default ;
   private int[] P01SD2_A3CliCod ;
   private byte[] P01SD2_A1792EmpTipoExp ;
   private String[] P01SD2_A1802EmpPromDesde ;
   private byte[] P01SD2_A1811EmpPerVacDes ;
   private byte[] P01SD2_A1812EmpPerVacHas ;
   private java.math.BigDecimal[] P01SD2_A1813EmpFracVacAnt ;
   private String[] P01SD2_A1533EmpActComercial ;
   private boolean[] P01SD2_A2259EmpVacExpLim ;
   private byte[] P01SD2_A2260EmpVacExpTie ;
   private int[] P01SD2_A2261EmpVacDisMax ;
   private String[] P01SD2_A44EmpZonCod ;
   private boolean[] P01SD2_n44EmpZonCod ;
   private short[] P01SD2_A46PaiCod ;
   private boolean[] P01SD2_n46PaiCod ;
   private short[] P01SD2_A47ProvCod ;
   private boolean[] P01SD2_n47ProvCod ;
   private short[] P01SD2_A48LocCod ;
   private boolean[] P01SD2_n48LocCod ;
   private String[] P01SD2_A43ActCodigo ;
   private boolean[] P01SD2_n43ActCodigo ;
   private String[] P01SD2_A45TipEmpleCod ;
   private boolean[] P01SD2_n45TipEmpleCod ;
   private short[] P01SD2_A1EmpCod ;
}

final  class datosultimaemp__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01SD2", "SELECT CliCod, EmpTipoExp, EmpPromDesde, EmpPerVacDes, EmpPerVacHas, EmpFracVacAnt, EmpActComercial, EmpVacExpLim, EmpVacExpTie, EmpVacDisMax, EmpZonCod, PaiCod, ProvCod, LocCod, ActCodigo, TipEmpleCod, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod, EmpCod DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((byte[]) buf[8])[0] = rslt.getByte(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((short[]) buf[12])[0] = rslt.getShort(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(13);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((short[]) buf[16])[0] = rslt.getShort(14);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(15, 8);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getString(16, 4);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((short[]) buf[22])[0] = rslt.getShort(17);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

