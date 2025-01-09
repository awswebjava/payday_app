package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class bajalegajossiegreso extends GXProcedure
{
   public bajalegajossiegreso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( bajalegajossiegreso.class ), "" );
   }

   public bajalegajossiegreso( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 )
   {
      bajalegajossiegreso.this.AV9CliCod = aP0;
      bajalegajossiegreso.this.AV8EmpCod = aP1;
      bajalegajossiegreso.this.AV10LiqNro = aP2;
      bajalegajossiegreso.this.AV12TLiqCod = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV11egresoTLiqCod ;
      GXt_char2 = AV11egresoTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      bajalegajossiegreso.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      bajalegajossiegreso.this.GXt_char1 = GXv_char4[0] ;
      AV11egresoTLiqCod = GXt_char1 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV17Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " liq ", "")+GXutil.trim( GXutil.str( AV10LiqNro, 8, 0))) ;
      if ( GXutil.strcmp(AV12TLiqCod, AV11egresoTLiqCod) == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV17Pgmname, httpContext.getMessage( "es egreso ", "")) ;
         AV18GXLvl5 = (byte)(0) ;
         /* Using cursor P025Z2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LiqNro)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A31LiqNro = P025Z2_A31LiqNro[0] ;
            A1EmpCod = P025Z2_A1EmpCod[0] ;
            A3CliCod = P025Z2_A3CliCod[0] ;
            A6LegNumero = P025Z2_A6LegNumero[0] ;
            A244LegFecEgreso = P025Z2_A244LegFecEgreso[0] ;
            n244LegFecEgreso = P025Z2_n244LegFecEgreso[0] ;
            A283LiqPeriodo = P025Z2_A283LiqPeriodo[0] ;
            A244LegFecEgreso = P025Z2_A244LegFecEgreso[0] ;
            n244LegFecEgreso = P025Z2_n244LegFecEgreso[0] ;
            AV18GXLvl5 = (byte)(1) ;
            new web.actualizarlegajoactivo(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, A6LegNumero, (byte)(2)) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV17Pgmname, httpContext.getMessage( "LegNumero ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))+httpContext.getMessage( " bajo!", "")) ;
            new web.actualizarliqpermanencia(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, A6LegNumero, A244LegFecEgreso, A31LiqNro) ;
            AV13hoy = GXutil.serverDate( context, remoteHandle, pr_default) ;
            GXv_int5[0] = AV14LegCuLiPSaldo ;
            new web.licccgetsaldodisponible(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, A6LegNumero, "Vacaciones", (short)(GXutil.year( AV13hoy)), GXv_int5) ;
            bajalegajossiegreso.this.AV14LegCuLiPSaldo = GXv_int5[0] ;
            if ( AV14LegCuLiPSaldo > 0 )
            {
               new web.asignarconsumoscclicencias(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, A6LegNumero, A283LiqPeriodo, AV14LegCuLiPSaldo, "final", A31LiqNro) ;
            }
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV18GXLvl5 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV17Pgmname, httpContext.getMessage( "none liq", "")) ;
         }
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "bajalegajossiegreso");
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
      AV11egresoTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV17Pgmname = "" ;
      scmdbuf = "" ;
      P025Z2_A31LiqNro = new int[1] ;
      P025Z2_A1EmpCod = new short[1] ;
      P025Z2_A3CliCod = new int[1] ;
      P025Z2_A6LegNumero = new int[1] ;
      P025Z2_A244LegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      P025Z2_n244LegFecEgreso = new boolean[] {false} ;
      P025Z2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A283LiqPeriodo = GXutil.nullDate() ;
      AV13hoy = GXutil.nullDate() ;
      GXv_int5 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.bajalegajossiegreso__default(),
         new Object[] {
             new Object[] {
            P025Z2_A31LiqNro, P025Z2_A1EmpCod, P025Z2_A3CliCod, P025Z2_A6LegNumero, P025Z2_A244LegFecEgreso, P025Z2_n244LegFecEgreso, P025Z2_A283LiqPeriodo
            }
         }
      );
      AV17Pgmname = "bajaLegajosSiEgreso" ;
      /* GeneXus formulas. */
      AV17Pgmname = "bajaLegajosSiEgreso" ;
      Gx_err = (short)(0) ;
   }

   private byte AV18GXLvl5 ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short AV14LegCuLiPSaldo ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String AV12TLiqCod ;
   private String AV11egresoTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV17Pgmname ;
   private String scmdbuf ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV13hoy ;
   private boolean n244LegFecEgreso ;
   private IDataStoreProvider pr_default ;
   private int[] P025Z2_A31LiqNro ;
   private short[] P025Z2_A1EmpCod ;
   private int[] P025Z2_A3CliCod ;
   private int[] P025Z2_A6LegNumero ;
   private java.util.Date[] P025Z2_A244LegFecEgreso ;
   private boolean[] P025Z2_n244LegFecEgreso ;
   private java.util.Date[] P025Z2_A283LiqPeriodo ;
}

final  class bajalegajossiegreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P025Z2", "SELECT T1.LiqNro, T1.EmpCod, T1.CliCod, T1.LegNumero, T2.LegFecEgreso, T1.LiqPeriodo FROM (LiquidacionLegajo T1 INNER JOIN Legajo T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
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
      }
   }

}

