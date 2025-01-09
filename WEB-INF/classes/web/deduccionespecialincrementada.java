package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deduccionespecialincrementada extends GXProcedure
{
   public deduccionespecialincrementada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deduccionespecialincrementada.class ), "" );
   }

   public deduccionespecialincrementada( int remoteHandle ,
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
                             java.util.Date aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             String aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 )
   {
      deduccionespecialincrementada.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        java.math.BigDecimal aP6 ,
                        java.math.BigDecimal aP7 ,
                        String aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        byte[] aP10 ,
                        String[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             java.math.BigDecimal aP6 ,
                             java.math.BigDecimal aP7 ,
                             String aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 ,
                             String[] aP12 )
   {
      deduccionespecialincrementada.this.AV22CliCod = aP0;
      deduccionespecialincrementada.this.AV21EmpCod = aP1;
      deduccionespecialincrementada.this.AV14LiqNro = aP2;
      deduccionespecialincrementada.this.AV49LiqRelNro = aP3;
      deduccionespecialincrementada.this.AV15LegNumero = aP4;
      deduccionespecialincrementada.this.AV32LiqPeriodo = aP5;
      deduccionespecialincrementada.this.AV38simulacionGNSI = aP6;
      deduccionespecialincrementada.this.AV39simulacionSueldoBrutoImponible = aP7;
      deduccionespecialincrementada.this.AV47ProcesoLiquidacion = aP8;
      deduccionespecialincrementada.this.aP9 = aP9;
      deduccionespecialincrementada.this.aP10 = aP10;
      deduccionespecialincrementada.this.aP11 = aP11;
      deduccionespecialincrementada.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV13LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV36parametroPalabra ;
      GXt_char2 = AV36parametroPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.metodorecalculo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      deduccionespecialincrementada.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV22CliCod, GXt_char2, GXv_char4) ;
      deduccionespecialincrementada.this.GXt_char1 = GXv_char4[0] ;
      AV36parametroPalabra = GXt_char1 ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38simulacionGNSI)==0) )
      {
         GXv_char4[0] = AV25ganNetaSujAImpConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV22CliCod, new web.gannetsujimp_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
         deduccionespecialincrementada.this.AV25ganNetaSujAImpConCodigo = GXv_char4[0] ;
         GXv_decimal5[0] = AV26GNSIImportes ;
         GXv_boolean6[0] = AV19existe ;
         GXv_int7[0] = AV13LiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV22CliCod, AV21EmpCod, AV14LiqNro, AV15LegNumero, AV25ganNetaSujAImpConCodigo, AV47ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         deduccionespecialincrementada.this.AV26GNSIImportes = GXv_decimal5[0] ;
         deduccionespecialincrementada.this.AV19existe = GXv_boolean6[0] ;
         deduccionespecialincrementada.this.AV13LiqDCalculado = GXv_int7[0] ;
         if ( AV13LiqDCalculado == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV55Pgmname, httpContext.getMessage( "return 1", "")) ;
            AV52error = httpContext.getMessage( "Fala calcular concepto ", "") + GXutil.trim( AV25ganNetaSujAImpConCodigo) ;
            AV48LiqDLog = GXutil.trim( AV52error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_decimal5[0] = AV40auxImportes ;
         new web.getliqdimp_recalculadoliqantper(remoteHandle, context).execute( AV22CliCod, AV21EmpCod, AV14LiqNro, AV49LiqRelNro, AV32LiqPeriodo, AV15LegNumero, AV25ganNetaSujAImpConCodigo, GXv_decimal5) ;
         deduccionespecialincrementada.this.AV40auxImportes = GXv_decimal5[0] ;
         AV26GNSIImportes = AV26GNSIImportes.add(AV40auxImportes) ;
      }
      else
      {
         AV26GNSIImportes = AV38simulacionGNSI ;
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV39simulacionSueldoBrutoImponible)==0) )
      {
         GXv_char4[0] = AV35SueldoSinSacConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV22CliCod, new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
         deduccionespecialincrementada.this.AV35SueldoSinSacConCodigo = GXv_char4[0] ;
         GXv_decimal5[0] = AV44sueldoSinSacImportes ;
         GXv_decimal8[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean6[0] = AV19existe ;
         GXv_int7[0] = AV13LiqDCalculado ;
         new web.getliqdimpcalcuporperiodo(remoteHandle, context).execute( AV22CliCod, AV21EmpCod, AV14LiqNro, AV49LiqRelNro, AV32LiqPeriodo, AV15LegNumero, AV35SueldoSinSacConCodigo, AV47ProcesoLiquidacion, true, true, GXv_decimal5, GXv_decimal8, GXv_boolean6, GXv_int7) ;
         deduccionespecialincrementada.this.AV44sueldoSinSacImportes = GXv_decimal5[0] ;
         deduccionespecialincrementada.this.AV19existe = GXv_boolean6[0] ;
         deduccionespecialincrementada.this.AV13LiqDCalculado = GXv_int7[0] ;
         if ( AV13LiqDCalculado == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV55Pgmname, httpContext.getMessage( "return 2", "")) ;
            AV52error = httpContext.getMessage( "Fala calcular concepto ", "") + GXutil.trim( AV35SueldoSinSacConCodigo) ;
            AV48LiqDLog = GXutil.trim( AV52error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_char4[0] = AV45SueldoPromedioConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV22CliCod, new web.concepto_brutopromedio_codigoparam(remoteHandle, context).executeUdp( ), GXv_char4) ;
         deduccionespecialincrementada.this.AV45SueldoPromedioConCodigo = GXv_char4[0] ;
         GXv_decimal8[0] = AV46sueldoPromedioImportes ;
         GXv_boolean6[0] = AV19existe ;
         GXv_int7[0] = AV13LiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV22CliCod, AV21EmpCod, AV14LiqNro, AV15LegNumero, AV45SueldoPromedioConCodigo, AV47ProcesoLiquidacion, false, GXv_decimal8, GXv_boolean6, GXv_int7) ;
         deduccionespecialincrementada.this.AV46sueldoPromedioImportes = GXv_decimal8[0] ;
         deduccionespecialincrementada.this.AV19existe = GXv_boolean6[0] ;
         deduccionespecialincrementada.this.AV13LiqDCalculado = GXv_int7[0] ;
         if ( AV13LiqDCalculado == 0 )
         {
            AV52error = httpContext.getMessage( "Fala calcular concepto ", "") + GXutil.trim( AV45SueldoPromedioConCodigo) ;
            AV48LiqDLog = GXutil.trim( AV52error) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV55Pgmname, httpContext.getMessage( "return 2", "")) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( DecimalUtil.compareTo(AV44sueldoSinSacImportes, AV46sueldoPromedioImportes) < 0 )
         {
            AV12importes = AV44sueldoSinSacImportes ;
         }
         else
         {
            AV12importes = AV46sueldoPromedioImportes ;
         }
      }
      else
      {
         AV12importes = AV39simulacionSueldoBrutoImponible ;
      }
      GXv_char4[0] = AV50OpeCliValor ;
      GXv_char3[0] = "" ;
      GXv_char9[0] = AV51auxError ;
      new web.getmnisegunestadocivilehijos(remoteHandle, context).execute( AV22CliCod, AV21EmpCod, AV15LegNumero, AV32LiqPeriodo, AV47ProcesoLiquidacion, true, GXv_char4, GXv_char3, GXv_char9) ;
      deduccionespecialincrementada.this.AV50OpeCliValor = GXv_char4[0] ;
      deduccionespecialincrementada.this.AV51auxError = GXv_char9[0] ;
      if ( ! (GXutil.strcmp("", AV51auxError)==0) )
      {
         AV13LiqDCalculado = (byte)(0) ;
         AV52error = AV51auxError ;
         AV48LiqDLog = GXutil.trim( AV52error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV27pisoGananciasImportes = CommonUtil.decimalVal( AV50OpeCliValor, ".") ;
      if ( AV26GNSIImportes.doubleValue() > 0 )
      {
         if ( DecimalUtil.compareTo(AV12importes, AV27pisoGananciasImportes) <= 0 )
         {
            AV48LiqDLog = httpContext.getMessage( "Inicializa valor con la Ganancia neta sujeta a impuestos ", "") + GXutil.trim( GXutil.str( AV26GNSIImportes, 14, 2)) + httpContext.getMessage( " por ser el ", "") ;
            if ( DecimalUtil.compareTo(AV44sueldoSinSacImportes, AV46sueldoPromedioImportes) < 0 )
            {
               AV48LiqDLog += httpContext.getMessage( "sueldo bruto sin sac ", "") ;
            }
            else
            {
               AV48LiqDLog += httpContext.getMessage( "sueldo bruto promedio ", "") ;
            }
            AV48LiqDLog += GXutil.trim( GXutil.str( AV12importes, 14, 2)) + httpContext.getMessage( " menor o igual al piso de ganancias ", "") + GXutil.trim( GXutil.str( AV27pisoGananciasImportes, 14, 2)) ;
            AV28deduccionImportes = AV26GNSIImportes ;
         }
         else
         {
         }
         GXt_char2 = AV42DEIConCodigo ;
         GXt_char1 = AV42DEIConCodigo ;
         GXv_char9[0] = GXt_char1 ;
         new web.concepto_deduccionespecialincrementada_codigoparam(remoteHandle, context).execute( GXv_char9) ;
         deduccionespecialincrementada.this.GXt_char1 = GXv_char9[0] ;
         GXv_char4[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV22CliCod, GXt_char1, GXv_char4) ;
         deduccionespecialincrementada.this.GXt_char2 = GXv_char4[0] ;
         AV42DEIConCodigo = GXt_char2 ;
         GXv_decimal8[0] = AV41anteriorImportes ;
         new web.getliqdimp_recalculadoliqantper(remoteHandle, context).execute( AV22CliCod, AV21EmpCod, AV14LiqNro, AV49LiqRelNro, AV32LiqPeriodo, AV15LegNumero, AV42DEIConCodigo, GXv_decimal8) ;
         deduccionespecialincrementada.this.AV41anteriorImportes = GXv_decimal8[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV41anteriorImportes)==0) )
         {
            AV28deduccionImportes = AV28deduccionImportes.subtract(AV41anteriorImportes) ;
            AV48LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV41anteriorImportes, 14, 2)) + httpContext.getMessage( " correspondiente a liquidaciones anteriores del periodo", "") ;
         }
      }
      if ( (GXutil.strcmp("", AV48LiqDLog)==0) )
      {
         AV48LiqDLog = httpContext.getMessage( "No corresponde deducción especial incrementada", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = deduccionespecialincrementada.this.AV28deduccionImportes;
      this.aP10[0] = deduccionespecialincrementada.this.AV13LiqDCalculado;
      this.aP11[0] = deduccionespecialincrementada.this.AV48LiqDLog;
      this.aP12[0] = deduccionespecialincrementada.this.AV52error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV28deduccionImportes = DecimalUtil.ZERO ;
      AV48LiqDLog = "" ;
      AV52error = "" ;
      AV36parametroPalabra = "" ;
      AV25ganNetaSujAImpConCodigo = "" ;
      AV26GNSIImportes = DecimalUtil.ZERO ;
      AV55Pgmname = "" ;
      AV40auxImportes = DecimalUtil.ZERO ;
      AV35SueldoSinSacConCodigo = "" ;
      AV44sueldoSinSacImportes = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV45SueldoPromedioConCodigo = "" ;
      AV46sueldoPromedioImportes = DecimalUtil.ZERO ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      AV12importes = DecimalUtil.ZERO ;
      AV50OpeCliValor = "" ;
      GXv_char3 = new String[1] ;
      AV51auxError = "" ;
      AV27pisoGananciasImportes = DecimalUtil.ZERO ;
      AV42DEIConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV41anteriorImportes = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      AV55Pgmname = "DeduccionEspecialIncrementada" ;
      /* GeneXus formulas. */
      AV55Pgmname = "DeduccionEspecialIncrementada" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13LiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV21EmpCod ;
   private short Gx_err ;
   private int AV22CliCod ;
   private int AV14LiqNro ;
   private int AV49LiqRelNro ;
   private int AV15LegNumero ;
   private java.math.BigDecimal AV38simulacionGNSI ;
   private java.math.BigDecimal AV39simulacionSueldoBrutoImponible ;
   private java.math.BigDecimal AV28deduccionImportes ;
   private java.math.BigDecimal AV26GNSIImportes ;
   private java.math.BigDecimal AV40auxImportes ;
   private java.math.BigDecimal AV44sueldoSinSacImportes ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV46sueldoPromedioImportes ;
   private java.math.BigDecimal AV12importes ;
   private java.math.BigDecimal AV27pisoGananciasImportes ;
   private java.math.BigDecimal AV41anteriorImportes ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV47ProcesoLiquidacion ;
   private String AV36parametroPalabra ;
   private String AV25ganNetaSujAImpConCodigo ;
   private String AV55Pgmname ;
   private String AV35SueldoSinSacConCodigo ;
   private String AV45SueldoPromedioConCodigo ;
   private String GXv_char3[] ;
   private String AV42DEIConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char9[] ;
   private String GXv_char4[] ;
   private java.util.Date AV32LiqPeriodo ;
   private boolean AV19existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV48LiqDLog ;
   private String AV50OpeCliValor ;
   private String AV52error ;
   private String AV51auxError ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP9 ;
   private byte[] aP10 ;
   private String[] aP11 ;
}

