package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class setestadoliqok extends GXProcedure
{
   public setestadoliqok( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( setestadoliqok.class ), "" );
   }

   public setestadoliqok( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date[] aP3 )
   {
      setestadoliqok.this.aP4 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date[] aP3 ,
                        boolean[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date[] aP3 ,
                             boolean[] aP4 )
   {
      setestadoliqok.this.AV11CliCod = aP0;
      setestadoliqok.this.AV12EmpCod = aP1;
      setestadoliqok.this.AV9LiqNro = aP2;
      setestadoliqok.this.aP3 = aP3;
      setestadoliqok.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, "1") ;
      AV22GXLvl3 = (byte)(0) ;
      /* Using cursor P02B82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02B82_A31LiqNro[0] ;
         A1EmpCod = P02B82_A1EmpCod[0] ;
         A3CliCod = P02B82_A3CliCod[0] ;
         A283LiqPeriodo = P02B82_A283LiqPeriodo[0] ;
         A278LiqEstado = P02B82_A278LiqEstado[0] ;
         A496LiqImpNeto = P02B82_A496LiqImpNeto[0] ;
         A497LiqImpBruto = P02B82_A497LiqImpBruto[0] ;
         A495LiqCntLeg = P02B82_A495LiqCntLeg[0] ;
         AV22GXLvl3 = (byte)(1) ;
         AV8LiqPeriodo = A283LiqPeriodo ;
         /* Optimized group. */
         /* Using cursor P02B83 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV9LiqNro)});
         cV15LiqCntLeg = P02B83_AV15LiqCntLeg[0] ;
         c2268LiqLegProcesado = P02B83_A2268LiqLegProcesado[0] ;
         c281LiqLegImpTotal = P02B83_A281LiqLegImpTotal[0] ;
         c498LiqLegImpTotBruto = P02B83_A498LiqLegImpTotBruto[0] ;
         pr_default.close(1);
         AV15LiqCntLeg = (short)(AV15LiqCntLeg+cV15LiqCntLeg*1) ;
         AV16LiqLegProcesado = (byte)(AV16LiqLegProcesado+c2268LiqLegProcesado) ;
         AV13LiqImpNeto = AV13LiqImpNeto.add(c281LiqLegImpTotal) ;
         AV14LiqImpBruto = AV14LiqImpBruto.add(c498LiqLegImpTotBruto) ;
         /* End optimized group. */
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&LiqCntLeg ", "")+GXutil.trim( GXutil.str( AV15LiqCntLeg, 4, 0))+httpContext.getMessage( " &LiqLegProcesado ", "")+GXutil.trim( GXutil.str( AV16LiqLegProcesado, 1, 0))) ;
         A278LiqEstado = (byte)(3) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "setea estado ok", "")) ;
         AV18ok = true ;
         A496LiqImpNeto = AV13LiqImpNeto ;
         A497LiqImpBruto = AV14LiqImpBruto ;
         A495LiqCntLeg = AV15LiqCntLeg ;
         /* Using cursor P02B84 */
         pr_default.execute(2, new Object[] {Byte.valueOf(A278LiqEstado), A496LiqImpNeto, A497LiqImpBruto, Short.valueOf(A495LiqCntLeg), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV22GXLvl3 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = setestadoliqok.this.AV8LiqPeriodo;
      this.aP4[0] = setestadoliqok.this.AV18ok;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8LiqPeriodo = GXutil.nullDate() ;
      AV21Pgmname = "" ;
      scmdbuf = "" ;
      P02B82_A31LiqNro = new int[1] ;
      P02B82_A1EmpCod = new short[1] ;
      P02B82_A3CliCod = new int[1] ;
      P02B82_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02B82_A278LiqEstado = new byte[1] ;
      P02B82_A496LiqImpNeto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02B82_A497LiqImpBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02B82_A495LiqCntLeg = new short[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      c281LiqLegImpTotal = DecimalUtil.ZERO ;
      c498LiqLegImpTotBruto = DecimalUtil.ZERO ;
      P02B83_AV15LiqCntLeg = new short[1] ;
      P02B83_A2268LiqLegProcesado = new byte[1] ;
      P02B83_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P02B83_A498LiqLegImpTotBruto = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV13LiqImpNeto = DecimalUtil.ZERO ;
      AV14LiqImpBruto = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.setestadoliqok__default(),
         new Object[] {
             new Object[] {
            P02B82_A31LiqNro, P02B82_A1EmpCod, P02B82_A3CliCod, P02B82_A283LiqPeriodo, P02B82_A278LiqEstado, P02B82_A496LiqImpNeto, P02B82_A497LiqImpBruto, P02B82_A495LiqCntLeg
            }
            , new Object[] {
            P02B83_AV15LiqCntLeg, P02B83_A2268LiqLegProcesado, P02B83_A281LiqLegImpTotal, P02B83_A498LiqLegImpTotBruto
            }
            , new Object[] {
            }
         }
      );
      AV21Pgmname = "setEstadoLiqOK" ;
      /* GeneXus formulas. */
      AV21Pgmname = "setEstadoLiqOK" ;
      Gx_err = (short)(0) ;
   }

   private byte AV22GXLvl3 ;
   private byte A278LiqEstado ;
   private byte c2268LiqLegProcesado ;
   private byte AV16LiqLegProcesado ;
   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short A495LiqCntLeg ;
   private short cV15LiqCntLeg ;
   private short AV15LiqCntLeg ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal c281LiqLegImpTotal ;
   private java.math.BigDecimal c498LiqLegImpTotBruto ;
   private java.math.BigDecimal AV13LiqImpNeto ;
   private java.math.BigDecimal AV14LiqImpBruto ;
   private String AV21Pgmname ;
   private String scmdbuf ;
   private java.util.Date AV8LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV18ok ;
   private boolean[] aP4 ;
   private java.util.Date[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02B82_A31LiqNro ;
   private short[] P02B82_A1EmpCod ;
   private int[] P02B82_A3CliCod ;
   private java.util.Date[] P02B82_A283LiqPeriodo ;
   private byte[] P02B82_A278LiqEstado ;
   private java.math.BigDecimal[] P02B82_A496LiqImpNeto ;
   private java.math.BigDecimal[] P02B82_A497LiqImpBruto ;
   private short[] P02B82_A495LiqCntLeg ;
   private short[] P02B83_AV15LiqCntLeg ;
   private byte[] P02B83_A2268LiqLegProcesado ;
   private java.math.BigDecimal[] P02B83_A281LiqLegImpTotal ;
   private java.math.BigDecimal[] P02B83_A498LiqLegImpTotBruto ;
}

final  class setestadoliqok__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02B82", "SELECT LiqNro, EmpCod, CliCod, LiqPeriodo, LiqEstado, LiqImpNeto, LiqImpBruto, LiqCntLeg FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P02B83", "SELECT COUNT(*), SUM(LiqLegProcesado), SUM(LiqLegImpTotal), SUM(LiqLegImpTotBruto) FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02B84", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqEstado=?, LiqImpNeto=?, LiqImpBruto=?, LiqCntLeg=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 2);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 2);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
      }
   }

}

