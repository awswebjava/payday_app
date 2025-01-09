package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sac extends GXProcedure
{
   public sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sac.class ), "" );
   }

   public sac( int remoteHandle ,
               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( String aP0 ,
                                           int aP1 ,
                                           short aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           int aP5 ,
                                           java.util.Date aP6 ,
                                           String aP7 ,
                                           String aP8 ,
                                           boolean aP9 ,
                                           java.math.BigDecimal[] aP10 ,
                                           String[] aP11 ,
                                           byte[] aP12 ,
                                           String[] aP13 )
   {
      sac.this.aP14 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( String aP0 ,
                        int aP1 ,
                        short aP2 ,
                        int aP3 ,
                        int aP4 ,
                        int aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 ,
                        String[] aP13 ,
                        java.math.BigDecimal[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( String aP0 ,
                             int aP1 ,
                             short aP2 ,
                             int aP3 ,
                             int aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 ,
                             String[] aP13 ,
                             java.math.BigDecimal[] aP14 )
   {
      sac.this.AV31que = aP0;
      sac.this.AV16CliCod = aP1;
      sac.this.AV20EmpCod = aP2;
      sac.this.AV27LiqNro = aP3;
      sac.this.AV33LiqRelNro = aP4;
      sac.this.AV24LegNumero = aP5;
      sac.this.AV28LiqPeriodo = aP6;
      sac.this.AV17ConCodigo = aP7;
      sac.this.AV30ProcesoLiquidacion = aP8;
      sac.this.AV23insertandoConceptos = aP9;
      sac.this.aP10 = aP10;
      sac.this.aP11 = aP11;
      sac.this.aP12 = aP12;
      sac.this.aP13 = aP13;
      sac.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV25LiqDCalculado = (byte)(1) ;
      AV32sacOperandos = "{sac}" ;
      GXt_char1 = AV9auxConCodigo ;
      GXt_char2 = AV9auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_liquidasac_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      sac.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char2, GXv_char4) ;
      sac.this.GXt_char1 = GXv_char4[0] ;
      AV9auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV12auxLiqDImpCalcu ;
      GXv_boolean6[0] = false ;
      GXv_int7[0] = AV11auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV20EmpCod, AV27LiqNro, AV24LegNumero, AV9auxConCodigo, AV30ProcesoLiquidacion, AV23insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      sac.this.AV12auxLiqDImpCalcu = GXv_decimal5[0] ;
      sac.this.AV11auxLiqDCalculado = GXv_int7[0] ;
      if ( AV11auxLiqDCalculado == 0 )
      {
         AV25LiqDCalculado = (byte)(0) ;
         AV21error = httpContext.getMessage( "Falta calcular concepto \"Liquida SAC\"", "") ;
         AV26LiqDLog = GXutil.trim( AV21error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV12auxLiqDImpCalcu.doubleValue() == 1 )
      {
         AV29palabra = "[dias_remunerados_semestre]" ;
         GXv_int8[0] = AV18dias_remu_sem ;
         GXv_int7[0] = AV11auxLiqDCalculado ;
         GXv_char4[0] = AV10auxError ;
         GXv_char3[0] = AV13auxLiqDLog ;
         new web.obtvalformuladtmydts(remoteHandle, context).execute( AV16CliCod, AV20EmpCod, AV27LiqNro, AV33LiqRelNro, AV24LegNumero, AV29palabra, AV28LiqPeriodo, true, true, true, AV30ProcesoLiquidacion, AV23insertandoConceptos, GXv_int8, GXv_int7, GXv_char4, GXv_char3) ;
         sac.this.AV18dias_remu_sem = (short)((short)(GXv_int8[0])) ;
         sac.this.AV11auxLiqDCalculado = GXv_int7[0] ;
         sac.this.AV10auxError = GXv_char4[0] ;
         sac.this.AV13auxLiqDLog = GXv_char3[0] ;
         if ( AV11auxLiqDCalculado == 0 )
         {
            AV25LiqDCalculado = (byte)(0) ;
            AV21error = httpContext.getMessage( "Error al calcular días remunerados en el semestre (", "") + GXutil.trim( AV10auxError) + ")" ;
            AV26LiqDLog = GXutil.trim( AV21error) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV18dias_remu_sem > 0 )
         {
            AV29palabra = "[dias_semestre]" ;
            GXv_int8[0] = AV19diasSemestre ;
            new web.obtvalformulacdmycds(remoteHandle, context).execute( AV16CliCod, AV20EmpCod, AV27LiqNro, AV24LegNumero, AV28LiqPeriodo, AV29palabra, AV28LiqPeriodo, GXutil.toBoolean( 0), GXv_int8) ;
            sac.this.AV19diasSemestre = (short)((short)(GXv_int8[0])) ;
            AV14calcular = true ;
            if ( GXutil.strcmp(AV31que, AV32sacOperandos) == 0 )
            {
               if ( AV18dias_remu_sem < AV19diasSemestre )
               {
                  AV14calcular = false ;
               }
            }
            else
            {
               if ( AV18dias_remu_sem >= AV19diasSemestre )
               {
                  AV14calcular = false ;
               }
            }
            if ( ! AV14calcular )
            {
               if ( GXutil.strcmp(AV31que, AV32sacOperandos) == 0 )
               {
                  AV26LiqDLog = httpContext.getMessage( "No se calcula SAC porque corresponde liquidar SAC proporcional a los días trabajados", "") ;
               }
               else
               {
                  AV26LiqDLog = httpContext.getMessage( "No se calcula SAC porque corresponde liquidar SAC (sin proporcionar)", "") ;
               }
            }
            else
            {
               GXt_char2 = AV9auxConCodigo ;
               GXt_char1 = AV9auxConCodigo ;
               GXv_char4[0] = GXt_char1 ;
               new web.concepto_calculosac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
               sac.this.GXt_char1 = GXv_char4[0] ;
               GXv_char3[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char1, GXv_char3) ;
               sac.this.GXt_char2 = GXv_char3[0] ;
               AV9auxConCodigo = GXt_char2 ;
               GXv_decimal5[0] = AV12auxLiqDImpCalcu ;
               GXv_boolean6[0] = false ;
               GXv_int7[0] = AV11auxLiqDCalculado ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV16CliCod, AV20EmpCod, AV27LiqNro, AV24LegNumero, AV9auxConCodigo, AV30ProcesoLiquidacion, AV23insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
               sac.this.AV12auxLiqDImpCalcu = GXv_decimal5[0] ;
               sac.this.AV11auxLiqDCalculado = GXv_int7[0] ;
               if ( AV11auxLiqDCalculado == 0 )
               {
                  AV25LiqDCalculado = (byte)(0) ;
                  AV21error = httpContext.getMessage( "Falta calcular concepto \"Cálculo SAC\"", "") ;
                  AV26LiqDLog = GXutil.trim( AV21error) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV22Importes = AV12auxLiqDImpCalcu ;
               AV26LiqDLog = httpContext.getMessage( "Inicializa valor con concepto \"Cálculo SAC\" ", "") + GXutil.trim( GXutil.str( AV22Importes, 14, 2)) ;
               if ( GXutil.strcmp(AV31que, AV32sacOperandos) == 0 )
               {
                  AV15cantidadCalculada = DecimalUtil.doubleToDec(AV19diasSemestre) ;
               }
               else
               {
                  AV15cantidadCalculada = DecimalUtil.doubleToDec(AV18dias_remu_sem) ;
               }
            }
         }
      }
      GXv_decimal5[0] = AV12auxLiqDImpCalcu ;
      new web.getliqdimp_recalculadoliqantper(remoteHandle, context).execute( AV16CliCod, AV20EmpCod, AV27LiqNro, AV33LiqRelNro, AV28LiqPeriodo, AV24LegNumero, AV17ConCodigo, GXv_decimal5) ;
      sac.this.AV12auxLiqDImpCalcu = GXv_decimal5[0] ;
      if ( AV12auxLiqDImpCalcu.doubleValue() > 0 )
      {
         AV26LiqDLog += httpContext.getMessage( ". Resta importe de liquidaciones anteriores del periodo ", "") + GXutil.trim( GXutil.str( AV12auxLiqDImpCalcu, 14, 2)) ;
         AV22Importes = AV22Importes.subtract(AV12auxLiqDImpCalcu) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = sac.this.AV22Importes;
      this.aP11[0] = sac.this.AV21error;
      this.aP12[0] = sac.this.AV25LiqDCalculado;
      this.aP13[0] = sac.this.AV26LiqDLog;
      this.aP14[0] = sac.this.AV15cantidadCalculada;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22Importes = DecimalUtil.ZERO ;
      AV21error = "" ;
      AV26LiqDLog = "" ;
      AV15cantidadCalculada = DecimalUtil.ZERO ;
      AV32sacOperandos = "" ;
      AV9auxConCodigo = "" ;
      AV12auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV29palabra = "" ;
      AV10auxError = "" ;
      AV13auxLiqDLog = "" ;
      GXv_int8 = new int[1] ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV25LiqDCalculado ;
   private byte AV11auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV20EmpCod ;
   private short AV18dias_remu_sem ;
   private short AV19diasSemestre ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV27LiqNro ;
   private int AV33LiqRelNro ;
   private int AV24LegNumero ;
   private int GXv_int8[] ;
   private java.math.BigDecimal AV22Importes ;
   private java.math.BigDecimal AV15cantidadCalculada ;
   private java.math.BigDecimal AV12auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV31que ;
   private String AV17ConCodigo ;
   private String AV30ProcesoLiquidacion ;
   private String AV32sacOperandos ;
   private String AV9auxConCodigo ;
   private String AV29palabra ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV28LiqPeriodo ;
   private boolean AV23insertandoConceptos ;
   private boolean returnInSub ;
   private boolean AV14calcular ;
   private boolean GXv_boolean6[] ;
   private String AV26LiqDLog ;
   private String AV13auxLiqDLog ;
   private String AV21error ;
   private String AV10auxError ;
   private java.math.BigDecimal[] aP14 ;
   private java.math.BigDecimal[] aP10 ;
   private String[] aP11 ;
   private byte[] aP12 ;
   private String[] aP13 ;
}

