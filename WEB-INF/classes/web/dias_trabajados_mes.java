package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dias_trabajados_mes extends GXProcedure
{
   public dias_trabajados_mes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dias_trabajados_mes.class ), "" );
   }

   public dias_trabajados_mes( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.util.Date aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             short[] aP14 ,
                             byte[] aP15 ,
                             String[] aP16 )
   {
      dias_trabajados_mes.this.aP17 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.util.Date aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        String aP12 ,
                        boolean aP13 ,
                        short[] aP14 ,
                        byte[] aP15 ,
                        String[] aP16 ,
                        String[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.util.Date aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             short[] aP14 ,
                             byte[] aP15 ,
                             String[] aP16 ,
                             String[] aP17 )
   {
      dias_trabajados_mes.this.AV9CliCod = aP0;
      dias_trabajados_mes.this.AV10EmpCod = aP1;
      dias_trabajados_mes.this.AV11LiqNro = aP2;
      dias_trabajados_mes.this.AV20LegNumero = aP3;
      dias_trabajados_mes.this.AV25LiqPeriodo = aP4;
      dias_trabajados_mes.this.AV23LegFecEgreso = aP5;
      dias_trabajados_mes.this.AV26LegClase = aP6;
      dias_trabajados_mes.this.AV51LegModTra = aP7;
      dias_trabajados_mes.this.AV28todosLosMeses30 = aP8;
      dias_trabajados_mes.this.AV29LegFecIngreso = aP9;
      dias_trabajados_mes.this.AV31restarLicencias = aP10;
      dias_trabajados_mes.this.AV32restarFeriados = aP11;
      dias_trabajados_mes.this.AV43procesoLiquidacion = aP12;
      dias_trabajados_mes.this.AV44insertandoConceptos = aP13;
      dias_trabajados_mes.this.aP14 = aP14;
      dias_trabajados_mes.this.aP15 = aP15;
      dias_trabajados_mes.this.aP16 = aP16;
      dias_trabajados_mes.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV41LiqDCalculado = (byte)(1) ;
      GXv_char1[0] = AV8OpeCodFormula ;
      new web.codigoopeformula(remoteHandle, context).execute( AV9CliCod, "[dias_trabajados_mes]", false, false, GXv_char1) ;
      dias_trabajados_mes.this.AV8OpeCodFormula = GXv_char1[0] ;
      GXv_char1[0] = AV12TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, GXv_char1) ;
      dias_trabajados_mes.this.AV12TLiqCod = GXv_char1[0] ;
      GXt_char2 = AV13adelanVacTLiqCod ;
      GXt_char3 = AV13adelanVacTLiqCod ;
      GXv_char1[0] = GXt_char3 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char1) ;
      dias_trabajados_mes.this.GXt_char3 = GXv_char1[0] ;
      GXv_char4[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char3, GXv_char4) ;
      dias_trabajados_mes.this.GXt_char2 = GXv_char4[0] ;
      AV13adelanVacTLiqCod = GXt_char2 ;
      GXt_char3 = AV15egresoTLiqCOd ;
      GXt_char2 = AV15egresoTLiqCOd ;
      GXv_char4[0] = GXt_char2 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      dias_trabajados_mes.this.GXt_char2 = GXv_char4[0] ;
      GXv_char1[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
      dias_trabajados_mes.this.GXt_char3 = GXv_char1[0] ;
      AV15egresoTLiqCOd = GXt_char3 ;
      if ( GXutil.strcmp(AV12TLiqCod, AV13adelanVacTLiqCod) == 0 )
      {
         AV18yaCalculoAdelanto = true ;
         GXt_char3 = AV19AdelanVacProxConCodigo ;
         GXt_char2 = AV19AdelanVacProxConCodigo ;
         GXv_char4[0] = GXt_char2 ;
         new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         dias_trabajados_mes.this.GXt_char2 = GXv_char4[0] ;
         GXv_char1[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
         dias_trabajados_mes.this.GXt_char3 = GXv_char1[0] ;
         AV19AdelanVacProxConCodigo = GXt_char3 ;
         GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean6[0] = AV21existe ;
         GXv_int7[0] = (byte)(0) ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV20LegNumero, AV19AdelanVacProxConCodigo, AV43procesoLiquidacion, AV44insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         dias_trabajados_mes.this.AV21existe = GXv_boolean6[0] ;
         if ( AV21existe )
         {
            GXt_char3 = AV45adelanVacMespROXConCodigo ;
            GXt_char2 = AV45adelanVacMespROXConCodigo ;
            GXv_char4[0] = GXt_char2 ;
            new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            dias_trabajados_mes.this.GXt_char2 = GXv_char4[0] ;
            GXv_char1[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
            dias_trabajados_mes.this.GXt_char3 = GXv_char1[0] ;
            AV45adelanVacMespROXConCodigo = GXt_char3 ;
            GXv_decimal5[0] = DecimalUtil.doubleToDec(AV16Cantidad) ;
            GXv_boolean6[0] = AV21existe ;
            GXv_int7[0] = (byte)(0) ;
            new web.getliqdcantidad(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV20LegNumero, AV45adelanVacMespROXConCodigo, GXv_decimal5, GXv_boolean6, GXv_int7) ;
            dias_trabajados_mes.this.AV16Cantidad = (short)(DecimalUtil.decToDouble(GXv_decimal5[0])) ;
            dias_trabajados_mes.this.AV21existe = GXv_boolean6[0] ;
            if ( AV21existe )
            {
               AV17LiqDLog = httpContext.getMessage( "Se inicializa cantidad de días en ", "") + GXutil.trim( GXutil.str( AV16Cantidad, 4, 0)) + httpContext.getMessage( ", por los días de adelanto de vacaciones de mes próximo", "") ;
            }
            else
            {
               AV41LiqDCalculado = (byte)(0) ;
               AV42error = httpContext.getMessage( "Falta calcular concepto de adelanto de vacaciones", "") ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else
         {
            GXt_char3 = AV22adelanVacMesActualConCodigo ;
            GXt_char2 = AV22adelanVacMesActualConCodigo ;
            GXv_char4[0] = GXt_char2 ;
            new web.concepto_adelantovacamesactual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            dias_trabajados_mes.this.GXt_char2 = GXv_char4[0] ;
            GXv_char1[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
            dias_trabajados_mes.this.GXt_char3 = GXv_char1[0] ;
            AV22adelanVacMesActualConCodigo = GXt_char3 ;
            GXv_decimal5[0] = DecimalUtil.doubleToDec(AV16Cantidad) ;
            GXv_boolean6[0] = AV21existe ;
            GXv_int7[0] = (byte)(0) ;
            new web.getliqdcantidad(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV20LegNumero, AV22adelanVacMesActualConCodigo, GXv_decimal5, GXv_boolean6, GXv_int7) ;
            dias_trabajados_mes.this.AV16Cantidad = (short)(DecimalUtil.decToDouble(GXv_decimal5[0])) ;
            dias_trabajados_mes.this.AV21existe = GXv_boolean6[0] ;
            if ( AV21existe )
            {
               AV17LiqDLog = httpContext.getMessage( "Se inicializa cantidad de días en ", "") + GXutil.trim( GXutil.str( AV16Cantidad, 4, 0)) + httpContext.getMessage( ", por los días de adelanto de vacaciones", "") ;
            }
            else
            {
               AV41LiqDCalculado = (byte)(0) ;
               AV42error = httpContext.getMessage( "Falta calcular concepto de adelanto de vacaciones", "") ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV20LegNumero, 8, 0))+httpContext.getMessage( " &LegFecIngreso ", "")+GXutil.trim( localUtil.dtoc( AV29LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV25LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         if ( GXutil.strcmp(AV12TLiqCod, AV15egresoTLiqCOd) == 0 )
         {
            GXt_char3 = AV50mensualTLiqCod ;
            GXt_char2 = AV50mensualTLiqCod ;
            GXv_char4[0] = GXt_char2 ;
            new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            dias_trabajados_mes.this.GXt_char2 = GXv_char4[0] ;
            GXv_char1[0] = GXt_char3 ;
            new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
            dias_trabajados_mes.this.GXt_char3 = GXv_char1[0] ;
            AV50mensualTLiqCod = GXt_char3 ;
            GXv_boolean6[0] = AV48tiene ;
            new web.tieneotraliquidacionenperiodo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV20LegNumero, AV25LiqPeriodo, AV50mensualTLiqCod, GXv_boolean6) ;
            dias_trabajados_mes.this.AV48tiene = GXv_boolean6[0] ;
            if ( AV48tiene )
            {
               AV27cantidadBasica = (short)(0) ;
               AV17LiqDLog = httpContext.getMessage( "Días en cero por ser liquidación de egreso y ya haberse liquidado los días trabajados del periodo en otra liquidación", "") ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         GXv_int7[0] = AV49EmpTipoExp ;
         new web.getemptipoexp(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, GXv_int7) ;
         dias_trabajados_mes.this.AV49EmpTipoExp = GXv_int7[0] ;
         GXv_int8[0] = AV16Cantidad ;
         GXv_int9[0] = AV27cantidadBasica ;
         GXv_char4[0] = AV17LiqDLog ;
         new web.cantinicialdiastrabajados(remoteHandle, context).execute( AV9CliCod, AV12TLiqCod, AV15egresoTLiqCOd, AV26LegClase, AV29LegFecIngreso, AV23LegFecEgreso, AV25LiqPeriodo, AV28todosLosMeses30, AV49EmpTipoExp, GXv_int8, GXv_int9, GXv_char4) ;
         dias_trabajados_mes.this.AV16Cantidad = GXv_int8[0] ;
         dias_trabajados_mes.this.AV27cantidadBasica = GXv_int9[0] ;
         dias_trabajados_mes.this.AV17LiqDLog = GXv_char4[0] ;
         if ( AV49EmpTipoExp == 1 )
         {
            if ( ( AV31restarLicencias ) || ( AV32restarFeriados ) )
            {
               if ( AV31restarLicencias )
               {
                  AV46devolverPalabra = httpContext.getMessage( "CUENTAN COMO TRABAJADOS", "") ;
                  GXv_int9[0] = AV33licencias ;
                  GXv_date10[0] = AV34inicio_date ;
                  GXv_date11[0] = AV35fin_date ;
                  new web.getdiaslicenciaperiodo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, "", AV20LegNumero, AV25LiqPeriodo, false, false, AV46devolverPalabra, false, false, GXv_int9, GXv_date10, GXv_date11) ;
                  dias_trabajados_mes.this.AV33licencias = GXv_int9[0] ;
                  dias_trabajados_mes.this.AV34inicio_date = GXv_date10[0] ;
                  dias_trabajados_mes.this.AV35fin_date = GXv_date11[0] ;
                  /* Execute user subroutine: 'RESTAR LICENCIA' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
               GXt_char3 = AV36adelanVacConCodigo ;
               GXt_char2 = AV36adelanVacConCodigo ;
               GXv_char4[0] = GXt_char2 ;
               new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               dias_trabajados_mes.this.GXt_char2 = GXv_char4[0] ;
               GXv_char1[0] = GXt_char3 ;
               new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char1) ;
               dias_trabajados_mes.this.GXt_char3 = GXv_char1[0] ;
               AV36adelanVacConCodigo = GXt_char3 ;
               if ( AV32restarFeriados )
               {
                  GXv_boolean6[0] = AV47EmpLiqFer ;
                  new web.getempliqfer(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV20LegNumero, AV26LegClase, AV51LegModTra, GXv_boolean6) ;
                  dias_trabajados_mes.this.AV47EmpLiqFer = GXv_boolean6[0] ;
                  if ( AV47EmpLiqFer )
                  {
                     GXv_int9[0] = AV40Feriados ;
                     new web.cantidadferiadosenperiodo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV20LegNumero, AV25LiqPeriodo, GXv_int9) ;
                     dias_trabajados_mes.this.AV40Feriados = GXv_int9[0] ;
                     if ( AV40Feriados > 0 )
                     {
                        AV16Cantidad = (short)(AV16Cantidad-AV40Feriados) ;
                        AV17LiqDLog += httpContext.getMessage( ". Se le resta ", "") + GXutil.trim( GXutil.str( AV40Feriados, 4, 0)) + httpContext.getMessage( " días por feriados no trabajados", "") ;
                     }
                  }
               }
            }
            else
            {
               if ( ! AV31restarLicencias && ! AV32restarFeriados )
               {
                  GXv_int9[0] = AV33licencias ;
                  GXv_date11[0] = AV34inicio_date ;
                  GXv_date10[0] = AV35fin_date ;
                  new web.getdiaslicenciaperiodo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, "", AV20LegNumero, AV25LiqPeriodo, false, false, httpContext.getMessage( "CUENTAN COMO NO TRABAJADOS", ""), false, false, GXv_int9, GXv_date11, GXv_date10) ;
                  dias_trabajados_mes.this.AV33licencias = GXv_int9[0] ;
                  dias_trabajados_mes.this.AV34inicio_date = GXv_date11[0] ;
                  dias_trabajados_mes.this.AV35fin_date = GXv_date10[0] ;
                  /* Execute user subroutine: 'RESTAR LICENCIA' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
               }
            }
         }
         if ( AV16Cantidad != AV27cantidadBasica )
         {
            AV17LiqDLog += httpContext.getMessage( ", por lo tanto el cálculo de días queda en ", "") + GXutil.trim( GXutil.str( AV16Cantidad, 4, 0)) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'RESTAR LICENCIA' Routine */
      returnInSub = false ;
      if ( ( AV33licencias == GXutil.day( GXutil.eomdate( AV25LiqPeriodo)) ) && ( AV28todosLosMeses30 ) )
      {
         AV33licencias = (short)(30) ;
      }
      if ( AV33licencias > 0 )
      {
         AV16Cantidad = (short)(AV16Cantidad-AV33licencias) ;
         AV17LiqDLog += httpContext.getMessage( ". Se le resta ", "") + GXutil.trim( GXutil.str( AV33licencias, 4, 0)) + httpContext.getMessage( " días de licencia", "") ;
         if ( AV33licencias == 30 )
         {
            AV17LiqDLog += httpContext.getMessage( " de todo el mes", "") ;
         }
         else
         {
            AV17LiqDLog += httpContext.getMessage( " del ", "") + GXutil.trim( localUtil.dtoc( AV34inicio_date, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " al ", "") + localUtil.dtoc( AV35fin_date, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/") ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP14[0] = dias_trabajados_mes.this.AV16Cantidad;
      this.aP15[0] = dias_trabajados_mes.this.AV41LiqDCalculado;
      this.aP16[0] = dias_trabajados_mes.this.AV42error;
      this.aP17[0] = dias_trabajados_mes.this.AV17LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV42error = "" ;
      AV17LiqDLog = "" ;
      AV8OpeCodFormula = "" ;
      AV12TLiqCod = "" ;
      AV13adelanVacTLiqCod = "" ;
      AV15egresoTLiqCOd = "" ;
      AV19AdelanVacProxConCodigo = "" ;
      AV45adelanVacMespROXConCodigo = "" ;
      AV22adelanVacMesActualConCodigo = "" ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV54Pgmname = "" ;
      AV50mensualTLiqCod = "" ;
      GXv_int7 = new byte[1] ;
      GXv_int8 = new short[1] ;
      AV46devolverPalabra = "" ;
      AV34inicio_date = GXutil.nullDate() ;
      AV35fin_date = GXutil.nullDate() ;
      AV36adelanVacConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char2 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char1 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int9 = new short[1] ;
      GXv_date11 = new java.util.Date[1] ;
      GXv_date10 = new java.util.Date[1] ;
      AV54Pgmname = "dias_trabajados_mes" ;
      /* GeneXus formulas. */
      AV54Pgmname = "dias_trabajados_mes" ;
      Gx_err = (short)(0) ;
   }

   private byte AV26LegClase ;
   private byte AV41LiqDCalculado ;
   private byte AV49EmpTipoExp ;
   private byte GXv_int7[] ;
   private short AV10EmpCod ;
   private short AV16Cantidad ;
   private short AV27cantidadBasica ;
   private short GXv_int8[] ;
   private short AV33licencias ;
   private short AV40Feriados ;
   private short GXv_int9[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV20LegNumero ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV51LegModTra ;
   private String AV43procesoLiquidacion ;
   private String AV8OpeCodFormula ;
   private String AV12TLiqCod ;
   private String AV13adelanVacTLiqCod ;
   private String AV15egresoTLiqCOd ;
   private String AV19AdelanVacProxConCodigo ;
   private String AV45adelanVacMespROXConCodigo ;
   private String AV22adelanVacMesActualConCodigo ;
   private String AV54Pgmname ;
   private String AV50mensualTLiqCod ;
   private String AV46devolverPalabra ;
   private String AV36adelanVacConCodigo ;
   private String GXt_char3 ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String GXv_char1[] ;
   private java.util.Date AV25LiqPeriodo ;
   private java.util.Date AV23LegFecEgreso ;
   private java.util.Date AV29LegFecIngreso ;
   private java.util.Date AV34inicio_date ;
   private java.util.Date AV35fin_date ;
   private java.util.Date GXv_date11[] ;
   private java.util.Date GXv_date10[] ;
   private boolean AV28todosLosMeses30 ;
   private boolean AV31restarLicencias ;
   private boolean AV32restarFeriados ;
   private boolean AV44insertandoConceptos ;
   private boolean AV18yaCalculoAdelanto ;
   private boolean AV21existe ;
   private boolean returnInSub ;
   private boolean AV48tiene ;
   private boolean AV47EmpLiqFer ;
   private boolean GXv_boolean6[] ;
   private String AV17LiqDLog ;
   private String AV42error ;
   private String[] aP17 ;
   private short[] aP14 ;
   private byte[] aP15 ;
   private String[] aP16 ;
}

