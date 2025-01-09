package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class presentismo_importe2 extends GXProcedure
{
   public presentismo_importe2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( presentismo_importe2.class ), "" );
   }

   public presentismo_importe2( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           int aP4 ,
                           java.util.Date aP5 ,
                           String aP6 ,
                           String aP7 ,
                           String aP8 ,
                           String aP9 ,
                           java.math.BigDecimal[] aP10 ,
                           String[] aP11 ,
                           String[] aP12 )
   {
      presentismo_importe2.this.aP13 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 ,
                        byte[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 ,
                             byte[] aP13 )
   {
      presentismo_importe2.this.AV8CliCod = aP0;
      presentismo_importe2.this.AV9EmpCod = aP1;
      presentismo_importe2.this.AV10LiqNro = aP2;
      presentismo_importe2.this.AV63LiqRelNro = aP3;
      presentismo_importe2.this.AV11LegNumero = aP4;
      presentismo_importe2.this.AV12LiqPeriodo = aP5;
      presentismo_importe2.this.AV71tipo_tarifa = aP6;
      presentismo_importe2.this.AV13ConCodigo = aP7;
      presentismo_importe2.this.AV16ProcesoLiquidacion = aP8;
      presentismo_importe2.this.AV62llamador = aP9;
      presentismo_importe2.this.aP10 = aP10;
      presentismo_importe2.this.aP11 = aP11;
      presentismo_importe2.this.aP12 = aP12;
      presentismo_importe2.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV24LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV32asistencia_perfecta ;
      GXv_char2[0] = AV59auxLiqDLog ;
      new web.asistencia_perfecta(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV12LiqPeriodo, GXv_int1, GXv_char2) ;
      presentismo_importe2.this.AV32asistencia_perfecta = GXv_int1[0] ;
      presentismo_importe2.this.AV59auxLiqDLog = GXv_char2[0] ;
      if ( AV32asistencia_perfecta == 0 )
      {
         AV18LiqDLog = httpContext.getMessage( "No calcula porque todavía no cumple con asistencia perfecta en el periodo (", "") + GXutil.trim( AV59auxLiqDLog) + ")" ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_int3 = AV15PaiCod ;
      GXv_int1[0] = GXt_int3 ;
      new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int1) ;
      presentismo_importe2.this.GXt_int3 = GXv_int1[0] ;
      AV15PaiCod = GXt_int3 ;
      GXt_char4 = AV14presentismoPalabra ;
      GXv_char2[0] = GXt_char4 ;
      new web.getadicionalreservado(remoteHandle, context).execute( AV15PaiCod, "presentismo", GXv_char2) ;
      presentismo_importe2.this.GXt_char4 = GXv_char2[0] ;
      AV14presentismoPalabra = GXt_char4 ;
      GXv_decimal5[0] = AV30presentismoImportes ;
      GXv_char2[0] = AV59auxLiqDLog ;
      new web.conveniogetadicional2(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV12LiqPeriodo, AV13ConCodigo, AV14presentismoPalabra, "", AV16ProcesoLiquidacion, GXv_decimal5, GXv_char2) ;
      presentismo_importe2.this.AV30presentismoImportes = GXv_decimal5[0] ;
      presentismo_importe2.this.AV59auxLiqDLog = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV59auxLiqDLog)==0) )
      {
         AV18LiqDLog = AV59auxLiqDLog ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30presentismoImportes)==0) )
      {
         if ( AV30presentismoImportes.doubleValue() > 1 )
         {
            AV17Importes = AV30presentismoImportes ;
            AV18LiqDLog = httpContext.getMessage( "Inicializa valor de adicional por convenio con ", "") + GXutil.trim( GXutil.str( AV17Importes, 14, 2)) ;
         }
         else
         {
            AV31definidaEnPalabra = httpContext.getMessage( "convenio", "") ;
            /* Execute user subroutine: 'GET SUELDO' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         GXv_decimal5[0] = AV30presentismoImportes ;
         new web.getpresentismoporempresa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, GXv_decimal5) ;
         presentismo_importe2.this.AV30presentismoImportes = GXv_decimal5[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30presentismoImportes)==0) )
         {
            if ( AV30presentismoImportes.doubleValue() > 1 )
            {
               AV17Importes = AV30presentismoImportes ;
               AV18LiqDLog = httpContext.getMessage( "Inicializa valor de adicional por empresa con ", "") + GXutil.trim( GXutil.str( AV17Importes, 14, 2)) ;
            }
            else
            {
               AV31definidaEnPalabra = httpContext.getMessage( "empresa", "") ;
               /* Execute user subroutine: 'GET SUELDO' */
               S111 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         else
         {
            AV18LiqDLog = httpContext.getMessage( "No calcula porque no tiene configurado valor por presentismo en convenio ni empresa", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&diasTrabLiqDCanti: ", "")+GXutil.trim( GXutil.str( AV65diasTrabLiqDCanti, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&ParmValue: ", "")+GXutil.trim( AV61ParmValue)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&todosLosMeses30Es: ", "")+GXutil.trim( GXutil.booltostr( AV66todosLosMeses30Es))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&mesCompletoCantDias: ", "")+GXutil.trim( GXutil.str( AV67mesCompletoCantDias, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&Importes: ", "")+GXutil.trim( GXutil.str( AV17Importes, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV74Pgmname, httpContext.getMessage( "&LiqDLog: ", "")+GXutil.trim( AV18LiqDLog)) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'GET SUELDO' Routine */
      returnInSub = false ;
      AV57desde_LiqPeriodo = localUtil.ymdtod( GXutil.year( AV12LiqPeriodo), 1, 1) ;
      GXv_char2[0] = AV61ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), GXv_char2) ;
      presentismo_importe2.this.AV61ParmValue = GXv_char2[0] ;
      AV58proporcionHabitualPorUnaje = CommonUtil.decimalVal( AV61ParmValue, ".") ;
      GXv_decimal5[0] = AV17Importes ;
      GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
      GXv_int7[0] = AV35auxLiqDCalculado ;
      GXv_char2[0] = AV55auxError ;
      GXv_char8[0] = AV59auxLiqDLog ;
      new web.base_calculo_pres_ant(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV63LiqRelNro, AV11LegNumero, AV12LiqPeriodo, AV71tipo_tarifa, httpContext.getMessage( "PRESENTISMO", ""), AV62llamador, AV57desde_LiqPeriodo, AV58proporcionHabitualPorUnaje, AV16ProcesoLiquidacion, GXv_decimal5, GXv_decimal6, GXv_int7, GXv_char2, GXv_char8) ;
      presentismo_importe2.this.AV17Importes = GXv_decimal5[0] ;
      presentismo_importe2.this.AV35auxLiqDCalculado = GXv_int7[0] ;
      presentismo_importe2.this.AV55auxError = GXv_char2[0] ;
      presentismo_importe2.this.AV59auxLiqDLog = GXv_char8[0] ;
      if ( AV35auxLiqDCalculado == 0 )
      {
         AV24LiqDCalculado = (byte)(0) ;
         AV29error = AV55auxError ;
         AV18LiqDLog = AV29error ;
      }
      AV18LiqDLog += GXutil.trim( AV59auxLiqDLog) ;
      AV17Importes = AV17Importes.multiply(AV30presentismoImportes) ;
      AV18LiqDLog += httpContext.getMessage( ". Multiplica por alícuota ", "") + GXutil.trim( GXutil.str( AV30presentismoImportes, 14, 2)) + httpContext.getMessage( " definida en ", "") + AV31definidaEnPalabra ;
   }

   protected void cleanup( )
   {
      this.aP10[0] = presentismo_importe2.this.AV17Importes;
      this.aP11[0] = presentismo_importe2.this.AV29error;
      this.aP12[0] = presentismo_importe2.this.AV18LiqDLog;
      this.aP13[0] = presentismo_importe2.this.AV24LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV17Importes = DecimalUtil.ZERO ;
      AV29error = "" ;
      AV18LiqDLog = "" ;
      AV59auxLiqDLog = "" ;
      GXv_int1 = new short[1] ;
      AV14presentismoPalabra = "" ;
      GXt_char4 = "" ;
      AV30presentismoImportes = DecimalUtil.ZERO ;
      AV31definidaEnPalabra = "" ;
      AV74Pgmname = "" ;
      AV65diasTrabLiqDCanti = DecimalUtil.ZERO ;
      AV61ParmValue = "" ;
      AV57desde_LiqPeriodo = GXutil.nullDate() ;
      AV58proporcionHabitualPorUnaje = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_int7 = new byte[1] ;
      AV55auxError = "" ;
      GXv_char2 = new String[1] ;
      GXv_char8 = new String[1] ;
      AV74Pgmname = "presentismo_importe2" ;
      /* GeneXus formulas. */
      AV74Pgmname = "presentismo_importe2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV24LiqDCalculado ;
   private byte AV35auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV9EmpCod ;
   private short AV32asistencia_perfecta ;
   private short AV15PaiCod ;
   private short GXt_int3 ;
   private short GXv_int1[] ;
   private short AV67mesCompletoCantDias ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV63LiqRelNro ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV17Importes ;
   private java.math.BigDecimal AV30presentismoImportes ;
   private java.math.BigDecimal AV65diasTrabLiqDCanti ;
   private java.math.BigDecimal AV58proporcionHabitualPorUnaje ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String AV71tipo_tarifa ;
   private String AV13ConCodigo ;
   private String AV16ProcesoLiquidacion ;
   private String AV62llamador ;
   private String AV14presentismoPalabra ;
   private String GXt_char4 ;
   private String AV31definidaEnPalabra ;
   private String AV74Pgmname ;
   private String GXv_char2[] ;
   private String GXv_char8[] ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date AV57desde_LiqPeriodo ;
   private boolean returnInSub ;
   private boolean AV66todosLosMeses30Es ;
   private String AV18LiqDLog ;
   private String AV59auxLiqDLog ;
   private String AV61ParmValue ;
   private String AV29error ;
   private String AV55auxError ;
   private byte[] aP13 ;
   private java.math.BigDecimal[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
}

