package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mejorsac extends GXProcedure
{
   public mejorsac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mejorsac.class ), "" );
   }

   public mejorsac( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      mejorsac.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 )
   {
      mejorsac.this.AV8CliCod = aP0;
      mejorsac.this.AV9EmpCod = aP1;
      mejorsac.this.AV10LiqNro = aP2;
      mejorsac.this.AV44LiqRelNro = aP3;
      mejorsac.this.AV11LegNumero = aP4;
      mejorsac.this.AV12haberesSACConCodigo = aP5;
      mejorsac.this.AV13LiqPeriodo = aP6;
      mejorsac.this.AV25ProcesoLiquidacion = aP7;
      mejorsac.this.aP8 = aP8;
      mejorsac.this.aP9 = aP9;
      mejorsac.this.aP10 = aP10;
      mejorsac.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV28LiqDCalculado = (byte)(1) ;
      GXv_decimal1[0] = AV14mejorSacLiqDImpCalcu ;
      GXv_boolean2[0] = false ;
      GXv_date3[0] = AV15mejorLiqPeriodo ;
      GXv_int4[0] = AV16auxLiqDCalculado ;
      GXv_char5[0] = AV17mejorSacError ;
      new web.getliqdimpcalcumejor2(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV44LiqRelNro, AV11LegNumero, GXutil.trim( AV12haberesSACConCodigo), AV43ConceptoTipo, AV13LiqPeriodo, "Calculo", true, "", false, GXv_decimal1, GXv_boolean2, GXv_date3, GXv_int4, GXv_char5) ;
      mejorsac.this.AV14mejorSacLiqDImpCalcu = GXv_decimal1[0] ;
      mejorsac.this.AV15mejorLiqPeriodo = GXv_date3[0] ;
      mejorsac.this.AV16auxLiqDCalculado = GXv_int4[0] ;
      mejorsac.this.AV17mejorSacError = GXv_char5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "11 &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV13LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      if ( AV16auxLiqDCalculado == 0 )
      {
         AV28LiqDCalculado = (byte)(0) ;
         AV18error = httpContext.getMessage( "Falta calcular haberes SAC", "") ;
         if ( ! (GXutil.strcmp("", AV17mejorSacError)==0) )
         {
            AV18error += " (" + GXutil.trim( AV17mejorSacError) + ")" ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "return ", "")+AV18error) ;
         AV19LiqDLog = GXutil.trim( AV18error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char6 = AV21mesPalabra ;
      GXv_char5[0] = GXt_char6 ;
      new web.armamespalabra(remoteHandle, context).execute( AV8CliCod, AV15mejorLiqPeriodo, GXv_char5) ;
      mejorsac.this.GXt_char6 = GXv_char5[0] ;
      AV21mesPalabra = GXt_char6 ;
      AV19LiqDLog = httpContext.getMessage( "El mejor mes de haberes que aportan al SAC (concepto ", "") + GXutil.trim( AV12haberesSACConCodigo) + httpContext.getMessage( ") es ", "") + GXutil.trim( AV21mesPalabra) + httpContext.getMessage( " con ", "") + GXutil.trim( GXutil.str( AV14mejorSacLiqDImpCalcu, 14, 2)) ;
      AV34mesesSAC.fromJSonString(new web.getparametro(remoteHandle, context).executeUdp( AV8CliCod, new web.meses_liquidar_sac_param(remoteHandle, context).executeUdp( )), null);
      AV35e = (short)(1) ;
      while ( AV35e <= AV34mesesSAC.size() )
      {
         if ( GXutil.month( AV13LiqPeriodo) <= ((Number) AV34mesesSAC.elementAt(-1+AV35e)).byteValue() )
         {
            if ( AV35e == 1 )
            {
               AV38cuotaActual = (short)(1) ;
               AV33cuotaSacAnterior = (short)(0) ;
            }
            else
            {
               AV38cuotaActual = AV35e ;
               AV36eAnt = (short)(AV35e-1) ;
               AV33cuotaSacAnterior = ((Number) AV34mesesSAC.elementAt(-1+AV36eAnt)).byteValue() ;
            }
            if (true) break;
         }
         AV35e = (short)(AV35e+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "2 &LiqDLog ", "")+GXutil.trim( AV19LiqDLog)) ;
      AV39desde_TipoConCod = "NRE_ARG" ;
      AV40hasta_TipoConCod = "REM_ARG" ;
      /* Using cursor P01GC2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), AV39desde_TipoConCod, AV40hasta_TipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1539ConSacDeven = P01GC2_A1539ConSacDeven[0] ;
         A37TipoConCod = P01GC2_A37TipoConCod[0] ;
         A3CliCod = P01GC2_A3CliCod[0] ;
         A26ConCodigo = P01GC2_A26ConCodigo[0] ;
         AV30sac_devengamiento = A1539ConSacDeven ;
         if ( ( AV38cuotaActual == 1 ) || ( A1539ConSacDeven == 12 ) )
         {
            AV32desdeFecha = localUtil.ymdtod( GXutil.year( AV13LiqPeriodo), 1, 1) ;
         }
         else
         {
            AV32desdeFecha = localUtil.ymdtod( GXutil.year( AV13LiqPeriodo), 7, 1) ;
         }
         AV42ConCodigo = A26ConCodigo ;
         /* Execute user subroutine: 'RECORRER LIQUIDACIONES' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   public void S111( )
   {
      /* 'RECORRER LIQUIDACIONES' Routine */
      returnInSub = false ;
      /* Using cursor P01GC3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LegNumero), AV42ConCodigo, AV32desdeFecha, Integer.valueOf(AV44LiqRelNro), AV13LiqPeriodo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A31LiqNro = P01GC3_A31LiqNro[0] ;
         A2112LiqRelNro = P01GC3_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01GC3_n2112LiqRelNro[0] ;
         A397DLiqPeriodo = P01GC3_A397DLiqPeriodo[0] ;
         A394DConCodigo = P01GC3_A394DConCodigo[0] ;
         A6LegNumero = P01GC3_A6LegNumero[0] ;
         A1EmpCod = P01GC3_A1EmpCod[0] ;
         A3CliCod = P01GC3_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01GC3_A764LiqDImpReCalcu[0] ;
         A393DConDescrip = P01GC3_A393DConDescrip[0] ;
         A81LiqDSecuencial = P01GC3_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01GC3_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01GC3_n2112LiqRelNro[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "4 LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))) ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, A764LiqDImpReCalcu)==0) )
         {
            AV31cantDeveng = AV30sac_devengamiento ;
            AV29divide = AV31cantDeveng ;
            if ( GXutil.month( A397DLiqPeriodo) > AV33cuotaSacAnterior )
            {
               AV29divide = (short)(AV29divide-AV33cuotaSacAnterior) ;
            }
            if ( AV29divide <= 0 )
            {
               AV18error = httpContext.getMessage( ". Error al calcular divisor para proporcionar concepto de devengamiento mayor a 1 mes (", "") + GXutil.trim( GXutil.str( AV31cantDeveng, 4, 0)) + " - " + GXutil.trim( GXutil.str( AV33cuotaSacAnterior, 4, 0)) ;
               AV19LiqDLog += AV18error ;
               AV28LiqDCalculado = (byte)(0) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, httpContext.getMessage( "&error ", "")+AV18error) ;
               pr_default.close(1);
               pr_default.close(1);
               returnInSub = true;
               if (true) return;
            }
            AV37ProporcionadoImportes = A764LiqDImpReCalcu.divide(DecimalUtil.doubleToDec(AV29divide), 18, java.math.RoundingMode.DOWN) ;
            AV14mejorSacLiqDImpCalcu = AV14mejorSacLiqDImpCalcu.add(AV37ProporcionadoImportes) ;
            AV19LiqDLog += httpContext.getMessage( ". Suma ", "") + GXutil.trim( GXutil.str( AV37ProporcionadoImportes, 14, 2)) + httpContext.getMessage( " resultado de dividir entre ", "") + GXutil.trim( GXutil.str( AV29divide, 4, 0)) + httpContext.getMessage( " los ", "") + GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2)) + httpContext.getMessage( " del concepto ", "") + GXutil.trim( A393DConDescrip) + httpContext.getMessage( " de ", "") + GXutil.trim( localUtil.cmonth( A397DLiqPeriodo, httpContext.getLanguage( ))) + httpContext.getMessage( " de devengamiento ", "") + GXutil.trim( httpContext.getMessage( web.gxdomainsac_devengamiento.getDescription(httpContext,(byte)AV30sac_devengamiento), "")) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV47Pgmname, "5 ") ;
         }
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP8[0] = mejorsac.this.AV14mejorSacLiqDImpCalcu;
      this.aP9[0] = mejorsac.this.AV18error;
      this.aP10[0] = mejorsac.this.AV28LiqDCalculado;
      this.aP11[0] = mejorsac.this.AV19LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14mejorSacLiqDImpCalcu = DecimalUtil.ZERO ;
      AV18error = "" ;
      AV19LiqDLog = "" ;
      AV43ConceptoTipo = "" ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_boolean2 = new boolean[1] ;
      AV15mejorLiqPeriodo = GXutil.nullDate() ;
      GXv_date3 = new java.util.Date[1] ;
      GXv_int4 = new byte[1] ;
      AV17mejorSacError = "" ;
      AV47Pgmname = "" ;
      AV21mesPalabra = "" ;
      GXt_char6 = "" ;
      GXv_char5 = new String[1] ;
      AV34mesesSAC = new GXSimpleCollection<Byte>(Byte.class, "internal", "");
      AV39desde_TipoConCod = "" ;
      AV40hasta_TipoConCod = "" ;
      scmdbuf = "" ;
      P01GC2_A1539ConSacDeven = new byte[1] ;
      P01GC2_A37TipoConCod = new String[] {""} ;
      P01GC2_A3CliCod = new int[1] ;
      P01GC2_A26ConCodigo = new String[] {""} ;
      A37TipoConCod = "" ;
      A26ConCodigo = "" ;
      AV32desdeFecha = GXutil.nullDate() ;
      AV42ConCodigo = "" ;
      P01GC3_A31LiqNro = new int[1] ;
      P01GC3_A2112LiqRelNro = new int[1] ;
      P01GC3_n2112LiqRelNro = new boolean[] {false} ;
      P01GC3_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01GC3_A394DConCodigo = new String[] {""} ;
      P01GC3_A6LegNumero = new int[1] ;
      P01GC3_A1EmpCod = new short[1] ;
      P01GC3_A3CliCod = new int[1] ;
      P01GC3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01GC3_A393DConDescrip = new String[] {""} ;
      P01GC3_A81LiqDSecuencial = new int[1] ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A394DConCodigo = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A393DConDescrip = "" ;
      AV37ProporcionadoImportes = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.mejorsac__default(),
         new Object[] {
             new Object[] {
            P01GC2_A1539ConSacDeven, P01GC2_A37TipoConCod, P01GC2_A3CliCod, P01GC2_A26ConCodigo
            }
            , new Object[] {
            P01GC3_A31LiqNro, P01GC3_A2112LiqRelNro, P01GC3_n2112LiqRelNro, P01GC3_A397DLiqPeriodo, P01GC3_A394DConCodigo, P01GC3_A6LegNumero, P01GC3_A1EmpCod, P01GC3_A3CliCod, P01GC3_A764LiqDImpReCalcu, P01GC3_A393DConDescrip,
            P01GC3_A81LiqDSecuencial
            }
         }
      );
      AV47Pgmname = "mejorSAC" ;
      /* GeneXus formulas. */
      AV47Pgmname = "mejorSAC" ;
      Gx_err = (short)(0) ;
   }

   private byte AV28LiqDCalculado ;
   private byte AV16auxLiqDCalculado ;
   private byte GXv_int4[] ;
   private byte A1539ConSacDeven ;
   private byte AV30sac_devengamiento ;
   private short AV9EmpCod ;
   private short AV35e ;
   private short AV38cuotaActual ;
   private short AV33cuotaSacAnterior ;
   private short AV36eAnt ;
   private short A1EmpCod ;
   private short AV31cantDeveng ;
   private short AV29divide ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV44LiqRelNro ;
   private int AV11LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV14mejorSacLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV37ProporcionadoImportes ;
   private String AV12haberesSACConCodigo ;
   private String AV25ProcesoLiquidacion ;
   private String AV43ConceptoTipo ;
   private String AV47Pgmname ;
   private String AV21mesPalabra ;
   private String GXt_char6 ;
   private String GXv_char5[] ;
   private String AV39desde_TipoConCod ;
   private String AV40hasta_TipoConCod ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private String AV42ConCodigo ;
   private String A394DConCodigo ;
   private java.util.Date AV13LiqPeriodo ;
   private java.util.Date AV15mejorLiqPeriodo ;
   private java.util.Date GXv_date3[] ;
   private java.util.Date AV32desdeFecha ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean n2112LiqRelNro ;
   private String AV19LiqDLog ;
   private String AV18error ;
   private String AV17mejorSacError ;
   private String A393DConDescrip ;
   private GXSimpleCollection<Byte> AV34mesesSAC ;
   private String[] aP11 ;
   private java.math.BigDecimal[] aP8 ;
   private String[] aP9 ;
   private byte[] aP10 ;
   private IDataStoreProvider pr_default ;
   private byte[] P01GC2_A1539ConSacDeven ;
   private String[] P01GC2_A37TipoConCod ;
   private int[] P01GC2_A3CliCod ;
   private String[] P01GC2_A26ConCodigo ;
   private int[] P01GC3_A31LiqNro ;
   private int[] P01GC3_A2112LiqRelNro ;
   private boolean[] P01GC3_n2112LiqRelNro ;
   private java.util.Date[] P01GC3_A397DLiqPeriodo ;
   private String[] P01GC3_A394DConCodigo ;
   private int[] P01GC3_A6LegNumero ;
   private short[] P01GC3_A1EmpCod ;
   private int[] P01GC3_A3CliCod ;
   private java.math.BigDecimal[] P01GC3_A764LiqDImpReCalcu ;
   private String[] P01GC3_A393DConDescrip ;
   private int[] P01GC3_A81LiqDSecuencial ;
}

final  class mejorsac__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01GC2", "SELECT ConSacDeven, TipoConCod, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ? and ConSacDeven >= 2 and TipoConCod >= ( ?)) AND (TipoConCod <= ( ?)) AND (ConSacDeven <= 12) ORDER BY CliCod, ConSacDeven ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01GC3", "SELECT T1.LiqNro, T2.LiqRelNro, T1.DLiqPeriodo, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.DConDescrip, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.DConCodigo = ( ?) and T1.DLiqPeriodo >= ?) AND (T2.LiqRelNro IS NULL or T2.LiqRelNro = ?) AND (T1.DLiqPeriodo <= ?) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 10);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
      }
   }

}

