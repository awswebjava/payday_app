package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class saldof1357 extends GXProcedure
{
   public saldof1357( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( saldof1357.class ), "" );
   }

   public saldof1357( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           java.util.Date aP3 )
   {
      saldof1357.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      saldof1357.this.AV12CliCod = aP0;
      saldof1357.this.AV13EmpCod = aP1;
      saldof1357.this.AV15LegNumero = aP2;
      saldof1357.this.AV11LiqPeriodo = aP3;
      saldof1357.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( GXutil.month( AV11LiqPeriodo) == 4 )
      {
         AV10anioAnterior = (short)(GXutil.year( AV11LiqPeriodo)-1) ;
         AV9F1357CPer = GXutil.trim( GXutil.str( AV10anioAnterior, 4, 0)) + "12" ;
         /* Using cursor P00WQ2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13EmpCod), Integer.valueOf(AV15LegNumero), AV9F1357CPer});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A861F1357LCTipReg = P00WQ2_A861F1357LCTipReg[0] ;
            A6LegNumero = P00WQ2_A6LegNumero[0] ;
            A777F1357CPer = P00WQ2_A777F1357CPer[0] ;
            A784F1357CTipoPre = P00WQ2_A784F1357CTipoPre[0] ;
            A1EmpCod = P00WQ2_A1EmpCod[0] ;
            A3CliCod = P00WQ2_A3CliCod[0] ;
            A849F1357LCSaldo = P00WQ2_A849F1357LCSaldo[0] ;
            A778F1357CSec = P00WQ2_A778F1357CSec[0] ;
            AV8F1357LCSaldo = A849F1357LCSaldo.multiply(DecimalUtil.doubleToDec(-1)) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = saldof1357.this.AV8F1357LCSaldo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8F1357LCSaldo = DecimalUtil.ZERO ;
      AV9F1357CPer = "" ;
      scmdbuf = "" ;
      P00WQ2_A861F1357LCTipReg = new String[] {""} ;
      P00WQ2_A6LegNumero = new int[1] ;
      P00WQ2_A777F1357CPer = new String[] {""} ;
      P00WQ2_A784F1357CTipoPre = new byte[1] ;
      P00WQ2_A1EmpCod = new short[1] ;
      P00WQ2_A3CliCod = new int[1] ;
      P00WQ2_A849F1357LCSaldo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00WQ2_A778F1357CSec = new byte[1] ;
      A861F1357LCTipReg = "" ;
      A777F1357CPer = "" ;
      A849F1357LCSaldo = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.saldof1357__default(),
         new Object[] {
             new Object[] {
            P00WQ2_A861F1357LCTipReg, P00WQ2_A6LegNumero, P00WQ2_A777F1357CPer, P00WQ2_A784F1357CTipoPre, P00WQ2_A1EmpCod, P00WQ2_A3CliCod, P00WQ2_A849F1357LCSaldo, P00WQ2_A778F1357CSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private short AV13EmpCod ;
   private short AV10anioAnterior ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV15LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private java.math.BigDecimal AV8F1357LCSaldo ;
   private java.math.BigDecimal A849F1357LCSaldo ;
   private String AV9F1357CPer ;
   private String scmdbuf ;
   private String A861F1357LCTipReg ;
   private String A777F1357CPer ;
   private java.util.Date AV11LiqPeriodo ;
   private java.math.BigDecimal[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P00WQ2_A861F1357LCTipReg ;
   private int[] P00WQ2_A6LegNumero ;
   private String[] P00WQ2_A777F1357CPer ;
   private byte[] P00WQ2_A784F1357CTipoPre ;
   private short[] P00WQ2_A1EmpCod ;
   private int[] P00WQ2_A3CliCod ;
   private java.math.BigDecimal[] P00WQ2_A849F1357LCSaldo ;
   private byte[] P00WQ2_A778F1357CSec ;
}

final  class saldof1357__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00WQ2", "SELECT F1357LCTipReg, LegNumero, F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357LCSaldo, F1357CSec FROM F1357LCalculo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and F1357CTipoPre = 1 and F1357CPer = ( ?) and F1357LCTipReg = ( '06') ORDER BY CliCod, EmpCod, LegNumero, F1357CTipoPre, F1357CPer, F1357LCTipReg, F1357CSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 6);
               return;
      }
   }

}

