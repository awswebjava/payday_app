package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempbasedatosremu extends GXProcedure
{
   public getempbasedatosremu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempbasedatosremu.class ), "" );
   }

   public getempbasedatosremu( int remoteHandle ,
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
                              java.math.BigDecimal[] aP6 ,
                              short[] aP7 ,
                              short[] aP8 ,
                              String[] aP9 )
   {
      getempbasedatosremu.this.aP10 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        short[] aP7 ,
                        short[] aP8 ,
                        String[] aP9 ,
                        boolean[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             short[] aP7 ,
                             short[] aP8 ,
                             String[] aP9 ,
                             boolean[] aP10 )
   {
      getempbasedatosremu.this.AV18CliCod = aP0;
      getempbasedatosremu.this.AV17EmpCod = aP1;
      getempbasedatosremu.this.AV20tipo_tarifa = aP2;
      getempbasedatosremu.this.AV15tipo_base = aP3;
      getempbasedatosremu.this.AV14codigo1 = aP4;
      getempbasedatosremu.this.AV13codigo2 = aP5;
      getempbasedatosremu.this.aP6 = aP6;
      getempbasedatosremu.this.aP7 = aP7;
      getempbasedatosremu.this.aP8 = aP8;
      getempbasedatosremu.this.aP9 = aP9;
      getempbasedatosremu.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.strcmp(AV20tipo_tarifa, "H") == 0 )
      {
         AV16ClaseLeg = (byte)(2) ;
      }
      else
      {
         AV16ClaseLeg = (byte)(1) ;
      }
      /* Using cursor P01GN2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV18CliCod), Short.valueOf(AV17EmpCod), Byte.valueOf(AV16ClaseLeg), AV15tipo_base, AV14codigo1, AV13codigo2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1431EmpBaseCod2 = P01GN2_A1431EmpBaseCod2[0] ;
         A1430EmpBaseCod1 = P01GN2_A1430EmpBaseCod1[0] ;
         A1429EmpBaseTipo = P01GN2_A1429EmpBaseTipo[0] ;
         A1427EmpBaseClaseLeg = P01GN2_A1427EmpBaseClaseLeg[0] ;
         A1EmpCod = P01GN2_A1EmpCod[0] ;
         A3CliCod = P01GN2_A3CliCod[0] ;
         A1432EmpBasePlus = P01GN2_A1432EmpBasePlus[0] ;
         A1437EmpBasePromCnt1 = P01GN2_A1437EmpBasePromCnt1[0] ;
         A1438EmpBasePromCnt2 = P01GN2_A1438EmpBasePromCnt2[0] ;
         A1439EmpBasePromTCnt = P01GN2_A1439EmpBasePromTCnt[0] ;
         AV9EmpBasePlus = A1432EmpBasePlus ;
         AV12EmpBasePromCnt1 = A1437EmpBasePromCnt1 ;
         AV10EmpBasePromCnt2 = A1438EmpBasePromCnt2 ;
         AV11EmpBasePromTCnt = A1439EmpBasePromTCnt ;
         AV19hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = getempbasedatosremu.this.AV9EmpBasePlus;
      this.aP7[0] = getempbasedatosremu.this.AV12EmpBasePromCnt1;
      this.aP8[0] = getempbasedatosremu.this.AV10EmpBasePromCnt2;
      this.aP9[0] = getempbasedatosremu.this.AV11EmpBasePromTCnt;
      this.aP10[0] = getempbasedatosremu.this.AV19hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9EmpBasePlus = DecimalUtil.ZERO ;
      AV11EmpBasePromTCnt = "" ;
      scmdbuf = "" ;
      P01GN2_A1431EmpBaseCod2 = new String[] {""} ;
      P01GN2_A1430EmpBaseCod1 = new String[] {""} ;
      P01GN2_A1429EmpBaseTipo = new String[] {""} ;
      P01GN2_A1427EmpBaseClaseLeg = new byte[1] ;
      P01GN2_A1EmpCod = new short[1] ;
      P01GN2_A3CliCod = new int[1] ;
      P01GN2_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GN2_A1437EmpBasePromCnt1 = new short[1] ;
      P01GN2_A1438EmpBasePromCnt2 = new short[1] ;
      P01GN2_A1439EmpBasePromTCnt = new String[] {""} ;
      A1431EmpBaseCod2 = "" ;
      A1430EmpBaseCod1 = "" ;
      A1429EmpBaseTipo = "" ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      A1439EmpBasePromTCnt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempbasedatosremu__default(),
         new Object[] {
             new Object[] {
            P01GN2_A1431EmpBaseCod2, P01GN2_A1430EmpBaseCod1, P01GN2_A1429EmpBaseTipo, P01GN2_A1427EmpBaseClaseLeg, P01GN2_A1EmpCod, P01GN2_A3CliCod, P01GN2_A1432EmpBasePlus, P01GN2_A1437EmpBasePromCnt1, P01GN2_A1438EmpBasePromCnt2, P01GN2_A1439EmpBasePromTCnt
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16ClaseLeg ;
   private byte A1427EmpBaseClaseLeg ;
   private short AV17EmpCod ;
   private short AV12EmpBasePromCnt1 ;
   private short AV10EmpBasePromCnt2 ;
   private short A1EmpCod ;
   private short A1437EmpBasePromCnt1 ;
   private short A1438EmpBasePromCnt2 ;
   private short Gx_err ;
   private int AV18CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV9EmpBasePlus ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private String AV20tipo_tarifa ;
   private String AV15tipo_base ;
   private String AV14codigo1 ;
   private String AV13codigo2 ;
   private String AV11EmpBasePromTCnt ;
   private String scmdbuf ;
   private String A1431EmpBaseCod2 ;
   private String A1430EmpBaseCod1 ;
   private String A1429EmpBaseTipo ;
   private String A1439EmpBasePromTCnt ;
   private boolean AV19hay ;
   private boolean[] aP10 ;
   private java.math.BigDecimal[] aP6 ;
   private short[] aP7 ;
   private short[] aP8 ;
   private String[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P01GN2_A1431EmpBaseCod2 ;
   private String[] P01GN2_A1430EmpBaseCod1 ;
   private String[] P01GN2_A1429EmpBaseTipo ;
   private byte[] P01GN2_A1427EmpBaseClaseLeg ;
   private short[] P01GN2_A1EmpCod ;
   private int[] P01GN2_A3CliCod ;
   private java.math.BigDecimal[] P01GN2_A1432EmpBasePlus ;
   private short[] P01GN2_A1437EmpBasePromCnt1 ;
   private short[] P01GN2_A1438EmpBasePromCnt2 ;
   private String[] P01GN2_A1439EmpBasePromTCnt ;
}

final  class getempbasedatosremu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GN2", "SELECT EmpBaseCod2, EmpBaseCod1, EmpBaseTipo, EmpBaseClaseLeg, EmpCod, CliCod, EmpBasePlus, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt FROM Empresabase_calculo WHERE CliCod = ? and EmpCod = ? and EmpBaseClaseLeg = ? and EmpBaseTipo = ( ?) and EmpBaseCod1 = ( ?) and EmpBaseCod2 = ( ?) ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((String[]) buf[9])[0] = rslt.getString(10, 20);
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
      }
   }

}

