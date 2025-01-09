package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaisextraespeciales extends GXProcedure
{
   public getpaisextraespeciales( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaisextraespeciales.class ), "" );
   }

   public getpaisextraespeciales( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             String[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 )
   {
      getpaisextraespeciales.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        byte aP2 ,
                        String[] aP3 ,
                        java.math.BigDecimal[] aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             byte aP2 ,
                             String[] aP3 ,
                             java.math.BigDecimal[] aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 )
   {
      getpaisextraespeciales.this.AV8PaiCod = aP0;
      getpaisextraespeciales.this.AV17PaiHsPDiaTipTra = aP1;
      getpaisextraespeciales.this.AV18PaiHsPDiaDia = aP2;
      getpaisextraespeciales.this.aP3 = aP3;
      getpaisextraespeciales.this.aP4 = aP4;
      getpaisextraespeciales.this.aP5 = aP5;
      getpaisextraespeciales.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02M92 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV17PaiHsPDiaTipTra, Byte.valueOf(AV18PaiHsPDiaDia)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1333PaiHsPDiaDia = P02M92_A1333PaiHsPDiaDia[0] ;
         A1331PaiHsPDiaTipTra = P02M92_A1331PaiHsPDiaTipTra[0] ;
         A46PaiCod = P02M92_A46PaiCod[0] ;
         A1334PaiHsPDiaDesde = P02M92_A1334PaiHsPDiaDesde[0] ;
         n1334PaiHsPDiaDesde = P02M92_n1334PaiHsPDiaDesde[0] ;
         A1335PaiTarifaPDia = P02M92_A1335PaiTarifaPDia[0] ;
         A1348PaiTarifaPDRec = P02M92_A1348PaiTarifaPDRec[0] ;
         A2434PaiTarifaPDCri = P02M92_A2434PaiTarifaPDCri[0] ;
         A1332PaiHsExSec = P02M92_A1332PaiHsExSec[0] ;
         AV10PaiHsPDiaDesde = A1334PaiHsPDiaDesde ;
         AV11PaiTarifaPDia = A1335PaiTarifaPDia ;
         AV12PaiTarifaPDRec = A1348PaiTarifaPDRec ;
         AV19PaiTarifaPDCri = A2434PaiTarifaPDCri ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getpaisextraespeciales.this.AV10PaiHsPDiaDesde;
      this.aP4[0] = getpaisextraespeciales.this.AV11PaiTarifaPDia;
      this.aP5[0] = getpaisextraespeciales.this.AV12PaiTarifaPDRec;
      this.aP6[0] = getpaisextraespeciales.this.AV19PaiTarifaPDCri;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10PaiHsPDiaDesde = "" ;
      AV11PaiTarifaPDia = DecimalUtil.ZERO ;
      AV12PaiTarifaPDRec = DecimalUtil.ZERO ;
      AV19PaiTarifaPDCri = "" ;
      scmdbuf = "" ;
      P02M92_A1333PaiHsPDiaDia = new byte[1] ;
      P02M92_A1331PaiHsPDiaTipTra = new String[] {""} ;
      P02M92_A46PaiCod = new short[1] ;
      P02M92_A1334PaiHsPDiaDesde = new String[] {""} ;
      P02M92_n1334PaiHsPDiaDesde = new boolean[] {false} ;
      P02M92_A1335PaiTarifaPDia = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M92_A1348PaiTarifaPDRec = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02M92_A2434PaiTarifaPDCri = new String[] {""} ;
      P02M92_A1332PaiHsExSec = new short[1] ;
      A1331PaiHsPDiaTipTra = "" ;
      A1334PaiHsPDiaDesde = "" ;
      A1335PaiTarifaPDia = DecimalUtil.ZERO ;
      A1348PaiTarifaPDRec = DecimalUtil.ZERO ;
      A2434PaiTarifaPDCri = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getpaisextraespeciales__default(),
         new Object[] {
             new Object[] {
            P02M92_A1333PaiHsPDiaDia, P02M92_A1331PaiHsPDiaTipTra, P02M92_A46PaiCod, P02M92_A1334PaiHsPDiaDesde, P02M92_n1334PaiHsPDiaDesde, P02M92_A1335PaiTarifaPDia, P02M92_A1348PaiTarifaPDRec, P02M92_A2434PaiTarifaPDCri, P02M92_A1332PaiHsExSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18PaiHsPDiaDia ;
   private byte A1333PaiHsPDiaDia ;
   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short A1332PaiHsExSec ;
   private short Gx_err ;
   private java.math.BigDecimal AV11PaiTarifaPDia ;
   private java.math.BigDecimal AV12PaiTarifaPDRec ;
   private java.math.BigDecimal A1335PaiTarifaPDia ;
   private java.math.BigDecimal A1348PaiTarifaPDRec ;
   private String AV17PaiHsPDiaTipTra ;
   private String AV10PaiHsPDiaDesde ;
   private String AV19PaiTarifaPDCri ;
   private String scmdbuf ;
   private String A1331PaiHsPDiaTipTra ;
   private String A1334PaiHsPDiaDesde ;
   private String A2434PaiTarifaPDCri ;
   private boolean n1334PaiHsPDiaDesde ;
   private String[] aP6 ;
   private String[] aP3 ;
   private java.math.BigDecimal[] aP4 ;
   private java.math.BigDecimal[] aP5 ;
   private IDataStoreProvider pr_default ;
   private byte[] P02M92_A1333PaiHsPDiaDia ;
   private String[] P02M92_A1331PaiHsPDiaTipTra ;
   private short[] P02M92_A46PaiCod ;
   private String[] P02M92_A1334PaiHsPDiaDesde ;
   private boolean[] P02M92_n1334PaiHsPDiaDesde ;
   private java.math.BigDecimal[] P02M92_A1335PaiTarifaPDia ;
   private java.math.BigDecimal[] P02M92_A1348PaiTarifaPDRec ;
   private String[] P02M92_A2434PaiTarifaPDCri ;
   private short[] P02M92_A1332PaiHsExSec ;
}

final  class getpaisextraespeciales__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02M92", "SELECT PaiHsPDiaDia, PaiHsPDiaTipTra, PaiCod, PaiHsPDiaDesde, PaiTarifaPDia, PaiTarifaPDRec, PaiTarifaPDCri, PaiHsExSec FROM Paishorasextras_pordia WHERE (PaiCod = ? and PaiHsPDiaTipTra = ( ?)) AND (PaiHsPDiaDia = ?) ORDER BY PaiCod, PaiHsPDiaTipTra  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 5);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((short[]) buf[8])[0] = rslt.getShort(8);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               return;
      }
   }

}

