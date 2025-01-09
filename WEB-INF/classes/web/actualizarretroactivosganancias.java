package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarretroactivosganancias extends GXProcedure
{
   public actualizarretroactivosganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarretroactivosganancias.class ), "" );
   }

   public actualizarretroactivosganancias( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             short aP4 ,
                             java.util.Date aP5 )
   {
      actualizarretroactivosganancias.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        GXSimpleCollection<Integer> aP3 ,
                        short aP4 ,
                        java.util.Date aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             GXSimpleCollection<Integer> aP3 ,
                             short aP4 ,
                             java.util.Date aP5 ,
                             String[] aP6 )
   {
      actualizarretroactivosganancias.this.AV14CliCod = aP0;
      actualizarretroactivosganancias.this.AV8EmpCod = aP1;
      actualizarretroactivosganancias.this.AV16LiqNro = aP2;
      actualizarretroactivosganancias.this.AV23parmLegNumero = aP3;
      actualizarretroactivosganancias.this.AV20LiqPerAno = aP4;
      actualizarretroactivosganancias.this.AV22LiqPeriodo = aP5;
      actualizarretroactivosganancias.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV21pagosACuentaConCodigo ;
      GXt_char2 = AV21pagosACuentaConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      actualizarretroactivosganancias.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV14CliCod, GXt_char2, GXv_char4) ;
      actualizarretroactivosganancias.this.GXt_char1 = GXv_char4[0] ;
      AV21pagosACuentaConCodigo = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "1 !dsfdsf &parmLegNumero ", "")+GXutil.str( AV23parmLegNumero.size(), 9, 0)) ;
      AV11eneroFecha = localUtil.ymdtod( GXutil.year( AV12fecha), 1, 1) ;
      AV24i = (short)(1) ;
      while ( AV24i <= AV23parmLegNumero.size() )
      {
         AV9LegNumero = ((Number) AV23parmLegNumero.elementAt(-1+AV24i)).intValue() ;
         GXv_boolean5[0] = AV25LegAgenReten ;
         new web.getlegagenreten(remoteHandle, context).execute( AV14CliCod, AV8EmpCod, AV9LegNumero, GXv_boolean5) ;
         actualizarretroactivosganancias.this.AV25LegAgenReten = GXv_boolean5[0] ;
         if ( AV25LegAgenReten )
         {
            /* Using cursor P00ST2 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV16LiqNro), Integer.valueOf(AV9LegNumero)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A6LegNumero = P00ST2_A6LegNumero[0] ;
               A31LiqNro = P00ST2_A31LiqNro[0] ;
               A1EmpCod = P00ST2_A1EmpCod[0] ;
               A3CliCod = P00ST2_A3CliCod[0] ;
               A283LiqPeriodo = P00ST2_A283LiqPeriodo[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "LegNumero ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))) ;
               GXt_boolean6 = AV17recalcular ;
               GXv_boolean5[0] = GXt_boolean6 ;
               new web.getlegrecalcularliq(remoteHandle, context).execute( AV14CliCod, AV8EmpCod, AV9LegNumero, GXv_boolean5) ;
               actualizarretroactivosganancias.this.GXt_boolean6 = GXv_boolean5[0] ;
               AV17recalcular = GXt_boolean6 ;
               if ( ( AV17recalcular ) && ( new web.viejopagosacuenta(remoteHandle, context).executeUdp( ) ) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  new web.resetearcuenta(remoteHandle, context).execute( AV14CliCod, AV8EmpCod, AV16LiqNro, AV20LiqPerAno, A283LiqPeriodo, AV9LegNumero, AV21pagosACuentaConCodigo) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "&LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV22LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &recalcular ", "")+GXutil.trim( GXutil.booltostr( AV17recalcular))) ;
               if ( ( GXutil.month( AV22LiqPeriodo) > 1 ) && ( AV17recalcular ) )
               {
                  AV12fecha = A283LiqPeriodo ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "2") ;
                  /* Execute user subroutine: 'RECALCULAR LIQUIDACIONES ANTERIORES' */
                  S111 ();
                  if ( returnInSub )
                  {
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  if ( ! (GXutil.strcmp("", AV19error)==0) )
                  {
                     /* Exit For each command. Update data (if necessary), close cursors & exit. */
                     if (true) break;
                  }
               }
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(0);
         }
         if ( ! (GXutil.strcmp("", AV19error)==0) )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV24i = (short)(AV24i+1) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'RECALCULAR LIQUIDACIONES ANTERIORES' Routine */
      returnInSub = false ;
      AV30GXLvl45 = (byte)(0) ;
      /* Using cursor P00ST3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LegNumero), AV11eneroFecha, AV12fecha});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A2112LiqRelNro = P00ST3_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00ST3_n2112LiqRelNro[0] ;
         A283LiqPeriodo = P00ST3_A283LiqPeriodo[0] ;
         A6LegNumero = P00ST3_A6LegNumero[0] ;
         A1EmpCod = P00ST3_A1EmpCod[0] ;
         A3CliCod = P00ST3_A3CliCod[0] ;
         A31LiqNro = P00ST3_A31LiqNro[0] ;
         A2112LiqRelNro = P00ST3_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00ST3_n2112LiqRelNro[0] ;
         AV30GXLvl45 = (byte)(1) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, "3") ;
         GXv_char4[0] = AV19error ;
         new web.procrecalculo(remoteHandle, context).execute( AV14CliCod, AV8EmpCod, A31LiqNro, AV16LiqNro, A6LegNumero, GXv_char4) ;
         actualizarretroactivosganancias.this.AV19error = GXv_char4[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV28Pgmname, httpContext.getMessage( "err", "")+AV19error) ;
         if ( ! (GXutil.strcmp("", AV19error)==0) )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV30GXLvl45 == 0 )
      {
      }
      if ( ! (GXutil.strcmp("", AV19error)==0) )
      {
         new web.setliqlegerror(remoteHandle, context).execute( AV14CliCod, AV8EmpCod, AV16LiqNro, AV9LegNumero, AV19error) ;
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = actualizarretroactivosganancias.this.AV19error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19error = "" ;
      AV21pagosACuentaConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      AV28Pgmname = "" ;
      AV11eneroFecha = GXutil.nullDate() ;
      AV12fecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00ST2_A6LegNumero = new int[1] ;
      P00ST2_A31LiqNro = new int[1] ;
      P00ST2_A1EmpCod = new short[1] ;
      P00ST2_A3CliCod = new int[1] ;
      P00ST2_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A283LiqPeriodo = GXutil.nullDate() ;
      GXv_boolean5 = new boolean[1] ;
      P00ST3_A2112LiqRelNro = new int[1] ;
      P00ST3_n2112LiqRelNro = new boolean[] {false} ;
      P00ST3_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00ST3_A6LegNumero = new int[1] ;
      P00ST3_A1EmpCod = new short[1] ;
      P00ST3_A3CliCod = new int[1] ;
      P00ST3_A31LiqNro = new int[1] ;
      GXv_char4 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarretroactivosganancias__default(),
         new Object[] {
             new Object[] {
            P00ST2_A6LegNumero, P00ST2_A31LiqNro, P00ST2_A1EmpCod, P00ST2_A3CliCod, P00ST2_A283LiqPeriodo
            }
            , new Object[] {
            P00ST3_A2112LiqRelNro, P00ST3_n2112LiqRelNro, P00ST3_A283LiqPeriodo, P00ST3_A6LegNumero, P00ST3_A1EmpCod, P00ST3_A3CliCod, P00ST3_A31LiqNro
            }
         }
      );
      AV28Pgmname = "actualizarRetroActivosGanancias" ;
      /* GeneXus formulas. */
      AV28Pgmname = "actualizarRetroActivosGanancias" ;
      Gx_err = (short)(0) ;
   }

   private byte AV30GXLvl45 ;
   private short AV8EmpCod ;
   private short AV20LiqPerAno ;
   private short AV24i ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV16LiqNro ;
   private int AV9LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A2112LiqRelNro ;
   private String AV21pagosACuentaConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String AV28Pgmname ;
   private String scmdbuf ;
   private String GXv_char4[] ;
   private java.util.Date AV22LiqPeriodo ;
   private java.util.Date AV11eneroFecha ;
   private java.util.Date AV12fecha ;
   private java.util.Date A283LiqPeriodo ;
   private boolean AV25LegAgenReten ;
   private boolean AV17recalcular ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean5[] ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private boolean n2112LiqRelNro ;
   private String AV19error ;
   private GXSimpleCollection<Integer> AV23parmLegNumero ;
   private String[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P00ST2_A6LegNumero ;
   private int[] P00ST2_A31LiqNro ;
   private short[] P00ST2_A1EmpCod ;
   private int[] P00ST2_A3CliCod ;
   private java.util.Date[] P00ST2_A283LiqPeriodo ;
   private int[] P00ST3_A2112LiqRelNro ;
   private boolean[] P00ST3_n2112LiqRelNro ;
   private java.util.Date[] P00ST3_A283LiqPeriodo ;
   private int[] P00ST3_A6LegNumero ;
   private short[] P00ST3_A1EmpCod ;
   private int[] P00ST3_A3CliCod ;
   private int[] P00ST3_A31LiqNro ;
}

final  class actualizarretroactivosganancias__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00ST2", "SELECT LegNumero, LiqNro, EmpCod, CliCod, LiqPeriodo FROM LiquidacionLegajo WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00ST3", "SELECT T2.LiqRelNro, T1.LiqPeriodo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqNro FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LiqPeriodo >= ?) AND (T2.LiqRelNro IS NULL) AND (T1.LiqPeriodo < ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(2);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
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
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
      }
   }

}

