package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diasproptope_sueldo extends GXProcedure
{
   public diasproptope_sueldo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diasproptope_sueldo.class ), "" );
   }

   public diasproptope_sueldo( int remoteHandle ,
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
                           boolean aP7 ,
                           String aP8 ,
                           short[] aP9 ,
                           String[] aP10 ,
                           String[] aP11 )
   {
      diasproptope_sueldo.this.aP12 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        short[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             short[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 )
   {
      diasproptope_sueldo.this.AV9CliCod = aP0;
      diasproptope_sueldo.this.AV10EmpCod = aP1;
      diasproptope_sueldo.this.AV11LiqNro = aP2;
      diasproptope_sueldo.this.AV39LiqRelNro = aP3;
      diasproptope_sueldo.this.AV12LegNumero = aP4;
      diasproptope_sueldo.this.AV13LiqPeriodo = aP5;
      diasproptope_sueldo.this.AV27ProcesoLIquidacion = aP6;
      diasproptope_sueldo.this.AV28insertandoConceptos = aP7;
      diasproptope_sueldo.this.AV33llamador = aP8;
      diasproptope_sueldo.this.aP9 = aP9;
      diasproptope_sueldo.this.aP10 = aP10;
      diasproptope_sueldo.this.aP11 = aP11;
      diasproptope_sueldo.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LiqDCalculado = (byte)(1) ;
      if ( GXutil.strcmp(AV33llamador, httpContext.getMessage( "ProcLiquidacion2", "")) == 0 )
      {
         GXt_char1 = AV29auxConCodigo ;
         GXt_char2 = AV29auxConCodigo ;
         GXv_char3[0] = GXt_char2 ;
         new web.concepto_sueldomensual_codigoparam(remoteHandle, context).execute( GXv_char3) ;
         diasproptope_sueldo.this.GXt_char2 = GXv_char3[0] ;
         GXv_char4[0] = GXt_char1 ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
         diasproptope_sueldo.this.GXt_char1 = GXv_char4[0] ;
         AV29auxConCodigo = GXt_char1 ;
         GXv_decimal5[0] = AV30auxLiqDCanti ;
         GXv_boolean6[0] = AV22existe ;
         GXv_int7[0] = AV31auxLiqDCalculado ;
         new web.getliqdcantidad(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV29auxConCodigo, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         diasproptope_sueldo.this.AV30auxLiqDCanti = GXv_decimal5[0] ;
         diasproptope_sueldo.this.AV22existe = GXv_boolean6[0] ;
         diasproptope_sueldo.this.AV31auxLiqDCalculado = GXv_int7[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( "legnumero ", "")+GXutil.trim( GXutil.str( AV12LegNumero, 8, 0))+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV22existe))) ;
         if ( AV22existe )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( "&auxLiqDCalculado ", "")+GXutil.trim( GXutil.str( AV31auxLiqDCalculado, 1, 0))) ;
            if ( AV31auxLiqDCalculado == 0 )
            {
               AV15LiqDCalculado = (byte)(0) ;
               AV16error = httpContext.getMessage( "Falta calcular concepto ", "") ;
               AV19LiqDLog = GXutil.trim( AV16error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( "&auxLiqDCanti ", "")+GXutil.trim( GXutil.str( AV30auxLiqDCanti, 14, 2))) ;
            if ( AV30auxLiqDCanti.doubleValue() > 0 )
            {
               AV14dias_trabajados_mes = (short)(DecimalUtil.decToDouble(AV30auxLiqDCanti)) ;
               AV19LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV14dias_trabajados_mes, 4, 0)) + httpContext.getMessage( " de concepto ", "") + GXutil.trim( AV29auxConCodigo) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      GXv_int8[0] = AV18dias_mes ;
      new web.diasmes(remoteHandle, context).execute( AV9CliCod, AV13LiqPeriodo, GXv_int8) ;
      diasproptope_sueldo.this.AV18dias_mes = GXv_int8[0] ;
      AV8palabra = "[dias_trabajados_mes]" ;
      GXv_int9[0] = AV14dias_trabajados_mes ;
      GXv_int7[0] = AV15LiqDCalculado ;
      GXv_char4[0] = AV16error ;
      GXv_char3[0] = AV17dtmLiqDLog ;
      new web.obtvalformuladtmydts(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV39LiqRelNro, AV12LegNumero, AV8palabra, AV13LiqPeriodo, false, false, false, AV27ProcesoLIquidacion, AV28insertandoConceptos, GXv_int9, GXv_int7, GXv_char4, GXv_char3) ;
      diasproptope_sueldo.this.AV14dias_trabajados_mes = (short)((short)(GXv_int9[0])) ;
      diasproptope_sueldo.this.AV15LiqDCalculado = GXv_int7[0] ;
      diasproptope_sueldo.this.AV16error = GXv_char4[0] ;
      diasproptope_sueldo.this.AV17dtmLiqDLog = GXv_char3[0] ;
      AV19LiqDLog = GXutil.trim( AV17dtmLiqDLog) ;
      if ( AV15LiqDCalculado == 0 )
      {
         if ( (GXutil.strcmp("", AV16error)==0) )
         {
            AV16error = httpContext.getMessage( "Falta calcular días trabajados en el mes", "") ;
         }
         AV19LiqDLog += GXutil.trim( AV16error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( true )
      {
         AV35desdeTipoConCod = "NRE_ARG" ;
         AV36hastaTipoConCod = "REM_ARG" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV45Pgmname, httpContext.getMessage( "resta? 1", "")) ;
         GXv_decimal5[0] = AV40restarLiqDCanti ;
         GXv_char4[0] = AV41auxError ;
         GXv_char3[0] = AV42auxLiqDLog ;
         new web.obtienediasnoremunerados(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV35desdeTipoConCod, AV36hastaTipoConCod, GXv_decimal5, GXv_char4, GXv_char3) ;
         diasproptope_sueldo.this.AV40restarLiqDCanti = GXv_decimal5[0] ;
         diasproptope_sueldo.this.AV41auxError = GXv_char4[0] ;
         diasproptope_sueldo.this.AV42auxLiqDLog = GXv_char3[0] ;
         if ( ! (GXutil.strcmp("", AV41auxError)==0) )
         {
            AV16error = AV41auxError ;
            AV15LiqDCalculado = (byte)(0) ;
            AV19LiqDLog = GXutil.trim( AV16error) ;
         }
         AV14dias_trabajados_mes = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV14dias_trabajados_mes).subtract(AV40restarLiqDCanti))) ;
         AV19LiqDLog += AV42auxLiqDLog ;
      }
      if ( AV18dias_mes == 0 )
      {
         AV16error = httpContext.getMessage( "Días del mes en cero al calcular descuento por adelanto de vacaciones", "") ;
         AV15LiqDCalculado = (byte)(0) ;
         AV19LiqDLog += AV16error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'SEPARAR LOG' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV19LiqDLog)==0) )
      {
         AV19LiqDLog += ". " ;
      }
   }

   protected void cleanup( )
   {
      this.aP9[0] = diasproptope_sueldo.this.AV14dias_trabajados_mes;
      this.aP10[0] = diasproptope_sueldo.this.AV16error;
      this.aP11[0] = diasproptope_sueldo.this.AV19LiqDLog;
      this.aP12[0] = diasproptope_sueldo.this.AV15LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV16error = "" ;
      AV19LiqDLog = "" ;
      AV29auxConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      AV30auxLiqDCanti = DecimalUtil.ZERO ;
      GXv_boolean6 = new boolean[1] ;
      AV45Pgmname = "" ;
      GXv_int8 = new short[1] ;
      AV8palabra = "" ;
      GXv_int9 = new int[1] ;
      GXv_int7 = new byte[1] ;
      AV17dtmLiqDLog = "" ;
      AV35desdeTipoConCod = "" ;
      AV36hastaTipoConCod = "" ;
      AV40restarLiqDCanti = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV41auxError = "" ;
      GXv_char4 = new String[1] ;
      AV42auxLiqDLog = "" ;
      GXv_char3 = new String[1] ;
      AV45Pgmname = "diasPropTope_sueldo" ;
      /* GeneXus formulas. */
      AV45Pgmname = "diasPropTope_sueldo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV31auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV10EmpCod ;
   private short AV14dias_trabajados_mes ;
   private short AV18dias_mes ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LiqNro ;
   private int AV39LiqRelNro ;
   private int AV12LegNumero ;
   private int GXv_int9[] ;
   private java.math.BigDecimal AV30auxLiqDCanti ;
   private java.math.BigDecimal AV40restarLiqDCanti ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV27ProcesoLIquidacion ;
   private String AV33llamador ;
   private String AV29auxConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String AV45Pgmname ;
   private String AV8palabra ;
   private String AV35desdeTipoConCod ;
   private String AV36hastaTipoConCod ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV13LiqPeriodo ;
   private boolean AV28insertandoConceptos ;
   private boolean AV22existe ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private String AV19LiqDLog ;
   private String AV17dtmLiqDLog ;
   private String AV42auxLiqDLog ;
   private String AV16error ;
   private String AV41auxError ;
   private byte[] aP12 ;
   private short[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
}

