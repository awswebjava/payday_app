package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class liqsumarcontribuciones extends GXProcedure
{
   public liqsumarcontribuciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( liqsumarcontribuciones.class ), "" );
   }

   public liqsumarcontribuciones( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      liqsumarcontribuciones.this.AV8CliCod = aP0;
      liqsumarcontribuciones.this.AV9EmpCod = aP1;
      liqsumarcontribuciones.this.AV10LiqNro = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02BH2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02BH2_A31LiqNro[0] ;
         A1EmpCod = P02BH2_A1EmpCod[0] ;
         A3CliCod = P02BH2_A3CliCod[0] ;
         A6LegNumero = P02BH2_A6LegNumero[0] ;
         A1157LiqLegImpContr = P02BH2_A1157LiqLegImpContr[0] ;
         GXv_decimal1[0] = AV11LiqLegImpContr ;
         new web.liqlegsumarcontribuciones(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, A6LegNumero, GXv_decimal1) ;
         liqsumarcontribuciones.this.AV11LiqLegImpContr = GXv_decimal1[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "&LiqLegImpContr ", "")+GXutil.trim( GXutil.str( AV11LiqLegImpContr, 14, 2))) ;
         A1157LiqLegImpContr = AV11LiqLegImpContr ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "g!raba ", "")+GXutil.str( AV11LiqLegImpContr, 14, 2)) ;
         /* Using cursor P02BH3 */
         pr_default.execute(1, new Object[] {A1157LiqLegImpContr, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "liqsumarcontribuciones");
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
      P02BH2_A31LiqNro = new int[1] ;
      P02BH2_A1EmpCod = new short[1] ;
      P02BH2_A3CliCod = new int[1] ;
      P02BH2_A6LegNumero = new int[1] ;
      P02BH2_A1157LiqLegImpContr = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1157LiqLegImpContr = DecimalUtil.ZERO ;
      AV11LiqLegImpContr = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV15Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.liqsumarcontribuciones__default(),
         new Object[] {
             new Object[] {
            P02BH2_A31LiqNro, P02BH2_A1EmpCod, P02BH2_A3CliCod, P02BH2_A6LegNumero, P02BH2_A1157LiqLegImpContr
            }
            , new Object[] {
            }
         }
      );
      AV15Pgmname = "LiqSumarContribuciones" ;
      /* GeneXus formulas. */
      AV15Pgmname = "LiqSumarContribuciones" ;
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private java.math.BigDecimal A1157LiqLegImpContr ;
   private java.math.BigDecimal AV11LiqLegImpContr ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private String scmdbuf ;
   private String AV15Pgmname ;
   private IDataStoreProvider pr_default ;
   private int[] P02BH2_A31LiqNro ;
   private short[] P02BH2_A1EmpCod ;
   private int[] P02BH2_A3CliCod ;
   private int[] P02BH2_A6LegNumero ;
   private java.math.BigDecimal[] P02BH2_A1157LiqLegImpContr ;
}

final  class liqsumarcontribuciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BH2", "SELECT LiqNro, EmpCod, CliCod, LegNumero, LiqLegImpContr FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro  FOR UPDATE OF LiquidacionLegajo",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P02BH3", "SAVEPOINT gxupdate;UPDATE LiquidacionLegajo SET LiqLegImpContr=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
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
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
      }
   }

}

