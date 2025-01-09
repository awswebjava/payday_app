package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getconvebasedatosremu extends GXProcedure
{
   public getconvebasedatosremu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getconvebasedatosremu.class ), "" );
   }

   public getconvebasedatosremu( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              String aP2 ,
                              String aP3 ,
                              String aP4 ,
                              String aP5 ,
                              String aP6 ,
                              java.math.BigDecimal[] aP7 ,
                              short[] aP8 ,
                              short[] aP9 ,
                              String[] aP10 )
   {
      getconvebasedatosremu.this.aP11 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        short[] aP8 ,
                        short[] aP9 ,
                        String[] aP10 ,
                        boolean[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             short[] aP8 ,
                             short[] aP9 ,
                             String[] aP10 ,
                             boolean[] aP11 )
   {
      getconvebasedatosremu.this.AV8CliConveVer = aP0;
      getconvebasedatosremu.this.AV9PaiCod = aP1;
      getconvebasedatosremu.this.AV10ConveCodigo = aP2;
      getconvebasedatosremu.this.AV20tipo_tarifa = aP3;
      getconvebasedatosremu.this.AV12tipo_base = aP4;
      getconvebasedatosremu.this.AV13codigo1 = aP5;
      getconvebasedatosremu.this.AV14codigo2 = aP6;
      getconvebasedatosremu.this.aP7 = aP7;
      getconvebasedatosremu.this.aP8 = aP8;
      getconvebasedatosremu.this.aP9 = aP9;
      getconvebasedatosremu.this.aP10 = aP10;
      getconvebasedatosremu.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV20tipo_tarifa, "H") == 0 )
      {
         AV11ClaseLeg = (byte)(2) ;
      }
      else
      {
         AV11ClaseLeg = (byte)(1) ;
      }
      /* Using cursor P01GM2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliConveVer), Short.valueOf(AV9PaiCod), AV10ConveCodigo, Byte.valueOf(AV11ClaseLeg), AV12tipo_base, AV13codigo1, AV14codigo2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1457ConveBaseCod2 = P01GM2_A1457ConveBaseCod2[0] ;
         A1456ConveBaseCod1 = P01GM2_A1456ConveBaseCod1[0] ;
         A1455ConveBaseTipo = P01GM2_A1455ConveBaseTipo[0] ;
         A1454ConveBaseClaseLeg = P01GM2_A1454ConveBaseClaseLeg[0] ;
         A1565CliConvenio = P01GM2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01GM2_A1564CliPaiConve[0] ;
         A3CliCod = P01GM2_A3CliCod[0] ;
         A1458ConveBasePlus = P01GM2_A1458ConveBasePlus[0] ;
         A1465ConveBasePromCnt1 = P01GM2_A1465ConveBasePromCnt1[0] ;
         A1466ConveBasePromCnt2 = P01GM2_A1466ConveBasePromCnt2[0] ;
         A1467ConveBasePromTCnt = P01GM2_A1467ConveBasePromTCnt[0] ;
         AV15ConveBasePlus = A1458ConveBasePlus ;
         AV18ConveBasePromCnt1 = A1465ConveBasePromCnt1 ;
         AV17ConveBasePromCnt2 = A1466ConveBasePromCnt2 ;
         AV19ConveBasePromTCnt = A1467ConveBasePromTCnt ;
         AV16hay = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = getconvebasedatosremu.this.AV15ConveBasePlus;
      this.aP8[0] = getconvebasedatosremu.this.AV18ConveBasePromCnt1;
      this.aP9[0] = getconvebasedatosremu.this.AV17ConveBasePromCnt2;
      this.aP10[0] = getconvebasedatosremu.this.AV19ConveBasePromTCnt;
      this.aP11[0] = getconvebasedatosremu.this.AV16hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15ConveBasePlus = DecimalUtil.ZERO ;
      AV19ConveBasePromTCnt = "" ;
      scmdbuf = "" ;
      P01GM2_A1457ConveBaseCod2 = new String[] {""} ;
      P01GM2_A1456ConveBaseCod1 = new String[] {""} ;
      P01GM2_A1455ConveBaseTipo = new String[] {""} ;
      P01GM2_A1454ConveBaseClaseLeg = new byte[1] ;
      P01GM2_A1565CliConvenio = new String[] {""} ;
      P01GM2_A1564CliPaiConve = new short[1] ;
      P01GM2_A3CliCod = new int[1] ;
      P01GM2_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GM2_A1465ConveBasePromCnt1 = new short[1] ;
      P01GM2_A1466ConveBasePromCnt2 = new short[1] ;
      P01GM2_A1467ConveBasePromTCnt = new String[] {""} ;
      A1457ConveBaseCod2 = "" ;
      A1456ConveBaseCod1 = "" ;
      A1455ConveBaseTipo = "" ;
      A1565CliConvenio = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      A1467ConveBasePromTCnt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getconvebasedatosremu__default(),
         new Object[] {
             new Object[] {
            P01GM2_A1457ConveBaseCod2, P01GM2_A1456ConveBaseCod1, P01GM2_A1455ConveBaseTipo, P01GM2_A1454ConveBaseClaseLeg, P01GM2_A1565CliConvenio, P01GM2_A1564CliPaiConve, P01GM2_A3CliCod, P01GM2_A1458ConveBasePlus, P01GM2_A1465ConveBasePromCnt1, P01GM2_A1466ConveBasePromCnt2,
            P01GM2_A1467ConveBasePromTCnt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11ClaseLeg ;
   private byte A1454ConveBaseClaseLeg ;
   private short AV9PaiCod ;
   private short AV18ConveBasePromCnt1 ;
   private short AV17ConveBasePromCnt2 ;
   private short A1564CliPaiConve ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short Gx_err ;
   private int AV8CliConveVer ;
   private int A3CliCod ;
   private java.math.BigDecimal AV15ConveBasePlus ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private String AV10ConveCodigo ;
   private String AV20tipo_tarifa ;
   private String AV12tipo_base ;
   private String AV13codigo1 ;
   private String AV14codigo2 ;
   private String AV19ConveBasePromTCnt ;
   private String scmdbuf ;
   private String A1457ConveBaseCod2 ;
   private String A1456ConveBaseCod1 ;
   private String A1455ConveBaseTipo ;
   private String A1565CliConvenio ;
   private String A1467ConveBasePromTCnt ;
   private boolean AV16hay ;
   private boolean[] aP11 ;
   private java.math.BigDecimal[] aP7 ;
   private short[] aP8 ;
   private short[] aP9 ;
   private String[] aP10 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GM2_A1457ConveBaseCod2 ;
   private String[] P01GM2_A1456ConveBaseCod1 ;
   private String[] P01GM2_A1455ConveBaseTipo ;
   private byte[] P01GM2_A1454ConveBaseClaseLeg ;
   private String[] P01GM2_A1565CliConvenio ;
   private short[] P01GM2_A1564CliPaiConve ;
   private int[] P01GM2_A3CliCod ;
   private java.math.BigDecimal[] P01GM2_A1458ConveBasePlus ;
   private short[] P01GM2_A1465ConveBasePromCnt1 ;
   private short[] P01GM2_A1466ConveBasePromCnt2 ;
   private String[] P01GM2_A1467ConveBasePromTCnt ;
}

final  class getconvebasedatosremu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GM2", "SELECT ConveBaseCod2, ConveBaseCod1, ConveBaseTipo, ConveBaseClaseLeg, CliConvenio, CliPaiConve, CliCod, ConveBasePlus, ConveBasePromCnt1, ConveBasePromCnt2, ConveBasePromTCnt FROM Convenio_base_calculo WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveBaseClaseLeg = ? and ConveBaseTipo = ( ?) and ConveBaseCod1 = ( ?) and ConveBaseCod2 = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,4);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 20);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
      }
   }

}

