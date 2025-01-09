package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class indemnizacion_antiguedad extends GXProcedure
{
   public indemnizacion_antiguedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( indemnizacion_antiguedad.class ), "" );
   }

   public indemnizacion_antiguedad( int remoteHandle ,
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
                           String aP5 ,
                           java.util.Date aP6 ,
                           java.math.BigDecimal[] aP7 ,
                           String[] aP8 ,
                           String[] aP9 )
   {
      indemnizacion_antiguedad.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      indemnizacion_antiguedad.this.AV12CliCod = aP0;
      indemnizacion_antiguedad.this.AV8EmpCod = aP1;
      indemnizacion_antiguedad.this.AV15LiqNro = aP2;
      indemnizacion_antiguedad.this.AV33LiqRelNro = aP3;
      indemnizacion_antiguedad.this.AV13LegNumero = aP4;
      indemnizacion_antiguedad.this.AV28ConCodigo = aP5;
      indemnizacion_antiguedad.this.AV14LiqPeriodo = aP6;
      indemnizacion_antiguedad.this.aP7 = aP7;
      indemnizacion_antiguedad.this.aP8 = aP8;
      indemnizacion_antiguedad.this.aP9 = aP9;
      indemnizacion_antiguedad.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV27LiqDCalculado = (byte)(1) ;
      AV9palabra = "[antiguedad_indemnizacion]" ;
      GXv_int1[0] = AV10antiguedad ;
      GXv_char2[0] = AV11LiqDLog ;
      new web.antiguedad_anios(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, AV13LegNumero, AV14LiqPeriodo, AV9palabra, GXv_int1, GXv_char2) ;
      indemnizacion_antiguedad.this.AV10antiguedad = GXv_int1[0] ;
      indemnizacion_antiguedad.this.AV11LiqDLog = GXv_char2[0] ;
      if ( AV10antiguedad > 0 )
      {
         GXv_decimal3[0] = AV16mejorSueldo ;
         GXv_char2[0] = AV17auxLiqDLog ;
         new web.mejorremuneracionmensualnormalyhabitual(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, AV33LiqRelNro, AV13LegNumero, AV14LiqPeriodo, GXv_decimal3, GXv_char2) ;
         indemnizacion_antiguedad.this.AV16mejorSueldo = GXv_decimal3[0] ;
         indemnizacion_antiguedad.this.AV17auxLiqDLog = GXv_char2[0] ;
         AV11LiqDLog += ". " + GXutil.trim( AV17auxLiqDLog) ;
         GXv_decimal3[0] = AV18topeIndemLiqDImpCalcu ;
         GXv_char2[0] = AV22topeLiqDLog ;
         new web.tope_indemnizatorio(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, AV13LegNumero, AV14LiqPeriodo, GXv_decimal3, GXv_char2) ;
         indemnizacion_antiguedad.this.AV18topeIndemLiqDImpCalcu = GXv_decimal3[0] ;
         indemnizacion_antiguedad.this.AV22topeLiqDLog = GXv_char2[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV18topeIndemLiqDImpCalcu)==0) )
         {
            AV11LiqDLog += ". " + GXutil.trim( AV22topeLiqDLog) ;
            GXv_boolean4[0] = AV19EmpExcVizzoti ;
            GXv_decimal3[0] = AV20EmpVizzoti ;
            new web.getempresavizzoti(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, GXv_boolean4, GXv_decimal3) ;
            indemnizacion_antiguedad.this.AV19EmpExcVizzoti = GXv_boolean4[0] ;
            indemnizacion_antiguedad.this.AV20EmpVizzoti = GXv_decimal3[0] ;
            if ( ! AV19EmpExcVizzoti || (DecimalUtil.compareTo(DecimalUtil.ZERO, AV20EmpVizzoti)==0) )
            {
               if ( DecimalUtil.compareTo(AV16mejorSueldo, AV18topeIndemLiqDImpCalcu) > 0 )
               {
                  AV32quePalabra = httpContext.getMessage( "tope", "") ;
                  AV21Importes = AV18topeIndemLiqDImpCalcu ;
               }
               else
               {
                  AV21Importes = AV16mejorSueldo ;
                  AV32quePalabra = httpContext.getMessage( "mejor sueldo", "") ;
               }
            }
            else
            {
               if ( DecimalUtil.compareTo(AV16mejorSueldo, AV18topeIndemLiqDImpCalcu) > 0 )
               {
                  AV23sueldoVizzotiLiqDImpCalcu = AV16mejorSueldo.multiply(AV20EmpVizzoti) ;
                  AV11LiqDLog += httpContext.getMessage( ". La proporción ", "") + GXutil.trim( GXutil.str( AV20EmpVizzoti, 6, 4)) + httpContext.getMessage( " del sueldo para evaluar excepción a tope (fallo Vizzoti) es ", "") + GXutil.trim( GXutil.str( AV23sueldoVizzotiLiqDImpCalcu, 14, 2)) ;
                  if ( DecimalUtil.compareTo(AV23sueldoVizzotiLiqDImpCalcu, AV18topeIndemLiqDImpCalcu) > 0 )
                  {
                     AV21Importes = AV23sueldoVizzotiLiqDImpCalcu ;
                     AV32quePalabra = httpContext.getMessage( "el valor", "") ;
                     AV31razonTexto = httpContext.getMessage( " porque ", "") + GXutil.trim( GXutil.str( AV23sueldoVizzotiLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " es mayor al tope", "") ;
                  }
                  else
                  {
                     AV21Importes = AV18topeIndemLiqDImpCalcu ;
                     AV32quePalabra = httpContext.getMessage( "tope", "") ;
                     if ( DecimalUtil.compareTo(AV23sueldoVizzotiLiqDImpCalcu, AV18topeIndemLiqDImpCalcu) < 0 )
                     {
                        AV31razonTexto += httpContext.getMessage( " porque ", "") + GXutil.trim( GXutil.str( AV23sueldoVizzotiLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " es menor al tope", "") ;
                     }
                     else
                     {
                        AV31razonTexto += httpContext.getMessage( " porque ", "") + GXutil.trim( GXutil.str( AV23sueldoVizzotiLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " es igual al tope", "") ;
                     }
                  }
               }
               else
               {
                  AV21Importes = AV16mejorSueldo ;
                  AV32quePalabra = httpContext.getMessage( "mejor sueldo", "") ;
               }
            }
         }
         else
         {
            AV21Importes = AV16mejorSueldo ;
         }
         AV11LiqDLog += httpContext.getMessage( ". Se inicializa valor con ", "") + GXutil.trim( AV32quePalabra) + " " + GXutil.trim( GXutil.str( AV21Importes, 14, 2)) ;
         if ( ! (GXutil.strcmp("", AV31razonTexto)==0) )
         {
            AV11LiqDLog += " " + GXutil.trim( AV31razonTexto) ;
         }
         AV21Importes = AV21Importes.multiply(DecimalUtil.doubleToDec(AV10antiguedad)) ;
         AV11LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV10antiguedad, 4, 0)) + httpContext.getMessage( " años de antiguedad", "") ;
         GXv_char2[0] = AV25auxError ;
         GXv_decimal3[0] = AV26sueldoImportes ;
         GXv_char5[0] = AV34LegSuelTipo ;
         GXv_char6[0] = AV17auxLiqDLog ;
         new web.obtsueldobasicomensual(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, AV13LegNumero, AV15LiqNro, AV14LiqPeriodo, DecimalUtil.doubleToDec(0), httpContext.getMessage( "TOTAL", ""), GXv_char2, GXv_decimal3, GXv_char5, GXv_char6) ;
         indemnizacion_antiguedad.this.AV25auxError = GXv_char2[0] ;
         indemnizacion_antiguedad.this.AV26sueldoImportes = GXv_decimal3[0] ;
         indemnizacion_antiguedad.this.AV34LegSuelTipo = GXv_char5[0] ;
         indemnizacion_antiguedad.this.AV17auxLiqDLog = GXv_char6[0] ;
         if ( ! (GXutil.strcmp("", AV25auxError)==0) )
         {
            AV24error = AV25auxError ;
            AV11LiqDLog += ". " + GXutil.trim( AV24error) ;
            AV27LiqDCalculado = (byte)(0) ;
         }
         else
         {
            if ( DecimalUtil.compareTo(AV21Importes, AV26sueldoImportes) < 0 )
            {
               AV21Importes = AV26sueldoImportes ;
               AV11LiqDLog += httpContext.getMessage( ". Se asigna valor de sueldo ", "") + GXutil.trim( GXutil.str( AV21Importes, 14, 2)) + httpContext.getMessage( " por ser el valor calculado menor a 1 mes de sueldo", "") ;
            }
         }
         GXv_boolean4[0] = false ;
         GXv_decimal3[0] = AV29ConMegPropor ;
         new web.conceptoaplicamotegr(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, AV13LegNumero, AV28ConCodigo, GXv_boolean4, GXv_decimal3) ;
         indemnizacion_antiguedad.this.AV29ConMegPropor = GXv_decimal3[0] ;
         if ( AV29ConMegPropor.doubleValue() != 1 )
         {
            AV21Importes = AV21Importes.multiply(AV29ConMegPropor) ;
            AV11LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV29ConMegPropor, 6, 4)) + httpContext.getMessage( " definido en el motivo de egreso relacionado al concepto por antiguedad", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = indemnizacion_antiguedad.this.AV21Importes;
      this.aP8[0] = indemnizacion_antiguedad.this.AV11LiqDLog;
      this.aP9[0] = indemnizacion_antiguedad.this.AV24error;
      this.aP10[0] = indemnizacion_antiguedad.this.AV27LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21Importes = DecimalUtil.ZERO ;
      AV11LiqDLog = "" ;
      AV24error = "" ;
      AV9palabra = "" ;
      GXv_int1 = new short[1] ;
      AV16mejorSueldo = DecimalUtil.ZERO ;
      AV17auxLiqDLog = "" ;
      AV18topeIndemLiqDImpCalcu = DecimalUtil.ZERO ;
      AV22topeLiqDLog = "" ;
      AV20EmpVizzoti = DecimalUtil.ZERO ;
      AV32quePalabra = "" ;
      AV23sueldoVizzotiLiqDImpCalcu = DecimalUtil.ZERO ;
      AV31razonTexto = "" ;
      AV25auxError = "" ;
      GXv_char2 = new String[1] ;
      AV26sueldoImportes = DecimalUtil.ZERO ;
      AV34LegSuelTipo = "" ;
      GXv_char5 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_boolean4 = new boolean[1] ;
      AV29ConMegPropor = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV27LiqDCalculado ;
   private short AV8EmpCod ;
   private short AV10antiguedad ;
   private short GXv_int1[] ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV15LiqNro ;
   private int AV33LiqRelNro ;
   private int AV13LegNumero ;
   private java.math.BigDecimal AV21Importes ;
   private java.math.BigDecimal AV16mejorSueldo ;
   private java.math.BigDecimal AV18topeIndemLiqDImpCalcu ;
   private java.math.BigDecimal AV20EmpVizzoti ;
   private java.math.BigDecimal AV23sueldoVizzotiLiqDImpCalcu ;
   private java.math.BigDecimal AV26sueldoImportes ;
   private java.math.BigDecimal AV29ConMegPropor ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private String AV28ConCodigo ;
   private String AV9palabra ;
   private String AV32quePalabra ;
   private String GXv_char2[] ;
   private String AV34LegSuelTipo ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean AV19EmpExcVizzoti ;
   private boolean GXv_boolean4[] ;
   private String AV11LiqDLog ;
   private String AV17auxLiqDLog ;
   private String AV22topeLiqDLog ;
   private String AV24error ;
   private String AV31razonTexto ;
   private String AV25auxError ;
   private byte[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
}

