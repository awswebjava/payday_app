package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class existeliquidacionpertipo extends GXProcedure
{
   public existeliquidacionpertipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( existeliquidacionpertipo.class ), "" );
   }

   public existeliquidacionpertipo( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            String aP2 ,
                            java.util.Date aP3 ,
                            String aP4 ,
                            byte aP5 ,
                            String aP6 )
   {
      existeliquidacionpertipo.this.aP7 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        byte aP5 ,
                        String aP6 ,
                        short[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             byte aP5 ,
                             String aP6 ,
                             short[] aP7 )
   {
      existeliquidacionpertipo.this.AV12CliCod = aP0;
      existeliquidacionpertipo.this.AV8EmpCod = aP1;
      existeliquidacionpertipo.this.AV11TLiqCod = aP2;
      existeliquidacionpertipo.this.AV10LiqPeriodo = aP3;
      existeliquidacionpertipo.this.AV15LiqModTra = aP4;
      existeliquidacionpertipo.this.AV16LiqFrecPag = aP5;
      existeliquidacionpertipo.this.AV17LiqTipoTarifa = aP6;
      existeliquidacionpertipo.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P00VY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), AV11TLiqCod, AV10LiqPeriodo, AV15LiqModTra, Byte.valueOf(AV16LiqFrecPag), AV17LiqTipoTarifa});
      cV13cantidad = P00VY2_AV13cantidad[0] ;
      pr_default.close(0);
      AV13cantidad = (short)(AV13cantidad+cV13cantidad*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = existeliquidacionpertipo.this.AV13cantidad;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P00VY2_AV13cantidad = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.existeliquidacionpertipo__default(),
         new Object[] {
             new Object[] {
            P00VY2_AV13cantidad
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV16LiqFrecPag ;
   private short AV8EmpCod ;
   private short AV13cantidad ;
   private short cV13cantidad ;
   private short Gx_err ;
   private int AV12CliCod ;
   private String AV11TLiqCod ;
   private String AV15LiqModTra ;
   private String AV17LiqTipoTarifa ;
   private String scmdbuf ;
   private java.util.Date AV10LiqPeriodo ;
   private short[] aP7 ;
   private IDataStoreProvider pr_default ;
   private short[] P00VY2_AV13cantidad ;
}

final  class existeliquidacionpertipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00VY2", "SELECT COUNT(*) FROM Liquidacion WHERE (CliCod = ? and EmpCod = ? and TLiqCod = ( ?) and LiqPeriodo = ?) AND (LiqRelNro IS NULL) AND (LiqModTra = ( ?)) AND (LiqFrecPag = ?) AND (LiqTipoTarifa = ( ?)) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 1);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 1);
               return;
      }
   }

}

