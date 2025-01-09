package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcparpergetdesdehasta extends GXProcedure
{
   public calcparpergetdesdehasta( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcparpergetdesdehasta.class ), "" );
   }

   public calcparpergetdesdehasta( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              int aP4 ,
                              String aP5 ,
                              java.util.Date[] aP6 ,
                              java.util.Date[] aP7 )
   {
      calcparpergetdesdehasta.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date[] aP6 ,
                        java.util.Date[] aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date[] aP6 ,
                             java.util.Date[] aP7 ,
                             boolean[] aP8 )
   {
      calcparpergetdesdehasta.this.AV26CliCod = aP0;
      calcparpergetdesdehasta.this.AV25EmpCod = aP1;
      calcparpergetdesdehasta.this.AV24LiqNro = aP2;
      calcparpergetdesdehasta.this.AV23LiqPeriodo = aP3;
      calcparpergetdesdehasta.this.AV18PeriodoNum6 = aP4;
      calcparpergetdesdehasta.this.AV10CriterioBusqueda = aP5;
      calcparpergetdesdehasta.this.aP6 = aP6;
      calcparpergetdesdehasta.this.aP7 = aP7;
      calcparpergetdesdehasta.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11excluirLiquidacionPropia = true ;
      if ( ! (0==AV18PeriodoNum6) )
      {
         GXv_int1[0] = (short)(0) ;
         GXv_int2[0] = AV29mes ;
         GXv_int3[0] = (byte)(0) ;
         GXv_date4[0] = AV12FecDesde ;
         new web.convertirnum6afecha(remoteHandle, context).execute( AV18PeriodoNum6, GXv_int1, GXv_int2, GXv_int3, GXv_date4) ;
         calcparpergetdesdehasta.this.AV29mes = GXv_int2[0] ;
         calcparpergetdesdehasta.this.AV12FecDesde = GXv_date4[0] ;
         AV14FecHasta = AV12FecDesde ;
      }
      else
      {
         AV16mesesAnterioresPalabra = "deMesesAnteriores" ;
         AV15liquidacionesAnterioresPalabra = "liquidacionesAnteriores" ;
         AV19semestrePalabra = "semestre" ;
         AV9anualPalabra = "acumulado" ;
         AV17mismoPeriodoPalabra = "mismoPeriodo" ;
         AV8anterioresDelPeriodoPalabra = "anterioresDelPeriodo" ;
         AV20ultimaNormativaPalabra = "tramoGanancias" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&&CriterioBusqueda \"", "")+AV10CriterioBusqueda+httpContext.getMessage( "\" trim upper ", "")+GXutil.upper( GXutil.trim( AV10CriterioBusqueda))+httpContext.getMessage( " &&mismoPeriodoPalabra ", "")+GXutil.trim( AV17mismoPeriodoPalabra)) ;
         new web.msgdebug2(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&&&&ultimaNormativaPalabra \"", "")+AV20ultimaNormativaPalabra+httpContext.getMessage( "\" trim upper ", "")+GXutil.upper( GXutil.trim( AV20ultimaNormativaPalabra))) ;
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10CriterioBusqueda)), GXutil.upper( GXutil.trim( AV16mesesAnterioresPalabra))) == 0 )
         {
            /* Using cursor P01Z92 */
            pr_default.execute(0, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV24LiqNro)});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A31LiqNro = P01Z92_A31LiqNro[0] ;
               A1EmpCod = P01Z92_A1EmpCod[0] ;
               A3CliCod = P01Z92_A3CliCod[0] ;
               A283LiqPeriodo = P01Z92_A283LiqPeriodo[0] ;
               AV14FecHasta = A283LiqPeriodo ;
               AV14FecHasta = GXutil.eomdate( AV14FecHasta) ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(0);
            AV14FecHasta = GXutil.addmth( AV14FecHasta, (short)(-1)) ;
            AV12FecDesde = localUtil.ymdtod( GXutil.year( AV23LiqPeriodo), 1, 1) ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10CriterioBusqueda)), GXutil.upper( GXutil.trim( AV15liquidacionesAnterioresPalabra))) == 0 )
         {
            /* Using cursor P01Z93 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV26CliCod), Short.valueOf(AV25EmpCod), Integer.valueOf(AV24LiqNro)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A31LiqNro = P01Z93_A31LiqNro[0] ;
               A1EmpCod = P01Z93_A1EmpCod[0] ;
               A3CliCod = P01Z93_A3CliCod[0] ;
               A283LiqPeriodo = P01Z93_A283LiqPeriodo[0] ;
               AV14FecHasta = A283LiqPeriodo ;
               AV14FecHasta = GXutil.eomdate( AV14FecHasta) ;
               /* Exiting from a For First loop. */
               if (true) break;
            }
            pr_default.close(1);
            AV12FecDesde = localUtil.ymdtod( GXutil.year( AV23LiqPeriodo), 1, 1) ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10CriterioBusqueda)), GXutil.upper( GXutil.trim( AV19semestrePalabra))) == 0 )
         {
            if ( ( AV35Conceptoaplicatipoliq.doubleValue() == ( 1 )) && ( GXutil.strcmp(AV27ConCodigo, AV28ConceptoPar) != 0 ) )
            {
               AV11excluirLiquidacionPropia = false ;
            }
            GXv_date4[0] = AV12FecDesde ;
            GXv_date5[0] = AV14FecHasta ;
            new web.rangofechassac(remoteHandle, context).execute( AV23LiqPeriodo, GXv_date4, GXv_date5) ;
            calcparpergetdesdehasta.this.AV12FecDesde = GXv_date4[0] ;
            calcparpergetdesdehasta.this.AV14FecHasta = GXv_date5[0] ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10CriterioBusqueda)), GXutil.upper( GXutil.trim( AV9anualPalabra))) == 0 )
         {
            if ( ( AV35Conceptoaplicatipoliq.doubleValue() == ( 1 )) )
            {
               AV11excluirLiquidacionPropia = false ;
            }
            AV12FecDesde = localUtil.ymdtod( GXutil.year( AV23LiqPeriodo), 1, 1) ;
            AV14FecHasta = GXutil.eomdate( AV23LiqPeriodo) ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10CriterioBusqueda)), GXutil.upper( GXutil.trim( AV17mismoPeriodoPalabra))) == 0 )
         {
            AV11excluirLiquidacionPropia = false ;
            AV12FecDesde = AV23LiqPeriodo ;
            AV14FecHasta = GXutil.eomdate( AV23LiqPeriodo) ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10CriterioBusqueda)), GXutil.upper( GXutil.trim( AV8anterioresDelPeriodoPalabra))) == 0 )
         {
            AV12FecDesde = AV23LiqPeriodo ;
            AV14FecHasta = GXutil.eomdate( AV23LiqPeriodo) ;
         }
         else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV10CriterioBusqueda)), GXutil.upper( GXutil.trim( AV20ultimaNormativaPalabra))) == 0 )
         {
            if ( ( AV35Conceptoaplicatipoliq.doubleValue() == ( 1 )) )
            {
               AV11excluirLiquidacionPropia = false ;
            }
            GXt_date6 = AV12FecDesde ;
            GXv_date5[0] = GXt_date6 ;
            new web.getliqultpernorma(remoteHandle, context).execute( AV26CliCod, AV25EmpCod, AV24LiqNro, GXv_date5) ;
            calcparpergetdesdehasta.this.GXt_date6 = GXv_date5[0] ;
            AV12FecDesde = GXt_date6 ;
            AV14FecHasta = GXutil.eomdate( AV23LiqPeriodo) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = calcparpergetdesdehasta.this.AV12FecDesde;
      this.aP7[0] = calcparpergetdesdehasta.this.AV14FecHasta;
      this.aP8[0] = calcparpergetdesdehasta.this.AV11excluirLiquidacionPropia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12FecDesde = GXutil.nullDate() ;
      AV14FecHasta = GXutil.nullDate() ;
      GXv_int1 = new short[1] ;
      GXv_int2 = new byte[1] ;
      GXv_int3 = new byte[1] ;
      AV16mesesAnterioresPalabra = "" ;
      AV15liquidacionesAnterioresPalabra = "" ;
      AV19semestrePalabra = "" ;
      AV9anualPalabra = "" ;
      AV17mismoPeriodoPalabra = "" ;
      AV8anterioresDelPeriodoPalabra = "" ;
      AV20ultimaNormativaPalabra = "" ;
      AV32Pgmname = "" ;
      scmdbuf = "" ;
      P01Z92_A31LiqNro = new int[1] ;
      P01Z92_A1EmpCod = new short[1] ;
      P01Z92_A3CliCod = new int[1] ;
      P01Z92_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      A283LiqPeriodo = GXutil.nullDate() ;
      P01Z93_A31LiqNro = new int[1] ;
      P01Z93_A1EmpCod = new short[1] ;
      P01Z93_A3CliCod = new int[1] ;
      P01Z93_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      AV35Conceptoaplicatipoliq = DecimalUtil.ZERO ;
      AV27ConCodigo = "" ;
      AV28ConceptoPar = "" ;
      GXv_date4 = new java.util.Date[1] ;
      GXt_date6 = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calcparpergetdesdehasta__default(),
         new Object[] {
             new Object[] {
            P01Z92_A31LiqNro, P01Z92_A1EmpCod, P01Z92_A3CliCod, P01Z92_A283LiqPeriodo
            }
            , new Object[] {
            P01Z93_A31LiqNro, P01Z93_A1EmpCod, P01Z93_A3CliCod, P01Z93_A283LiqPeriodo
            }
         }
      );
      AV32Pgmname = "CalcParPerGetDesdeHasta" ;
      /* GeneXus formulas. */
      AV32Pgmname = "CalcParPerGetDesdeHasta" ;
      Gx_err = (short)(0) ;
   }

   private byte AV29mes ;
   private byte GXv_int2[] ;
   private byte GXv_int3[] ;
   private short AV25EmpCod ;
   private short GXv_int1[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV26CliCod ;
   private int AV24LiqNro ;
   private int AV18PeriodoNum6 ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private java.math.BigDecimal AV35Conceptoaplicatipoliq ;
   private String AV10CriterioBusqueda ;
   private String AV16mesesAnterioresPalabra ;
   private String AV15liquidacionesAnterioresPalabra ;
   private String AV19semestrePalabra ;
   private String AV9anualPalabra ;
   private String AV17mismoPeriodoPalabra ;
   private String AV8anterioresDelPeriodoPalabra ;
   private String AV20ultimaNormativaPalabra ;
   private String AV32Pgmname ;
   private String scmdbuf ;
   private String AV27ConCodigo ;
   private String AV28ConceptoPar ;
   private java.util.Date AV23LiqPeriodo ;
   private java.util.Date AV12FecDesde ;
   private java.util.Date AV14FecHasta ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date GXv_date4[] ;
   private java.util.Date GXt_date6 ;
   private java.util.Date GXv_date5[] ;
   private boolean AV11excluirLiquidacionPropia ;
   private boolean[] aP8 ;
   private java.util.Date[] aP6 ;
   private java.util.Date[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P01Z92_A31LiqNro ;
   private short[] P01Z92_A1EmpCod ;
   private int[] P01Z92_A3CliCod ;
   private java.util.Date[] P01Z92_A283LiqPeriodo ;
   private int[] P01Z93_A31LiqNro ;
   private short[] P01Z93_A1EmpCod ;
   private int[] P01Z93_A3CliCod ;
   private java.util.Date[] P01Z93_A283LiqPeriodo ;
}

final  class calcparpergetdesdehasta__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Z92", "SELECT LiqNro, EmpCod, CliCod, LiqPeriodo FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01Z93", "SELECT LiqNro, EmpCod, CliCod, LiqPeriodo FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
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
      }
   }

}

