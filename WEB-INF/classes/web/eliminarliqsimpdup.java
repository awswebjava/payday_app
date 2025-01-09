package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminarliqsimpdup extends GXProcedure
{
   public eliminarliqsimpdup( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminarliqsimpdup.class ), "" );
   }

   public eliminarliqsimpdup( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      eliminarliqsimpdup.this.AV8clicod = aP0;
      eliminarliqsimpdup.this.AV9empcod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02CY2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02CY2_A31LiqNro[0] ;
         A1EmpCod = P02CY2_A1EmpCod[0] ;
         A3CliCod = P02CY2_A3CliCod[0] ;
         A283LiqPeriodo = P02CY2_A283LiqPeriodo[0] ;
         A719LiqFecImp = P02CY2_A719LiqFecImp[0] ;
         A495LiqCntLeg = P02CY2_A495LiqCntLeg[0] ;
         AV12LiqNro = A31LiqNro ;
         AV16LiqCntLeg = A495LiqCntLeg ;
         /* Using cursor P02CY3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A6LegNumero = P02CY3_A6LegNumero[0] ;
            A281LiqLegImpTotal = P02CY3_A281LiqLegImpTotal[0] ;
            AV11LegNumero = A6LegNumero ;
            AV10LiqLegImpTotal = A281LiqLegImpTotal ;
            AV15LiqPeriodo = A283LiqPeriodo ;
            /* Execute user subroutine: 'BUSCAR DUPLICADO' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(1);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
         A495LiqCntLeg = AV16LiqCntLeg ;
         /* Using cursor P02CY4 */
         pr_default.execute(2, new Object[] {Short.valueOf(A495LiqCntLeg), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'BUSCAR DUPLICADO' Routine */
      returnInSub = false ;
      GXv_boolean1[0] = AV13duplicaEs ;
      GXv_int2[0] = AV14AuxLiqNro ;
      new web.validarliqdupliporimporte(remoteHandle, context).execute( AV8clicod, AV9empcod, AV10LiqLegImpTotal, AV12LiqNro, AV11LegNumero, AV15LiqPeriodo, true, GXv_boolean1, GXv_int2) ;
      eliminarliqsimpdup.this.AV13duplicaEs = GXv_boolean1[0] ;
      eliminarliqsimpdup.this.AV14AuxLiqNro = GXv_int2[0] ;
      if ( AV13duplicaEs )
      {
         new web.eliminaliquidaciondetalle(remoteHandle, context).execute( AV8clicod, AV9empcod, AV14AuxLiqNro, AV11LegNumero, "") ;
         /* Using cursor P02CY5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV8clicod), Short.valueOf(AV9empcod), Integer.valueOf(AV14AuxLiqNro), Integer.valueOf(AV11LegNumero)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            A6LegNumero = P02CY5_A6LegNumero[0] ;
            A31LiqNro = P02CY5_A31LiqNro[0] ;
            A1EmpCod = P02CY5_A1EmpCod[0] ;
            A3CliCod = P02CY5_A3CliCod[0] ;
            A874LiqNombre = P02CY5_A874LiqNombre[0] ;
            A874LiqNombre = P02CY5_A874LiqNombre[0] ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV8clicod, AV22Pgmname, httpContext.getMessage( "elimina ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))+" \""+GXutil.trim( A874LiqNombre)+"\""+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
            /* Using cursor P02CY6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
            AV16LiqCntLeg = (short)(AV16LiqCntLeg-1) ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(3);
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminarliqsimpdup");
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
      P02CY2_A31LiqNro = new int[1] ;
      P02CY2_A1EmpCod = new short[1] ;
      P02CY2_A3CliCod = new int[1] ;
      P02CY2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02CY2_A719LiqFecImp = new java.util.Date[] {GXutil.nullDate()} ;
      P02CY2_A495LiqCntLeg = new short[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      P02CY3_A3CliCod = new int[1] ;
      P02CY3_A1EmpCod = new short[1] ;
      P02CY3_A31LiqNro = new int[1] ;
      P02CY3_A6LegNumero = new int[1] ;
      P02CY3_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      AV10LiqLegImpTotal = DecimalUtil.ZERO ;
      AV15LiqPeriodo = GXutil.nullDate() ;
      GXv_boolean1 = new boolean[1] ;
      GXv_int2 = new int[1] ;
      P02CY5_A6LegNumero = new int[1] ;
      P02CY5_A31LiqNro = new int[1] ;
      P02CY5_A1EmpCod = new short[1] ;
      P02CY5_A3CliCod = new int[1] ;
      P02CY5_A874LiqNombre = new String[] {""} ;
      A874LiqNombre = "" ;
      AV22Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminarliqsimpdup__default(),
         new Object[] {
             new Object[] {
            P02CY2_A31LiqNro, P02CY2_A1EmpCod, P02CY2_A3CliCod, P02CY2_A283LiqPeriodo, P02CY2_A719LiqFecImp, P02CY2_A495LiqCntLeg
            }
            , new Object[] {
            P02CY3_A3CliCod, P02CY3_A1EmpCod, P02CY3_A31LiqNro, P02CY3_A6LegNumero, P02CY3_A281LiqLegImpTotal
            }
            , new Object[] {
            }
            , new Object[] {
            P02CY5_A6LegNumero, P02CY5_A31LiqNro, P02CY5_A1EmpCod, P02CY5_A3CliCod, P02CY5_A874LiqNombre
            }
            , new Object[] {
            }
         }
      );
      AV22Pgmname = "eliminarLiqsImpDup" ;
      /* GeneXus formulas. */
      AV22Pgmname = "eliminarLiqsImpDup" ;
      Gx_err = (short)(0) ;
   }

   private short AV9empcod ;
   private short A1EmpCod ;
   private short A495LiqCntLeg ;
   private short AV16LiqCntLeg ;
   private short Gx_err ;
   private int AV8clicod ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int AV12LiqNro ;
   private int A6LegNumero ;
   private int AV11LegNumero ;
   private int AV14AuxLiqNro ;
   private int GXv_int2[] ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal AV10LiqLegImpTotal ;
   private String scmdbuf ;
   private String AV22Pgmname ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV15LiqPeriodo ;
   private boolean returnInSub ;
   private boolean AV13duplicaEs ;
   private boolean GXv_boolean1[] ;
   private String A874LiqNombre ;
   private IDataStoreProvider pr_default ;
   private int[] P02CY2_A31LiqNro ;
   private short[] P02CY2_A1EmpCod ;
   private int[] P02CY2_A3CliCod ;
   private java.util.Date[] P02CY2_A283LiqPeriodo ;
   private java.util.Date[] P02CY2_A719LiqFecImp ;
   private short[] P02CY2_A495LiqCntLeg ;
   private int[] P02CY3_A3CliCod ;
   private short[] P02CY3_A1EmpCod ;
   private int[] P02CY3_A31LiqNro ;
   private int[] P02CY3_A6LegNumero ;
   private java.math.BigDecimal[] P02CY3_A281LiqLegImpTotal ;
   private int[] P02CY5_A6LegNumero ;
   private int[] P02CY5_A31LiqNro ;
   private short[] P02CY5_A1EmpCod ;
   private int[] P02CY5_A3CliCod ;
   private String[] P02CY5_A874LiqNombre ;
}

final  class eliminarliqsimpdup__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02CY2", "SELECT LiqNro, EmpCod, CliCod, LiqPeriodo, LiqFecImp, LiqCntLeg FROM Liquidacion WHERE (CliCod = ? and EmpCod = ?) AND (Not (LiqFecImp = DATE '00010101')) ORDER BY CliCod, EmpCod  FOR UPDATE OF Liquidacion",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02CY3", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqLegImpTotal FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02CY4", "SAVEPOINT gxupdate;UPDATE Liquidacion SET LiqCntLeg=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P02CY5", "SELECT T1.LegNumero, T1.LiqNro, T1.EmpCod, T1.CliCod, T2.LiqNombre FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero  LIMIT 1 FOR UPDATE OF T1, T1",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02CY6", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLegajo  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDateTime(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

