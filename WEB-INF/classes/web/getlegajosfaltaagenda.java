package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getlegajosfaltaagenda extends GXProcedure
{
   public getlegajosfaltaagenda( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getlegajosfaltaagenda.class ), "" );
   }

   public getlegajosfaltaagenda( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXSimpleCollection<Integer> executeUdp( int aP0 ,
                                                  short aP1 ,
                                                  int aP2 ,
                                                  String aP3 ,
                                                  String aP4 ,
                                                  String aP5 ,
                                                  GXSimpleCollection<Integer> aP6 ,
                                                  java.util.Date aP7 ,
                                                  boolean aP8 ,
                                                  java.util.Date aP9 ,
                                                  java.util.Date aP10 ,
                                                  GXSimpleCollection<Integer>[] aP11 )
   {
      getlegajosfaltaagenda.this.aP12 = new GXSimpleCollection[] {new GXSimpleCollection<Integer>(Integer.class, "internal", "")};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        GXSimpleCollection<Integer> aP6 ,
                        java.util.Date aP7 ,
                        boolean aP8 ,
                        java.util.Date aP9 ,
                        java.util.Date aP10 ,
                        GXSimpleCollection<Integer>[] aP11 ,
                        GXSimpleCollection<Integer>[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             GXSimpleCollection<Integer> aP6 ,
                             java.util.Date aP7 ,
                             boolean aP8 ,
                             java.util.Date aP9 ,
                             java.util.Date aP10 ,
                             GXSimpleCollection<Integer>[] aP11 ,
                             GXSimpleCollection<Integer>[] aP12 )
   {
      getlegajosfaltaagenda.this.AV13CliCod = aP0;
      getlegajosfaltaagenda.this.AV10EmpCod = aP1;
      getlegajosfaltaagenda.this.AV16LiqNro = aP2;
      getlegajosfaltaagenda.this.AV23ConCodigo = aP3;
      getlegajosfaltaagenda.this.AV25ConCodigo2 = aP4;
      getlegajosfaltaagenda.this.AV22TLiqCod = aP5;
      getlegajosfaltaagenda.this.AV8LegNumero = aP6;
      getlegajosfaltaagenda.this.AV14LiqPeriodo = aP7;
      getlegajosfaltaagenda.this.AV24controlAdelantoVacaciones = aP8;
      getlegajosfaltaagenda.this.AV43LiqPerDes = aP9;
      getlegajosfaltaagenda.this.AV44LiqPerHas = aP10;
      getlegajosfaltaagenda.this.aP11 = aP11;
      getlegajosfaltaagenda.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9i = (short)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( " &LegNumero.Count ", "")+GXutil.trim( GXutil.str( AV8LegNumero.size(), 9, 0))) ;
      while ( AV9i <= AV8LegNumero.size() )
      {
         GXt_char1 = AV42egresoTLiqCod ;
         GXt_char2 = AV42egresoTLiqCod ;
         GXv_char3[0] = GXt_char2 ;
         new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         getlegajosfaltaagenda.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char2, GXv_char4) ;
         getlegajosfaltaagenda.this.GXt_char1 = GXv_char4[0] ;
         AV42egresoTLiqCod = GXt_char1 ;
         if ( GXutil.strcmp(AV22TLiqCod, AV42egresoTLiqCod) != 0 )
         {
            GXt_char2 = AV34vacacionesTLiqCod ;
            GXt_char1 = AV34vacacionesTLiqCod ;
            GXv_char4[0] = GXt_char1 ;
            new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            getlegajosfaltaagenda.this.GXt_char1 = GXv_char4[0] ;
            GXv_char3[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
            getlegajosfaltaagenda.this.GXt_char2 = GXv_char3[0] ;
            AV34vacacionesTLiqCod = GXt_char2 ;
            if ( AV24controlAdelantoVacaciones )
            {
               GXv_date5[0] = AV20primerDiaPeriodo ;
               GXv_date6[0] = AV21ultimoDiaPeriodo ;
               new web.getrangoperiodos(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, AV16LiqNro, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV22TLiqCod, (byte)(2), AV14LiqPeriodo, AV24controlAdelantoVacaciones, GXv_date5, GXv_date6) ;
               getlegajosfaltaagenda.this.AV20primerDiaPeriodo = GXv_date5[0] ;
               getlegajosfaltaagenda.this.AV21ultimoDiaPeriodo = GXv_date6[0] ;
            }
            else
            {
               AV20primerDiaPeriodo = AV43LiqPerDes ;
               AV21ultimoDiaPeriodo = AV44LiqPerHas ;
            }
            if ( GXutil.strcmp(AV22TLiqCod, AV34vacacionesTLiqCod) == 0 )
            {
               GXv_int7[0] = AV33diasVacacionesMesActual ;
               GXv_date6[0] = AV32Date ;
               GXv_date5[0] = AV32Date ;
               new web.getdiaslicenciaperiodo(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, AV16LiqNro, AV22TLiqCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV14LiqPeriodo, false, false, httpContext.getMessage( "TODOS", ""), true, false, GXv_int7, GXv_date6, GXv_date5) ;
               getlegajosfaltaagenda.this.AV33diasVacacionesMesActual = GXv_int7[0] ;
               getlegajosfaltaagenda.this.AV32Date = GXv_date6[0] ;
               getlegajosfaltaagenda.this.AV32Date = GXv_date5[0] ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, " 1") ;
            if ( (0==AV33diasVacacionesMesActual) )
            {
               GXv_int8[0] = AV19legClase ;
               GXv_char4[0] = AV45LegModTra ;
               new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), GXv_int8, GXv_char4) ;
               getlegajosfaltaagenda.this.AV19legClase = GXv_int8[0] ;
               getlegajosfaltaagenda.this.AV45LegModTra = GXv_char4[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV13CliCod, AV50Pgmname, httpContext.getMessage( " 1 &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV14LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ultimoDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV21ultimoDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &primerDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV20primerDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
               GXv_decimal9[0] = AV18AgeCanti ;
               GXv_decimal10[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean12[0] = false ;
               new web.getagendavalor(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, 0, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV14LiqPeriodo, AV21ultimoDiaPeriodo, AV20primerDiaPeriodo, AV23ConCodigo, true, GXv_decimal9, GXv_decimal10, GXv_decimal11, GXv_boolean12) ;
               getlegajosfaltaagenda.this.AV18AgeCanti = GXv_decimal9[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( " 2 &AgeCanti ", "")+GXutil.trim( GXutil.str( AV18AgeCanti, 9, 2))) ;
               if ( AV18AgeCanti.doubleValue() <= 0 )
               {
                  GXv_char4[0] = "" ;
                  GXv_int7[0] = AV35LegLicCntDias ;
                  GXv_date6[0] = AV36LegLicenIni ;
                  GXv_date5[0] = AV37logDesdeFecha ;
                  GXv_date13[0] = AV38logHastaFecha ;
                  GXv_decimal11[0] = AV39LiqDPlus ;
                  GXv_boolean12[0] = false ;
                  GXv_char3[0] = "" ;
                  new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV16LiqNro, false, AV20primerDiaPeriodo, true, AV21ultimoDiaPeriodo, "", false, false, true, GXv_char4, GXv_int7, GXv_date6, GXv_date5, GXv_date13, GXv_decimal11, GXv_boolean12, GXv_char3) ;
                  getlegajosfaltaagenda.this.AV35LegLicCntDias = GXv_int7[0] ;
                  getlegajosfaltaagenda.this.AV36LegLicenIni = GXv_date6[0] ;
                  getlegajosfaltaagenda.this.AV37logDesdeFecha = GXv_date5[0] ;
                  getlegajosfaltaagenda.this.AV38logHastaFecha = GXv_date13[0] ;
                  getlegajosfaltaagenda.this.AV39LiqDPlus = GXv_decimal11[0] ;
                  GXv_char4[0] = AV46tipo_tarifa ;
                  new web.gettipodetarifa(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, 0, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), (short)(0), "", "", GXv_char4) ;
                  getlegajosfaltaagenda.this.AV46tipo_tarifa = GXv_char4[0] ;
                  if ( GXutil.strcmp(AV46tipo_tarifa, "H") == 0 )
                  {
                     GXv_int7[0] = AV40mesDias ;
                     new web.diasenperiodo(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), (short)(0), AV20primerDiaPeriodo, AV21ultimoDiaPeriodo, false, false, GXv_int7) ;
                     getlegajosfaltaagenda.this.AV40mesDias = GXv_int7[0] ;
                  }
                  else
                  {
                     AV40mesDias = (short)(GXutil.ddiff(AV21ultimoDiaPeriodo,AV20primerDiaPeriodo)) ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( " &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV35LegLicCntDias, 4, 0))+httpContext.getMessage( " &mesDias ", "")+GXutil.trim( GXutil.str( AV40mesDias, 4, 0))+httpContext.getMessage( " &primerDiaPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV20primerDiaPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                  if ( AV35LegLicCntDias < AV40mesDias )
                  {
                     AV12LegNoAplican.add((int)(((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue()), 0);
                     new web.msgdebug_prod(remoteHandle, context).execute( AV50Pgmname, httpContext.getMessage( " agrega", "")) ;
                  }
               }
               else
               {
                  GXt_char2 = AV27AdelVacConCodigo ;
                  GXt_char1 = AV27AdelVacConCodigo ;
                  GXv_char4[0] = GXt_char1 ;
                  new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                  getlegajosfaltaagenda.this.GXt_char1 = GXv_char4[0] ;
                  GXv_char3[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
                  getlegajosfaltaagenda.this.GXt_char2 = GXv_char3[0] ;
                  AV27AdelVacConCodigo = GXt_char2 ;
                  if ( GXutil.strcmp(AV23ConCodigo, AV27AdelVacConCodigo) == 0 )
                  {
                     if ( AV18AgeCanti.doubleValue() > 0 )
                     {
                        AV28tieneLiquidadoMesCompleto = true ;
                        if ( ( AV19legClase != 1 ) || ( GXutil.strcmp(AV45LegModTra, "E") != 0 ) )
                        {
                           GXt_char2 = AV29quincenaTLiqCod ;
                           GXt_char1 = AV29quincenaTLiqCod ;
                           GXv_char4[0] = GXt_char1 ;
                           new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                           getlegajosfaltaagenda.this.GXt_char1 = GXv_char4[0] ;
                           GXv_char3[0] = GXt_char2 ;
                           new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
                           getlegajosfaltaagenda.this.GXt_char2 = GXv_char3[0] ;
                           AV29quincenaTLiqCod = GXt_char2 ;
                           GXv_boolean12[0] = AV28tieneLiquidadoMesCompleto ;
                           new web.tieneliquidacionenperiodo(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV14LiqPeriodo, AV29quincenaTLiqCod, GXv_boolean12) ;
                           getlegajosfaltaagenda.this.AV28tieneLiquidadoMesCompleto = GXv_boolean12[0] ;
                        }
                        if ( AV28tieneLiquidadoMesCompleto )
                        {
                           GXt_char2 = AV30mesTLiqCod ;
                           GXt_char1 = AV30mesTLiqCod ;
                           GXv_char4[0] = GXt_char1 ;
                           new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char4) ;
                           getlegajosfaltaagenda.this.GXt_char1 = GXv_char4[0] ;
                           GXv_char3[0] = GXt_char2 ;
                           new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char1, GXv_char3) ;
                           getlegajosfaltaagenda.this.GXt_char2 = GXv_char3[0] ;
                           AV30mesTLiqCod = GXt_char2 ;
                           GXv_boolean12[0] = AV28tieneLiquidadoMesCompleto ;
                           new web.tieneliquidacionenperiodo(remoteHandle, context).execute( AV13CliCod, AV10EmpCod, ((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue(), AV14LiqPeriodo, AV30mesTLiqCod, GXv_boolean12) ;
                           getlegajosfaltaagenda.this.AV28tieneLiquidadoMesCompleto = GXv_boolean12[0] ;
                        }
                        if ( ! AV28tieneLiquidadoMesCompleto )
                        {
                           AV31LegNoAplican2.add((int)(((Number) AV8LegNumero.elementAt(-1+AV9i)).intValue()), 0);
                        }
                     }
                  }
               }
            }
         }
         AV9i = (short)(AV9i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP11[0] = getlegajosfaltaagenda.this.AV12LegNoAplican;
      this.aP12[0] = getlegajosfaltaagenda.this.AV31LegNoAplican2;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LegNoAplican = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV31LegNoAplican2 = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV50Pgmname = "" ;
      AV42egresoTLiqCod = "" ;
      AV34vacacionesTLiqCod = "" ;
      AV20primerDiaPeriodo = GXutil.nullDate() ;
      AV21ultimoDiaPeriodo = GXutil.nullDate() ;
      AV32Date = GXutil.nullDate() ;
      GXv_int8 = new byte[1] ;
      AV45LegModTra = "" ;
      AV18AgeCanti = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal10 = new java.math.BigDecimal[1] ;
      AV36LegLicenIni = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV37logDesdeFecha = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV38logHastaFecha = GXutil.nullDate() ;
      GXv_date13 = new java.util.Date[1] ;
      AV39LiqDPlus = DecimalUtil.ZERO ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      AV46tipo_tarifa = "" ;
      GXv_int7 = new short[1] ;
      AV27AdelVacConCodigo = "" ;
      AV29quincenaTLiqCod = "" ;
      AV30mesTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_boolean12 = new boolean[1] ;
      AV50Pgmname = "GetLegajosFaltaAgenda" ;
      /* GeneXus formulas. */
      AV50Pgmname = "GetLegajosFaltaAgenda" ;
      Gx_err = (short)(0) ;
   }

   private byte AV19legClase ;
   private byte GXv_int8[] ;
   private short AV10EmpCod ;
   private short AV9i ;
   private short AV33diasVacacionesMesActual ;
   private short AV35LegLicCntDias ;
   private short AV40mesDias ;
   private short GXv_int7[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV16LiqNro ;
   private java.math.BigDecimal AV18AgeCanti ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal10[] ;
   private java.math.BigDecimal AV39LiqDPlus ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private String AV23ConCodigo ;
   private String AV25ConCodigo2 ;
   private String AV22TLiqCod ;
   private String AV50Pgmname ;
   private String AV42egresoTLiqCod ;
   private String AV34vacacionesTLiqCod ;
   private String AV45LegModTra ;
   private String AV46tipo_tarifa ;
   private String AV27AdelVacConCodigo ;
   private String AV29quincenaTLiqCod ;
   private String AV30mesTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV14LiqPeriodo ;
   private java.util.Date AV43LiqPerDes ;
   private java.util.Date AV44LiqPerHas ;
   private java.util.Date AV20primerDiaPeriodo ;
   private java.util.Date AV21ultimoDiaPeriodo ;
   private java.util.Date AV32Date ;
   private java.util.Date AV36LegLicenIni ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date AV37logDesdeFecha ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date AV38logHastaFecha ;
   private java.util.Date GXv_date13[] ;
   private boolean AV24controlAdelantoVacaciones ;
   private boolean AV28tieneLiquidadoMesCompleto ;
   private boolean GXv_boolean12[] ;
   private GXSimpleCollection<Integer> AV8LegNumero ;
   private GXSimpleCollection<Integer> AV12LegNoAplican ;
   private GXSimpleCollection<Integer> AV31LegNoAplican2 ;
   private GXSimpleCollection<Integer>[] aP12 ;
   private GXSimpleCollection<Integer>[] aP11 ;
}

