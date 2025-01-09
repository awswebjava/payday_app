package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newcuentaobligacion extends GXProcedure
{
   public newcuentaobligacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newcuentaobligacion.class ), "" );
   }

   public newcuentaobligacion( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        int aP4 ,
                        int aP5 ,
                        boolean aP6 ,
                        java.math.BigDecimal aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.util.Date aP9 ,
                        String aP10 ,
                        boolean aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             int aP4 ,
                             int aP5 ,
                             boolean aP6 ,
                             java.math.BigDecimal aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.util.Date aP9 ,
                             String aP10 ,
                             boolean aP11 )
   {
      newcuentaobligacion.this.AV13CliCod = aP0;
      newcuentaobligacion.this.AV14EmpCod = aP1;
      newcuentaobligacion.this.AV15LegNumero = aP2;
      newcuentaobligacion.this.AV16OblSecuencial = aP3;
      newcuentaobligacion.this.AV17LiqOblAltaNro = aP4;
      newcuentaobligacion.this.AV18LiqOblNuevaNro = aP5;
      newcuentaobligacion.this.AV10LiqOblPrimera = aP6;
      newcuentaobligacion.this.AV8LiqOblCuota = aP7;
      newcuentaobligacion.this.AV11LiqOblSaldo = aP8;
      newcuentaobligacion.this.AV29LiqOblPeriodo = aP9;
      newcuentaobligacion.this.AV25ProcesoLiquidacion = aP10;
      newcuentaobligacion.this.AV26insertandoConceptos = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE LiqLegObligacionCuenta

      */
      A3CliCod = AV13CliCod ;
      A1EmpCod = AV14EmpCod ;
      A6LegNumero = AV15LegNumero ;
      A1172OblSecuencial = AV16OblSecuencial ;
      A1199LiqOblPeriodo = AV29LiqOblPeriodo ;
      A1184LiqOblAltaNro = AV17LiqOblAltaNro ;
      A1185LiqOblNuevaNro = AV18LiqOblNuevaNro ;
      A1186LiqOblPrimera = AV10LiqOblPrimera ;
      A1187LiqOblLog = AV19LiqOblLog ;
      A1188LiqOblCuota = AV8LiqOblCuota ;
      A1197LiqOblSaldo = AV11LiqOblSaldo ;
      if ( AV10LiqOblPrimera )
      {
         A1189LiqOblTotal = AV8LiqOblCuota.add(AV11LiqOblSaldo) ;
         A1190LiqOblTotRecal = AV8LiqOblCuota.add(AV11LiqOblSaldo) ;
      }
      else
      {
         A1189LiqOblTotal = DecimalUtil.ZERO ;
         A1190LiqOblTotRecal = DecimalUtil.ZERO ;
      }
      GXt_dtime1 = AV27ahora ;
      GXv_dtime2[0] = GXt_dtime1 ;
      new web.getahora(remoteHandle, context).execute( AV13CliCod, GXv_dtime2) ;
      newcuentaobligacion.this.GXt_dtime1 = GXv_dtime2[0] ;
      AV27ahora = GXt_dtime1 ;
      AV20LiqDLog = "#" + GXutil.trim( localUtil.ttoc( AV27ahora, 8, 12, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " ")) + httpContext.getMessage( " &&LiqOblPrimera ", "") + GXutil.trim( GXutil.booltostr( AV10LiqOblPrimera)) + httpContext.getMessage( " &&LiqOblAltaNro ", "") + GXutil.trim( GXutil.str( AV17LiqOblAltaNro, 8, 0)) + httpContext.getMessage( " &&LiqOblNuevaNro ", "") + GXutil.trim( GXutil.str( AV18LiqOblNuevaNro, 8, 0)) + httpContext.getMessage( " &&LiqOblSaldo ", "") + GXutil.trim( GXutil.str( AV11LiqOblSaldo, 14, 2)) ;
      A1187LiqOblLog = AV20LiqDLog ;
      /* Using cursor P01A22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro), Boolean.valueOf(A1186LiqOblPrimera), A1187LiqOblLog, A1188LiqOblCuota, A1189LiqOblTotal, A1190LiqOblTotRecal, A1197LiqOblSaldo, A1199LiqOblPeriodo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         AV20LiqDLog = httpContext.getMessage( "#dupli#&LiqLegPrimera ", "") + GXutil.trim( GXutil.booltostr( AV10LiqOblPrimera)) + httpContext.getMessage( " &ProcesoLiquidacion ", "") + GXutil.trim( AV25ProcesoLiquidacion) ;
         if ( ( AV10LiqOblPrimera ) && ( GXutil.strcmp(AV25ProcesoLiquidacion, "Recalculo") == 0 ) )
         {
            /* Using cursor P01A23 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A3CliCod = P01A23_A3CliCod[0] ;
               A1EmpCod = P01A23_A1EmpCod[0] ;
               A6LegNumero = P01A23_A6LegNumero[0] ;
               A1172OblSecuencial = P01A23_A1172OblSecuencial[0] ;
               A1184LiqOblAltaNro = P01A23_A1184LiqOblAltaNro[0] ;
               A1185LiqOblNuevaNro = P01A23_A1185LiqOblNuevaNro[0] ;
               A1190LiqOblTotRecal = P01A23_A1190LiqOblTotRecal[0] ;
               A1190LiqOblTotRecal = AV8LiqOblCuota.add(AV11LiqOblSaldo) ;
               AV20LiqDLog += httpContext.getMessage( "actualiza recal &&LiqOblCuota ", "") + GXutil.trim( GXutil.str( AV8LiqOblCuota, 14, 2)) + httpContext.getMessage( " + &&LiqOblSaldo ", "") + GXutil.trim( GXutil.str( AV11LiqOblSaldo, 14, 2)) ;
               /* Using cursor P01A24 */
               pr_default.execute(2, new Object[] {A1190LiqOblTotRecal, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), Short.valueOf(A1172OblSecuencial), Integer.valueOf(A1184LiqOblAltaNro), Integer.valueOf(A1185LiqOblNuevaNro)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
         }
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A1199LiqOblPeriodo = GXutil.nullDate() ;
      A1187LiqOblLog = "" ;
      AV19LiqOblLog = "" ;
      A1188LiqOblCuota = DecimalUtil.ZERO ;
      A1197LiqOblSaldo = DecimalUtil.ZERO ;
      A1189LiqOblTotal = DecimalUtil.ZERO ;
      A1190LiqOblTotRecal = DecimalUtil.ZERO ;
      AV27ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime2 = new java.util.Date[1] ;
      AV20LiqDLog = "" ;
      Gx_emsg = "" ;
      scmdbuf = "" ;
      P01A23_A3CliCod = new int[1] ;
      P01A23_A1EmpCod = new short[1] ;
      P01A23_A6LegNumero = new int[1] ;
      P01A23_A1172OblSecuencial = new short[1] ;
      P01A23_A1184LiqOblAltaNro = new int[1] ;
      P01A23_A1185LiqOblNuevaNro = new int[1] ;
      P01A23_A1190LiqOblTotRecal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newcuentaobligacion__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P01A23_A3CliCod, P01A23_A1EmpCod, P01A23_A6LegNumero, P01A23_A1172OblSecuencial, P01A23_A1184LiqOblAltaNro, P01A23_A1185LiqOblNuevaNro, P01A23_A1190LiqOblTotRecal
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV14EmpCod ;
   private short AV16OblSecuencial ;
   private short A1EmpCod ;
   private short A1172OblSecuencial ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV15LegNumero ;
   private int AV17LiqOblAltaNro ;
   private int AV18LiqOblNuevaNro ;
   private int GX_INS136 ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A1184LiqOblAltaNro ;
   private int A1185LiqOblNuevaNro ;
   private java.math.BigDecimal AV8LiqOblCuota ;
   private java.math.BigDecimal AV11LiqOblSaldo ;
   private java.math.BigDecimal A1188LiqOblCuota ;
   private java.math.BigDecimal A1197LiqOblSaldo ;
   private java.math.BigDecimal A1189LiqOblTotal ;
   private java.math.BigDecimal A1190LiqOblTotRecal ;
   private String AV25ProcesoLiquidacion ;
   private String Gx_emsg ;
   private String scmdbuf ;
   private java.util.Date AV27ahora ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXv_dtime2[] ;
   private java.util.Date AV29LiqOblPeriodo ;
   private java.util.Date A1199LiqOblPeriodo ;
   private boolean AV10LiqOblPrimera ;
   private boolean AV26insertandoConceptos ;
   private boolean A1186LiqOblPrimera ;
   private String AV20LiqDLog ;
   private String A1187LiqOblLog ;
   private String AV19LiqOblLog ;
   private IDataStoreProvider pr_default ;
   private int[] P01A23_A3CliCod ;
   private short[] P01A23_A1EmpCod ;
   private int[] P01A23_A6LegNumero ;
   private short[] P01A23_A1172OblSecuencial ;
   private int[] P01A23_A1184LiqOblAltaNro ;
   private int[] P01A23_A1185LiqOblNuevaNro ;
   private java.math.BigDecimal[] P01A23_A1190LiqOblTotRecal ;
}

final  class newcuentaobligacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01A22", "SAVEPOINT gxupdate;INSERT INTO LiqLegObligacionCuenta(CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro, LiqOblPrimera, LiqOblLog, LiqOblCuota, LiqOblTotal, LiqOblTotRecal, LiqOblSaldo, LiqOblPeriodo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01A23", "SELECT CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro, LiqOblTotRecal FROM LiqLegObligacionCuenta WHERE CliCod = ? and EmpCod = ? and LegNumero = ? and OblSecuencial = ? and LiqOblAltaNro = ? and LiqOblNuevaNro = ? ORDER BY CliCod, EmpCod, LegNumero, OblSecuencial, LiqOblAltaNro, LiqOblNuevaNro  FOR UPDATE OF LiqLegObligacionCuenta",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01A24", "SAVEPOINT gxupdate;UPDATE LiqLegObligacionCuenta SET LiqOblTotRecal=?  WHERE CliCod = ? AND EmpCod = ? AND LegNumero = ? AND OblSecuencial = ? AND LiqOblAltaNro = ? AND LiqOblNuevaNro = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
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
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setVarchar(8, (String)parms[7], 1000, false);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setDate(13, (java.util.Date)parms[12]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 2 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               return;
      }
   }

}

