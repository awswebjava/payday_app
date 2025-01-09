package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class invocar_guardaliquidacion extends GXProcedure
{
   public invocar_guardaliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( invocar_guardaliquidacion.class ), "" );
   }

   public invocar_guardaliquidacion( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        boolean aP1 ,
                        web.Sdtsdt_datos_liq aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             boolean aP1 ,
                             web.Sdtsdt_datos_liq aP2 )
   {
      invocar_guardaliquidacion.this.AV8CliCod = aP0;
      invocar_guardaliquidacion.this.AV36chequearPorRest = aP1;
      invocar_guardaliquidacion.this.AV35sdt_datos_liq = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV41liqModoPalabra ;
      GXt_char2 = AV41liqModoPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.liq_modo2_codigoparam(remoteHandle, context).execute( "liq_modo_prin", GXv_char3) ;
      invocar_guardaliquidacion.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      invocar_guardaliquidacion.this.GXt_char1 = GXv_char4[0] ;
      AV41liqModoPalabra = GXt_char1 ;
      AV47modoPalabra = httpContext.getMessage( "LOCAL", "") ;
      AV43falloDaemon = false ;
      if ( GXutil.strcmp(AV41liqModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV56Pgmname, httpContext.getMessage( "llama a daemondisponible", "")) ;
         GXt_char2 = AV42daemonUUID ;
         GXv_char4[0] = GXt_char2 ;
         new web.daemondisponible(remoteHandle, context).execute( AV8CliCod, "GuardaLiquidacion", GXv_char4) ;
         invocar_guardaliquidacion.this.GXt_char2 = GXv_char4[0] ;
         AV42daemonUUID = GXt_char2 ;
         GXt_boolean5 = AV43falloDaemon ;
         GXv_boolean6[0] = GXt_boolean5 ;
         new web.daemonvalido(remoteHandle, context).execute( AV42daemonUUID, true, GXv_boolean6) ;
         invocar_guardaliquidacion.this.GXt_boolean5 = GXv_boolean6[0] ;
         AV43falloDaemon = (boolean)(!GXt_boolean5) ;
         if ( AV43falloDaemon )
         {
            AV47modoPalabra += httpContext.getMessage( " (falló DAEMON)", "") ;
         }
      }
      if ( ( GXutil.strcmp(AV41liqModoPalabra, httpContext.getMessage( "DAEMON", "")) == 0 ) && ! AV43falloDaemon )
      {
         new web.newcola(remoteHandle, context).execute( AV8CliCod, AV35sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Empcod(), AV35sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Liqnro(), (byte)(0), "GuardaLiquidacion", AV35sdt_datos_liq.toJSonString(false, true), AV42daemonUUID) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         if ( AV36chequearPorRest )
         {
            AV35sdt_datos_liq.setgxTv_Sdtsdt_datos_liq_Daemonuuid( httpContext.getMessage( "HTTP", "") );
            GXv_boolean6[0] = AV30RestLocHab ;
            GXv_char4[0] = AV34error ;
            new web.invocar_rest_conreplica(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "GuardaLiquidacion_rest", ""), AV35sdt_datos_liq.getgxTv_Sdtsdt_datos_liq_Replicanro(), AV35sdt_datos_liq.toJSonString(false, true), GXv_boolean6, GXv_char4) ;
            invocar_guardaliquidacion.this.AV30RestLocHab = GXv_boolean6[0] ;
            invocar_guardaliquidacion.this.AV34error = GXv_char4[0] ;
            if ( ! (GXutil.strcmp("", AV34error)==0) )
            {
               System.out.println( httpContext.getMessage( "No se pudo ejecutar el microservicio http de liquidación, se ejecuta en modo local (", "")+GXutil.trim( AV34error)+httpContext.getMessage( "), req: ", "")+GXutil.trim( AV35sdt_datos_liq.toJSonString(false, true)) );
               AV47modoPalabra += httpContext.getMessage( " (falló HTTP)", "") ;
            }
            else
            {
               if ( ( AV30RestLocHab ) && (GXutil.strcmp("", AV34error)==0) )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV56Pgmname, httpContext.getMessage( "!error ", "")+AV34error) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV56Pgmname, httpContext.getMessage( "!&RestLocHab ", "")+GXutil.trim( GXutil.booltostr( AV30RestLocHab))+httpContext.getMessage( " &batchHab ", "")+GXutil.trim( GXutil.booltostr( AV40batchHab))+httpContext.getMessage( " &falloDaemon ", "")+GXutil.trim( GXutil.booltostr( AV43falloDaemon))) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV56Pgmname, httpContext.getMessage( "&sdt_datos_liq ", "")+AV35sdt_datos_liq.toJSonString(false, true)) ;
      GXv_int7[0] = AV8CliCod ;
      GXv_int8[0] = AV9EmpCod ;
      GXv_int9[0] = AV10LiqNro ;
      GXv_date10[0] = AV11LiqFecha ;
      GXv_date11[0] = AV12LiqFecPago ;
      GXv_char4[0] = AV13LiqDescrip ;
      GXv_int12[0] = AV14LiqClase ;
      GXv_int13[0] = AV15LiqEstado ;
      GXv_char3[0] = AV16TLiqCod ;
      GXv_char14[0] = AV17AplicaA ;
      GXv_objcol_int15[0] = AV18collecion_LegNumero ;
      GXv_char16[0] = AV19LiqDepBanCod ;
      GXv_date17[0] = AV20LiqDepPrvFec ;
      GXv_int18[0] = AV21LiqDepPerAno ;
      GXv_int19[0] = AV22LiqDepPerMes ;
      GXv_int20[0] = AV23LiqPerMes ;
      GXv_int21[0] = AV24LiqPerAno ;
      GXv_boolean6[0] = AV25final ;
      GXv_dtime22[0] = AV26LiqFecImp ;
      GXv_char23[0] = AV27parmLiqPerPalabra ;
      GXv_char24[0] = AV28LiqNombre ;
      GXv_int25[0] = AV29LiqRelNro ;
      GXv_char26[0] = "" ;
      GXv_char27[0] = "" ;
      GXv_decimal28[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char29[0] = AV31ClientId ;
      GXv_boolean30[0] = AV32LiqSac ;
      GXv_char31[0] = AV33LiqSacLog ;
      GXv_boolean32[0] = AV44reLiquidacion ;
      GXv_char33[0] = AV49LiqModTra ;
      GXv_int34[0] = AV52LiqFrecPag ;
      GXv_date35[0] = AV51LiqPerDes ;
      GXv_date36[0] = AV50LiqPerHas ;
      GXv_char37[0] = AV53LiqTipoTarifa ;
      new web.armarparmdesdesdtdatosliq(remoteHandle, context).execute( AV35sdt_datos_liq, GXv_int7, GXv_int8, GXv_int9, GXv_date10, GXv_date11, GXv_char4, GXv_int12, GXv_int13, GXv_char3, GXv_char14, GXv_objcol_int15, GXv_char16, GXv_date17, GXv_int18, GXv_int19, GXv_int20, GXv_int21, GXv_boolean6, GXv_dtime22, GXv_char23, GXv_char24, GXv_int25, GXv_char26, GXv_char27, GXv_decimal28, GXv_char29, GXv_boolean30, GXv_char31, GXv_boolean32, GXv_char33, GXv_int34, GXv_date35, GXv_date36, GXv_char37) ;
      invocar_guardaliquidacion.this.AV8CliCod = GXv_int7[0] ;
      invocar_guardaliquidacion.this.AV9EmpCod = GXv_int8[0] ;
      invocar_guardaliquidacion.this.AV10LiqNro = GXv_int9[0] ;
      invocar_guardaliquidacion.this.AV11LiqFecha = GXv_date10[0] ;
      invocar_guardaliquidacion.this.AV12LiqFecPago = GXv_date11[0] ;
      invocar_guardaliquidacion.this.AV13LiqDescrip = GXv_char4[0] ;
      invocar_guardaliquidacion.this.AV14LiqClase = GXv_int12[0] ;
      invocar_guardaliquidacion.this.AV15LiqEstado = GXv_int13[0] ;
      invocar_guardaliquidacion.this.AV16TLiqCod = GXv_char3[0] ;
      invocar_guardaliquidacion.this.AV17AplicaA = GXv_char14[0] ;
      AV18collecion_LegNumero = GXv_objcol_int15[0] ;
      invocar_guardaliquidacion.this.AV19LiqDepBanCod = GXv_char16[0] ;
      invocar_guardaliquidacion.this.AV20LiqDepPrvFec = GXv_date17[0] ;
      invocar_guardaliquidacion.this.AV21LiqDepPerAno = GXv_int18[0] ;
      invocar_guardaliquidacion.this.AV22LiqDepPerMes = GXv_int19[0] ;
      invocar_guardaliquidacion.this.AV23LiqPerMes = GXv_int20[0] ;
      invocar_guardaliquidacion.this.AV24LiqPerAno = GXv_int21[0] ;
      invocar_guardaliquidacion.this.AV25final = GXv_boolean6[0] ;
      invocar_guardaliquidacion.this.AV26LiqFecImp = GXv_dtime22[0] ;
      invocar_guardaliquidacion.this.AV27parmLiqPerPalabra = GXv_char23[0] ;
      invocar_guardaliquidacion.this.AV28LiqNombre = GXv_char24[0] ;
      invocar_guardaliquidacion.this.AV29LiqRelNro = GXv_int25[0] ;
      invocar_guardaliquidacion.this.AV31ClientId = GXv_char29[0] ;
      invocar_guardaliquidacion.this.AV32LiqSac = GXv_boolean30[0] ;
      invocar_guardaliquidacion.this.AV33LiqSacLog = GXv_char31[0] ;
      invocar_guardaliquidacion.this.AV44reLiquidacion = GXv_boolean32[0] ;
      invocar_guardaliquidacion.this.AV49LiqModTra = GXv_char33[0] ;
      invocar_guardaliquidacion.this.AV52LiqFrecPag = GXv_int34[0] ;
      invocar_guardaliquidacion.this.AV51LiqPerDes = GXv_date35[0] ;
      invocar_guardaliquidacion.this.AV50LiqPerHas = GXv_date36[0] ;
      invocar_guardaliquidacion.this.AV53LiqTipoTarifa = GXv_char37[0] ;
      GXv_boolean32[0] = false ;
      new web.guardaliquidacion(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LiqFecha, AV12LiqFecPago, AV13LiqDescrip, AV14LiqClase, AV49LiqModTra, AV52LiqFrecPag, AV53LiqTipoTarifa, AV51LiqPerDes, AV50LiqPerHas, AV15LiqEstado, AV16TLiqCod, AV17AplicaA, AV18collecion_LegNumero, AV19LiqDepBanCod, AV20LiqDepPrvFec, AV21LiqDepPerAno, AV22LiqDepPerMes, AV23LiqPerMes, AV24LiqPerAno, AV25final, AV26LiqFecImp, AV27parmLiqPerPalabra, AV28LiqNombre, AV29LiqRelNro, "", "", DecimalUtil.doubleToDec(0), AV31ClientId, AV32LiqSac, AV33LiqSacLog, AV47modoPalabra, AV44reLiquidacion, GXv_boolean32) ;
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
      AV41liqModoPalabra = "" ;
      GXt_char1 = "" ;
      AV47modoPalabra = "" ;
      AV56Pgmname = "" ;
      AV42daemonUUID = "" ;
      GXt_char2 = "" ;
      AV34error = "" ;
      GXv_int7 = new int[1] ;
      GXv_int8 = new short[1] ;
      GXv_int9 = new int[1] ;
      AV11LiqFecha = GXutil.nullDate() ;
      GXv_date10 = new java.util.Date[1] ;
      AV12LiqFecPago = GXutil.nullDate() ;
      GXv_date11 = new java.util.Date[1] ;
      AV13LiqDescrip = "" ;
      GXv_char4 = new String[1] ;
      GXv_int12 = new byte[1] ;
      GXv_int13 = new byte[1] ;
      AV16TLiqCod = "" ;
      GXv_char3 = new String[1] ;
      AV17AplicaA = "" ;
      GXv_char14 = new String[1] ;
      AV18collecion_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_objcol_int15 = new GXSimpleCollection[1] ;
      AV19LiqDepBanCod = "" ;
      GXv_char16 = new String[1] ;
      AV20LiqDepPrvFec = GXutil.nullDate() ;
      GXv_date17 = new java.util.Date[1] ;
      GXv_int18 = new short[1] ;
      GXv_int19 = new byte[1] ;
      GXv_int20 = new byte[1] ;
      GXv_int21 = new short[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV26LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime22 = new java.util.Date[1] ;
      AV27parmLiqPerPalabra = "" ;
      GXv_char23 = new String[1] ;
      AV28LiqNombre = "" ;
      GXv_char24 = new String[1] ;
      GXv_int25 = new int[1] ;
      GXv_char26 = new String[1] ;
      GXv_char27 = new String[1] ;
      GXv_decimal28 = new java.math.BigDecimal[1] ;
      AV31ClientId = "" ;
      GXv_char29 = new String[1] ;
      GXv_boolean30 = new boolean[1] ;
      AV33LiqSacLog = "" ;
      GXv_char31 = new String[1] ;
      AV49LiqModTra = "" ;
      GXv_char33 = new String[1] ;
      GXv_int34 = new byte[1] ;
      AV51LiqPerDes = GXutil.nullDate() ;
      GXv_date35 = new java.util.Date[1] ;
      AV50LiqPerHas = GXutil.nullDate() ;
      GXv_date36 = new java.util.Date[1] ;
      AV53LiqTipoTarifa = "" ;
      GXv_char37 = new String[1] ;
      GXv_boolean32 = new boolean[1] ;
      AV56Pgmname = "invocar_guardaLiquidacion" ;
      /* GeneXus formulas. */
      AV56Pgmname = "invocar_guardaLiquidacion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqClase ;
   private byte GXv_int12[] ;
   private byte AV15LiqEstado ;
   private byte GXv_int13[] ;
   private byte AV22LiqDepPerMes ;
   private byte GXv_int19[] ;
   private byte AV23LiqPerMes ;
   private byte GXv_int20[] ;
   private byte AV52LiqFrecPag ;
   private byte GXv_int34[] ;
   private short AV9EmpCod ;
   private short GXv_int8[] ;
   private short AV21LiqDepPerAno ;
   private short GXv_int18[] ;
   private short AV24LiqPerAno ;
   private short GXv_int21[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GXv_int7[] ;
   private int AV10LiqNro ;
   private int GXv_int9[] ;
   private int AV29LiqRelNro ;
   private int GXv_int25[] ;
   private java.math.BigDecimal GXv_decimal28[] ;
   private String AV41liqModoPalabra ;
   private String GXt_char1 ;
   private String AV47modoPalabra ;
   private String AV56Pgmname ;
   private String AV42daemonUUID ;
   private String GXt_char2 ;
   private String GXv_char4[] ;
   private String AV16TLiqCod ;
   private String GXv_char3[] ;
   private String AV17AplicaA ;
   private String GXv_char14[] ;
   private String AV19LiqDepBanCod ;
   private String GXv_char16[] ;
   private String AV27parmLiqPerPalabra ;
   private String GXv_char23[] ;
   private String GXv_char24[] ;
   private String GXv_char26[] ;
   private String GXv_char27[] ;
   private String GXv_char29[] ;
   private String GXv_char31[] ;
   private String AV49LiqModTra ;
   private String GXv_char33[] ;
   private String AV53LiqTipoTarifa ;
   private String GXv_char37[] ;
   private java.util.Date AV26LiqFecImp ;
   private java.util.Date GXv_dtime22[] ;
   private java.util.Date AV11LiqFecha ;
   private java.util.Date GXv_date10[] ;
   private java.util.Date AV12LiqFecPago ;
   private java.util.Date GXv_date11[] ;
   private java.util.Date AV20LiqDepPrvFec ;
   private java.util.Date GXv_date17[] ;
   private java.util.Date AV51LiqPerDes ;
   private java.util.Date GXv_date35[] ;
   private java.util.Date AV50LiqPerHas ;
   private java.util.Date GXv_date36[] ;
   private boolean AV36chequearPorRest ;
   private boolean AV43falloDaemon ;
   private boolean GXt_boolean5 ;
   private boolean returnInSub ;
   private boolean AV30RestLocHab ;
   private boolean AV40batchHab ;
   private boolean AV25final ;
   private boolean GXv_boolean6[] ;
   private boolean AV32LiqSac ;
   private boolean GXv_boolean30[] ;
   private boolean AV44reLiquidacion ;
   private boolean GXv_boolean32[] ;
   private String AV34error ;
   private String AV13LiqDescrip ;
   private String AV28LiqNombre ;
   private String AV31ClientId ;
   private String AV33LiqSacLog ;
   private GXSimpleCollection<Integer> AV18collecion_LegNumero ;
   private GXSimpleCollection<Integer> GXv_objcol_int15[] ;
   private web.Sdtsdt_datos_liq AV35sdt_datos_liq ;
}

