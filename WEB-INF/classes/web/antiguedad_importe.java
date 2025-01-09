package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class antiguedad_importe extends GXProcedure
{
   public antiguedad_importe( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( antiguedad_importe.class ), "" );
   }

   public antiguedad_importe( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
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
      antiguedad_importe.this.aP14 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
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
                        byte[] aP13 ,
                        short[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
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
                             byte[] aP13 ,
                             short[] aP14 )
   {
      antiguedad_importe.this.AV8CliCod = aP0;
      antiguedad_importe.this.AV9EmpCod = aP1;
      antiguedad_importe.this.AV10LiqNro = aP2;
      antiguedad_importe.this.AV41LiqRelNro = aP3;
      antiguedad_importe.this.AV11LegNumero = aP4;
      antiguedad_importe.this.AV12LiqPeriodo = aP5;
      antiguedad_importe.this.AV49tipo_tarifa = aP6;
      antiguedad_importe.this.AV13ConCodigo = aP7;
      antiguedad_importe.this.AV16ProcesoLiquidacion = aP8;
      antiguedad_importe.this.AV39llamador = aP9;
      antiguedad_importe.this.aP10 = aP10;
      antiguedad_importe.this.aP11 = aP11;
      antiguedad_importe.this.aP12 = aP12;
      antiguedad_importe.this.aP13 = aP13;
      antiguedad_importe.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV24LiqDCalculado = (byte)(1) ;
      AV21palabra = "[antiguedad]" ;
      GXv_int1[0] = AV22anios ;
      GXv_char2[0] = AV23antiguedadLiqDLog ;
      new web.antiguedad_anios(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV11LegNumero, AV12LiqPeriodo, AV21palabra, GXv_int1, GXv_char2) ;
      antiguedad_importe.this.AV22anios = GXv_int1[0] ;
      antiguedad_importe.this.AV23antiguedadLiqDLog = GXv_char2[0] ;
      if ( AV22anios == 0 )
      {
         AV18LiqDLog = httpContext.getMessage( "No calcula porque todavía no tiene 1 año de antiguedad", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_int3 = AV15PaiCod ;
      GXv_int1[0] = GXt_int3 ;
      new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int1) ;
      antiguedad_importe.this.GXt_int3 = GXv_int1[0] ;
      AV15PaiCod = GXt_int3 ;
      GXt_char4 = AV14antiguedadPalabra ;
      GXv_char2[0] = GXt_char4 ;
      new web.getadicionalreservado(remoteHandle, context).execute( AV15PaiCod, "antiguedad", GXv_char2) ;
      antiguedad_importe.this.GXt_char4 = GXv_char2[0] ;
      AV14antiguedadPalabra = GXt_char4 ;
      GXv_decimal5[0] = AV30antiguedadImportes ;
      GXv_char2[0] = AV38auxLiqDLog ;
      new web.conveniogetadicional2(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV12LiqPeriodo, AV13ConCodigo, AV14antiguedadPalabra, "", AV16ProcesoLiquidacion, GXv_decimal5, GXv_char2) ;
      antiguedad_importe.this.AV30antiguedadImportes = GXv_decimal5[0] ;
      antiguedad_importe.this.AV38auxLiqDLog = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV38auxLiqDLog)==0) )
      {
         AV18LiqDLog = AV38auxLiqDLog ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30antiguedadImportes)==0) )
      {
         if ( AV30antiguedadImportes.doubleValue() > 1 )
         {
            AV17Importes = AV30antiguedadImportes ;
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
         GXv_decimal5[0] = AV30antiguedadImportes ;
         new web.getantiguedadporempresa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, GXv_decimal5) ;
         antiguedad_importe.this.AV30antiguedadImportes = GXv_decimal5[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30antiguedadImportes)==0) )
         {
            if ( AV30antiguedadImportes.doubleValue() > 1 )
            {
               AV17Importes = AV30antiguedadImportes ;
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
            AV18LiqDLog = httpContext.getMessage( "No calcula porque no tiene configurado valor por antiguedad en convenio ni empresa", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV17Importes = AV17Importes.multiply(DecimalUtil.doubleToDec(AV22anios)) ;
      AV18LiqDLog += httpContext.getMessage( ". Multiplica por ", "") + GXutil.trim( AV23antiguedadLiqDLog) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'GET SUELDO' Routine */
      returnInSub = false ;
      AV32desde_LiqPeriodo = localUtil.ymdtod( GXutil.year( AV12LiqPeriodo), 1, 1) ;
      GXv_char2[0] = AV33ParmValue ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.proporcion_habitual_param(remoteHandle, context).executeUdp( ), GXv_char2) ;
      antiguedad_importe.this.AV33ParmValue = GXv_char2[0] ;
      AV34proporcionHabitualPorUnaje = CommonUtil.decimalVal( AV33ParmValue, ".") ;
      GXv_decimal5[0] = AV17Importes ;
      GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
      GXv_int7[0] = AV36auxLiqDCalculado ;
      GXv_char2[0] = AV37auxError ;
      GXv_char8[0] = AV38auxLiqDLog ;
      new web.base_calculo_pres_ant(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV41LiqRelNro, AV11LegNumero, AV12LiqPeriodo, AV49tipo_tarifa, httpContext.getMessage( "PRESENTISMO", ""), AV39llamador, AV32desde_LiqPeriodo, AV34proporcionHabitualPorUnaje, AV16ProcesoLiquidacion, GXv_decimal5, GXv_decimal6, GXv_int7, GXv_char2, GXv_char8) ;
      antiguedad_importe.this.AV17Importes = GXv_decimal5[0] ;
      antiguedad_importe.this.AV36auxLiqDCalculado = GXv_int7[0] ;
      antiguedad_importe.this.AV37auxError = GXv_char2[0] ;
      antiguedad_importe.this.AV38auxLiqDLog = GXv_char8[0] ;
      if ( AV36auxLiqDCalculado == 0 )
      {
         AV24LiqDCalculado = (byte)(0) ;
         AV29error = AV37auxError ;
         AV18LiqDLog = AV29error ;
      }
      AV18LiqDLog += GXutil.trim( AV38auxLiqDLog) ;
      AV17Importes = AV17Importes.multiply(AV30antiguedadImportes) ;
      AV18LiqDLog += httpContext.getMessage( ". Multiplica por alícuota ", "") + GXutil.trim( GXutil.str( AV30antiguedadImportes, 14, 2)) + httpContext.getMessage( " definida en ", "") + AV31definidaEnPalabra ;
   }

   protected void cleanup( )
   {
      this.aP10[0] = antiguedad_importe.this.AV17Importes;
      this.aP11[0] = antiguedad_importe.this.AV29error;
      this.aP12[0] = antiguedad_importe.this.AV18LiqDLog;
      this.aP13[0] = antiguedad_importe.this.AV24LiqDCalculado;
      this.aP14[0] = antiguedad_importe.this.AV22anios;
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
      AV21palabra = "" ;
      AV23antiguedadLiqDLog = "" ;
      GXv_int1 = new short[1] ;
      AV14antiguedadPalabra = "" ;
      GXt_char4 = "" ;
      AV30antiguedadImportes = DecimalUtil.ZERO ;
      AV38auxLiqDLog = "" ;
      AV31definidaEnPalabra = "" ;
      AV32desde_LiqPeriodo = GXutil.nullDate() ;
      AV33ParmValue = "" ;
      AV34proporcionHabitualPorUnaje = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_int7 = new byte[1] ;
      AV37auxError = "" ;
      GXv_char2 = new String[1] ;
      GXv_char8 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV24LiqDCalculado ;
   private byte AV36auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV9EmpCod ;
   private short AV22anios ;
   private short AV15PaiCod ;
   private short GXt_int3 ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV41LiqRelNro ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV17Importes ;
   private java.math.BigDecimal AV30antiguedadImportes ;
   private java.math.BigDecimal AV34proporcionHabitualPorUnaje ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private String AV49tipo_tarifa ;
   private String AV13ConCodigo ;
   private String AV16ProcesoLiquidacion ;
   private String AV39llamador ;
   private String AV21palabra ;
   private String AV14antiguedadPalabra ;
   private String GXt_char4 ;
   private String AV31definidaEnPalabra ;
   private String GXv_char2[] ;
   private String GXv_char8[] ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date AV32desde_LiqPeriodo ;
   private boolean returnInSub ;
   private String AV18LiqDLog ;
   private String AV23antiguedadLiqDLog ;
   private String AV38auxLiqDLog ;
   private String AV33ParmValue ;
   private String AV29error ;
   private String AV37auxError ;
   private short[] aP14 ;
   private java.math.BigDecimal[] aP10 ;
   private String[] aP11 ;
   private String[] aP12 ;
   private byte[] aP13 ;
}

